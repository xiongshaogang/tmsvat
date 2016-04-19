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
import com.deloitte.tms.base.masterdata.model.BaseOrg;
import com.deloitte.tms.base.masterdata.model.BaseOrgInParam;
import com.deloitte.tms.base.taxsetting.dao.TmsMdOrgBsnStructuresDao;
import com.deloitte.tms.base.taxsetting.dao.impl.TmsMdOrgBsnStructuresDaoImpl;
import com.deloitte.tms.base.taxsetting.model.TmsMdOrgBsnStructures;
import com.deloitte.tms.base.taxsetting.model.TmsMdOrgBsnStructuresInParam;
import com.deloitte.tms.base.taxsetting.service.TmsMdOrgBsnStructuresService;
/**
 * Home object for domain model class TmsMdOrgBsnStructures.
 * @see com.deloitte.tms.base.masterdata.model
 * @author Hibernate Tools
 */
@Component(TmsMdOrgBsnStructuresService.BEAN_ID)
public class TmsMdOrgBsnStructuresServiceImpl extends BaseService implements TmsMdOrgBsnStructuresService{
	@Resource
	TmsMdOrgBsnStructuresDao tmsMdOrgBsnStructuresDao;

	@Override
	public IDao getDao() {
		return tmsMdOrgBsnStructuresDao;
	}

	@Override
	public DaoPage findTmsMdOrgBsnStructuresByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= tmsMdOrgBsnStructuresDao.findTmsMdOrgBsnStructuresByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertTmsMdOrgBsnStructuresToInParam((List<TmsMdOrgBsnStructures>) daoPage.getResult()));
		return daoPage;
	}
	@Override
	public List<TmsMdOrgBsnStructuresInParam> findTmsMdOrgBsnStructuresByParams(Map params) {
		if(params==null)
		{
			params=new HashMap();
		}
		List<TmsMdOrgBsnStructures> temp= tmsMdOrgBsnStructuresDao.findTmsMdOrgBsnStructuresByParams(params);
		return convertTmsMdOrgBsnStructuresToInParam(temp);
	}
	@Override
	public void saveTmsMdOrgBsnStructuresDataListsMap(Map dataListsMap) {
		Collection<TmsMdOrgBsnStructuresInParam> deleteList = BatchUtils.to(TmsMdOrgBsnStructuresInParam.class).getDeleteEntities(dataListsMap);
		Collection<TmsMdOrgBsnStructuresInParam> insertList =  BatchUtils.to(TmsMdOrgBsnStructuresInParam.class).getInsertEntities(dataListsMap);
		Collection<TmsMdOrgBsnStructuresInParam> updateList =  BatchUtils.to(TmsMdOrgBsnStructuresInParam.class).getModifiedEntities(dataListsMap);
		if (updateList != null&&updateList.size() > 0) {
			for(TmsMdOrgBsnStructuresInParam inParam: updateList){
				TmsMdOrgBsnStructures entity=convertTmsMdOrgBsnStructuresInParamToEntity(inParam);
				tmsMdOrgBsnStructuresDao.update(entity);
			}		
//			tmsMdOrgBsnStructuresDao.updateAll(updateList);
		}
		if (insertList != null&&insertList.size() > 0) {
			for(TmsMdOrgBsnStructuresInParam inParam: insertList){
				TmsMdOrgBsnStructures entity=convertTmsMdOrgBsnStructuresInParamToEntity(inParam);
				tmsMdOrgBsnStructuresDao.save(entity);
				inParam.setId(entity.getId());
			}
//			tmsMdOrgBsnStructuresDao.saveAll(insertList);
		}
		if (deleteList != null&&deleteList.size() > 0) {
			for(TmsMdOrgBsnStructuresInParam inParam:deleteList){
				TmsMdOrgBsnStructures entity=new TmsMdOrgBsnStructures();
				entity.setId(inParam.getId());
				tmsMdOrgBsnStructuresDao.remove(entity);
			}
//			tmsMdOrgBsnStructuresDao.removeAll(deleteList);
		}
		
	}
	private List<TmsMdOrgBsnStructuresInParam> convertTmsMdOrgBsnStructuresToInParam(List<TmsMdOrgBsnStructures> models){
		List<TmsMdOrgBsnStructuresInParam> result=new ArrayList<TmsMdOrgBsnStructuresInParam>();
		for(TmsMdOrgBsnStructures initiation:models){
			
			TmsMdOrgBsnStructuresInParam inparam=convertTmsMdOrgBsnStructuresToInParam(initiation);
			result.add(inparam);
		}
		return result;
	}
	public TmsMdOrgBsnStructuresInParam convertTmsMdOrgBsnStructuresToInParam(TmsMdOrgBsnStructures model){
		TmsMdOrgBsnStructuresInParam inparam=new TmsMdOrgBsnStructuresInParam();
		
		if(model.getBaseOrg() !=null && !"".equals(model.getBaseOrg())){			
			inparam.setOrgName(model.getBaseOrg().getOrgName());			
		}
		if(model.getBaseOrg() != null && !"".equals(model.getBaseOrg())){			
			inparam.setOrgCode(model.getBaseOrg().getOrgCode());		
		}
		if(model.getTmsMdFlexStructures() !=null && !"".equals(model.getTmsMdFlexStructures()) ){
			inparam.setAccdflexStructuresDescription(model.getTmsMdFlexStructures().getFlexStructuresDescription());
		}
		if(model.getTmsMdFlexStructures() != null && !"".equals(model.getTmsMdFlexStructures())){			
			inparam.setAccdflexStructuresCode(model.getTmsMdFlexStructures().getFlexStructuresCode());			
		}
		if(model.getTmsMdFlexStructures2() != null && !"".equals(model.getTmsMdFlexStructures2())){
			inparam.setBsnflexStructuresCode(model.getTmsMdFlexStructures2().getFlexStructuresCode());		
		}
		if(model.getTmsMdFlexStructures2() != null && !"".equals(model.getTmsMdFlexStructures2())){
			inparam.setBsnflexStructuresDescription(model.getTmsMdFlexStructures2().getFlexStructuresDescription());
		}
		if(model.getTmsMdLegalEntity() != null && !"".equals(model.getTmsMdLegalEntity())){			
			inparam.setLegalEntityCode(model.getTmsMdLegalEntity().getLegalEntityCode());			
		}
		if(model.getTmsMdLegalEntity() !=null && !"".equals(model.getTmsMdLegalEntity())){
			inparam.setLegalEntityName(model.getTmsMdLegalEntity().getLegalEntityName());
		}
		ReflectUtils.copyProperties(model, inparam);
		return inparam;
	}
	public TmsMdOrgBsnStructures convertTmsMdOrgBsnStructuresInParamToEntity(TmsMdOrgBsnStructuresInParam inParam){
		TmsMdOrgBsnStructures entity=new TmsMdOrgBsnStructures();
		ReflectUtils.copyProperties(inParam, entity);
		return entity;
	}
	
	
	
	
	
	
}

