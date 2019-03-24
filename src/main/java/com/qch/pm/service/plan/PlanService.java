package com.qch.pm.service.plan;

/**
 * @author : qiuchenhao
 * @date : 2019/3/16
 */
import com.qch.pm.domain.plan.Plan;
import com.qch.pm.domain.plan.PlanRepository;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    @PersistenceContext //注入的是实体管理器,执行持久化操作
    private EntityManager entityManager;

    public Plan savePlan(Plan plan) {
        return planRepository.save(plan);
    }

    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public List<Plan> getMap() {
        return planRepository.findAll();
    }

    public Plan queryById(String id) {
        return planRepository.getOne(Long.valueOf(id));
    }

    public void deleteById(String id) {
        planRepository.deleteById(Long.valueOf(id));
    }


    public List queryAlltoMap() {
        Query nativeQuery=entityManager.createNativeQuery("select * from plan order by end_date desc");
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return nativeQuery.getResultList();
    }

}
