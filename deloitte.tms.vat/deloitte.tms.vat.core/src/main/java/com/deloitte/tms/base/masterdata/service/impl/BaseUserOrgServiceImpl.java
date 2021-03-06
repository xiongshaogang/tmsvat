package com.deloitte.tms.base.masterdata.service.impl;
// Generated by bo.wang with ling2.autoproject

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.commons.utils.BatchUtils;
import com.deloitte.tms.pl.core.commons.utils.reflect.ReflectUtils;
import com.deloitte.tms.pl.core.dao.IDao;
import com.deloitte.tms.pl.core.service.impl.BaseService;
import com.deloitte.tms.base.masterdata.model.BaseUserOrg;
import com.deloitte.tms.base.masterdata.model.BaseUserOrgInParam;
import com.deloitte.tms.base.masterdata.model.BaseUserOrg;
import com.deloitte.tms.base.masterdata.model.BaseUserOrgInParam;
import com.deloitte.tms.base.masterdata.dao.BaseUserOrgDao;
import com.deloitte.tms.base.masterdata.service.BaseUserOrgService;
/**
 * Home object for domain model class BaseUserOrg.
 * @see com.deloitte.tms.base.masterdata.model
 * @author Hibernate Tools
 */
@Component(BaseUserOrgService.BEAN_ID)
public class BaseUserOrgServiceImpl extends BaseService implements BaseUserOrgService{

	
	/**   
	 * @return  
	 * @see com.deloitte.tms.pl.core.service.IService#getDao()  
	 */
	
	@Override
	public IDao getDao() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**   
	 * @param params
	 * @param pageIndex
	 * @param pageSize
	 * @return  
	 * @see com.deloitte.tms.base.masterdata.service.BaseUserOrgService#findBaseUserOrgByParams(java.util.Map, java.lang.Integer, java.lang.Integer)  
	 */
	
	@Override
	public DaoPage findBaseUserOrgByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**   
	 * @param params
	 * @return  
	 * @see com.deloitte.tms.base.masterdata.service.BaseUserOrgService#findBaseUserOrgByParams(java.util.Map)  
	 */
	
	@Override
	public List<BaseUserOrgInParam> findBaseUserOrgByParams(Map params) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**   
	 * @param dataListsMap  
	 * @see com.deloitte.tms.base.masterdata.service.BaseUserOrgService#saveBaseUserOrgDataListsMap(java.util.Map)  
	 */
	
	@Override
	public void saveBaseUserOrgDataListsMap(Map dataListsMap) {
		// TODO Auto-generated method stub
		
	}

	
	/**   
	 * @param model
	 * @return  
	 * @see com.deloitte.tms.base.masterdata.service.BaseUserOrgService#convertBaseUserOrgToInParam(com.deloitte.tms.base.masterdata.model.BaseUserOrg)  
	 */
	
	@Override
	public BaseUserOrgInParam convertBaseUserOrgToInParam(BaseUserOrg model) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**   
	 * @param inParam
	 * @return  
	 * @see com.deloitte.tms.base.masterdata.service.BaseUserOrgService#convertBaseUserOrgInParamToEntity(com.deloitte.tms.base.masterdata.model.BaseUserOrgInParam)  
	 */
	
	@Override
	public BaseUserOrg convertBaseUserOrgInParamToEntity(
			BaseUserOrgInParam inParam) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

