package com.deloitte.tms.vat.salesinvoice.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deloitte.tms.base.masterdata.model.BaseOrg;
import com.deloitte.tms.base.masterdata.model.Customer;
import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.commons.utils.DateUtils;
import com.deloitte.tms.pl.core.dao.impl.BaseDao;
import com.deloitte.tms.vat.salesinvoice.dao.InvoiceSpecialDao;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceReqH;

@Component
public class InvoiceSpecialDaoImpl extends BaseDao<InvoiceReqH> implements
		InvoiceSpecialDao {
	@Autowired
	BaseDao<BaseOrg> baseDao;

	/**
	 * 申请单数据查询
	 * 
	 * @param params
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@Override
	public DaoPage findInvoiceReqHByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		StringBuffer query = new StringBuffer();
		Map<String, Object> values = new HashMap<String, Object>();
		buildInvoiceReqHQuery(query, values, params);
		return pageBy(query, values, pageIndex, pageSize);
	}

	/**
	 * 申请单数据查询
	 * 
	 * @param query
	 * @param values
	 * @param params
	 */
	private void buildInvoiceReqHQuery(StringBuffer query, Map values,
			Map params) {
		query.append(" from InvoiceReqH where invoiceReqType = :invoiceReqType ");
		values.put("invoiceReqType", "2");//过滤条件：特殊（无合同）
		
		Object value = params.get("status");
		if (AssertHelper.isOrNotEmpty_assert(value))// 状态
		{
			query.append(" and status=:status");
			values.put("status", value);
		}
		if (AssertHelper.isOrNotEmpty_assert(params
				.get("custRegistrationNumber"))) {// 购方纳税识别号
			query.append(" and custRegistrationNumber=:custRegistrationNumber");
			values.put("custRegistrationNumber",
					params.get("custRegistrationNumber"));
		}
		if (AssertHelper.isOrNotEmpty_assert(params.get("invoiceReqStartDate"))
				&& AssertHelper.isOrNotEmpty_assert(params
						.get("invoiceReqendDate"))) {
			query.append(" and invoiceReqDate between :invoiceReqStartDate and :invoiceReqendDate");// 提交日期
			Date datefrom = DateUtils.parse(params.get("invoiceReqStartDate")
					.toString(), "yyyy-MM-dd");
			Date dateTo = DateUtils.parse(params.get("invoiceReqendDate")
					.toString(), "yyyy-MM-dd");
			values.put("invoiceReqStartDate", datefrom);
			values.put("invoiceReqendDate", dateTo);
		}
		if (AssertHelper
				.isOrNotEmpty_assert(params.get("custRegistrationCode"))) {// 购方纳税识别号类型
			query.append(" and custRegistrationCode=:custRegistrationCode");
			values.put("custRegistrationCode",
					params.get("custRegistrationCode"));
		}
		if (AssertHelper.isOrNotEmpty_assert(params.get("customerId"))) {// 购方名称ID
			query.append(" and customerId=:customerId");
			values.put("customerId", params.get("customerId"));
		}
		query.append(" and flag=:flag");
		values.put("flag", "1");
	}

	/**
	 * 商品分类及服务编码
	 * 
	 * @param params
	 * @return
	 */
	public DaoPage findTmsMdInventoryItemsByParams(Map params,
			Integer pageIndex, Integer pageSize) {
		StringBuffer query = new StringBuffer();
		Map values = new HashMap();
		buildTmsMdInventoryItemsQuery(query, values, params);
		return pageBy(query, values, pageIndex, pageSize);
	}

	/**
	 * 商品分类及服务编码
	 * 
	 * @param params
	 * @return
	 */
	private void buildTmsMdInventoryItemsQuery(StringBuffer query, Map values,
			Map params) {
		query.append(" from TmsMdInventoryItems where 1=1 ");
		Object value = params.get("id");
		if (value != null) {
			query.append(" and id=:id");
			values.put("id", value);
		}
	}

	/**
	 * 根据客户编号查询客户信息
	 */
	@Override
	public List<Customer> findCustomer(String string,String string1) {
		StringBuffer query=new StringBuffer();
		Map<String,Object> values=new HashMap<String,Object>();
		List<Customer> list = null;
		if(AssertHelper.notEmpty(string))
		{
			query.append(" from Customer where 1=1 ");
			query.append(" and customerNumber=:customerNumber");
			values.put("customerNumber", string);
			list =  findBy(query, values);
		}
		if(AssertHelper.notEmpty(string1)){
			query.append(" from Customer where 1=1 ");
			query.append(" and id=:id");
			values.put("id", string1);
			list =  findBy(query, values);
		}
		
		return list;
	}

	@Override
	public DaoPage findInvoiceReqPByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		return null;
	}
}
