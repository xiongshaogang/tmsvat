package com.deloitte.tms.base.taxsetting.dao;
// Generated by bo.wang with ling2.autoproject

import java.util.List;
import java.util.Map;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.dao.IDao;
import com.deloitte.tms.base.taxsetting.model.TmsMdFlexValueSets;
import com.deloitte.tms.base.taxsetting.model.TmsMdFlexValues;
/**
 * Home object for domain model class TmsMdFlexValueSets.
 * @see com.deloitte.tms.base.taxsetting.model
 * @author Hibernate Tools
 */
public interface TmsMdFlexValueSetsDao extends IDao<TmsMdFlexValueSets>{
	public static final String BEAN_ID="tmsMdFlexValueSetsDao";
	public DaoPage findTmsMdFlexValueSetsByParams(Map params, Integer pageIndex,Integer pageSize);
	public DaoPage findTmsMdFlexValuesByParams(Map params, Integer pageIndex,Integer pageSize);
	public List<TmsMdFlexValues> findTmsMdFlexValuesByParams(Map params);
	public void removeTmsMdFlexValueSetss(String tmsMdFlexValueSetsId);
	public DaoPage searchivaluesetencoding(Map<String, Object> parameter,
			int parseInt, int parseInt2);
	public DaoPage setsearchvaluesetthat(Map<String, Object> parameter,
			int parseInt, int parseInt2);
}

