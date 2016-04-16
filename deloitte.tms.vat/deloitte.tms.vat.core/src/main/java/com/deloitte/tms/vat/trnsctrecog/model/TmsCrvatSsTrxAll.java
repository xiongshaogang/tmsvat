package com.deloitte.tms.vat.trnsctrecog.model;

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
import com.deloitte.tms.base.masterdata.model.Customer;
import com.deloitte.tms.base.taxsetting.model.TmsMdFlexStructures;
import com.deloitte.tms.pl.core.commons.annotation.ModelProperty;
import com.deloitte.tms.pl.core.hibernate.identifier.Ling2UUIDGenerator;
import com.deloitte.tms.pl.core.model.impl.BaseEntity;

/**
 * TmsCrvatSsTrxAll generated by ling autoproject
 */
@Entity
@Table(name=TmsCrvatSsTrxAll.TABLE)
public class TmsCrvatSsTrxAll extends BaseEntity {

	public static final String TABLE = "TMS_CRVAT_SS_TRX_ALL";
	public static final String SEQ = TABLE;
	
	@ManyToOne
	@Cascade(CascadeType.REFRESH)
	@JoinColumn(name="ORG_ID",insertable=false,updatable=false,nullable=true)
	private BaseOrg baseOrg;
	
	@ManyToOne
	@Cascade(CascadeType.REFRESH)
	@JoinColumn(name="CUSTOMER_ID",insertable=false,updatable=false,nullable=true)
	//TmsMdFlexStructures tmsMdFlexStructures;
	Customer customer;

    public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BaseOrg getBaseOrg() {
		return baseOrg;
	}

	public void setBaseOrg(BaseOrg baseOrg) {
		this.baseOrg = baseOrg;
	}


	@Id
	@GenericGenerator(name=SEQ+"_GENERATOR",strategy=Ling2UUIDGenerator.STRATEGY_NAME,parameters={@Parameter(name="pkColumnValue",value=SEQ)})
	@GeneratedValue(strategy = GenerationType.TABLE, generator = SEQ+"_GENERATOR")

    @Column(name="SALES_TRX_ID", length=36)
	@ModelProperty(comment="交易汇总数据ID")
	private String id;

    @Column(name="PERIOD_NAME", length=100)
	@ModelProperty(comment="所属期间(1.2.3月)")
	private String periodName;

    @Column(name="TRX_BATCH_NUM", length=100)
	@ModelProperty(comment="交易批次号")
	private String trxBatchNum;

    @Column(name="TRX_NUMBER", length=100)
	@ModelProperty(comment="交易流水号")
	private String trxNumber;

    @Column(name="TRX_EVENT_ID", length=100)
	@ModelProperty(comment="交易分录行号")
	private String trxEventId;

    @Column(name="TRX_DATE", length=7)
	@ModelProperty(comment="交易日期")
	private Date trxDate;

    @Column(name="ACCOUNT_DATE", length=7)
	@ModelProperty(comment="记账日期")
	private Date accountDate;

    @Column(name="INVENTORY_CATEGORY_ID", length=36)
	@ModelProperty(comment="商品及服务分类ID")
	private String inventoryCategoryId;

    @Column(name="INVENTORY_ITEM_ID", length=100)
	@ModelProperty(comment="商品及服务ID")
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

    @Column(name="SOURCE_CODE", length=100)
	@ModelProperty(comment="来源系统")
	private String sourceCode;

    @Column(name="SOURCE_TRX_ID", length=100)
	@ModelProperty(comment="来源数据头ID")
	private String sourceTrxId;

    @Column(name="SOURCE_TRX_LINE_ID", length=100)
	@ModelProperty(comment="来源数据行ID")
	private String sourceTrxLineId;

    @Column(name="SOURCE_TRX_LINE_TYPE", length=100)
	@ModelProperty(comment="来源数据行类型")
	private String sourceTrxLineType;

    @Column(name="SOURCE_TRX_DETAIL_TAX_LINE_ID", length=100)
	@ModelProperty(comment="来源数据明细税ID")
	private String sourceTrxDetailTaxLineId;

    @Column(name="SOURCE_DISTRIBUTION_ID", length=100)
	@ModelProperty(comment="来源数据明细ID")
	private String sourceDistributionId;

    @Column(name="SOURCE_INV_CATEGORY_ID", length=36)
	@ModelProperty(comment="来源商品及服务分类ID")
	private String sourceInvCategoryId;

    @Column(name="SOURCE_INV_ITEM_ID", length=100)
	@ModelProperty(comment="来源商品及服务ID")
	private String sourceInvItemId;

    @Column(name="SOURCE_INV_ITEM_NUMBER", length=100)
	@ModelProperty(comment="来源商品及服务编码")
	private String sourceInvItemNumber;

    @Column(name="SOURCE_INV_ITEM_DESCRIPTON", length=2000)
	@ModelProperty(comment="来源商品及服务名称")
	private String sourceInvItemDescripton;

    @Column(name="SOURCE_INV_ITEM_MODELS", length=500)
	@ModelProperty(comment="来源规格型号")
	private String sourceInvItemModels;

    @Column(name="SOURCE_INV_UOM_CODE", length=100)
	@ModelProperty(comment="来源单位代码")
	private String sourceInvUomCode;

    @Column(name="SOURCE_INV_UOM_CODE_DESC", length=100)
	@ModelProperty(comment="来源单位名称")
	private String sourceInvUomCodeDesc;

    @Column(name="ACCD_COMBINATION_ID", length=36)
	@ModelProperty(comment="会计科目结构组合ID")
	private String accdCombinationId;

    @Column(name="ACCD_COMBINATION_NAME", length=2000)
	@ModelProperty(comment="会计科目结构组合说明")
	private String accdCombinationName;

    @Column(name="ACCD_COMBINATION_CODE", length=2000)
	@ModelProperty(comment="会计科目结构组合代码")
	private String accdCombinationCode;

    @Column(name="ORIGINAL_CURRENCY_CODE", length=100)
	@ModelProperty(comment="原币种_枚举值")
	private String originalCurrencyCode;

    @Column(name="ORIGINAL_CURRENCY_AMOUNT_DR")
	@ModelProperty(comment="原币借方金额")
	private Long originalCurrencyAmountDr;

    @Column(name="ORIGINAL_CURRENCY_AMOUNT_CR")
	@ModelProperty(comment="原币贷方金额")
	private Long originalCurrencyAmountCr;

    @Column(name="CURRENCY_CODE", length=100)
	@ModelProperty(comment="本位币_枚举值")
	private String currencyCode;

    @Column(name="CURRENCY_AMOUNT_DR")
	@ModelProperty(comment="本位币借方金额")
	private Long currencyAmountDr;

    @Column(name="CURRENCY_AMOUNT_CR")
	@ModelProperty(comment="本位币贷方金额")
	private Long currencyAmountCr;

    @Column(name="EXCHANGE_RATE")
	@ModelProperty(comment="开票汇率")
	private Long exchangeRate;

    @Column(name="RATE_TYPE", length=100)
	@ModelProperty(comment="汇率类型")
	private String rateType;

    @Column(name="RATE_DATE", length=7)
	@ModelProperty(comment="汇率日期")
	private Date rateDate;

    @Column(name="ACCOUNT_RATE")
	@ModelProperty(comment="核算汇率")
	private Long accountRate;

    @Column(name="CUSTOMER_ID", length=36)
	@ModelProperty(comment="客户ID")
	private String customerId;

    @Column(name="IMPORT_DATE", length=7)
	@ModelProperty(comment="导入日期")
	private Date importDate;

    @Column(name="ACCOUNT_SEGMENT", length=100)
	@ModelProperty(comment="会计科目编码(C)")
	private String accountSegment;

    @Column(name="ACCOUNT_SEGMENT_NAME", length=100)
	@ModelProperty(comment="会计科目名称")
	private String accountSegmentName;

    @Column(name="IS_FARM", length=100)
	@ModelProperty(comment="是否涉农(D)")
	private String isFarm;

    @Column(name="IS_AREA", length=100)
	@ModelProperty(comment="境内外(E)")
	private String isArea;

    @Column(name="TAX_TRX_TYPE_ID", length=36)
	@ModelProperty(comment="涉税交易类型ID")
	private String taxTrxTypeId;

    @Column(name="BSN_COMBINATION_ID", length=36)
	@ModelProperty(comment="业务数据结构组合ID")
	private String bsnCombinationId;

    @Column(name="BSN_COMBINATION_CODE", length=2000)
	@ModelProperty(comment="业务数据结构组合代码")
	private String bsnCombinationCode;

    @Column(name="BSN_COMBINATION_NAME", length=2000)
	@ModelProperty(comment="业务数据结构组合说明")
	private String bsnCombinationName;

    @Column(name="TRANS_SEGMENT1", length=100)
	@ModelProperty(comment="业务字段1")
	private String transSegment1;

    @Column(name="TRANS_SEGMENT2", length=100)
	@ModelProperty(comment="业务字段2")
	private String transSegment2;

    @Column(name="TRANS_SEGMENT3", length=100)
	@ModelProperty(comment="业务字段3")
	private String transSegment3;

    @Column(name="TRANS_SEGMENT4", length=100)
	@ModelProperty(comment="业务字段4")
	private String transSegment4;

    @Column(name="TRANS_SEGMENT5", length=100)
	@ModelProperty(comment="业务字段5")
	private String transSegment5;

    @Column(name="TRANS_SEGMENT6", length=100)
	@ModelProperty(comment="业务字段6")
	private String transSegment6;

    @Column(name="TRANS_SEGMENT7", length=100)
	@ModelProperty(comment="业务字段7")
	private String transSegment7;

    @Column(name="TRANS_SEGMENT8", length=100)
	@ModelProperty(comment="业务字段8")
	private String transSegment8;

    @Column(name="TRANS_SEGMENT9", length=100)
	@ModelProperty(comment="业务字段9")
	private String transSegment9;

    @Column(name="TRANS_SEGMENT10", length=100)
	@ModelProperty(comment="业务字段10")
	private String transSegment10;

    @Column(name="CCID_SEGMENT1", length=100)
	@ModelProperty(comment="会计字段1")
	private String ccidSegment1;

    @Column(name="CCID_SEGMENT2", length=100)
	@ModelProperty(comment="会计字段2")
	private String ccidSegment2;

    @Column(name="CCID_SEGMENT3", length=100)
	@ModelProperty(comment="会计字段3")
	private String ccidSegment3;

    @Column(name="CCID_SEGMENT4", length=100)
	@ModelProperty(comment="会计字段4")
	private String ccidSegment4;

    @Column(name="CCID_SEGMENT5", length=100)
	@ModelProperty(comment="会计字段5")
	private String ccidSegment5;

    @Column(name="CCID_SEGMENT6", length=100)
	@ModelProperty(comment="会计字段6")
	private String ccidSegment6;

    @Column(name="CCID_SEGMENT7", length=100)
	@ModelProperty(comment="会计字段7")
	private String ccidSegment7;

    @Column(name="CCID_SEGMENT8", length=100)
	@ModelProperty(comment="会计字段8")
	private String ccidSegment8;

    @Column(name="CCID_SEGMENT9", length=100)
	@ModelProperty(comment="会计字段9")
	private String ccidSegment9;

    @Column(name="CCID_SEGMENT10", length=100)
	@ModelProperty(comment="会计字段10")
	private String ccidSegment10;

    @Column(name="TRX_CATEGORY_ID", length=36)
	@ModelProperty(comment="交易类型ID")
	private String trxCategoryId;

    @Column(name="AMOUNT_OF_SALES_TRX")
	@ModelProperty(comment="交易总额")
	private Long amountOfSalasTrx;

    @Column(name="CAPITAL_ACCOUNT_NUM", length=240)
	@ModelProperty(comment="资金账号")
	private String capitalAccountNum;

    @Column(name="SOURCE_CUSTOMER_CODE", length=100)
	@ModelProperty(comment="来源客户代码")
	private String sourceCustomerCode;

    @Column(name="SOURCE_CUSTOMER_NAME", length=500)
	@ModelProperty(comment="来源客户名称")
	private String sourceCustomerName;

    @Column(name="SOURCE_CUSTOMER_TYPE", length=100)
	@ModelProperty(comment="来源客户类型")
	private String sourceCustomerType;

    @Column(name="BANK_NUMBER", length=100)
	@ModelProperty(comment="银行代码")
	private String bankNumber;

    @Column(name="BANK_ACCOUNT_NUM", length=100)
	@ModelProperty(comment="银行账号")
	private String bankAccountNum;

    @Column(name="PRICE_OF_UNIT")
	@ModelProperty(comment="单价")
	private Long priceOfUnit;

    @Column(name="ORG_ID", length=36)
	@ModelProperty(comment="组织")
	private String orgId;

    @Column(name="IS_AFFIRM", length=10)
	@ModelProperty(comment="是否已认定")
	private Boolean isAffirm;

    


	public String getAttribute7() {
		return attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	
	@Column(name="ATTRIBUTE7")
	private String attribute7;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPeriodName() {
		return periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public String getTrxBatchNum() {
		return trxBatchNum;
	}

	public void setTrxBatchNum(String trxBatchNum) {
		this.trxBatchNum = trxBatchNum;
	}

	public String getTrxNumber() {
		return trxNumber;
	}

	public void setTrxNumber(String trxNumber) {
		this.trxNumber = trxNumber;
	}

	public String getTrxEventId() {
		return trxEventId;
	}

	public void setTrxEventId(String trxEventId) {
		this.trxEventId = trxEventId;
	}

	public Date getTrxDate() {
		return trxDate;
	}

	public void setTrxDate(Date trxDate) {
		this.trxDate = trxDate;
	}

	public Date getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

	public String getInventoryCategoryId() {
		return inventoryCategoryId;
	}

	public void setInventoryCategoryId(String inventoryCategoryId) {
		this.inventoryCategoryId = inventoryCategoryId;
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

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceTrxId() {
		return sourceTrxId;
	}

	public void setSourceTrxId(String sourceTrxId) {
		this.sourceTrxId = sourceTrxId;
	}

	public String getSourceTrxLineId() {
		return sourceTrxLineId;
	}

	public void setSourceTrxLineId(String sourceTrxLineId) {
		this.sourceTrxLineId = sourceTrxLineId;
	}

	public String getSourceTrxLineType() {
		return sourceTrxLineType;
	}

	public void setSourceTrxLineType(String sourceTrxLineType) {
		this.sourceTrxLineType = sourceTrxLineType;
	}

	public String getSourceTrxDetailTaxLineId() {
		return sourceTrxDetailTaxLineId;
	}

	public void setSourceTrxDetailTaxLineId(String sourceTrxDetailTaxLineId) {
		this.sourceTrxDetailTaxLineId = sourceTrxDetailTaxLineId;
	}

	public String getSourceDistributionId() {
		return sourceDistributionId;
	}

	public void setSourceDistributionId(String sourceDistributionId) {
		this.sourceDistributionId = sourceDistributionId;
	}

	public String getSourceInvCategoryId() {
		return sourceInvCategoryId;
	}

	public void setSourceInvCategoryId(String sourceInvCategoryId) {
		this.sourceInvCategoryId = sourceInvCategoryId;
	}

	public String getSourceInvItemId() {
		return sourceInvItemId;
	}

	public void setSourceInvItemId(String sourceInvItemId) {
		this.sourceInvItemId = sourceInvItemId;
	}

	public String getSourceInvItemNumber() {
		return sourceInvItemNumber;
	}

	public void setSourceInvItemNumber(String sourceInvItemNumber) {
		this.sourceInvItemNumber = sourceInvItemNumber;
	}

	public String getSourceInvItemDescripton() {
		return sourceInvItemDescripton;
	}

	public void setSourceInvItemDescripton(String sourceInvItemDescripton) {
		this.sourceInvItemDescripton = sourceInvItemDescripton;
	}

	public String getSourceInvItemModels() {
		return sourceInvItemModels;
	}

	public void setSourceInvItemModels(String sourceInvItemModels) {
		this.sourceInvItemModels = sourceInvItemModels;
	}

	public String getSourceInvUomCode() {
		return sourceInvUomCode;
	}

	public void setSourceInvUomCode(String sourceInvUomCode) {
		this.sourceInvUomCode = sourceInvUomCode;
	}

	public String getSourceInvUomCodeDesc() {
		return sourceInvUomCodeDesc;
	}

	public void setSourceInvUomCodeDesc(String sourceInvUomCodeDesc) {
		this.sourceInvUomCodeDesc = sourceInvUomCodeDesc;
	}

	public String getAccdCombinationId() {
		return accdCombinationId;
	}

	public void setAccdCombinationId(String accdCombinationId) {
		this.accdCombinationId = accdCombinationId;
	}

	public String getAccdCombinationName() {
		return accdCombinationName;
	}

	public void setAccdCombinationName(String accdCombinationName) {
		this.accdCombinationName = accdCombinationName;
	}

	public String getAccdCombinationCode() {
		return accdCombinationCode;
	}

	public void setAccdCombinationCode(String accdCombinationCode) {
		this.accdCombinationCode = accdCombinationCode;
	}

	public String getOriginalCurrencyCode() {
		return originalCurrencyCode;
	}

	public void setOriginalCurrencyCode(String originalCurrencyCode) {
		this.originalCurrencyCode = originalCurrencyCode;
	}

	public Long getOriginalCurrencyAmountDr() {
		return originalCurrencyAmountDr;
	}

	public void setOriginalCurrencyAmountDr(Long originalCurrencyAmountDr) {
		this.originalCurrencyAmountDr = originalCurrencyAmountDr;
	}

	public Long getOriginalCurrencyAmountCr() {
		return originalCurrencyAmountCr;
	}

	public void setOriginalCurrencyAmountCr(Long originalCurrencyAmountCr) {
		this.originalCurrencyAmountCr = originalCurrencyAmountCr;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Long getCurrencyAmountDr() {
		return currencyAmountDr;
	}

	public void setCurrencyAmountDr(Long currencyAmountDr) {
		this.currencyAmountDr = currencyAmountDr;
	}

	public Long getCurrencyAmountCr() {
		return currencyAmountCr;
	}

	public void setCurrencyAmountCr(Long currencyAmountCr) {
		this.currencyAmountCr = currencyAmountCr;
	}

	public Long getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Long exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public Date getRateDate() {
		return rateDate;
	}

	public void setRateDate(Date rateDate) {
		this.rateDate = rateDate;
	}

	public Long getAccountRate() {
		return accountRate;
	}

	public void setAccountRate(Long accountRate) {
		this.accountRate = accountRate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public String getAccountSegment() {
		return accountSegment;
	}

	public void setAccountSegment(String accountSegment) {
		this.accountSegment = accountSegment;
	}

	public String getAccountSegmentName() {
		return accountSegmentName;
	}

	public void setAccountSegmentName(String accountSegmentName) {
		this.accountSegmentName = accountSegmentName;
	}

	public String getIsFarm() {
		return isFarm;
	}

	public void setIsFarm(String isFarm) {
		this.isFarm = isFarm;
	}

	public String getIsArea() {
		return isArea;
	}

	public void setIsArea(String isArea) {
		this.isArea = isArea;
	}

	public String getTaxTrxTypeId() {
		return taxTrxTypeId;
	}

	public void setTaxTrxTypeId(String taxTrxTypeId) {
		this.taxTrxTypeId = taxTrxTypeId;
	}

	public String getBsnCombinationId() {
		return bsnCombinationId;
	}

	public void setBsnCombinationId(String bsnCombinationId) {
		this.bsnCombinationId = bsnCombinationId;
	}

	public String getBsnCombinationCode() {
		return bsnCombinationCode;
	}

	public void setBsnCombinationCode(String bsnCombinationCode) {
		this.bsnCombinationCode = bsnCombinationCode;
	}

	public String getBsnCombinationName() {
		return bsnCombinationName;
	}

	public void setBsnCombinationName(String bsnCombinationName) {
		this.bsnCombinationName = bsnCombinationName;
	}

	public String getTransSegment1() {
		return transSegment1;
	}

	public void setTransSegment1(String transSegment1) {
		this.transSegment1 = transSegment1;
	}

	public String getTransSegment2() {
		return transSegment2;
	}

	public void setTransSegment2(String transSegment2) {
		this.transSegment2 = transSegment2;
	}

	public String getTransSegment3() {
		return transSegment3;
	}

	public void setTransSegment3(String transSegment3) {
		this.transSegment3 = transSegment3;
	}

	public String getTransSegment4() {
		return transSegment4;
	}

	public void setTransSegment4(String transSegment4) {
		this.transSegment4 = transSegment4;
	}

	public String getTransSegment5() {
		return transSegment5;
	}

	public void setTransSegment5(String transSegment5) {
		this.transSegment5 = transSegment5;
	}

	public String getTransSegment6() {
		return transSegment6;
	}

	public void setTransSegment6(String transSegment6) {
		this.transSegment6 = transSegment6;
	}

	public String getTransSegment7() {
		return transSegment7;
	}

	public void setTransSegment7(String transSegment7) {
		this.transSegment7 = transSegment7;
	}

	public String getTransSegment8() {
		return transSegment8;
	}

	public void setTransSegment8(String transSegment8) {
		this.transSegment8 = transSegment8;
	}

	public String getTransSegment9() {
		return transSegment9;
	}

	public void setTransSegment9(String transSegment9) {
		this.transSegment9 = transSegment9;
	}

	public String getTransSegment10() {
		return transSegment10;
	}

	public void setTransSegment10(String transSegment10) {
		this.transSegment10 = transSegment10;
	}

	public String getCcidSegment1() {
		return ccidSegment1;
	}

	public void setCcidSegment1(String ccidSegment1) {
		this.ccidSegment1 = ccidSegment1;
	}

	public String getCcidSegment2() {
		return ccidSegment2;
	}

	public void setCcidSegment2(String ccidSegment2) {
		this.ccidSegment2 = ccidSegment2;
	}

	public String getCcidSegment3() {
		return ccidSegment3;
	}

	public void setCcidSegment3(String ccidSegment3) {
		this.ccidSegment3 = ccidSegment3;
	}

	public String getCcidSegment4() {
		return ccidSegment4;
	}

	public void setCcidSegment4(String ccidSegment4) {
		this.ccidSegment4 = ccidSegment4;
	}

	public String getCcidSegment5() {
		return ccidSegment5;
	}

	public void setCcidSegment5(String ccidSegment5) {
		this.ccidSegment5 = ccidSegment5;
	}

	public String getCcidSegment6() {
		return ccidSegment6;
	}

	public void setCcidSegment6(String ccidSegment6) {
		this.ccidSegment6 = ccidSegment6;
	}

	public String getCcidSegment7() {
		return ccidSegment7;
	}

	public void setCcidSegment7(String ccidSegment7) {
		this.ccidSegment7 = ccidSegment7;
	}

	public String getCcidSegment8() {
		return ccidSegment8;
	}

	public void setCcidSegment8(String ccidSegment8) {
		this.ccidSegment8 = ccidSegment8;
	}

	public String getCcidSegment9() {
		return ccidSegment9;
	}

	public void setCcidSegment9(String ccidSegment9) {
		this.ccidSegment9 = ccidSegment9;
	}

	public String getCcidSegment10() {
		return ccidSegment10;
	}

	public void setCcidSegment10(String ccidSegment10) {
		this.ccidSegment10 = ccidSegment10;
	}

	public String getTrxCategoryId() {
		return trxCategoryId;
	}

	public void setTrxCategoryId(String trxCategoryId) {
		this.trxCategoryId = trxCategoryId;
	}

	public Long getAmountOfSalasTrx() {
		return amountOfSalasTrx;
	}

	public void setAmountOfSalasTrx(Long amountOfSalasTrx) {
		this.amountOfSalasTrx = amountOfSalasTrx;
	}

	public String getCapitalAccountNum() {
		return capitalAccountNum;
	}

	public void setCapitalAccountNum(String capitalAccountNum) {
		this.capitalAccountNum = capitalAccountNum;
	}

	public String getSourceCustomerCode() {
		return sourceCustomerCode;
	}

	public void setSourceCustomerCode(String sourceCustomerCode) {
		this.sourceCustomerCode = sourceCustomerCode;
	}

	public String getSourceCustomerName() {
		return sourceCustomerName;
	}

	public void setSourceCustomerName(String sourceCustomerName) {
		this.sourceCustomerName = sourceCustomerName;
	}

	public String getSourceCustomerType() {
		return sourceCustomerType;
	}

	public void setSourceCustomerType(String sourceCustomerType) {
		this.sourceCustomerType = sourceCustomerType;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getBankAccountNum() {
		return bankAccountNum;
	}

	public void setBankAccountNum(String bankAccountNum) {
		this.bankAccountNum = bankAccountNum;
	}

	public Long getPriceOfUnit() {
		return priceOfUnit;
	}

	public void setPriceOfUnit(Long priceOfUnit) {
		this.priceOfUnit = priceOfUnit;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Boolean getIsAffirm() {
		return isAffirm;
	}

	public void setIsAffirm(Boolean isAffirm) {
		this.isAffirm = isAffirm;
	}
	
    

}

