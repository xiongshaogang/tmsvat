package com.deloitte.tms.vat.salesinvoice.dao.impl;
// Generated by bo.wang with ling2.autoproject

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.deloitte.tms.base.cache.utils.LegalEntityCacheUtils;
import com.deloitte.tms.base.enums.PrintRangeEnums;
import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.commons.utils.DateUtils;
import com.deloitte.tms.pl.core.dao.impl.BaseDao;
import com.deloitte.tms.vat.base.enums.CrvatTaxPoolStatuEnums;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxPool;
import com.deloitte.tms.vat.salesinvoice.model.TempTmsCrvatInvoiceReqL;
import com.deloitte.tms.vat.salesinvoice.dao.InvoiceTrxPoolDao;
/**
 * Home object for domain model class InvoiceTrxPool.
 * @see com.deloitte.tms.vat.salesinvoice.model
 * @author Hibernate Tools
 */
@Component(InvoiceTrxPoolDao.BEAN_ID)
public class InvoiceTrxPoolDaoImpl extends BaseDao<InvoiceTrxPool> implements InvoiceTrxPoolDao{
	public DaoPage findInvoiceTrxPoolByParams(Map<String,Object> params, Integer pageIndex,Integer pageSize)
	{
		StringBuffer query=new StringBuffer();
		Map<String,Object> values=new HashMap<String,Object>();
		buildInvoiceTrxPoolQuery(query, values, params);
		return pageBy(query, values, pageIndex, pageSize);
		
//		String buySelectOption = (String) params.get("buySelectOption");//统一社会信用代码/纳税人识别号
//		String buySelectValue = (String) params.get("buySelectValue");//来源代码
//		String customerNo = (String) params.get("customerNo");//客户号
//		String taxType = (String) params.get("taxType");//涉税交易类型
//		String salesEntityName = (String) params.get("salesEntityName");//销方主体名称
//		String trsEndDate = (String) params.get("trsEndDate");//交易开始日期
//		String trsStartDate = (String) params.get("trsStartDate");// 交易结束日期
//		
//		StringBuffer query = new StringBuffer();
//		Map values = new HashMap();
//		query.append(" from InvoiceTrxPool where 1=1");
//		
//		if (trsStartDate != null && !"".equals(trsStartDate)) {
//			query.append(" and trxDate >= :trsStartDate");
//			values.put("trsStartDate",DateUtils.parseTime(trsStartDate,"yyyy-MM-dd"));
//		} 
//		if (trsEndDate != null && !"".equals(trsEndDate)) {
//			query.append(" and trxDate <= :trsEndDate");
//			values.put("trsStartDate",DateUtils.parseTime(trsEndDate,"yyyy-MM-dd"));
//		} 
//		if (sourceCode != null && !"".equals(sourceCode)) {
//			query.append(" and sourceCode = :sourceCode");
//			values.put("sourceCode",sourceCode);
//		} 
//		if (orgId != null && !"".equals(orgId)) {
//			query.append(" and orgId = :orgId");
//			values.put("orgId",orgId);
//		} 
//		if (trxNumber != null && !"".equals(trxNumber)) {
//			query.append(" and trxNumber = :trxNumber");
//			values.put("trxNumber",trxNumber);
//		}
//		if (taxTrxTypeId != null && !"".equals(taxTrxTypeId)) {
//			query.append(" and taxTrxTypeId = :taxTrxTypeId");
//			values.put("taxTrxTypeId",taxTrxTypeId);
//		}
//		if (trxEndDate != null && !"".equals(trxEndDate)) {
//			query.append(" and trxDate <= :trxEndDate");
//			values.put("trxEndDate",DateUtils.parseTime(trxEndDate,"yyyy-MM-dd"));
//		}
//		if (trxBeginDate != null && !"".equals(trxBeginDate)) {
//			query.append(" and trxDate >= :trxBeginDate");
//			values.put("trxBeginDate",DateUtils.parseTime(trxBeginDate, "yyyy-MM-dd"));
//		}
		
//		return pageBy(query, values, pageIndex, pageSize);
		
		
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<InvoiceTrxPool> findInvoiceTrxPoolByParams(Map<String,Object> params)
	{
		StringBuffer query=new StringBuffer();
		Map<String,Object> values=new HashMap<String,Object>();
		buildInvoiceTrxPoolQuery(query, values, params);
		return findBy(query, values);
	}
	
	private void buildInvoiceTrxPoolQuery(StringBuffer query,Map<String,Object> values,Map<String,Object> params) {
		query.append(" from InvoiceTrxPool where 1=1 ");
		Object value=params.get("status");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and status=:status");
			values.put("status", value);
		}
		value = params.get("source");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and sourceCode=:sourcecode");
			values.put("sourcecode", value);
		}
		value = params.get("trxNumber");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and trxNumber=:trxNumber");
			values.put("trxNumber", value);
		}
		value = params.get("batchNum");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and trxBatchNum=:trxBatchNum");
			values.put("trxBatchNum", value);
		}
		
		
//		String buySelectOption = (String) params.get("buySelectOption");//统一社会信用代码/纳税人识别号
//		String buySelectValue = (String) params.get("buySelectValue");//来源代码
//		String customerNo = (String) params.get("customerNo");//客户号
//		String taxType = (String) params.get("taxType");//涉税交易类型
//		String salesEntityName = (String) params.get("salesEntityName");//销方主体名称
//		String trsEndDate = (String) params.get("trsEndDate");//交易开始日期
//		String trsStartDate = (String) params.get("trsStartDate");// 交易结束日期
		value = params.get("custRegistrationNumber");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and custRegistrationNumber=:custRegistrationNumber");
			values.put("custRegistrationNumber", value);
		}
		value = params.get("trsEndDate");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and trxDate<=:trsEndDate");
			values.put("trsEndDate", DateUtils.parseTime((String)value,"yyyy-MM-dd"));
		}
		value = params.get("trsStartDate");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and trxDate>=:trsStartDate");
			values.put("trsStartDate", DateUtils.parseTime((String)value,"yyyy-MM-dd"));
		}
		
		value = params.get("customerId");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and customerId=:customerId");
			values.put("customerId", value);
		}
		value = params.get("taxTrxTypeId");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and taxTrxTypeId=:taxTrxTypeId");
			values.put("taxTrxTypeId", value);
		}
		value = params.get("legalEntityId");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and legalEntityId =:legalEntityId");
			values.put("legalEntityId", value);
		}
		value = params.get("selectOption");
		System.out.println("================value=============="+value);
		if("1".equals(value)){
			value=params.get("selectValue");
			if(AssertHelper.notEmpty(value))
			{
				query.append(" and custRegistrationNumber=:custRegistrationNumber");
				values.put("custRegistrationNumber", value);
			}
		}
	}
	private void buildGetAllTrxPoolQuery(StringBuffer query,Map values,Map params) {
		query.append(" from InvoiceTrxPool where 1=1");
		//交易流水号
		if(AssertHelper.isOrNotEmpty_assert(params.get("trxNumber"))){
			query.append(" and trxNumber=:trxNumber");
			values.put("trxNumber",params.get("trxNumber") );
		}else{
			if(AssertHelper.isOrNotEmpty_assert(params.get("customerId"))){
				query.append(" and customerId=:customerId ");
				values.put("customerId", params.get("customerId"));
			}
			/*if(AssertHelper.isOrNotEmpty_assert(params.get("custRegistrationCode"))){
				query.append(" and custRegistrationCode=:custRegistrationCode ");
				values.put("custRegistrationCode", params.get("custRegistrationCode"));
			}
			if(AssertHelper.isOrNotEmpty_assert(params.get("custRegistrationNumber"))){
				query.append(" and custRegistrationNumber=:custRegistrationNumber");
				values.put("custRegistrationNumber", params.get("custRegistrationNumber"));
			}*/if(AssertHelper.isOrNotEmpty_assert(params.get("isExitsCustomer"))){
				if("1".equals(params.get("isExitsCustomer"))){
					query.append(" and customerId is null");
				}else if("0".equals(params.get("isExitsCustomer"))){
					query.append(" and customerId is not null");
				}
			}if(AssertHelper.isOrNotEmpty_assert(params.get("trxStartDate"))&&AssertHelper.isOrNotEmpty_assert(params.get("trxEndDate"))){
				query.append(" and (trxDate between :startDate and :endDate)");
				Date  datefrom =  DateUtils.parse(params.get("trxStartDate").toString(), "yyyy-MM-dd");
			    Date  dateTo=  DateUtils.parse(params.get("trxEndDate").toString(), "yyyy-MM-dd");
				values.put("startDate",datefrom );
				values.put("endDate", dateTo);
			}if(AssertHelper.isOrNotEmpty_assert(params.get("inventoryItemNumber"))){
				query.append(" and inventoryItemNumber=:inventoryItemNumber");
				values.put("inventoryItemNumber", params.get("inventoryItemNumber"));
			}
			/*if(AssertHelper.isOrNotEmpty_assert(params.get("customerNumber"))){
				query.append(" and customerNumber=:customerNumber");
				values.put("customerNumber",params.get("customerNumber") );
			}*/
			if(AssertHelper.isOrNotEmpty_assert(params.get("reqInvoiceRange"))){
				PrintRangeEnums enums=findEnumsByValue(params.get("reqInvoiceRange").toString());
				if(enums!=PrintRangeEnums.all){
					List<String>list=LegalEntityCacheUtils.legalEntityCodesByOrgId(params.get("orgId").toString(),enums);
					String[]legalEntityCode=(String[]) list.toArray(new String[list.size()]);
					query.append(" and legalEntityCode in :legalEntityCode");
					values.put("legalEntityCode", legalEntityCode);
				}
			}
			//客户账号
			if(AssertHelper.isOrNotEmpty_assert(params.get("custBankAccountNum"))){
				query.append(" and inventoryItemNumber=:inventoryItemNumber");
				values.put("inventoryItemNumber", params.get("inventoryItemNumber"));
			}
		}
		query.append(" and ( status in :status");
		String[] status=new String[]{CrvatTaxPoolStatuEnums.OPEN.getValue(),CrvatTaxPoolStatuEnums.APPFORM_REVOKED.getValue(),CrvatTaxPoolStatuEnums.PREP_FORM_REVOKED.getValue()};
		values.put("status", status);
		query.append(" or status is null )");
		query.append(" and flag = 1");
	}
	
	/**   
	 * @param map
	 * @return  
	 * @see com.deloitte.tms.vat.salesinvoice.dao.InvoiceTrxPoolDao#getAlltransaction(java.util.Map)  
	 */
	
	@Override
	public List<InvoiceTrxPool> getAlltransaction(Map<String, Object> map) {
		StringBuffer query=new StringBuffer();
		Map<String,Object> values=new HashMap<String,Object>();
		buildGetAllTrxPoolQuery(query, values, map);
		return find(query.toString(), values);
	}
	/**
	 * 获取受理层级枚举
	 */
	private PrintRangeEnums findEnumsByValue(String value){
		if("1".equals(value)){
			return PrintRangeEnums.all;
		}else if("2".equals(value)){
			return PrintRangeEnums.current;
		}else if("3".equals(value)){
			return PrintRangeEnums.city;
		}
		return null;
	}

	@Override
	public DaoPage findInvoiceTempReqLByParams(Map<String, Object> params,
			Integer pageIndex, Integer pageSize) {
		StringBuffer query=new StringBuffer();
		Map<String,Object> values=new HashMap<String,Object>();
		query.append(" from TempTmsCrvatInvoiceReqL where 1=1 ");
		Object value=params.get("crvatInvoiceReqHId");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and invoiceReqhId=:invoiceReqhId");
			values.put("invoiceReqhId", value);
		}
		
		return pageBy(query, values, pageIndex, pageSize);
	}

	@Override
	public List<TempTmsCrvatInvoiceReqL> getTempTmsCrvatInvoiceReqLsByReqHid(
			String reHid) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		Map<String,Object> values=new HashMap<String,Object>();
		query.append(" from TempTmsCrvatInvoiceReqL where 1=1 ");		
		if(AssertHelper.notEmpty(reHid))
		{
			query.append(" and invoiceReqhId=:invoiceReqhId");
			values.put("invoiceReqhId", reHid);
		}
		return findBy(query, values);
	}

	@Override
	public void deleteTempCrvatInvoiceReqLByReqHid(String reqHid) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		Map<String,Object> values=new HashMap<String,Object>();
		query.append("delete from TempTmsCrvatInvoiceReqL where 1=1 ");		
		if(AssertHelper.notEmpty(reqHid))
		{
			query.append(" and invoiceReqhId=:invoiceReqhId");
			values.put("invoiceReqhId", reqHid);
		}
		executeHqlProduce(query.toString(), values);
	}

	@Override
	public void deleteTempCrvatInvoiceReqLById(String id) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		Map<String,Object> values=new HashMap<String,Object>();
		TempTmsCrvatInvoiceReqL tempTmsCrvatInvoiceReqL = (TempTmsCrvatInvoiceReqL) get(TempTmsCrvatInvoiceReqL.class, id);
		InvoiceTrxPool pool = (InvoiceTrxPool) get(InvoiceTrxPool.class, tempTmsCrvatInvoiceReqL.getInvoiceTrxId());
		pool.setStatus(null);
		this.update(pool);
		query.append("delete from TempTmsCrvatInvoiceReqL where 1=1 ");		
		if(AssertHelper.notEmpty(id))
		{
			query.append(" and id=:id");
			values.put("id", id);
		}
		executeHqlProduce(query.toString(), values);
	}

	@Override
	public void deleteTempCrvatInvoiceReqLByUserName(String userName) {
		// TODO Auto-generated method stub
		realeasePoolStatusTempCrvatInvoiceRelUserName(userName);
		StringBuffer query=new StringBuffer();
		Map<String,Object> values=new HashMap<String,Object>();
		
		query.append("delete from TempTmsCrvatInvoiceReqL where 1=1 ");		
		if(AssertHelper.notEmpty(userName))
		{
			query.append(" and operatorUser=:operatorUser");
			values.put("operatorUser", userName);
		}
		executeHqlProduce(query.toString(), values);
		
	}
	
	private void realeasePoolStatusTempCrvatInvoiceRelUserName(String userName){
		StringBuffer query=new StringBuffer();
		Map<String,Object> values=new HashMap<String,Object>();		
		query.append("update TMS_CRVAT_TRX_POOL_ALL set status = null  where CRVAT_TRX_POOL_ID in ");
		query.append("(select temp.INVOICE_TRX_ID from TEMP_TMS_CRVAT_INVOICE_REQ_L temp where 1=1 ");
		if(AssertHelper.notEmpty(userName))
		{
			query.append(" and temp.OPERATOR_USER=:operatorUser)");
			values.put("operatorUser", userName);
		}else {
			query.append(")");
		}
		executeSql(query, values);
		//executeProduce(query, values);
		
	}

	
}

