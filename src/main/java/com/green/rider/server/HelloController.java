package com.green.rider.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {
    @RequestMapping(value = "/api/user/create", method = RequestMethod.POST)
    public
    @ResponseBody
    String createUser(HttpServletRequest request) throws JSONException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        JSONObject user = new JSONObject();
        user.put("uid", "uid");
        user.put("app_key", "app_key");
        return user.toString();
    }

    @RequestMapping(value = "/api/plans", method = RequestMethod.GET)
    public
    @ResponseBody
    String getAllPlans() throws JSONException {
        JSONArray plans = new JSONArray();

        JSONObject plan = new JSONObject();
        plan.put("pid", "pid");
        plan.put("name", "name");
        plan.put("starter", "starter");
        plan.put("start_place", "start_place");
        plan.put("end_place", "end_place");
        plan.put("start_time", "start_time");
        plan.put("joiners", "joiners");
        plans.put(plan);

        return plans.toString();
    }

    @RequestMapping(value = "/api/plan/create", method = RequestMethod.POST)
    public
    @ResponseBody
    String createPlans(HttpServletRequest request) throws JSONException {
        String name = request.getParameter("name");
        String starter = request.getParameter("starter");
        String startTime = request.getParameter("start_time");
        String startPlace = request.getParameter("start_place");
        String endPlace = request.getParameter("end_place");
        String joiners = request.getParameter("joiners");

        JSONObject result = new JSONObject();
        result.put("status_code", HttpServletResponse.SC_OK);
        return result.toString();
    }

}