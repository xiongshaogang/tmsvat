package com.deloitte.tms.vat.salesinvoice.model;



import java.math.BigDecimal;
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

import com.deloitte.tms.base.masterdata.model.Customer;
import com.deloitte.tms.base.masterdata.model.TmsMdLegalEntity;
import com.deloitte.tms.base.taxsetting.model.TmsMdInventoryItems;
import com.deloitte.tms.pl.core.commons.annotation.ModelProperty;
import com.deloitte.tms.pl.core.hibernate.identifier.Ling2UUIDGenerator;
import com.deloitte.tms.pl.core.model.impl.BaseEntity;


/**
 * TmsCrvatInvReqBatchesL generated by ling autoproject
 */
@Entity
@Table(name=TmsCrvatInvReqBatchesL.TABLE)
public class TmsCrvatInvReqBatchesL extends BaseEntity {

	public static final String TABLE = "TMS_CRVAT_INV_REQ_BATCHES_L";
	public static final String SEQ = TABLE;

    @Id
	@GenericGenerator(name=SEQ+"_GENERATOR",strategy=Ling2UUIDGenerator.STRATEGY_NAME,parameters={@Parameter(name="pkColumnValue",value=SEQ)})
	@GeneratedValue(strategy = GenerationType.TABLE, generator = SEQ+"_GENERATOR")

    @Column(name="CRVAT_INV_REQ_BATCHES_L_ID", length=36)
	@ModelProperty(comment="特殊开票申请单行ID")
	private String id;

    @Column(name="CRVAT_INV_REQ_BATCHES_H_ID", length=36)
	@ModelProperty(comment="特殊批量开票申请ID")
	private String crvatInvReqBatchesHId;
    
    @Column(name="CUSTOMER_ID", length=36)
	@ModelProperty(comment="购方名称ID")
	private String customerId;

    @Column(name="SOURCE_CODE", length=100)
	@ModelProperty(comment="来源(柜台/特殊/自动匹配/特殊批量)")
	private String sourceCode;

    @Column(name="PROJECT_ID", length=36)
	@ModelProperty(comment="项目ID")
	private String projectId;

    @Column(name="CONTRACT_ID", length=36)
	@ModelProperty(comment="合同ID(冗余)")
	private String contractId;

    @Column(name="INVENTORY_ITEM_QTY")
	@ModelProperty(comment="数量")
	private Long inventoryItemQty;

    @Column(name="TRX_AFFIRM_SETTING_ID", length=36)
	@ModelProperty(comment="涉税交易认定设置规则ID")
	private String trxAffirmSettingId;

    @Column(name="TAX_TRX_TYPE_ID", length=36)
	@ModelProperty(comment="涉税交易类型ID")
	private String taxTrxTypeId;

    @Column(name="INVOICE_AMOUNT")
	@ModelProperty(comment="本次开票总金额")
	private BigDecimal invoiceAmount;

    @Column(name="IS_TAX", length=10)
	@ModelProperty(comment="是否含税")
	private String isTax;

    @Column(name="TAX_RATE")
	@ModelProperty(comment="税率")
	private Double taxRate;

    @Column(name="START_DATE", length=7)
	@ModelProperty(comment="有效日期")
	private Date startDate;

    @Column(name="END_DATE", length=7)
	@ModelProperty(comment="失效日期")
	private Date endDate;

    @Column(name="REFERENCE1", length=240)
	@ModelProperty(comment="参考字段1")
	private String reference1;

    @Column(name="REFERENCE2", length=240)
	@ModelProperty(comment="参考字段2")
	private String reference2;

    @Column(name="REFERENCE3", length=240)
	@ModelProperty(comment="参考字段3")
	private String reference3;

    @Column(name="REFERENCE4", length=240)
	@ModelProperty(comment="参考字段4")
	private String reference4;

    @Column(name="REFERENCE5", length=240)
	@ModelProperty(comment="参考字段5")
	private String reference5;

    @Column(name="ORG_ID", length=36)
	@ModelProperty(comment="组织ID")
	private String orgId;
    
    @Column(name="INVENTORY_ITEM_ID", length=36)
   	@ModelProperty(comment="商品及服务编码ID")
   	private String inventoryItemId;
    
    @ManyToOne
	@Cascade(CascadeType.REFRESH)
	@JoinColumn(name="INVENTORY_ITEM_ID",insertable=false,updatable=false,nullable=true)
    private TmsMdInventoryItems tmsMdInventoryItems;
    
    public TmsMdInventoryItems getTmsMdInventoryItems() {
		return tmsMdInventoryItems;
	}

	public void setTmsMdInventoryItems(TmsMdInventoryItems tmsMdInventoryItems) {
		this.tmsMdInventoryItems = tmsMdInventoryItems;
	}

	public String getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(String inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	@ManyToOne
	@Cascade(CascadeType.REFRESH)
	@JoinColumn(name="CRVAT_INV_REQ_BATCHES_H_ID",insertable=false,updatable=false,nullable=true)
    private TmsCrvatInvReqBatchesH tmsCrvatInvReqBatchesH;
    
    @ManyToOne
   	@Cascade(CascadeType.REFRESH)
   	@JoinColumn(name="CUSTOMER_ID",insertable=false,updatable=false,nullable=true)
    private Customer customer;
       
    
    
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCrvatInvReqBatchesHId() {
		return crvatInvReqBatchesHId;
	}

	public void setCrvatInvReqBatchesHId(String crvatInvReqBatchesHId) {
		this.crvatInvReqBatchesHId = crvatInvReqBatchesHId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public Long getInventoryItemQty() {
		return inventoryItemQty;
	}

	public void setInventoryItemQty(Long inventoryItemQty) {
		this.inventoryItemQty = inventoryItemQty;
	}

	public String getTrxAffirmSettingId() {
		return trxAffirmSettingId;
	}

	public void setTrxAffirmSettingId(String trxAffirmSettingId) {
		this.trxAffirmSettingId = trxAffirmSettingId;
	}

	public String getTaxTrxTypeId() {
		return taxTrxTypeId;
	}

	public void setTaxTrxTypeId(String taxTrxTypeId) {
		this.taxTrxTypeId = taxTrxTypeId;
	}



	public String getIsTax() {
		return isTax;
	}

	

	public BigDecimal getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public void setIsTax(String isTax) {
		this.isTax = isTax;
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

	public String getReference1() {
		return reference1;
	}

	public void setReference1(String reference1) {
		this.reference1 = reference1;
	}

	public String getReference2() {
		return reference2;
	}

	public void setReference2(String reference2) {
		this.reference2 = reference2;
	}

	public String getReference3() {
		return reference3;
	}

	public void setReference3(String reference3) {
		this.reference3 = reference3;
	}

	public String getReference4() {
		return reference4;
	}

	public void setReference4(String reference4) {
		this.reference4 = reference4;
	}

	public String getReference5() {
		return reference5;
	}

	public void setReference5(String reference5) {
		this.reference5 = reference5;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public TmsCrvatInvReqBatchesH getTmsCrvatInvReqBatchesH() {
		return tmsCrvatInvReqBatchesH;
	}

	public void setTmsCrvatInvReqBatchesH(
			TmsCrvatInvReqBatchesH tmsCrvatInvReqBatchesH) {
		this.tmsCrvatInvReqBatchesH = tmsCrvatInvReqBatchesH;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public Double getTaxRate() {
		return taxRate;
	}
	
}


