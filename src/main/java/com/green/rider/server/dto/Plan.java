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

    public String getPlanname() {
        return planname;
    }

    public User getStarter() {
        return starter;
    }

    public long getStartTime() {
        return startTime;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public List<User> getJoiners() {
        return joiners;
    }

    public void join(User user) {
        this.joiners.add(user);
    }
}
