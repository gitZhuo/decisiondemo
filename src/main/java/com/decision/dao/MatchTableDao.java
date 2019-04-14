package com.decision.dao;

import com.decision.dto.MatchDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhuoshengqi
 * @date 2019/04/10  14:54
 * @description
 */
public interface MatchTableDao extends JpaRepository<MatchDto,String> {

    List findMatchDtoByCompanyCodeLikeAndRiskCodeContains(String companyCode,String riskCode);
}
