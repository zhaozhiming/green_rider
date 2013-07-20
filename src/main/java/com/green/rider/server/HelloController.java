package com.green.rider.server;

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
    String createUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        JSONObject user = new JSONObject();
        return user.toString();
    }

    @RequestMapping(value = "/api/user/create", method = RequestMethod.POST)
    public
    @ResponseBody
    String printWelcome(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        JSONObject user = new JSONObject();
        return user.toString();
    }

}