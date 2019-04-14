package com.decision.service;

import com.decision.dao.DecisionGeneInConfigDao;
import com.decision.dao.MatchTableDao;
import com.decision.dto.DecisionGeneInConfigDto;
import com.decision.dto.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zhuoshengqi
 * @date 2019/04/03  9:59
 * @description
 */
@Service
public class DecisionService {

    @Autowired
    private DecisionGeneInConfigDao decisionGeneInConfigDao;


    public List findAll() {

        return decisionGeneInConfigDao.findAll();
    }

    public void save(DecisionGeneInConfigDto decisionGeneInConfigDto) {

        decisionGeneInConfigDao.save(decisionGeneInConfigDto);
    }

    public void update(Long id) {
        DecisionGeneInConfigDto decisionGeneInConfigDto = new DecisionGeneInConfigDto();
        decisionGeneInConfigDto.setDecisionTableId("HX001");
        List<DecisionGeneInConfigDto> all = decisionGeneInConfigDao.findAll(Example.of(decisionGeneInConfigDto));


        HashMap<String, String> map = new HashMap<>();
        map.put("COMPANEYCODE", "机构");
        map.put("CHANNELDETAILCODE", "渠道");
        map.put("RISKCODE", "险种");
        map.put("PLANCODE", "险种组合");
        map.put("APPLYNO", "决策单元代码");
        map.put("USENATURECODE", "使用性质");
        map.put("CARUSETYPE", "车辆用途");


        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {

            all.get(i).setGeneName(entry.getKey());
            all.get(i).setGeneDesc(entry.getValue());

            i++;
        }

        decisionGeneInConfigDao.saveAll(all);

    }


    public List findAll(DecisionGeneInConfigDto decisionGeneInConfigDto) {
        return decisionGeneInConfigDao.findAll(Example.of(decisionGeneInConfigDto));

    }

    public void createMatchTable() {
        List<DecisionGeneInConfigDto> all = decisionGeneInConfigDao.findAll();


    }

    @Autowired
    private MatchTableDao matchTableDao;

    public List match(HashMap<String, String> paramMap) {

        String companyCode = paramMap.get("companyCode");
        String riskCode = paramMap.get("riskCode");
        MatchDto matchDto = new MatchDto();
        matchDto.setCompanyCode(companyCode + "%");
        matchDto.setRiskCode(riskCode);
        boolean chaFlag = true;

        ArrayList<Object> rsList = new ArrayList<>();
        while (chaFlag) {
           // List<MatchDto> all = matchTableDao.findAll(Example.of(matchDto));
            List<MatchDto> all =  matchTableDao.findMatchDtoByCompanyCodeLikeAndRiskCodeContains(companyCode, riskCode);
            companyCode = companyCode.substring(0, companyCode.length() - 2);
            matchDto.setCompanyCode(companyCode + "%");


            if (companyCode.length() <= 0) {
                chaFlag = false;


            }
            if (all.size() > 0) {
                for (MatchDto dto : all) {
                    rsList.add(dto.getClauseCode());
                }
            }
        }
        return rsList;

    }
}
