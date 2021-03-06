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
    private Long startTime;

    @Basic
    private String startPlace;

    @Basic
    private String endPlace;

    @Basic
    private String endLocation;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<User> joiners;

    public Plan(String planname, User starter, Long startTime, String startPlace, String endPlace, String endLocation) {
        this.planname = planname;
        this.starter = starter;
        this.startTime = startTime;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.endLocation = endLocation;
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

    public Long getStartTime() {
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

    public String getEndLocation() {
        return endLocation;
    }
}
