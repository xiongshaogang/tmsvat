package com.deloitte.tms.vat.salesinvoice.service.impl;
// Generated by bo.wang with ling2.autoproject

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import com.deloitte.tms.base.masterdata.model.TmsMdLegalEntity;
import com.deloitte.tms.base.masterdata.model.TmsMdLegalEntityInParam;
import com.deloitte.tms.pl.core.commons.constant.TableColnumDef;
import com.deloitte.tms.pl.core.commons.exception.BusinessException;
import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.BatchUtils;
import com.deloitte.tms.pl.core.commons.utils.reflect.ReflectUtils;
import com.deloitte.tms.pl.core.dao.IDao;
import com.deloitte.tms.pl.core.service.impl.BaseService;
import com.deloitte.tms.vat.salesinvoice.dao.InvoiceTrxDao;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxD;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxDInParam;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxDataDict;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxDataDictInParam;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxH;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxHInParam;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxL;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxLInParam;
import com.deloitte.tms.vat.salesinvoice.service.InvoiceTrxService;
/**
 * Home object for domain model class InvoiceTrx.
 * @see com.deloitte.tms.vat.salesinvoice.model
 * @author Hibernate Tools
 */
@Component(InvoiceTrxService.BEAN_ID)
public class InvoiceTrxServiceImpl extends BaseService implements InvoiceTrxService{
	@Resource
	InvoiceTrxDao invoiceTrxDao;

	@Override
	public IDao getDao() {
		return invoiceTrxDao;
	}

	@Override
	public List<InvoiceTrxH> getLatestInvoiceTrxH() {
		List<InvoiceTrxH> list = invoiceTrxDao.getLatestInvoiceTrxH();
		return list;
	}
	
	@Override
	public DaoPage findInvoiceTrxByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= invoiceTrxDao.findInvoiceTrxByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertInvoiceTrxToInParam((List<InvoiceTrxH>) daoPage.getResult()));
		return daoPage;
	}

	@Override
	public DaoPage findInvoiceTrxLByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= invoiceTrxDao.findInvoiceTrxLByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertInvoiceTrxLToInParam((List<InvoiceTrxL>) daoPage.getResult()));
		return daoPage;
	}
	
	@Override
	public InvoiceTrxD getInvoice(String invoiceCode, String invoiceNo) {
		InvoiceTrxD invoiceTrxD=invoiceTrxDao.getInvoice(invoiceCode, invoiceNo);
		if(invoiceTrxD==null){
			throw new BusinessException("相关发票库存信息没找到");
		}
		return invoiceTrxD;
	}
	
	@Override
	public List<InvoiceTrxHInParam> findInvoiceTrxByParams(Map params) {
		if(params==null)
		{
			params=new HashMap();
		}
		List<InvoiceTrxH> temp= invoiceTrxDao.findInvoiceTrxByParams(params);
		return convertInvoiceTrxToInParam(temp);
	}
	
	@Override
	public List<InvoiceTrxD> findInvoiceTrxDByParams(Map params) {
		if(params==null)
		{
			params=new HashMap();
		}
		List<InvoiceTrxD> temp= invoiceTrxDao.findInvoiceTrxDByParams(params);
		return temp;
	}

	@Override
	public List<InvoiceTrxL> findAllInvoiceTrxL(Map params) {
		List<InvoiceTrxL> temp= invoiceTrxDao.findAllInvoiceTrxL(params);
		return temp;
	}
	
	@Override
	public void saveInvoiceTrxDataListsMap(Map dataListsMap) {
		Collection<InvoiceTrxHInParam> deleteList = BatchUtils.to(InvoiceTrxHInParam.class).getDeleteEntities(dataListsMap);
		Collection<InvoiceTrxHInParam> insertList =  BatchUtils.to(InvoiceTrxHInParam.class).getInsertEntities(dataListsMap);
		Collection<InvoiceTrxHInParam> updateList =  BatchUtils.to(InvoiceTrxHInParam.class).getModifiedEntities(dataListsMap);
		if (updateList != null&&updateList.size() > 0) {
			for(InvoiceTrxHInParam inParam: updateList){
				InvoiceTrxH entity=convertInvoiceTrxInParamToEntity(inParam);
				invoiceTrxDao.update(entity);
			}		
//			invoiceTrxDao.updateAll(updateList);
		}
		if (insertList != null&&insertList.size() > 0) {
			for(InvoiceTrxHInParam inParam: insertList){
				InvoiceTrxH entity=convertInvoiceTrxInParamToEntity(inParam);
				invoiceTrxDao.save(entity);
				inParam.setId(entity.getAttribute2());
			}
//			invoiceTrxDao.saveAll(insertList);
		}
		if (deleteList != null&&deleteList.size() > 0) {
			for(InvoiceTrxHInParam inParam:deleteList){
				InvoiceTrxH entity=new InvoiceTrxH();
				entity.setId(inParam.getAttribute2());
				invoiceTrxDao.remove(entity);
			}
//			invoiceTrxDao.removeAll(deleteList);
		}
		
	}
	
	
	@Override
	public void saveInvoiceTrxLDataListsMap(Map dataListsMap) {
		Collection<InvoiceTrxLInParam> deleteList = BatchUtils.to(InvoiceTrxLInParam.class).getDeleteEntities(dataListsMap);
		Collection<InvoiceTrxLInParam> insertList =  BatchUtils.to(InvoiceTrxLInParam.class).getInsertEntities(dataListsMap);
		Collection<InvoiceTrxLInParam> updateList =  BatchUtils.to(InvoiceTrxLInParam.class).getModifiedEntities(dataListsMap);
		if (updateList != null&&updateList.size() > 0) {
			for(InvoiceTrxLInParam inParam: updateList){
				InvoiceTrxL entity=convertInvoiceTrxLInParamToEntity(inParam);
				invoiceTrxDao.update(entity);
			}		
//			invoiceTrxDao.updateAll(updateList);
		}
		if (insertList != null&&insertList.size() > 0) {
			for(InvoiceTrxLInParam inParam: insertList){
				InvoiceTrxL entity=convertInvoiceTrxLInParamToEntity(inParam);
				invoiceTrxDao.save(entity);
				inParam.setId(entity.getAttribute2());
			}
//			invoiceTrxDao.saveAll(insertList);
		}
		if (deleteList != null&&deleteList.size() > 0) {
			for(InvoiceTrxLInParam inParam:deleteList){
				InvoiceTrxL entity=new InvoiceTrxL();
				entity.setId(inParam.getAttribute2());
				invoiceTrxDao.remove(entity);
			}
//			invoiceTrxDao.removeAll(deleteList);
		}
		
	}
	private List<InvoiceTrxHInParam> convertInvoiceTrxToInParam(List<InvoiceTrxH> models){
		List<InvoiceTrxHInParam> result=new ArrayList<InvoiceTrxHInParam>();
		for(InvoiceTrxH initiation:models){
			InvoiceTrxHInParam inparam=convertInvoiceTrxToInParam(initiation);
			result.add(inparam);
		}
		return result;
	}
	private List<InvoiceTrxLInParam> convertInvoiceTrxLToInParam(List<InvoiceTrxL> models){
		List<InvoiceTrxLInParam> result=new ArrayList<InvoiceTrxLInParam>();
		for(InvoiceTrxL initiation:models){
			InvoiceTrxLInParam inparam=convertInvoiceTrxLToInParam(initiation);
			result.add(inparam);
		}
		return result;
	}
	
	public InvoiceTrxHInParam convertInvoiceTrxToInParam(InvoiceTrxH model){
		InvoiceTrxHInParam inparam=new InvoiceTrxHInParam();
		ReflectUtils.copyProperties(model, inparam);
		return inparam;
	}
	public InvoiceTrxLInParam convertInvoiceTrxLToInParam(InvoiceTrxL model){
		InvoiceTrxLInParam inparam=new InvoiceTrxLInParam();
		ReflectUtils.copyProperties(model, inparam);
		return inparam;
	}
	public InvoiceTrxH convertInvoiceTrxInParamToEntity(InvoiceTrxHInParam inParam){
		InvoiceTrxH entity=new InvoiceTrxH();
		ReflectUtils.copyProperties(inParam, entity);
		return entity;
	}
	public InvoiceTrxL convertInvoiceTrxLInParamToEntity(InvoiceTrxLInParam inParam){
		InvoiceTrxL entity=new InvoiceTrxL();
		ReflectUtils.copyProperties(inParam, entity);
		return entity;
	}
	
	@Override
	public void deleteTrx(String id) {
		// TODO Auto-generated method stub
		invoiceTrxDao.deleteTrx(id);
	}
	
	@Override
	public void deleteTrxL(String id) {
		// TODO Auto-generated method stub
		invoiceTrxDao.deleteTrxL(id);
	}

	@Override
	public void saveInvoiceTrxH(InvoiceTrxH invoiceTrxH) {
		// TODO Auto-generated method stub
		for(InvoiceTrxL invoiceTrxL:invoiceTrxH.getList()){
			invoiceTrxDao.save(invoiceTrxL);
		}
		invoiceTrxDao.save(invoiceTrxH);
	}

	@Override
	public void deleteTrHById(String id) {
		// TODO Auto-generated method stub
		InvoiceTrxH invoiceTrxH = (InvoiceTrxH) invoiceTrxDao.get(InvoiceTrxH.class, id);
		Hibernate.initialize(invoiceTrxH.getInvoiceTrxLs());
		invoiceTrxDao.removeAll(invoiceTrxH.getInvoiceTrxLs());
		invoiceTrxDao.remove(invoiceTrxH);
	}

	@Override
	public void auditInvoiceTrhById(String id) {
		// TODO Auto-generated method stub
		InvoiceTrxH invoiceTrxH = (InvoiceTrxH) invoiceTrxDao.get(InvoiceTrxH.class, id);
		Hibernate.initialize(invoiceTrxH.getInvoiceTrxLs());
		Date date = getDatabaseServerDate();
		invoiceTrxH.setApprovalStatus("stocked");
		invoiceTrxH.setApprovalDate(date);
		this.update(invoiceTrxH);	
		for(InvoiceTrxL invoiceTrxL:invoiceTrxH.getInvoiceTrxLs()){
			int qty = Integer.parseInt(invoiceTrxL.getInvoiceQty().toString());
			for(int j=0;j<qty;j++){
				String invoiceNumber = String.format("%08d",(Integer.parseInt(invoiceTrxL.getStartInvoiceNumber())+j));
				InvoiceTrxD detail = new InvoiceTrxD();
				detail.setCrvatInvoiceTrxId(invoiceTrxL.getId());
				detail.setInvoiceCode(invoiceTrxL.getInvoiceCode());
				detail.setInvoiceCategory(invoiceTrxL.getInvoiceCategory());
				detail.setInvoiceNumber(invoiceNumber);
				detail.setInvoiceQty(1);
				detail.setLegalEntityId(invoiceTrxL.getLegalEntityId());
				detail.setIsUsage("0");
				detail.setIsAbolish("0");
				detail.setIsReturn("0");
				detail.setIsLost("0");
				detail.setIsReverse("0");
				detail.setIsHanding("0");
				detail.setIsLock("0");
				detail.setStatus("1");
				this.save(detail);
			}
		}
		
	}
	
}

