package com.deloitte.tms.vat.bill.pm.dao;
// Generated by bo.wang with ling2.autoproject

import java.util.List;
import java.util.Map;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.dao.IDao;
import com.deloitte.tms.vat.bill.pm.model.BillBook;
/**
 * Home object for domain model class BillBook.
 * @see com.deloitte.tms.vat.bill.pm.model
 * @author Hibernate Tools
 */
public interface BillBookDao extends IDao<BillBook>{
	public static final String BEAN_ID="billBookDao";
	public DaoPage findBillBookByParams(Map params, Integer pageIndex,Integer pageSize);
	public List<BillBook> findBillBookByParams(Map params);
}
