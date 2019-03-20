package com.qch.pm.service.plan;

/**
 * @author : qiuchenhao
 * @date : 2019/3/16
 */
import com.qch.pm.domain.plan.Plan;
import com.qch.pm.domain.plan.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public Plan savePlan(Plan plan) {
        return planRepository.save(plan);
    }

    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public Plan queryById(String id) {
        return planRepository.getOne(Long.valueOf(id));
    }

    public void deleteById(String id) {
        planRepository.deleteById(Long.valueOf(id));
    }
}
