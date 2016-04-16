package com.deloitte.tms.base.masterdata.dao.impl;
// Generated by bo.wang with ling2.autoproject

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.dao.impl.BaseDao;
import com.deloitte.tms.base.masterdata.model.Customer;
import com.deloitte.tms.base.masterdata.model.CustomerSite;
import com.deloitte.tms.base.masterdata.dao.CustomerSiteDao;
/**
 * Home object for domain model class CustomerSite.
 * @see com.deloitte.tms.base.masterdata.model
 * @author Hibernate Tools
 */
@Component(CustomerSiteDao.BEAN_ID)
public class CustomerSiteDaoImpl extends BaseDao<CustomerSite> implements CustomerSiteDao{
	public DaoPage findCustomerSiteByParams(Map params, Integer pageIndex,Integer pageSize)
	{
		StringBuffer query=new StringBuffer();
		Map values=new HashMap();
		buildCustomerSiteQuery(query, values, params);
		return pageBy(query, values, pageIndex, pageSize);
	}
	public List<CustomerSite> findCustomerSiteByParams(Map params)
	{
		StringBuffer query=new StringBuffer();
		Map values=new HashMap();
		buildCustomerSiteQuery(query, values, params);
		return findBy(query, values);
	}
	private void buildCustomerSiteQuery(StringBuffer query,Map values,Map params) {
		query.append(" from CustomerSite where 1=1 ");
		Object value=params.get("status");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and status=:status");
			values.put("status", value);
		}
		value=params.get("customerId");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and customerId=:customerId");
			values.put("customerId", value);
		}
		
		value=params.get("recipientAddr");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and recipientAddr=:recipientAddr");
			values.put("recipientAddr", value);
		}
		
		value=params.get("deleteFlag");
		if(AssertHelper.notEmpty(value))
		{
			query.append(" and deleteFlag=:deleteFlag");
			values.put("deleteFlag", value);
		}
	}
	
}

