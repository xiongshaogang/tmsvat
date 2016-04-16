package com.deloitte.tms.base.taxsetting.service;
// Generated by bo.wang with ling2.autoproject

import java.util.List;
import java.util.Map;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.service.IService;
import com.deloitte.tms.base.taxsetting.model.TmsMdFlexValueSets;
import com.deloitte.tms.base.taxsetting.model.TmsMdFlexValueSetsInParam;
import com.deloitte.tms.base.taxsetting.dao.TmsMdFlexValueSetsDao;
import com.deloitte.tms.base.taxsetting.model.TmsMdFlexValues;
import com.deloitte.tms.base.taxsetting.model.TmsMdFlexValuesInParam;
/**
 * Home object for domain model class TmsMdFlexValueSets.
 * @see com.deloitte.tms.base.taxsetting.model
 * @author Hibernate Tools
 */
public interface TmsMdFlexValueSetsService extends IService{
	public static final String BEAN_ID="tmsMdFlexValueSetsService";
	
	public DaoPage findTmsMdFlexValueSetsByParams(Map params, Integer pageIndex,Integer pageSize);
	
	
	public void saveTmsMdFlexValueSetsDataListsMap(Map dataListsMap);
	
	public TmsMdFlexValueSetsInParam convertTmsMdFlexValueSetsToInParam(TmsMdFlexValueSets model);
	
	public TmsMdFlexValueSets convertTmsMdFlexValueSetsInParamToEntity(TmsMdFlexValueSetsInParam inParam);
	
	public DaoPage findTmsMdFlexValuesByParams(Map params, Integer pageIndex,Integer pageSize);
	
	public List<TmsMdFlexValuesInParam> findTmsMdFlexValuesByParams(Map params);
	
	public void saveTmsMdFlexValuesDataListsMap(Map dataListsMap);
	
	public TmsMdFlexValuesInParam convertTmsMdFlexValuesToInParam(TmsMdFlexValues model);
	
	public TmsMdFlexValues convertTmsMdFlexValuesInParamToEntity(TmsMdFlexValuesInParam inParam);

	public void removeTmsMdFlexValueSetss(String tmsMdFlexValueSetsId);

	public DaoPage searchivaluesetencoding(Map<String, Object> parameter,
			int parseInt, int parseInt2);


	public DaoPage setsearchvaluesetthat(Map<String, Object> parameter,
			int parseInt, int parseInt2);
	
}
