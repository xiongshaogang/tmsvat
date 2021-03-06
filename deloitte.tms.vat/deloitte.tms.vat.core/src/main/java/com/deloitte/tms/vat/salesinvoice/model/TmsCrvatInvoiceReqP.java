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

import com.deloitte.tms.pl.core.commons.annotation.ModelProperty;
import com.deloitte.tms.pl.core.hibernate.identifier.Ling2UUIDGenerator;
import com.deloitte.tms.pl.core.model.impl.BaseEntity;

/**
 * 销项税开票申请单--特殊开票 行信息</br>
 * TmsCrvatInvoiceReqP generated by ling autoproject
 */
@Entity
@Table(name=TmsCrvatInvoiceReqP.TABLE)
@ModelProperty(comment="特殊开票申请单行")
public class TmsCrvatInvoiceReqP extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7320385370358772520L;
	public static final String TABLE = "TMS_CRVAT_INVOICE_REQ_P";
	public static final String SEQ = TABLE;

    @Id
	@GenericGenerator(name=SEQ+"_GENERATOR",strategy=Ling2UUIDGenerator.STRATEGY_NAME,parameters={@Parameter(name="pkColumnValue",value=SEQ)})
	@GeneratedValue(strategy = GenerationType.TABLE, generator = SEQ+"_GENERATOR")

    @Column(name="CRVAT_INVOICE_REQ_P_ID", length=36)
	@ModelProperty(comment="特殊开票申请单行ID")
	private String id;

    @Column(name="CRVAT_INVOICE_REQ_H_ID", length=36)
	@ModelProperty(comment="开票申请单-头表ID")
	private String crvatInvoiceReqHId;
    
    @ManyToOne(fetch=FetchType.EAGER)
	@Cascade(CascadeType.REFRESH)
	@JoinColumn(name="CRVAT_INVOICE_REQ_H_ID",insertable=false,updatable=false,nullable=true)
	InvoiceReqH invoiceReqH;

    @Column(name="INVOICING_TYPE", length=100)
	@ModelProperty(comment="开票方式_枚举值(明细/汇总)")
	private String invoicingType;

    @Column(name="ACCTD_AMOUNT_CR")
	@ModelProperty(comment="本次开票金额(不含税)")
    private BigDecimal acctdAmountCr;

    @Column(name="VAT_AMOUNT")
	@ModelProperty(comment="本次开票税额")
	private BigDecimal vatAmount;

    @Column(name="INVOICE_AMOUNT")
	@ModelProperty(comment="本次开票总金额")
	private BigDecimal invoiceAmount;

    @Column(name="SOURCE_CODE", length=100)
	@ModelProperty(comment="交易来源_枚举值(仅手工)")
	private String sourceCode;

    @Column(name="TAX_TRX_TYPE_ID", length=36)
	@ModelProperty(comment="涉税交易类型ID")
	private String taxTrxTypeId;

    @Column(name="LEGAL_ENTITY_ID", length=36)
	@ModelProperty(comment="销方纳税人实体ID")
	private String legalEntityId;

    @Column(name="LEGAL_ENTITY_CODE", length=100)
	@ModelProperty(comment="销方纳税人实体CODE")
	private String legalEntityCode;

    @Column(name="LEGAL_ENTITY_NAME", length=500)
	@ModelProperty(comment="销方纳税人实体名称")
	private String legalEntityName;

    @Column(name="REGISTRATION_NUMBER", length=100)
	@ModelProperty(comment="销方证件号码")
	private String registrationNumber;

    @Column(name="REGISTRATION_CODE", length=100)
	@ModelProperty(comment="销方证件类型_枚举值")
	private String registrationCode;

    @Column(name="INVENTORY_ITEM_ID", length=100)
	@ModelProperty(comment="货物ID")
	private String inventoryItemId;

    @Column(name="INVENTORY_ITEM_NUMBER", length=100)
	@ModelProperty(comment="商品及服务编码")
	private String inventoryItemNumber;

    @Column(name="INVENTORY_ITEM_DESCRIPTON", length=2000)
	@ModelProperty(comment="商品及服务名称")
	private String inventoryItemDescripton;

    @Column(name="INVENTORY_ITEM_MODELS", length=500)
	@ModelProperty(comment="规格型号")
	private String inventoryItemModels;

    @Column(name="UOM_CODE", length=100)
	@ModelProperty(comment="单位代码")
	private String uomCode;

    @Column(name="UOM_CODE_DESCRIPTON", length=100)
	@ModelProperty(comment="单位名称")
	private String uomCodeDescripton;

    @Column(name="INVENTORY_ITEM_QTY")
	@ModelProperty(comment="货物数量")
	private Long inventoryItemQty;

    @Column(name="PRICE_OF_UNIT")
	@ModelProperty(comment="单价")
	private Long priceOfUnit;

    @Column(name="START_DATE", length=7)
	@ModelProperty(comment="有效日期")
	private Date startDate;

    @Column(name="END_DATE", length=7)
	@ModelProperty(comment="失效日期")
	private Date endDate;

    @Column(name="ORG_ID", length=36)
	@ModelProperty(comment="组织ID")
	private String orgId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCrvatInvoiceReqHId() {
		return crvatInvoiceReqHId;
	}

	public void setCrvatInvoiceReqHId(String crvatInvoiceReqHId) {
		this.crvatInvoiceReqHId = crvatInvoiceReqHId;
	}

	public String getInvoicingType() {
		return invoicingType;
	}

	public void setInvoicingType(String invoicingType) {
		this.invoicingType = invoicingType;
	}


	public BigDecimal getAcctdAmountCr() {
		return acctdAmountCr;
	}

	public void setAcctdAmountCr(BigDecimal acctdAmountCr) {
		this.acctdAmountCr = acctdAmountCr;
	}

	public BigDecimal getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	public BigDecimal getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getTaxTrxTypeId() {
		return taxTrxTypeId;
	}

	public void setTaxTrxTypeId(String taxTrxTypeId) {
		this.taxTrxTypeId = taxTrxTypeId;
	}

	public String getLegalEntityId() {
		return legalEntityId;
	}

	public void setLegalEntityId(String legalEntityId) {
		this.legalEntityId = legalEntityId;
	}

	public String getLegalEntityCode() {
		return legalEntityCode;
	}

	public void setLegalEntityCode(String legalEntityCode) {
		this.legalEntityCode = legalEntityCode;
	}

	public String getLegalEntityName() {
		return legalEntityName;
	}

	public void setLegalEntityName(String legalEntityName) {
		this.legalEntityName = legalEntityName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public String getInventoryItemId() {
		return inventoryItemId;
	}

	public void setInventoryItemId(String inventoryItemId) {
		this.inventoryItemId = inventoryItemId;
	}

	public String getInventoryItemNumber() {
		return inventoryItemNumber;
	}

	public void setInventoryItemNumber(String inventoryItemNumber) {
		this.inventoryItemNumber = inventoryItemNumber;
	}

	public String getInventoryItemDescripton() {
		return inventoryItemDescripton;
	}

	public void setInventoryItemDescripton(String inventoryItemDescripton) {
		this.inventoryItemDescripton = inventoryItemDescripton;
	}

	public String getInventoryItemModels() {
		return inventoryItemModels;
	}

	public void setInventoryItemModels(String inventoryItemModels) {
		this.inventoryItemModels = inventoryItemModels;
	}

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public String getUomCodeDescripton() {
		return uomCodeDescripton;
	}

	public void setUomCodeDescripton(String uomCodeDescripton) {
		this.uomCodeDescripton = uomCodeDescripton;
	}

	public Long getInventoryItemQty() {
		return inventoryItemQty;
	}

	public void setInventoryItemQty(Long inventoryItemQty) {
		this.inventoryItemQty = inventoryItemQty;
	}

	public Long getPriceOfUnit() {
		return priceOfUnit;
	}

	public void setPriceOfUnit(Long priceOfUnit) {
		this.priceOfUnit = priceOfUnit;
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

	public InvoiceReqH getInvoiceReqH() {
		return invoiceReqH;
	}

	public void setInvoiceReqH(InvoiceReqH invoiceReqH) {
		this.invoiceReqH = invoiceReqH;
	}
	
	
}


