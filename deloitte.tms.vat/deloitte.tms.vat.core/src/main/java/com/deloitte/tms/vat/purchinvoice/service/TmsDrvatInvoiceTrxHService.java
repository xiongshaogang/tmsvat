package com.deloitte.tms.vat.purchinvoice.service;
// Generated by bo.wang with ling2.autoproject

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.service.IService;
import com.deloitte.tms.vat.purchinvoice.model.TmsDrvatInvoiceTrxH;
import com.deloitte.tms.vat.purchinvoice.model.TmsDrvatInvoiceTrxHInParam;
import com.deloitte.tms.vat.purchinvoice.dao.TmsDrvatInvoiceTrxHDao;
import com.deloitte.tms.vat.purchinvoice.model.TmsDrvatInvoiceTrxL;
import com.deloitte.tms.vat.purchinvoice.model.TmsDrvatInvoiceTrxLInParam;
/**
 * Home object for domain model class TmsDrvatInvoiceTrxH.
 * @see com.deloitte.tms.vat.purchinvoice.model
 * @author Hibernate Tools
 */
public interface TmsDrvatInvoiceTrxHService extends IService{
	public static final String BEAN_ID="tmsDrvatInvoiceTrxHService";
	
	public DaoPage findTmsDrvatInvoiceTrxHByParams(Map params, Integer pageIndex,Integer pageSize);
	
	public List<TmsDrvatInvoiceTrxHInParam> findTmsDrvatInvoiceTrxHByParams(Map params);
	
	public void saveTmsDrvatInvoiceTrxHDataListsMap(Map dataListsMap);
	
	public TmsDrvatInvoiceTrxHInParam convertTmsDrvatInvoiceTrxHToInParam(TmsDrvatInvoiceTrxH model);
	
	public TmsDrvatInvoiceTrxH convertTmsDrvatInvoiceTrxHInParamToEntity(TmsDrvatInvoiceTrxHInParam inParam);
	
	public DaoPage findTmsDrvatInvoiceTrxLByParams(Map params, Integer pageIndex,Integer pageSize);
	
	public List<TmsDrvatInvoiceTrxLInParam> findTmsDrvatInvoiceTrxLByParams(Map params);
	
	public void saveTmsDrvatInvoiceTrxLDataListsMap(Map dataListsMap);
	
	public TmsDrvatInvoiceTrxLInParam convertTmsDrvatInvoiceTrxLToInParam(TmsDrvatInvoiceTrxL model);
	
	public TmsDrvatInvoiceTrxL convertTmsDrvatInvoiceTrxLInParamToEntity(TmsDrvatInvoiceTrxLInParam inParam);

	public void saveTmsInVoiceLMap(Map dataListsMap);

	public StringBuffer importExcel(InputStream content);

	public List<TmsDrvatInvoiceTrxLInParam> findTmsDrvatInvoiceTrxLByParams2(Map params);

	public List<TmsDrvatInvoiceTrxLInParam> findTrxL4Exist(Map params);

	public void writeBackAuthen(TmsDrvatInvoiceTrxLInParam record);

	public List<TmsDrvatInvoiceTrxLInParam> findTmsDrvatInvoiceTrxLByDate(Map params);

	public DaoPage findTmsDrvatInvoiceTrxLByParams2(Map params, Integer pageIndex,
			Integer pageSize);

	public void removeTrxL(String ids);

	
}

