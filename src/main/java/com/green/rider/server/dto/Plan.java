package com.green.rider.server.dto;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.List;

@Entity(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;

    @Basic
    private String planname;

    @OneToOne
    private User starter;

    @Basic
    private long startTime;

    @Basic
    private String startPlace;

    @Basic
    private String endPlace;

    @OneToMany
    private List<User> joiners;

    public Plan(String planname, User starter, long startTime, String startPlace, String endPlace) {
        this.planname = planname;
        this.starter = starter;
        this.startTime = startTime;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.joiners = Lists.newArrayList();
    }

    public Plan() {
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

    public User getStarter() {
        return starter;
    }

    public void setStarter(User starter) {
        this.starter = starter;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
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
