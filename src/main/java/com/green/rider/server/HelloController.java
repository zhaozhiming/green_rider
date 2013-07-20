package com.green.rider.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

}