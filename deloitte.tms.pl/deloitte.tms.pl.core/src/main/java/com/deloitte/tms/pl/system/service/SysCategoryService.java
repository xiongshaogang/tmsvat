package com.deloitte.tms.pl.system.service;
// Generated by bo.wang with ling2.autoproject

import java.util.List;
import java.util.Map;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.service.IService;
import com.deloitte.tms.pl.system.model.SysCategory;
/**
 * Home object for domain model class SysCategory.
 * @see com.deloitte.tms.pl.system.model
 * @author Hibernate Tools
 */
public interface SysCategoryService extends IService{
	public static final String BEAN_ID="sysCategoryService";
	
	public DaoPage findSysCategoryByParams(Map params, Integer pageIndex,Integer pageSize);
	
	public List findSysCategoryByParams(Map params);
	
	public void saveSysCategoryDataListsMap(Map dataListsMap);
	
	List<SysCategory> loadSysCategory(Map<String, Object> map);
	
	public List<SysCategory> listEntries(String categoryCode);
	
	public SysCategory getCategoryCode(String code);
	
	public void removeSysCategory(String id) throws Exception;
}

