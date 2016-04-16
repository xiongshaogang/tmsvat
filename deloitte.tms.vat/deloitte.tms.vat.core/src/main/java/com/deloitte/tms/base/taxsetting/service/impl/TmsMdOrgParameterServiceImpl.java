package com.deloitte.tms.base.taxsetting.service.impl;
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
import com.deloitte.tms.base.taxsetting.dao.TmsMdOrgParameterDao;
import com.deloitte.tms.base.taxsetting.model.TmsMdOrgParameter;
import com.deloitte.tms.base.taxsetting.model.TmsMdOrgParameterInParam;
import com.deloitte.tms.base.taxsetting.service.TmsMdOrgParameterService;
/**
 * Home object for domain model class TmsMdOrgParameter.
 * @see com.deloitte.tms.base.masterdata.model
 * @author Hibernate Tools
 */
@Component(TmsMdOrgParameterService.BEAN_ID)
public class TmsMdOrgParameterServiceImpl extends BaseService implements TmsMdOrgParameterService{
	@Resource
	TmsMdOrgParameterDao tmsMdOrgParameterDao;

	@Override
	public IDao getDao() {
		return tmsMdOrgParameterDao;
	}

	@Override
	public DaoPage findTmsMdOrgParameterByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= tmsMdOrgParameterDao.findTmsMdOrgParameterByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertTmsMdOrgParameterToInParam((List<TmsMdOrgParameter>) daoPage.getResult()));
		return daoPage;
	}
	@Override
	public List<TmsMdOrgParameterInParam> findTmsMdOrgParameterByParams(Map params) {
		if(params==null)
		{
			params=new HashMap();
		}
		List<TmsMdOrgParameter> temp= tmsMdOrgParameterDao.findTmsMdOrgParameterByParams(params);
		return convertTmsMdOrgParameterToInParam(temp);
	}
	@Override
	public void saveTmsMdOrgParameterDataListsMap(Map dataListsMap) {
		Collection<TmsMdOrgParameterInParam> deleteList = BatchUtils.to(TmsMdOrgParameterInParam.class).getDeleteEntities(dataListsMap);
		Collection<TmsMdOrgParameterInParam> insertList =  BatchUtils.to(TmsMdOrgParameterInParam.class).getInsertEntities(dataListsMap);
		Collection<TmsMdOrgParameterInParam> updateList =  BatchUtils.to(TmsMdOrgParameterInParam.class).getModifiedEntities(dataListsMap);
		if (updateList != null&&updateList.size() > 0) {
			for(TmsMdOrgParameterInParam inParam: updateList){
				TmsMdOrgParameter entity=convertTmsMdOrgParameterInParamToEntity(inParam);
				tmsMdOrgParameterDao.update(entity);
			}		
//			tmsMdOrgParameterDao.updateAll(updateList);
		}
		if (insertList != null&&insertList.size() > 0) {
			for(TmsMdOrgParameterInParam inParam: insertList){
				TmsMdOrgParameter entity=convertTmsMdOrgParameterInParamToEntity(inParam);
				tmsMdOrgParameterDao.save(entity);
				inParam.setId(entity.getId());
			}
//			tmsMdOrgParameterDao.saveAll(insertList);
		}
		if (deleteList != null&&deleteList.size() > 0) {
			for(TmsMdOrgParameterInParam inParam:deleteList){
				TmsMdOrgParameter entity=new TmsMdOrgParameter();
				entity.setId(inParam.getId());
				tmsMdOrgParameterDao.remove(entity);
			}
//			tmsMdOrgParameterDao.removeAll(deleteList);
		}
		
	}
	private List<TmsMdOrgParameterInParam> convertTmsMdOrgParameterToInParam(List<TmsMdOrgParameter> models){
		List<TmsMdOrgParameterInParam> result=new ArrayList<TmsMdOrgParameterInParam>();
		for(TmsMdOrgParameter initiation:models){
			TmsMdOrgParameterInParam inparam=convertTmsMdOrgParameterToInParam(initiation);
			result.add(inparam);
		}
		return result;
	}
	public TmsMdOrgParameterInParam convertTmsMdOrgParameterToInParam(TmsMdOrgParameter model){
		TmsMdOrgParameterInParam inparam=new TmsMdOrgParameterInParam();
		if(model.getBaseOrg() != null && !"".equals(model.getBaseOrg()) ){
			
			inparam.setOrgName(model.getBaseOrg().getOrgName());
		}else{
			
			inparam.setOrgName("");
		}
		
		
		ReflectUtils.copyProperties(model, inparam);
		return inparam;
	}
	public TmsMdOrgParameter convertTmsMdOrgParameterInParamToEntity(TmsMdOrgParameterInParam inParam){
		TmsMdOrgParameter entity=new TmsMdOrgParameter();
		ReflectUtils.copyProperties(inParam, entity);
		return entity;
	}
}
