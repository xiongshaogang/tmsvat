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
import com.deloitte.tms.base.taxsetting.model.TmsMdTrxCatBsnStr;
import com.deloitte.tms.base.taxsetting.model.TmsMdTrxCatBsnStrInParam;
import com.deloitte.tms.base.taxsetting.dao.TmsMdTrxCatBsnStrDao;
import com.deloitte.tms.base.taxsetting.service.TmsMdTrxCatBsnStrService;
import com.itextpdf.text.io.GetBufferedRandomAccessSource;
/**
 * Home object for domain model class TmsMdTrxCatBsnStr.
 * @see com.deloitte.tms.base.taxsetting.model
 * @author Hibernate Tools
 */
@Component(TmsMdTrxCatBsnStrService.BEAN_ID)
public class TmsMdTrxCatBsnStrServiceImpl extends BaseService implements TmsMdTrxCatBsnStrService{
	@Resource
	TmsMdTrxCatBsnStrDao tmsMdTrxCatBsnStrDao;

	@Override
	public IDao getDao() {
		return tmsMdTrxCatBsnStrDao;
	}

	@Override
	public DaoPage findTmsMdTrxCatBsnStrByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= tmsMdTrxCatBsnStrDao.findTmsMdTrxCatBsnStrByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertTmsMdTrxCatBsnStrToInParam((List<TmsMdTrxCatBsnStr>) daoPage.getResult()));
		return daoPage;
	}
	@Override
	public List<TmsMdTrxCatBsnStrInParam> findTmsMdTrxCatBsnStrByParams(Map params) {
		if(params==null)
		{
			params=new HashMap();
		}
		List<TmsMdTrxCatBsnStr> temp= tmsMdTrxCatBsnStrDao.findTmsMdTrxCatBsnStrByParams(params);
		return convertTmsMdTrxCatBsnStrToInParam(temp);
	}
	@Override
	public void saveTmsMdTrxCatBsnStrDataListsMap(Map dataListsMap) {
		Collection<TmsMdTrxCatBsnStrInParam> deleteList = BatchUtils.to(TmsMdTrxCatBsnStrInParam.class).getDeleteEntities(dataListsMap);
		Collection<TmsMdTrxCatBsnStrInParam> insertList =  BatchUtils.to(TmsMdTrxCatBsnStrInParam.class).getInsertEntities(dataListsMap);
		Collection<TmsMdTrxCatBsnStrInParam> updateList =  BatchUtils.to(TmsMdTrxCatBsnStrInParam.class).getModifiedEntities(dataListsMap);
		if (updateList != null&&updateList.size() > 0) {
			for(TmsMdTrxCatBsnStrInParam inParam: updateList){
				TmsMdTrxCatBsnStr entity=convertTmsMdTrxCatBsnStrInParamToEntity(inParam);
				tmsMdTrxCatBsnStrDao.update(entity);
			}		
//			tmsMdTrxCatBsnStrDao.updateAll(updateList);
		}
		if (insertList != null&&insertList.size() > 0) {
			for(TmsMdTrxCatBsnStrInParam inParam: insertList){
				TmsMdTrxCatBsnStr entity=convertTmsMdTrxCatBsnStrInParamToEntity(inParam);
				tmsMdTrxCatBsnStrDao.save(entity);
				inParam.setId(entity.getId());
			}
//			tmsMdTrxCatBsnStrDao.saveAll(insertList);
		}
		if (deleteList != null&&deleteList.size() > 0) {
			for(TmsMdTrxCatBsnStrInParam inParam:deleteList){
				TmsMdTrxCatBsnStr entity=new TmsMdTrxCatBsnStr();
				entity.setId(inParam.getId());
				tmsMdTrxCatBsnStrDao.remove(entity);
			}
//			tmsMdTrxCatBsnStrDao.removeAll(deleteList);
		}
		
	}
	private List<TmsMdTrxCatBsnStrInParam> convertTmsMdTrxCatBsnStrToInParam(List<TmsMdTrxCatBsnStr> models){
		List<TmsMdTrxCatBsnStrInParam> result=new ArrayList<TmsMdTrxCatBsnStrInParam>();
		for(TmsMdTrxCatBsnStr initiation:models){
			TmsMdTrxCatBsnStrInParam inparam=convertTmsMdTrxCatBsnStrToInParam(initiation);
			result.add(inparam);
		}
		return result;
	}
	public TmsMdTrxCatBsnStrInParam convertTmsMdTrxCatBsnStrToInParam(TmsMdTrxCatBsnStr model){
		TmsMdTrxCatBsnStrInParam inparam=new TmsMdTrxCatBsnStrInParam();
		if(model.getTmsMdLegalEntity() != null && !"".equals(model.getTmsMdLegalEntity())){
			inparam.setLegalEntityName(model.getTmsMdLegalEntity().getLegalEntityName());
		}else{
			inparam.setLegalEntityName("");
		}
		if(model.getTmsMdBsnCombination() != null && !"".equals(model.getTmsMdBsnCombination())){
			inparam.setBsnCombinationName(model.getTmsMdBsnCombination().getBsnCombinationName());
		}else{
			inparam.setBsnCombinationName("");
		}
		if(model.getBaseOrg() != null && !"".equals(model.getBaseOrg())){
			
			inparam.setOrgName(model.getBaseOrg().getOrgName());
		}else{
			
			inparam.setOrgName("");
		}
		if(model.getTmsMdTaxTrxType()!=null && !"".equals(model.getTaxTrxTypeId())){
			inparam.setTaxTrxTypeName(model.getTmsMdTaxTrxType().getTaxTrxTypeName());
		}else{
			inparam.setTaxTrxTypeName("");
		}
		
		ReflectUtils.copyProperties(model, inparam);
		return inparam;
	}
	public TmsMdTrxCatBsnStr convertTmsMdTrxCatBsnStrInParamToEntity(TmsMdTrxCatBsnStrInParam inParam){
		TmsMdTrxCatBsnStr entity=new TmsMdTrxCatBsnStr();
		ReflectUtils.copyProperties(inParam, entity);
		return entity;
	}
}
