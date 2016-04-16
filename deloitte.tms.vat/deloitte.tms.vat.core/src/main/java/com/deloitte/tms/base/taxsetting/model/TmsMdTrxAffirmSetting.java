package com.deloitte.tms.base.taxsetting.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import com.deloitte.tms.pl.core.commons.annotation.ModelProperty;
import com.deloitte.tms.pl.core.hibernate.identifier.Ling2UUIDGenerator;
import com.deloitte.tms.pl.core.model.impl.BaseEntity;

/**
 * TmsMdTrxAffirmSetting generated by ling autoproject
 */
@Entity
@Table(name=TmsMdTrxAffirmSetting.TABLE)
@ModelProperty(comment="涉税交易认定设置规则")
public class TmsMdTrxAffirmSetting extends BaseEntity {

	public static final String TABLE = "TMS_MD_TRX_AFFIRM_SETTING";
	public static final String SEQ = TABLE;

    @Id
	@GenericGenerator(name=SEQ+"_GENERATOR",strategy=Ling2UUIDGenerator.STRATEGY_NAME,parameters={@Parameter(name="pkColumnValue",value=SEQ)})
	@GeneratedValue(strategy = GenerationType.TABLE, generator = SEQ+"_GENERATOR")

    @Column(name="TRX_AFFIRM_SETTING_ID")
	@ModelProperty(comment="涉税交易认定设置规则ID")
	private String id;

    @Column(name="TRX_AFFIRM_SETTING_CODE")
	@ModelProperty(comment="交易认定代码")
	private String trxAffirmSettingCode;

    @Column(name="TRX_AFFIRM_SETTING_NAME")
	@ModelProperty(comment="交易认定名称")
	private String trxAffirmSettingName;

    @Column(name="GLOBAL_OR_LOCAL_OGR_TYPE")
	@ModelProperty(comment="全局/组织类型_枚举值(全局/组织)")
	private String globalOrLocalOgrType;

    @Column(name="TAX_TRX_TYPE_ID")
	@ModelProperty(comment="涉税交易类型ID")
	private String taxTrxTypeId;

    @Column(name="BUSINESS_CATEGORIES")
	@ModelProperty(comment="业务大类_枚举值(进项/销项)")
	private String businessCategories;

    @Column(name="SPIT_RULE_CODE")
	@ModelProperty(comment="价税分离核算规则_枚举值")
	private String spitRuleCode;

    @Column(name="TAX_CATEGORY_ID")
	@ModelProperty(comment="税种ID")
	private String taxCategoryId;

    @Column(name="TAX_ITEM_ID")
	@ModelProperty(comment="税目ID")
	private String taxItemId;

    @Column(name="ACCD_SEGMENT")
	@ModelProperty(comment="税金科目编码")
	private String accdSegment;

    @Column(name="TRX_ITEM_ID")
	@ModelProperty(comment="交易目录ID")
	private String trxItemId;

    @Column(name="INVOICE_CATEGORIES")
	@ModelProperty(comment="开票规则类型_枚举值(专票/普票/不可开票)")
	private String invoiceCategories;

    @Column(name="INVOICING_TYPE")
	@ModelProperty(comment="开票方式_枚举值(属地/汇总)")
	private String invoicingType;

    @Column(name="TAX_RATE")
	@ModelProperty(comment="税率")
	private Double taxRate;

    @Column(name="TAX_SETTING_BASE")
	@ModelProperty(comment="计税基础_枚举值")
	private String taxSettingBase;

    @Column(name="IS_ACCOUNT")
	@ModelProperty(comment="是否核算")
	private Boolean isAccount;

    @Column(name="IS_TAX")
	@ModelProperty(comment="是否含税(Y/N)")
	private Boolean isTax;

    @Column(name="ENABLED_FLAG")
	@ModelProperty(comment="是否启用(Y/N)")
	private Boolean enabledFlag;

    @Column(name="LEGAL_ENTITY_ID")
	@ModelProperty(comment="纳税主体ID")
	private String legalEntityId;

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
    
    @ManyToOne(fetch = FetchType.LAZY)
	@Cascade(CascadeType.REFRESH)
	@JoinColumn(name="INVENTORY_ITEM_ID",insertable=false,updatable=false,nullable=true)
	private TmsMdInventoryItems tmsMdInventoryItems;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrxAffirmSettingCode() {
		return trxAffirmSettingCode;
	}

	public void setTrxAffirmSettingCode(String trxAffirmSettingCode) {
		this.trxAffirmSettingCode = trxAffirmSettingCode;
	}

	public String getTrxAffirmSettingName() {
		return trxAffirmSettingName;
	}

	public void setTrxAffirmSettingName(String trxAffirmSettingName) {
		this.trxAffirmSettingName = trxAffirmSettingName;
	}

	public String getGlobalOrLocalOgrType() {
		return globalOrLocalOgrType;
	}

	public void setGlobalOrLocalOgrType(String globalOrLocalOgrType) {
		this.globalOrLocalOgrType = globalOrLocalOgrType;
	}

	public String getTaxTrxTypeId() {
		return taxTrxTypeId;
	}

	public void setTaxTrxTypeId(String taxTrxTypeId) {
		this.taxTrxTypeId = taxTrxTypeId;
	}

	public String getBusinessCategories() {
		return businessCategories;
	}

	public void setBusinessCategories(String businessCategories) {
		this.businessCategories = businessCategories;
	}

	public String getSpitRuleCode() {
		return spitRuleCode;
	}

	public void setSpitRuleCode(String spitRuleCode) {
		this.spitRuleCode = spitRuleCode;
	}

	public String getTaxCategoryId() {
		return taxCategoryId;
	}

	public void setTaxCategoryId(String taxCategoryId) {
		this.taxCategoryId = taxCategoryId;
	}

	public String getTaxItemId() {
		return taxItemId;
	}

	public void setTaxItemId(String taxItemId) {
		this.taxItemId = taxItemId;
	}

	public String getAccdSegment() {
		return accdSegment;
	}

	public void setAccdSegment(String accdSegment) {
		this.accdSegment = accdSegment;
	}

	public String getTrxItemId() {
		return trxItemId;
	}

	public void setTrxItemId(String trxItemId) {
		this.trxItemId = trxItemId;
	}

	public String getInvoiceCategories() {
		return invoiceCategories;
	}

	public void setInvoiceCategories(String invoiceCategories) {
		this.invoiceCategories = invoiceCategories;
	}

	public String getInvoicingType() {
		return invoicingType;
	}

	public void setInvoicingType(String invoicingType) {
		this.invoicingType = invoicingType;
	}



	public String getTaxSettingBase() {
		return taxSettingBase;
	}

	public void setTaxSettingBase(String taxSettingBase) {
		this.taxSettingBase = taxSettingBase;
	}

	public Boolean getIsAccount() {
		return isAccount;
	}

	public void setIsAccount(Boolean isAccount) {
		this.isAccount = isAccount;
	}

	public Boolean getIsTax() {
		return isTax;
	}

	public void setIsTax(Boolean isTax) {
		this.isTax = isTax;
	}

	public Boolean getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(Boolean enabledFlag) {
		this.enabledFlag = enabledFlag;
	}

	public String getLegalEntityId() {
		return legalEntityId;
	}

	public void setLegalEntityId(String legalEntityId) {
		this.legalEntityId = legalEntityId;
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

	public TmsMdInventoryItems getTmsMdInventoryItems() {
		return tmsMdInventoryItems;
	}

	public void setTmsMdInventoryItems(TmsMdInventoryItems tmsMdInventoryItems) {
		this.tmsMdInventoryItems = tmsMdInventoryItems;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

}

