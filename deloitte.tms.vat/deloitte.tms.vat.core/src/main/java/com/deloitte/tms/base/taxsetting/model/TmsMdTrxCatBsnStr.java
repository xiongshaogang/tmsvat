package com.deloitte.tms.base.taxsetting.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deloitte.tms.base.masterdata.model.BaseOrg;
import com.deloitte.tms.base.masterdata.model.TmsMdLegalEntity;
import com.deloitte.tms.base.masterdata.model.TmsMdTaxTrxType;
import com.deloitte.tms.pl.core.commons.annotation.ModelProperty;
import com.deloitte.tms.pl.core.hibernate.identifier.Ling2UUIDGenerator;
import com.deloitte.tms.pl.core.model.impl.BaseEntity;

/**
 * TmsMdTrxCatBsnStr generated by ling autoproject
 */
@Entity
@Table(name=TmsMdTrxCatBsnStr.TABLE)
@ModelProperty(comment="交易类型与业务结构匹配")
public class TmsMdTrxCatBsnStr extends BaseEntity {

	public static final String TABLE = "TMS_MD_TRX_CAT_BSN_STR";
	public static final String SEQ = TABLE;

    @Id
	@GenericGenerator(name=SEQ+"_GENERATOR",strategy=Ling2UUIDGenerator.STRATEGY_NAME,parameters={@Parameter(name="pkColumnValue",value=SEQ)})
	@GeneratedValue(strategy = GenerationType.TABLE, generator = SEQ+"_GENERATOR")

    @Column(name="TRX_CAT_BSN_STR_ID")
	@ModelProperty(comment="交易类型与业务结构匹配ID")
	private String id;

    @Column(name="LEGAL_ENTITY_ID")
	@ModelProperty(comment="纳税主体ID")
	private String legalEntityId;

    @Column(name="BSN_COMBINATION_ID")
	@ModelProperty(comment="业务数据组合ID")
	private String bsnCombinationId;

    @Column(name="TAX_TRX_TYPE_ID")
	@ModelProperty(comment="涉税交易类型ID")
	private String taxTrxTypeId;

    @Column(name="GLOBAL_OR_LOCAL_OGR_TYPE")
	@ModelProperty(comment="全局/组织类型_枚举值(全局/组织)")
	private String globalOrLocalOgrType;

    @Column(name="SOURCE_CODE")
	@ModelProperty(comment="来源代码_枚举值")
	private String sourceCode;

    @Column(name="ENABLED_FLAG")
	@ModelProperty(comment="是否启用(Y/N)")
	private Boolean enabledFlag;

    @Column(name="DESCRIPTION")
	@ModelProperty(comment="备注")
	private String description;

    @Column(name="START_DATE")
	@ModelProperty(comment="有效日期")
	private Date startDate;

    @Column(name="END_DATE")
	@ModelProperty(comment="失效日期")
	private Date endDate;

    @Column(name="ORG_ID")
	@ModelProperty(comment="组织ID")
	private String orgId;

    //纳税人
    @ManyToOne
   	@Cascade(CascadeType.REFRESH)
   	@JoinColumn(name="LEGAL_ENTITY_ID", insertable=false,updatable=false,nullable=true)
    private TmsMdLegalEntity tmsMdLegalEntity;
    
    //业务组合
    @ManyToOne
   	@Cascade(CascadeType.REFRESH)
   	@JoinColumn(name="BSN_COMBINATION_ID", insertable=false,updatable=false,nullable=true)
    private TmsMdBsnCombination tmsMdBsnCombination;
    
    //组织
    @ManyToOne
	@Cascade(CascadeType.REFRESH)
	@JoinColumn(name="ORG_ID", insertable=false,updatable=false,nullable=true)
    private BaseOrg baseOrg;
    
    //涉税交易枚举
    @ManyToOne
	@Cascade(CascadeType.REFRESH)
	@JoinColumn(name="TAX_TRX_TYPE_ID", insertable=false,updatable=false,nullable=true)
    private TmsMdTaxTrxType tmsMdTaxTrxType;
    
    
    
    
    
	public TmsMdLegalEntity getTmsMdLegalEntity() {
		return tmsMdLegalEntity;
	}

	public void setTmsMdLegalEntity(TmsMdLegalEntity tmsMdLegalEntity) {
		this.tmsMdLegalEntity = tmsMdLegalEntity;
	}

	public TmsMdBsnCombination getTmsMdBsnCombination() {
		return tmsMdBsnCombination;
	}

	public void setTmsMdBsnCombination(TmsMdBsnCombination tmsMdBsnCombination) {
		this.tmsMdBsnCombination = tmsMdBsnCombination;
	}

	public BaseOrg getBaseOrg() {
		return baseOrg;
	}

	public void setBaseOrg(BaseOrg baseOrg) {
		this.baseOrg = baseOrg;
	}

	public TmsMdTaxTrxType getTmsMdTaxTrxType() {
		return tmsMdTaxTrxType;
	}

	public void setTmsMdTaxTrxType(TmsMdTaxTrxType tmsMdTaxTrxType) {
		this.tmsMdTaxTrxType = tmsMdTaxTrxType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLegalEntityId() {
		return legalEntityId;
	}

	public void setLegalEntityId(String legalEntityId) {
		this.legalEntityId = legalEntityId;
	}

	public String getBsnCombinationId() {
		return bsnCombinationId;
	}

	public void setBsnCombinationId(String bsnCombinationId) {
		this.bsnCombinationId = bsnCombinationId;
	}

	public String getTaxTrxTypeId() {
		return taxTrxTypeId;
	}

	public void setTaxTrxTypeId(String taxTrxTypeId) {
		this.taxTrxTypeId = taxTrxTypeId;
	}

	public String getGlobalOrLocalOgrType() {
		return globalOrLocalOgrType;
	}

	public void setGlobalOrLocalOgrType(String globalOrLocalOgrType) {
		this.globalOrLocalOgrType = globalOrLocalOgrType;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public Boolean getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(Boolean enabledFlag) {
		this.enabledFlag = enabledFlag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

    
}


