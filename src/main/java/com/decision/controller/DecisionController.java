package com.decision.controller;

import com.decision.dto.DecisionGeneInConfigDto;
import com.decision.service.DecisionService;
import com.decision.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuoshengqi
 * @date 2019/04/03  9:49
 * @description
 */
@RequestMapping("/decn")
@RestController
public class DecisionController {

    @Autowired
    private DecisionService decisionService;

    @RequestMapping("/findAll")
    public List findAll() {
        return decisionService.findAll();
    }

    @RequestMapping("/testjr")
    public String testJr(){
        return "JR 牛逼！";
    }


    @PostMapping("/findAll")
    public List findAll(@RequestBody DecisionGeneInConfigDto decisionGeneInConfigDto){
        return (List) decisionService.findAll(decisionGeneInConfigDto);
    }


    @Autowired
    private IdWorker idWorker;

    @PostMapping("/save")
    public void save(@RequestBody Map paramMap) {


        System.out.println("~~~~~~~~~~~~" + paramMap);
        DecisionGeneInConfigDto decisionGeneInConfigDto = new DecisionGeneInConfigDto();
        decisionGeneInConfigDto.setGeneId(idWorker.nextId());
        decisionGeneInConfigDto.setDecisionTableId((String) paramMap.get("decisionTableId"));

        decisionService.save(decisionGeneInConfigDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id){

        decisionService.update(id);
    }

    @GetMapping("/match")
    public List match(){
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("companyCode", "03310808");
        paramMap.put("riskCode", "0801");
        return decisionService.match(paramMap);
    }
}
