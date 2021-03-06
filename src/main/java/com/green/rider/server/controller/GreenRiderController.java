package com.green.rider.server.controller;

import com.google.common.collect.Sets;
import com.green.rider.server.dto.Plan;
import com.green.rider.server.dto.User;
import com.green.rider.server.repository.PlanRepository;
import com.green.rider.server.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Controller
public class GreenRiderController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlanRepository planRepository;

    @RequestMapping(value = "/api/user/create", method = RequestMethod.POST)
    public
    @ResponseBody
    String createUser(HttpServletRequest request) throws JSONException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String appKey = generateAppKey();

        User user = new User(username, password, appKey);
        userRepository.save(user);

        JSONObject userJson = new JSONObject();
        userJson.put("uid", user.getUid());
        userJson.put("app_key", user.getAppKey());
        return userJson.toString();
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public
    @ResponseBody
    String login(HttpServletRequest request) throws JSONException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user == null) {
            return new JSONObject().toString();
        }

        JSONObject userJson = new JSONObject();
        userJson.put("uid", user.getUid());
        userJson.put("app_key", user.getAppKey());
        return userJson.toString();
    }

    @RequestMapping(value = "/api/plan/create", method = RequestMethod.POST)
    public
    @ResponseBody
    String createPlans(HttpServletRequest request) throws JSONException {
        String planname = request.getParameter("planname");
        String starter = request.getParameter("starter");
        String startTime = request.getParameter("start_time");
        String startPlace = request.getParameter("start_place");
        String endPlace = request.getParameter("end_place");
        String endLocation = request.getParameter("end_location");

        User startUser = userRepository.findOne(Long.valueOf(starter));
        Plan plan = new Plan(planname, startUser, Math.round(Double.valueOf(startTime)), startPlace, endPlace, endLocation);
        planRepository.save(plan);

        JSONObject result = new JSONObject();
        result.put("pid", plan.getPid());
        result.put("status_code", HttpServletResponse.SC_OK);
        return result.toString();
    }

    @RequestMapping(value = "/api/plan/join", method = RequestMethod.POST)
    public
    @ResponseBody
    String joinPlan(HttpServletRequest request) throws JSONException {
        String pid = request.getParameter("pid");
        String uid = request.getParameter("uid");

        Plan plan = planRepository.findOne(Long.valueOf(pid));
        User user = userRepository.findOne(Long.valueOf(uid));
        plan.join(user);
        planRepository.save(plan);

        JSONObject result = new JSONObject();
        result.put("status_code", HttpServletResponse.SC_OK);
        return result.toString();
    }

    @RequestMapping(value = "/api/plans", method = RequestMethod.GET)
    public
    @ResponseBody
    String getAllPlans() throws JSONException {
        return getPlansJson(planRepository.findAll(), null).toString();
    }

    @RequestMapping(value = "/api/plans/{uid}", method = RequestMethod.GET)
    public
    @ResponseBody
    String findPlansByUid(@PathVariable Long uid) throws JSONException {
        User starter = userRepository.findOne(uid);

        List<Plan> allPlans = planRepository.findAll();
        Set<Plan> uidPlans = Sets.newHashSet();
        for (Plan plan : allPlans) {
            if (starter.equals(plan.getStarter())) {
                uidPlans.add(plan);
                continue;
            }

            if (plan.getJoiners().contains(starter)) {
                uidPlans.add(plan);
            }
        }

        return getPlansJson(uidPlans, starter).toString();
    }

    private JSONArray getPlansJson(Collection<Plan> uidPlans, User starter) throws JSONException {
        JSONArray plansJson = new JSONArray();
        for (Plan plan : uidPlans) {
            JSONObject planJson = new JSONObject();
            planJson.put("pid", plan.getPid());
            planJson.put("planname", plan.getPlanname());
            planJson.put("starter", getStarterJson(plan));
            planJson.put("start_place", plan.getStartPlace());
            planJson.put("end_place", plan.getEndPlace());
            planJson.put("end_location", plan.getEndLocation());
            planJson.put("start_time", plan.getStartTime());
            planJson.put("joiners", getJoinersJson(plan));
            if (starter == null) {
                planJson.put("role", "none");
            } else {
                planJson.put("role", (plan.getStarter().equals(starter)) ? "starter" : "joiner");
            }
            plansJson.put(planJson);
        }
        return plansJson;
    }

    private JSONArray getJoinersJson(Plan plan) throws JSONException {
        JSONArray joinersJson = new JSONArray();
        List<User> joiners = plan.getJoiners();
        for (User joiner : joiners) {
            JSONObject joinerJson = new JSONObject();
            joinerJson.put("uid", joiner.getUid());
            joinerJson.put("username", joiner.getUsername());
            joinersJson.put(joinerJson);
        }
        return joinersJson;
    }

    private JSONObject getStarterJson(Plan plan) throws JSONException {
        JSONObject starterJson = new JSONObject();
        starterJson.put("uid", plan.getStarter().getUid());
        starterJson.put("username", plan.getStarter().getUsername());
        return starterJson;
    }

    private String generateAppKey() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

}