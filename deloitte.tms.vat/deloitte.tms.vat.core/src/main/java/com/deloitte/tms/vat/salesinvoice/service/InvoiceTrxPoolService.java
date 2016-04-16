package com.deloitte.tms.vat.salesinvoice.service;
// Generated by bo.wang with ling2.autoproject

import java.util.List;
import java.util.Map;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.service.IService;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxPool;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxPoolInParam;
/**
 * Home object for domain model class InvoiceTrxPool.
 * @see com.deloitte.tms.vat.salesinvoice.model
 * @author Hibernate Tools
 */
public interface InvoiceTrxPoolService extends IService {
	public static final String BEAN_ID="invoiceTrxPoolService";
	
	public DaoPage findInvoiceTrxPoolByParams(Map<String,Object> params, Integer pageIndex,Integer pageSize);
	
	public void saveInvoiceTrxPoolList(Map<String,InvoiceTrxPool> map);
	
	/**
	 * 保存单个实体，解决性能问题
	 * @param map
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public void saveInvoiceTrxPool(Map<String,InvoiceTrxPool> map);
	
	/**
	 * 搜到所有符合条件的交易流水，不分页
	 */
	public List<InvoiceTrxPoolInParam> getAlltransaction(Map<String, Object> map);
	
	public void addTrxPoolToReqH(Map<String, Object> map);
	
	public void addTrxPoolToTempTmsCrvatReqL(Map<String, Object> map);
	
	public void insertTempTmsCrvatReqL(List<InvoiceTrxPoolInParam> list);
	
	public DaoPage findInvoiceTempReqLByParams(Map<String,Object> params, Integer pageIndex,Integer pageSize);
	
	public void deleteTempCrvatInvoiceRelById(String[] id);
}
