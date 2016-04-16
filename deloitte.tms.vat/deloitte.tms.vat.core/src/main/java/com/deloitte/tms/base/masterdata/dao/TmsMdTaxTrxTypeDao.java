package com.deloitte.tms.base.masterdata.dao;
// Generated by bo.wang with ling2.autoproject

import java.util.List;
import java.util.Map;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.dao.IDao;
import com.deloitte.tms.base.masterdata.model.TmsMdTaxTrxType;
/**
 * Home object for domain model class TmsMdTaxTrxType.
 * @see com.deloitte.tms.base.masterdata.model
 * @author Hibernate Tools
 */
public interface TmsMdTaxTrxTypeDao extends IDao<TmsMdTaxTrxType>{
	public static final String BEAN_ID="tmsMdTaxTrxTypeDao";
	public DaoPage findTmsMdTaxTrxTypeByParams(Map params, Integer pageIndex,Integer pageSize);
	public List<TmsMdTaxTrxType> findTmsMdTaxTrxTypeByParams(Map params);
	public int removeTmsMdTaxTrxTypes(String tmsMdTaxTrxTypeId);
}

