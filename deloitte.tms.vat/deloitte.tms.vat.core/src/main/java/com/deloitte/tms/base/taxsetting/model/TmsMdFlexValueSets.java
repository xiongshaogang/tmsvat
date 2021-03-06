package com.deloitte.tms.base.taxsetting.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;

import com.deloitte.tms.pl.core.commons.annotation.ModelProperty;
import com.deloitte.tms.pl.core.hibernate.identifier.Ling2UUIDGenerator;
import com.deloitte.tms.pl.core.model.impl.BaseEntity;

/**
 * TmsMdFlexValueSets generated by ling autoproject
 */
@Entity
@Table(name=TmsMdFlexValueSets.TABLE)
@ModelProperty(comment="值集定义")
public class TmsMdFlexValueSets extends BaseEntity {

	public static final String TABLE = "TMS_MD_FLEX_VALUE_SETS";
	public static final String SEQ = TABLE;

    @Id
	@GenericGenerator(name=SEQ+"_GENERATOR",strategy=Ling2UUIDGenerator.STRATEGY_NAME,parameters={@Parameter(name="pkColumnValue",value=SEQ)})
	@GeneratedValue(strategy = GenerationType.TABLE, generator = SEQ+"_GENERATOR")

    @Column(name="FLEX_VALUE_SET_ID")
	@ModelProperty(comment="值集ID")
	private String id;

    @Column(name="FLEX_VALUE_SET_NAME")
	@ModelProperty(comment="值集名")
	private String flexValueSetName;

    @Column(name="DESCRIPTION")
	@ModelProperty(comment="描述")
	private String description;

    @Column(name="ENABLED_FLAG")
	@ModelProperty(comment="是否启用")
	private Boolean enabledFlag;

    @Column(name="SOURCE_CODE")
	@ModelProperty(comment="来源代码")
	private String sourceCode;

    @Column(name="SOURCE_HEADER_ID")
	@ModelProperty(comment="来源ID")
	private String sourceHeaderId;

    @Column(name="PARENT_FLEX_VALUE_SET_ID")
	@ModelProperty(comment="父结点")
	private String parentFlexValueSetId;
    
    @Column(name="FLEX_VALUE_SET_CODE")
    @ModelProperty(comment="值集代码")
    private String flexValueSetCode;
    

    @Column(name="START_DATE_ACTIVE")
	@ModelProperty(comment="开始日期")
	private Date startDateActive;

    @Column(name="END_DATE_ACTIVE")
	@ModelProperty(comment="结束日期")
	private Date endDateActive;
    
	@OneToMany(mappedBy = "tmsMdFlexValueSets", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@Where(clause="DELETED_FLAG=1")
	Collection<TmsMdFlexValues> tmsMdFlexValues = new ArrayList<TmsMdFlexValues>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlexValueSetName() {
		return flexValueSetName;
	}

	public void setFlexValueSetName(String flexValueSetName) {
		this.flexValueSetName = flexValueSetName;
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

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceHeaderId() {
		return sourceHeaderId;
	}

	public void setSourceHeaderId(String sourceHeaderId) {
		this.sourceHeaderId = sourceHeaderId;
	}

	public String getParentFlexValueSetId() {
		return parentFlexValueSetId;
	}

	public void setParentFlexValueSetId(String parentFlexValueSetId) {
		this.parentFlexValueSetId = parentFlexValueSetId;
	}

	public Date getStartDateActive() {
		return startDateActive;
	}

	public void setStartDateActive(Date startDateActive) {
		this.startDateActive = startDateActive;
	}

	public Date getEndDateActive() {
		return endDateActive;
	}

	public void setEndDateActive(Date endDateActive) {
		this.endDateActive = endDateActive;
	}

	public String getFlexValueSetCode() {
		return flexValueSetCode;
	}

	public void setFlexValueSetCode(String flexValueSetCode) {
		this.flexValueSetCode = flexValueSetCode;
	}

	public Collection<TmsMdFlexValues> getTmsMdFlexValues() {
		return tmsMdFlexValues;
	}

	public void setTmsMdFlexValues(Collection<TmsMdFlexValues> tmsMdFlexValues) {
		this.tmsMdFlexValues = tmsMdFlexValues;
	}
	
}


