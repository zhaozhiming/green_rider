package com.green.rider.server.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;

    @Basic
    private String planname;

    @Basic
    private String starter;

    @Basic
    private Date startTime;

    @Basic
    private String startPlace;

    @Basic
    private String endPlace;

    @Basic
    private List<User> joiners;

    public Plan(String planname, String starter, Date startTime, String startPlace, String endPlace, List<User> joiners) {
        this.planname = planname;
        this.starter = starter;
        this.startTime = startTime;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.joiners = joiners;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname;
    }

    public String getStarter() {
        return starter;
    }

    public void setStarter(String starter) {
        this.starter = starter;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public List<User> getJoiners() {
        return joiners;
    }

    public void setJoiners(List<User> joiners) {
        this.joiners = joiners;
    }

    public void join(User user) {
        this.joiners.add(user);
    }
}
