package com.deloitte.tms.base.taxsetting.service;
// Generated by bo.wang with ling2.autoproject

import java.util.List;
import java.util.Map;

import com.deloitte.tms.base.taxsetting.model.Items;
import com.deloitte.tms.base.taxsetting.model.ItemsInParam;
import com.deloitte.tms.base.taxsetting.dao.ItemsDao;
import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.service.IService;
/**
 * Home object for domain model class Items.
 * @see com.deloitte.tms.base.taxsetting.model
 * @author Hibernate Tools
 */
public interface ItemsService extends IService{
	public static final String BEAN_ID="itemsService";
	
	public DaoPage findItemsByParams(Map params, Integer pageIndex,Integer pageSize);
	
	public List<ItemsInParam> findItemsByParams(Map params);
	
	public void saveItemsDataListsMap(Map dataListsMap);
	
	public ItemsInParam convertItemsToInParam(Items model);
	
	public Items convertItemsInParamToEntity(ItemsInParam inParam);
	
}

