package com.decision.dto;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuoshengqi
 * @date 2019/04/03  9:50
 * @description
 */
@Entity
@Data
@Table(name = "decisiongeneinconfig")
public class DecisionGeneInConfigDto implements Serializable {


    @Id
    //@GenericGenerator(name = "user-uuid", strategy = "uuid")
    //@GeneratedValue(generator = "user-uuid")
   // @GeneratedValue
    @Column(name = "GENEID")
    private Long geneId;
    @Column(name = "DECISIONTABLEID")
    private String decisionTableId;
    @Column(name = "GENENAME")
    private String geneName;
    @Column(name = "GENEDESC")
    private String geneDesc;
    @Column(name = "DATASOURCE")
    private String dataSource;
    @Column(name = "DATALENGTH")
    private String dataLength;
    @Column(name = "DATATYPE")
    private String dataType;
    @Column(name = "EXCELCOL")
    private Integer excelCol;
    @Column(name = "ISINDEXED")
    private String isIndexed;
    @Column(name = "INDEXORDER")
    private String indexOrder;
    @Column(name = "VALIDATIONTYPE")
    private String validationType;
    @Column(name = "VALIDATIONVALUE")
    private String validationValue;
    @Column(name = "ISMATCH")
    private String isMatch;
    @Column(name = "DEFLENGTH")
    private String defLength;
    @Column(name = "GENTYPE")
    private String genType;
    @Column(name = "CREATEDATE")
    private Date createDate;
    @Column(name = "CREATEBY")
    private String createBy;
    @Column(name = "LASTUPDATEDATE")
    private Date lastUpdateDate;
    @Column(name = "LASTUPDATEBY")
    private String lastUpdateBy;
    @Column(name = "REMARK")
    private String remark;
    @Column(name = "DATASOURCEVALUE")
    private String datasourceValue;
    @Column(name = "COLLENGTH")
    private Integer colLength;


}
