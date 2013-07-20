package com.green.rider.server.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.green.rider.server.dto.Plan;
import com.green.rider.server.dto.User;
import com.green.rider.server.repository.PlanRepository;
import com.green.rider.server.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/api/plans", method = RequestMethod.GET)
    public
    @ResponseBody
    String getAllPlans() throws JSONException {
        JSONArray plansJson = new JSONArray();

        for (Plan plan : planRepository.findAll()) {
            JSONObject planJson = new JSONObject();
            planJson.put("pid", plan.getPid());
            planJson.put("planname", plan.getPlanname());
            planJson.put("starter", plan.getStarter());
            planJson.put("start_place", plan.getStartPlace());
            planJson.put("end_place", plan.getEndPlace());
            planJson.put("start_time", plan.getStartTime());
            planJson.put("joiners", plan.getJoiners());
            plansJson.put(planJson);
        }
        return plansJson.toString();
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
        String joinersSource = request.getParameter("joiners");

        List<User> joiners = Lists.newArrayList();
        if (!Strings.isNullOrEmpty(joinersSource)) {
            String[] joinerUids = joinersSource.split(";");
            for (String joinerUid : joinerUids) {
                joiners.add(userRepository.findOne(Long.valueOf(joinerUid)));
            }
        }

        Plan plan = new Plan(planname, Long.valueOf(starter),
                new Date(Long.valueOf(startTime)).getTime(), startPlace, endPlace, joiners);
        planRepository.save(plan);

        JSONObject result = new JSONObject();
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

    private String generateAppKey() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

}