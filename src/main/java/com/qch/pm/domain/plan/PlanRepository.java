package com.qch.pm.domain.plan;

/**
 * @author : qiuchenhao
 * @date : 2019/3/16
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

}
