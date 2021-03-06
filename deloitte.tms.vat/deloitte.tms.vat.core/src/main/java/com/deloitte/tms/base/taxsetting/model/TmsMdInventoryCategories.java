package com.deloitte.tms.base.taxsetting.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deloitte.tms.pl.core.commons.annotation.ModelProperty;
import com.deloitte.tms.pl.core.hibernate.identifier.Ling2UUIDGenerator;
import com.deloitte.tms.pl.core.model.impl.BaseEntity;

/**
 * TmsMdInventoryCategories generated by ling autoproject
 */
@Entity
@Table(name=TmsMdInventoryCategories.TABLE)
@ModelProperty(comment="商品及服务分类")
public class TmsMdInventoryCategories extends BaseEntity {

	public static final String TABLE = "TMS_MD_INVENTORY_CATEGORIES";
	public static final String SEQ = TABLE;

    @Id
	@GenericGenerator(name=SEQ+"_GENERATOR",strategy=Ling2UUIDGenerator.STRATEGY_NAME,parameters={@Parameter(name="pkColumnValue",value=SEQ)})
	@GeneratedValue(strategy = GenerationType.TABLE, generator = SEQ+"_GENERATOR")

    @Column(name="INVENTORY_CATEGORY_ID")
	@ModelProperty(comment="商品及服务分类ID")
	private String id;

    @Column(name="ORG_ID")
	@ModelProperty(comment="组织ID")
	private String orgId;

    @Column(name="INVENTORY_CATEGORY_CODE")
	@ModelProperty(comment="商品及服务分类代码")
	private String inventoryCategoryCode;

    @Column(name="INVENTORY_CATEGORY_NAME")
	@ModelProperty(comment="商品及服务分类名称")
	private String inventoryCategoryName;

    @Column(name="DESCRIPTION")
	@ModelProperty(comment="描述")
	private String description;

    @Column(name="ENABLED_FLAG")
	@ModelProperty(comment="是否有效")
	private Boolean enabledFlag;

    @Column(name="START_DATE")
	@ModelProperty(comment="有效日期")
	private Date startDate;

    @Column(name="END_DATE")
	@ModelProperty(comment="失效日期")
	private Date endDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getInventoryCategoryCode() {
		return inventoryCategoryCode;
	}

	public void setInventoryCategoryCode(String inventoryCategoryCode) {
		this.inventoryCategoryCode = inventoryCategoryCode;
	}

	public String getInventoryCategoryName() {
		return inventoryCategoryName;
	}

	public void setInventoryCategoryName(String inventoryCategoryName) {
		this.inventoryCategoryName = inventoryCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(Boolean enabledFlag) {
		this.enabledFlag = enabledFlag;
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


}


