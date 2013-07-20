package com.green.rider.server.repository;

import com.green.rider.server.dto.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
