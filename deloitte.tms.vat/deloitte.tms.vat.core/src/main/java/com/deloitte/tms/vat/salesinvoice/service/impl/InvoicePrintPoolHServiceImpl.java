package com.deloitte.tms.vat.salesinvoice.service.impl;
// Generated by bo.wang with ling2.autoproject

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.commons.utils.BatchUtils;
import com.deloitte.tms.pl.core.commons.utils.reflect.ReflectUtils;
import com.deloitte.tms.pl.core.dao.IDao;
import com.deloitte.tms.pl.core.service.impl.BaseService;
import com.deloitte.tms.vat.base.enums.InvoicePrintStatusEnums;
import com.deloitte.tms.vat.base.enums.InvoiceReqTypeEnums;
import com.deloitte.tms.vat.base.enums.VatCRInvoiceTypeEnums;
import com.deloitte.tms.vat.salesinvoice.model.InvoicePrintPoolH;
import com.deloitte.tms.vat.salesinvoice.model.InvoicePrintPoolHInParam;
import com.deloitte.tms.vat.salesinvoice.model.InvoicePrintPoolL;
import com.deloitte.tms.vat.salesinvoice.model.InvoicePrintPoolLInParam;
import com.deloitte.tms.vat.salesinvoice.dao.InvoicePrintPoolHDao;
import com.deloitte.tms.vat.salesinvoice.service.InvoicePrintPoolHService;
/**
 * Home object for domain model class InvoicePrintPoolH.
 * @see com.deloitte.tms.vat.salesinvoice.model
 * @author Hibernate Tools
 */
@Component(InvoicePrintPoolHService.BEAN_ID)
public class InvoicePrintPoolHServiceImpl extends BaseService implements InvoicePrintPoolHService{
	@Resource
	InvoicePrintPoolHDao invoicePrintPoolHDao;

	@Override
	public IDao getDao() {
		return invoicePrintPoolHDao;
	}

	@Override
	public DaoPage findInvoicePrintPoolHByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= invoicePrintPoolHDao.findInvoicePrintPoolHByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertInvoicePrintPoolHToInParam((List<InvoicePrintPoolH>) daoPage.getResult()));
		return daoPage;
	}
	
	@Override
	public DaoPage findInvoicePrintedPoolHByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= invoicePrintPoolHDao.findInvoicePrintedPoolHByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertInvoicePrintPoolHToInParam((List<InvoicePrintPoolH>) daoPage.getResult()));
		return daoPage;
	}
	
	@Override
	public List<InvoicePrintPoolHInParam> findInvoicePrintPoolHByParams(Map params) {
		if(params==null)
		{
			params=new HashMap();
		}
		List<InvoicePrintPoolH> temp= invoicePrintPoolHDao.findInvoicePrintPoolHByParams(params);
		return convertInvoicePrintPoolHToInParam(temp);
	}
	/**
	 * 数据转换
	 * @param models
	 * @return
	 */
	private List<InvoicePrintPoolHInParam> convertInvoicePrintPoolHToInParam(List<InvoicePrintPoolH> models){
		
		List<InvoicePrintPoolHInParam> result=new ArrayList<InvoicePrintPoolHInParam>();
		for(InvoicePrintPoolH initiation:models){
			InvoicePrintPoolHInParam inparam=convertInvoicePrintPoolHToInParam(initiation);
			result.add(inparam);
		}
		return result;
	}
	/**
	 * 单个转换
	 */
	public InvoicePrintPoolHInParam convertInvoicePrintPoolHToInParam(InvoicePrintPoolH model){
		InvoicePrintPoolHInParam inparam=new InvoicePrintPoolHInParam();
		ReflectUtils.copyProperties(model, inparam);
		return inparam;
	}
	
	/**
	 * 
	 */
	@Override
	public DaoPage findInvoicePrintPoolLByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= invoicePrintPoolHDao.findInvoicePrintPoolLByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertInvoicePrintPoolLToInParam((List<InvoicePrintPoolL>) daoPage.getResult()));
		return daoPage;
	}
	
	@Override
	public List<InvoicePrintPoolLInParam> findInvoicePrintPoolLByParams(Map params) {
		if(params==null)
		{
			params=new HashMap();
		}
		List<InvoicePrintPoolL> temp= invoicePrintPoolHDao.findInvoicePrintPoolLByParams(params);
		return convertInvoicePrintPoolLToInParam(temp);
	}
	/*@Override
	public void saveInvoicePrintPoolLDataListsMap(Map dataListsMap) {
		Collection<InvoicePrintPoolLInParam> deleteList = BatchUtils.to(InvoicePrintPoolLInParam.class).getDeleteEntities(dataListsMap);
		Collection<InvoicePrintPoolLInParam> insertList =  BatchUtils.to(InvoicePrintPoolLInParam.class).getInsertEntities(dataListsMap);
		Collection<InvoicePrintPoolLInParam> updateList =  BatchUtils.to(InvoicePrintPoolLInParam.class).getModifiedEntities(dataListsMap);
		if (updateList != null&&updateList.size() > 0) {
			for(InvoicePrintPoolLInParam inParam: updateList){
				InvoicePrintPoolL entity=convertInvoicePrintPoolLInParamToEntity(inParam);
				invoicePrintPoolHDao.update(entity);
			}		
//			invoicePrintPoolHDao.updateAll(updateList);
		}
		if (insertList != null&&insertList.size() > 0) {
			for(InvoicePrintPoolLInParam inParam: insertList){
				InvoicePrintPoolL entity=convertInvoicePrintPoolLInParamToEntity(inParam);
				invoicePrintPoolHDao.save(entity);
				inParam.setId(entity.getId());
			}
//			invoicePrintPoolHDao.saveAll(insertList);
		}
		if (deleteList != null&&deleteList.size() > 0) {
			for(InvoicePrintPoolLInParam inParam:deleteList){
				InvoicePrintPoolL entity=new InvoicePrintPoolL();
				entity.setId(inParam.getId());
				invoicePrintPoolHDao.remove(entity);
			}
//			invoicePrintPoolHDao.removeAll(deleteList);
		}
	}*/
	/**
	 * 
	 * @param models
	 * @return
	 */
	private List<InvoicePrintPoolLInParam> convertInvoicePrintPoolLToInParam(List<InvoicePrintPoolL> models){
		List<InvoicePrintPoolLInParam> result=new ArrayList<InvoicePrintPoolLInParam>();
		for(InvoicePrintPoolL initiation:models){
			InvoicePrintPoolLInParam inparam=convertInvoicePrintPoolLToInParam(initiation);
			result.add(inparam);
		}
		return result;
	}
	/**
	 * 数据转换
	 */
	public InvoicePrintPoolLInParam convertInvoicePrintPoolLToInParam(InvoicePrintPoolL model){
		InvoicePrintPoolLInParam inparam=new InvoicePrintPoolLInParam();
		ReflectUtils.copyProperties(model, inparam);
		inparam.setAcctdAmountCR(model.getAcctdAmountCR());
		inparam.setTaxRate(model.getTaxRate());
		inparam.setVatAmount(model.getVatAmount());
		inparam.setInvoiceAmount(model.getInvoiceAmount());
		return inparam;
	}
	/**
	 * 发票开具数据库更新
	 */
	@Override
	public InvoicePrintPoolH exeInovicePrintPoolHPrintCommit(
			InvoicePrintPoolH inParam) {
		InvoicePrintPoolH return_value=new InvoicePrintPoolH();
		
		return return_value;
	}

	@Override
	public DaoPage findSqelQueryInvoicePrintPoolHByParams(Map params,
			Integer pageIndex, Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}			
		DaoPage daoPage= invoicePrintPoolHDao.findSqlQueryInvoicePrintPoolHByParams(params, pageIndex, pageSize);
		return daoPage;
	}
}

