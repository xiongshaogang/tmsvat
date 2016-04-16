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
import com.deloitte.tms.base.taxsetting.dao.TmsMdInventoryCategoriesDao;
import com.deloitte.tms.base.taxsetting.model.TmsMdInventoryCategories;
import com.deloitte.tms.base.taxsetting.model.TmsMdInventoryCategoriesInParam;
import com.deloitte.tms.base.taxsetting.model.TmsMdInventoryItems;
import com.deloitte.tms.base.taxsetting.model.TmsMdInventoryItemsInParam;
import com.deloitte.tms.base.taxsetting.service.TmsMdInventoryCategoriesService;
/**
 * Home object for domain model class TmsMdInventoryCategories.
 * @see com.deloitte.tms.base.masterdata.model
 * @author Hibernate Tools
 */
@Component(TmsMdInventoryCategoriesService.BEAN_ID)
public class TmsMdInventoryCategoriesServiceImpl extends BaseService implements TmsMdInventoryCategoriesService{
	@Resource
	TmsMdInventoryCategoriesDao tmsMdInventoryCategoriesDao;

	@Override
	public IDao getDao() {
		return tmsMdInventoryCategoriesDao;
	}

	@Override
	public DaoPage findTmsMdInventoryCategoriesByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= tmsMdInventoryCategoriesDao.findTmsMdInventoryCategoriesByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertTmsMdInventoryCategoriesToInParam((List<TmsMdInventoryCategories>) daoPage.getResult()));
		return daoPage;
	}
	@Override
	public List<TmsMdInventoryCategoriesInParam> findTmsMdInventoryCategoriesByParams(Map params) {
		if(params==null)
		{
			params=new HashMap();
		}
		List<TmsMdInventoryCategories> temp= tmsMdInventoryCategoriesDao.findTmsMdInventoryCategoriesByParams(params);
		return convertTmsMdInventoryCategoriesToInParam(temp);
	}
	@Override
	public void saveTmsMdInventoryCategoriesDataListsMap(Map dataListsMap) {
		Collection<TmsMdInventoryCategoriesInParam> deleteList = BatchUtils.to(TmsMdInventoryCategoriesInParam.class).getDeleteEntities(dataListsMap);
		Collection<TmsMdInventoryCategoriesInParam> insertList =  BatchUtils.to(TmsMdInventoryCategoriesInParam.class).getInsertEntities(dataListsMap);
		Collection<TmsMdInventoryCategoriesInParam> updateList =  BatchUtils.to(TmsMdInventoryCategoriesInParam.class).getModifiedEntities(dataListsMap);
		if (updateList != null&&updateList.size() > 0) {
			for(TmsMdInventoryCategoriesInParam inParam: updateList){
				TmsMdInventoryCategories entity=convertTmsMdInventoryCategoriesInParamToEntity(inParam);
				tmsMdInventoryCategoriesDao.update(entity);
			}		
//			tmsMdInventoryCategoriesDao.updateAll(updateList);
		}
		if (insertList != null&&insertList.size() > 0) {
			for(TmsMdInventoryCategoriesInParam inParam: insertList){
				TmsMdInventoryCategories entity=convertTmsMdInventoryCategoriesInParamToEntity(inParam);
				tmsMdInventoryCategoriesDao.save(entity);
				inParam.setId(entity.getId());
			}
//			tmsMdInventoryCategoriesDao.saveAll(insertList);
		}
		if (deleteList != null&&deleteList.size() > 0) {
			for(TmsMdInventoryCategoriesInParam inParam:deleteList){
				TmsMdInventoryCategories entity=new TmsMdInventoryCategories();
				entity.setId(inParam.getId());
				tmsMdInventoryCategoriesDao.remove(entity);
			}
//			tmsMdInventoryCategoriesDao.removeAll(deleteList);
		}
		
	}
	private List<TmsMdInventoryCategoriesInParam> convertTmsMdInventoryCategoriesToInParam(List<TmsMdInventoryCategories> models){
		List<TmsMdInventoryCategoriesInParam> result=new ArrayList<TmsMdInventoryCategoriesInParam>();
		for(TmsMdInventoryCategories initiation:models){
			TmsMdInventoryCategoriesInParam inparam=convertTmsMdInventoryCategoriesToInParam(initiation);
			result.add(inparam);
		}
		return result;
	}
	public TmsMdInventoryCategoriesInParam convertTmsMdInventoryCategoriesToInParam(TmsMdInventoryCategories model){
		TmsMdInventoryCategoriesInParam inparam=new TmsMdInventoryCategoriesInParam();
		ReflectUtils.copyProperties(model, inparam);
		return inparam;
	}
	public TmsMdInventoryCategories convertTmsMdInventoryCategoriesInParamToEntity(TmsMdInventoryCategoriesInParam inParam){
		TmsMdInventoryCategories entity=new TmsMdInventoryCategories();
		ReflectUtils.copyProperties(inParam, entity);
		return entity;
	}
	@Override
	public DaoPage findTmsMdInventoryItemsByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= tmsMdInventoryCategoriesDao.findTmsMdInventoryItemsByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertTmsMdInventoryItemsToInParam((List<TmsMdInventoryItems>) daoPage.getResult()));
		return daoPage;
	}
	@Override
	public List<TmsMdInventoryItemsInParam> findTmsMdInventoryItemsByParams(Map params) {
		if(params==null)
		{
			params=new HashMap();
		}
		List<TmsMdInventoryItems> temp= tmsMdInventoryCategoriesDao.findTmsMdInventoryItemsByParams(params);
		return convertTmsMdInventoryItemsToInParam(temp);
	}
	@Override
	public void saveTmsMdInventoryItemsDataListsMap(Map dataListsMap) {
		Collection<TmsMdInventoryItemsInParam> deleteList = BatchUtils.to(TmsMdInventoryItemsInParam.class).getDeleteEntities(dataListsMap);
		Collection<TmsMdInventoryItemsInParam> insertList =  BatchUtils.to(TmsMdInventoryItemsInParam.class).getInsertEntities(dataListsMap);
		Collection<TmsMdInventoryItemsInParam> updateList =  BatchUtils.to(TmsMdInventoryItemsInParam.class).getModifiedEntities(dataListsMap);
		if (updateList != null&&updateList.size() > 0) {
			for(TmsMdInventoryItemsInParam inParam: updateList){
				TmsMdInventoryItems entity=convertTmsMdInventoryItemsInParamToEntity(inParam);
				tmsMdInventoryCategoriesDao.update(entity);
			}		
//			tmsMdInventoryCategoriesDao.updateAll(updateList);
		}
		if (insertList != null&&insertList.size() > 0) {
			for(TmsMdInventoryItemsInParam inParam: insertList){
				TmsMdInventoryItems entity=convertTmsMdInventoryItemsInParamToEntity(inParam);
				tmsMdInventoryCategoriesDao.save(entity);
				inParam.setId(entity.getId());
			}
//			tmsMdInventoryCategoriesDao.saveAll(insertList);
		}
		if (deleteList != null&&deleteList.size() > 0) {
			for(TmsMdInventoryItemsInParam inParam:deleteList){
				TmsMdInventoryItems entity=new TmsMdInventoryItems();
				entity.setId(inParam.getId());
				tmsMdInventoryCategoriesDao.remove(entity);
			}
//			tmsMdInventoryCategoriesDao.removeAll(deleteList);
		}
	}
	private List<TmsMdInventoryItemsInParam> convertTmsMdInventoryItemsToInParam(List<TmsMdInventoryItems> models){
		List<TmsMdInventoryItemsInParam> result=new ArrayList<TmsMdInventoryItemsInParam>();
		for(TmsMdInventoryItems initiation:models){
			TmsMdInventoryItemsInParam inparam=convertTmsMdInventoryItemsToInParam(initiation);
			result.add(inparam);
		}
		return result;
	}
	public TmsMdInventoryItemsInParam convertTmsMdInventoryItemsToInParam(TmsMdInventoryItems model){
		TmsMdInventoryItemsInParam inparam=new TmsMdInventoryItemsInParam();
		ReflectUtils.copyProperties(model, inparam);
		return inparam;
	}
	public TmsMdInventoryItems convertTmsMdInventoryItemsInParamToEntity(TmsMdInventoryItemsInParam inParam){
		TmsMdInventoryItems entity=new TmsMdInventoryItems();
		ReflectUtils.copyProperties(inParam, entity);
		return entity;
	}
}
