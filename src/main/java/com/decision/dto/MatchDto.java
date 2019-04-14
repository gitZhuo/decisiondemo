package com.decision.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhuoshengqi
 * @date 2019/04/10  14:42
 * @description
 */
@Entity
@Table(name = "matchtable")
@Data
public class MatchDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;

    @Column(name = "companycode")
    public String companyCode;

    @Column(name = "riskcode")
    public String riskCode;
    @Column(name = "usecartye")
    public String useCarType;
    @Column(name = "motortype")
    public String motorType;

    @Column(name = "clausecode")
    public String ClauseCode;

}
