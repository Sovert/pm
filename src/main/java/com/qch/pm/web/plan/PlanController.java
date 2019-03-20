package com.qch.pm.web.plan;

/**
 * @author : qiuchenhao
 * @date : 2019/3/16
 */
import com.qch.pm.domain.plan.Plan;
import com.qch.pm.domain.util.ResponseEntity;
import com.qch.pm.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.qch.pm.domain.util.ResponseCode.SUCCESS;

@Controller
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;


    @GetMapping("/edit")
    public String add() {
        return "plan/edit";
    }

    @GetMapping("/list")
    public String list() {
        return "plan/list";
    }

    @PostMapping("/query")
    @ResponseBody
    public ResponseEntity query() {
        List<Plan> planList = planService.findAll();
        return new ResponseEntity(SUCCESS, planList);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity delete(@RequestBody String id) {
        System.out.println(id);
        planService.deleteById(id);
        return new ResponseEntity(SUCCESS);
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity save(@RequestBody Plan plan) {
        planService.savePlan(plan);
        return new ResponseEntity(SUCCESS);
    }

    @PostMapping("/queryById")
    @ResponseBody
    public ResponseEntity QueryById(@RequestBody String id) {
        Plan plan = planService.queryById(id);
        return new ResponseEntity(SUCCESS,plan);
    }

}
