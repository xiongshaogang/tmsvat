package com.deloitte.tms.vat.salesinvoice.service.impl;
// Generated by bo.wang with ling2.autoproject

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deloitte.tms.base.cache.model.BizOrgNode;
import com.deloitte.tms.base.cache.utils.LegalEntityCacheUtils;
import com.deloitte.tms.base.cache.utils.OrgCacheUtils;
import com.deloitte.tms.base.masterdata.model.Customer;
import com.deloitte.tms.base.masterdata.model.CustomerInParam;
import com.deloitte.tms.base.masterdata.model.TmsMdLegalEntity;
import com.deloitte.tms.base.masterdata.model.TmsMdTaxTrxType;
import com.deloitte.tms.base.masterdata.service.CustomerService;
import com.deloitte.tms.base.taxsetting.model.TmsMdInventoryItems;
import com.deloitte.tms.pl.cache.utils.DictionaryCacheUtils;
import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.commons.utils.BatchUtils;
import com.deloitte.tms.pl.core.commons.utils.DateUtils;
import com.deloitte.tms.pl.core.commons.utils.reflect.ReflectUtils;
import com.deloitte.tms.pl.core.dao.IDao;
import com.deloitte.tms.pl.core.service.impl.BaseService;
import com.deloitte.tms.pl.dictionary.service.DictionaryService;
import com.deloitte.tms.pl.flow.utils.FlowHelper;
import com.deloitte.tms.vat.base.enums.AppFormStatuEnums;
import com.deloitte.tms.vat.base.enums.CrvatTaxPoolStatuEnums;
import com.deloitte.tms.vat.base.enums.InvoiceReqTypeEnums;
import com.deloitte.tms.vat.core.common.IdGenerator;
import com.deloitte.tms.vat.salesinvoice.dao.InvoiceReqHDao;
import com.deloitte.tms.vat.salesinvoice.dao.InvoiceReqLDao;
import com.deloitte.tms.vat.salesinvoice.dao.InvoiceTrxPoolDao;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceReqH;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceReqHInParam;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceReqL;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceReqLInParam;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxPool;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxPoolInParam;
import com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService;
import com.deloitte.tms.vat.salesinvoice.service.InvoiceReqLService;
import com.deloitte.tms.vat.salesinvoice.service.InvoiceSyncProvider;
import com.deloitte.tms.vat.salesinvoice.service.InvoiceTrxPoolService;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
/**
 * Home object for domain model class InvoiceReqH.
 * @see com.deloitte.tms.vat.salesinvoice.model
 * @author Hibernate Tools
 */
@Component(InvoiceReqHService.BEAN_ID)
public class InvoiceReqHServiceImpl extends BaseService implements InvoiceReqHService{
	@Resource
	InvoiceReqHDao invoiceReqHDao;
	@Autowired
	InvoiceReqLService invoiceReqLService;
	@Autowired
	InvoiceTrxPoolService invoiceTrxPoolService;
	@Autowired
	CustomerService customerService;
	@Autowired
	DictionaryService dictionaryService;
	@Autowired
	InvoiceReqLDao invoiceReqLDao;
	@Autowired
	InvoiceTrxPoolDao invoiceTrxPoolDao;
	@Resource
	InvoiceSyncProvider invoiceSyncProvider;
	@Override
	public IDao getDao() {
		return invoiceReqHDao;
	}

	@Override
	public DaoPage findInvoiceReqHByParams(Map params, Integer pageIndex,
			Integer pageSize) {
		if(params==null)
		{
			params=new HashMap();
		}
		/*if(AssertHelper.isOrNotEmpty_assert(params.get("customerNumber"))){
			Map<String,Object>map=new HashMap<String, Object>();
			map.put("customerNumber", params.get("customerNumber"));
			List<CustomerInParam>list=customerService.findCustomerByParams(map);
			String customerId = "";
			for (int i = 0; i < list.size(); i++) {
				customerId+=list.get(i).getId()+",";
			}
			String[]ids=customerId.split(",");
			String ids="";
			if(list.size()>0){
				ids=list.get(0).getId();
			}
			params.put("customerId", ids);
		}*/
		DaoPage daoPage= invoiceReqHDao.findInvoiceReqHByParams(params, pageIndex, pageSize);
		daoPage.setResult(convertInvoiceReqHToInParam((List<InvoiceReqH>) daoPage.getResult()));
		return daoPage;
	}
	@Override
	public List<InvoiceReqHInParam> findInvoiceReqHByParams(Map params) {
		if(params==null)
		{
			params=new HashMap();
		}
		List<InvoiceReqH> temp= invoiceReqHDao.findInvoiceReqHByParams(params);
		return convertInvoiceReqHToInParam(temp);
	}
	@Override
	public void saveInvoiceReqHDataListsMap(Map dataListsMap) {
		Collection<InvoiceReqHInParam> deleteList = BatchUtils.to(InvoiceReqHInParam.class).getDeleteEntities(dataListsMap);
		Collection<InvoiceReqHInParam> insertList =  BatchUtils.to(InvoiceReqHInParam.class).getInsertEntities(dataListsMap);
		Collection<InvoiceReqHInParam> updateList =  BatchUtils.to(InvoiceReqHInParam.class).getModifiedEntities(dataListsMap);
		if (updateList != null&&updateList.size() > 0) {
			for(InvoiceReqHInParam inParam: updateList){
				InvoiceReqH entity=convertInvoiceReqHInParamToEntity(inParam);
				invoiceReqHDao.update(entity);
			}		
//			invoiceReqHDao.updateAll(updateList);
		}
		if (insertList != null&&insertList.size() > 0) {
			for(InvoiceReqHInParam inParam: insertList){
				InvoiceReqH entity=convertInvoiceReqHInParamToEntity(inParam);
				invoiceReqHDao.save(entity);
				inParam.setId(entity.getId());
			}
//			invoiceReqHDao.saveAll(insertList);
		}
		if (deleteList != null&&deleteList.size() > 0) {
			for(InvoiceReqHInParam inParam:deleteList){
				InvoiceReqH entity=new InvoiceReqH();
				entity.setId(inParam.getId());
				invoiceReqHDao.remove(entity);
			}
//			invoiceReqHDao.removeAll(deleteList);
		}
		
	}
	private List<InvoiceReqHInParam> convertInvoiceReqHToInParam(List<InvoiceReqH> models){
		List<InvoiceReqHInParam> result=new ArrayList<InvoiceReqHInParam>();
		for(InvoiceReqH initiation:models){
			InvoiceReqHInParam inparam=convertInvoiceReqHToInParam(initiation);
			result.add(inparam);
		}
		return result;
	}
	private List<InvoiceTrxPoolInParam> convertInvoiceTrxPoolToInParam(List<InvoiceTrxPool>models){
		List<InvoiceTrxPoolInParam> result=new ArrayList<InvoiceTrxPoolInParam>();
		for(InvoiceTrxPool initiation:models){
			InvoiceTrxPoolInParam inparam=convertInvoiceTrxPoolToInParam(initiation);
			//InvoiceTrxPoolInParam inparam=new InvoiceTrxPoolInParam();
			inparam.setTaxRate(null!=initiation.getTaxRate()?initiation.getTaxRate():0.00);
			inparam.setTrxAffirmId(initiation.getTrxAffirmId());
			inparam.setTrxBatchNum(initiation.getTrxBatchNum());
			inparam.setTrxNumber(initiation.getTrxNumber());
			inparam.setSourceCode(initiation.getSourceCode());
			inparam.setCustRegistrationCode(initiation.getCustRegistrationCode());
			inparam.setCustRegistrationNumber(initiation.getCustRegistrationNumber());
			inparam.setCustBankAccountNum(initiation.getCustBankAccountNum());
			inparam.setCustBankBranchName(initiation.getCustBankBranchName());
			inparam.setTaxRate(initiation.getTaxRate());
			inparam.setTaxBaseName(initiation.getTaxBaseName());
			inparam.setTaxSettingMethod(initiation.getTaxSettingMethod());
			inparam.setInvoiceCategoryName(DictionaryCacheUtils.getCodeName("VAT_INVOICE_RULE", initiation.getInvoiceCategory()));
			inparam.setLegalEntityName(initiation.getLegalEntityName());
			inparam.setRegistrationNumber(initiation.getRegistrationNumber());
			/*InvoiceReqLInParam amountInParam=getAmout(initiation.getId(),initiation);
			inparam.setUsedAmount(amountInParam.getUsedAmount());
			inparam.setUserfulAmount(amountInParam.getUserfulAmount());*/
			if(AssertHelper.isOrNotEmpty_assert(initiation.getCustomerId())){
				Customer customer = (Customer) customerService.get(Customer.class, initiation.getCustomerId());
				inparam.setCustomerNumber(customer.getCustomerNumber());
				inparam.setCustomerName(customer.getCustomerName());
			}
			inparam.setCrvatTrxPoolId(initiation.getId());
			inparam.setInvoiceAmount(initiation.getExchangeAmount());
			//inparam.setInvoiceAmount(null!=initiation.getCurrencyAmount()?initiation.getCurrencyAmount():BigDecimal.valueOf(0.00).multiply(null!=initiation.getExchangeRate()?initiation.getExchangeRate():BigDecimal.valueOf(0.00)));
			if(AssertHelper.isOrNotEmpty_assert(initiation.getOrgId())){
				BizOrgNode node=OrgCacheUtils.getNodeByOrgId(initiation.getOrgId());
				if(null!=node){
					inparam.setOrgName(node.getName());
					inparam.setOrgCode(node.getCode());	
				}
			}
			// TO DO
			String codeValue = initiation.getStatus();
			if(AssertHelper.isOrNotEmpty_assert(codeValue)){
				String valueName = DictionaryCacheUtils.getCodeName("VAT_CR_INVOICE_TRX_ITEM_STATUS", codeValue); 
				inparam.setStatus(valueName);
			}
			if(AssertHelper.isOrNotEmpty_assert(initiation.getTaxTrxTypeId())){
				TmsMdTaxTrxType trxType=(TmsMdTaxTrxType) invoiceReqLService.get(TmsMdTaxTrxType.class, initiation.getTaxTrxTypeId());
				if(null!=trxType){
					inparam.setTaxTrxTypeCode(trxType.getTaxTrxTypeCode());
					inparam.setTaxTrxTypeName(trxType.getTaxTrxTypeName());
				}
			}
			if(AssertHelper.isOrNotEmpty_assert(initiation.getInventoryItemId())){
				TmsMdInventoryItems items = (TmsMdInventoryItems) this.get(TmsMdInventoryItems.class, initiation.getInventoryItemId());
				if(null!=items){
					inparam.setInventoryItemNumber(initiation.getInventoryItemNumber());
					inparam.setInventoryItemDescripton(items.getInventoryItemDescripton());
				}
			}
			if(AssertHelper.isOrNotEmpty_assert(initiation.getLegalEntityId())){
				TmsMdLegalEntity entity=(TmsMdLegalEntity) this.get(TmsMdLegalEntity.class, initiation.getLegalEntityId());
				if(null!=entity){
					inparam.setLegalEntityCode(entity.getLegalEntityCode());
					inparam.setLegalEntityName(entity.getLegalEntityName());
				}
			}
			result.add(inparam);
		}
		return result;
		
	}
	/**
	 * @author sqing
	 * @see得到页面展示所需的行表金额信息
	 */
	public InvoiceReqLInParam getAmout(String poolId,InvoiceTrxPool pool){
		Map<String,Object>params=new HashMap();
		params.put("crvatTrxPoolId", poolId);
		List<InvoiceReqL>list=invoiceReqLDao.findInvoiceReqLByParams(params);
		InvoiceReqLInParam rInParam=new InvoiceReqLInParam();
		BigDecimal amount = BigDecimal.valueOf(0);
		for (int i = 0; i < list.size(); i++) {
			amount=amount.add(list.get(i).getInvoiceAmount());
		}
		/*****bo.wang******************/
//		rInParam.setUserfulAmount((pool.getCurrencyAmount().subtract(amount)).toString());
//		rInParam.setUsedAmount(amount.toString());
		rInParam.setUserfulAmount(invoiceSyncProvider.getUserfulAmountByTrxPoolId(poolId).toString());
		rInParam.setUsedAmount(invoiceSyncProvider.getUsedAmount(poolId).toString());
		/*****************bo.wang**********/
		
		return rInParam;
	}
	
	/**
	 * 
	 *交易流水记录转为VO
	 * 功能详细描述
	 * @param model
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	public InvoiceTrxPoolInParam convertInvoiceTrxPoolToInParam(InvoiceTrxPool model){
		InvoiceTrxPoolInParam inparam=new InvoiceTrxPoolInParam();
		ReflectUtils.copyProperties(model, inparam);
		inparam.setTrxid(model.getId());
		String orgName;
		//inparam.set
		if(AssertHelper.isOrNotEmpty_assert(model.getCustomer())){
			inparam.setCustomerName(model.getCustomer().getCustomerName());
			inparam.setCustomerId(model.getCustomerId());
		}if(AssertHelper.isOrNotEmpty_assert(model.getOrgId())){
			/*orgName=findOrgNameByOrgCode(model.getOperationOrgCode());
			inparam.setOrgName(orgName);*/
			BizOrgNode node=OrgCacheUtils.getNodeByOrgId(model.getOrgId());
			if(node!=null){
				inparam.setOrgName(node.getName());
			}
		}
		//inparam.setCustomer(model.getCustomer());
		return inparam;
	}
	public InvoiceReqHInParam convertInvoiceReqHToInParam(InvoiceReqH model){
		InvoiceReqHInParam inparam=new InvoiceReqHInParam();
		ReflectUtils.copyProperties(model, inparam);
		String codeValue = model.getCustRegistrationCode();
		if(AssertHelper.isOrNotEmpty_assert(codeValue)){
			String valueName = DictionaryCacheUtils.getCodeName("VAT_CUSTOMER_DISC_OPTION", codeValue); 
			inparam.setCustRegistrationCode(valueName);
		}if(AssertHelper.isOrNotEmpty_assert(model.getCustomer())){
			Customer customer = model.getCustomer();
			inparam.setCustomerNumber(customer.getCustomerNumber());
			inparam.setCustomerName(customer.getCustomerName());
			inparam.setBankBranchName(customer.getCustDepositBankName());
			inparam.setAddress(customer.getCustRegistrationAddress());
			inparam.setBankNum(customer.getCustDepositBankAccountNum());
			inparam.setContactName(customer.getContactName());
		}if(AssertHelper.isOrNotEmpty_assert(model.getStatus())){
			inparam.setStatus(DictionaryCacheUtils.getCodeName("VAT_CR_INVOICE_APPFORM_STATUS",model.getStatus()));
			inparam.setPageStatus(model.getStatus());
			inparam.setReqStatus(model.getStatus());
		}if(AssertHelper.isOrNotEmpty_assert(model.getOrgId())){
			BizOrgNode node=OrgCacheUtils.getNodeByOrgId(model.getOrgId().trim());
			if(node!=null){
				inparam.setOrgName(node.getName());
				inparam.setOrgCode(node.getCode());		
			}
			
		}
		if(AssertHelper.isOrNotEmpty_assert(model.getLegalEntityId())){
			TmsMdLegalEntity entity=(TmsMdLegalEntity) this.get(TmsMdLegalEntity.class, model.getLegalEntityId());
			inparam.setLegalEntityCode(entity.getLegalEntityCode());
			inparam.setLegalEntityName(entity.getLegalEntityName());
		}
		/*if(AssertHelper.isOrNotEmpty_assert(model.getin)){
			TmsMdInventoryItems items = (TmsMdInventoryItems) this.get(TmsMdInventoryItems.class, initiation.getInventoryItemId());
			inparam.setInventoryItemDescripto(items.getInventoryItemDescripton());
		}*/
		List<InvoiceReqL> list=getInvoiceReqLs(model.getId());
		if(AssertHelper.isOrNotEmpty_assert(list)){
			/*List<InvoiceReqL>list=(List<InvoiceReqL>) model.getInvoiceReqLs();*/		
			BigDecimal amount=BigDecimal.valueOf(0.00);
			BigDecimal realAmount=BigDecimal.valueOf(0.00);
			for (int i = 0; i < list.size(); i++) {
				amount=amount.add(list.get(i).getInvoiceAmount());
				//性能很慢，用于字段改造
				//realAmount=realAmount.add(invoiceSyncProvider.getUserfulAmountByTrxPoolId(list.get(i).getCrvatTrxPoolId()));
				String realAmountStr = list.get(i).getAttribute1();
				if(AssertHelper.isOrNotEmpty_assert(realAmountStr)){
					BigDecimal realBigDecimal = new BigDecimal(realAmountStr);
					realAmount = realAmount.add(realBigDecimal);
				}
				
			}
			if(list.size()>0){
				inparam.setHavereql(true);
			}else {
				inparam.setHavereql(false);
			}
			inparam.setReqAmount(amount.toString());
			// TO DO
			/**
			 * 实际开票金额
			 */
			
			inparam.setAcctdAmountCr(realAmount.toString());
		}
		
		return inparam;
	}
	public InvoiceReqH convertInvoiceReqHInParamToEntity(InvoiceReqHInParam inParam){
		InvoiceReqH entity=new InvoiceReqH();
		/*inParam.setCrvatInvoiceReqNumber(inParam.getReadyNo());	*/	
		inParam.setInvoiceReqDate(getDatabaseServerDate());
		ReflectUtils.copyProperties(inParam, entity);
		return entity;
	}
	/**
	 * @author sqing
	 */
	public List<InvoiceReqHInParam> convertInvoiceReqAllToInParam(List<InvoiceReqH>list){
		List<InvoiceReqHInParam> inParams=new ArrayList();
		for (InvoiceReqH invoiceReqH:list) {
			InvoiceReqHInParam inParam=convertInvoiceAllToInParam(invoiceReqH);
			inParams.add(inParam);
		}
		return inParams;
	}
	public InvoiceReqHInParam convertInvoiceAllToInParam(InvoiceReqH invoiceReqH){
		InvoiceReqHInParam inParam=new InvoiceReqHInParam();
		//Customer customer;
		ReflectUtils.copyProperties(invoiceReqH, inParam);
		if(AssertHelper.isOrNotEmpty_assert(invoiceReqH.getCustomerId())){
			//customer=(Customer) customerService.findById(Customer.class, invoiceReqH.getCustomerId());
			Customer customer = invoiceReqH.getCustomer();
			if(AssertHelper.isOrNotEmpty_assert(customer)){
				inParam.setCustomerCode(customer.getCustomerNumber());
				inParam.setCustomerName(customer.getCustomerName());
			}
		}
		
		return inParam;
	}
	public InvoiceReqL convertInvoiceTrxPoolToInvoiceReqL(InvoiceTrxPool pool,InvoiceReqH entity){
		//InvoiceReqL invoiceReqL = invoiceReqLService.findInvoiceReqLByPoolId(pool.getId());
		/*if(invoiceReqL!=null){
			return invoiceReqL;
		}
		else{*/
			InvoiceReqL invoiceReqL = new InvoiceReqL();
			invoiceReqL.setCrvatInvoiceReqHId(entity.getId());
			invoiceReqL.setLegalEntityId(pool.getLegalEntityId());
			invoiceReqL.setLegalEntityCode(pool.getLegalEntityCode());
			invoiceReqL.setLegalEntityName(pool.getLegalEntityName());
			invoiceReqL.setCrvatTrxPoolId(pool.getId());
			invoiceReqL.setTaxTrxTypeId(pool.getTaxTrxTypeId());
			invoiceReqL.setInventoryItemId(pool.getInventoryItemId());
			invoiceReqL.setInventoryItemDescripton(pool.getInventoryItemDescripton());
			invoiceReqL.setInventoryItemModels(pool.getInventoryItmeModels());
			invoiceReqL.setInventoryItemNumber(pool.getInventoryItemNumber());
			invoiceReqL.setInventoryItemQty(pool.getInventoryItemQty());
			//invoiceReqL.setVatAmount(pool.get);
			if(!AssertHelper.isOrNotEmpty_assert(pool.getExchangeRate())){
				pool.setExchangeRate(BigDecimal.ZERO);
			}
			if(!AssertHelper.isOrNotEmpty_assert(pool.getCurrencyAmount())){
				invoiceReqL.setInvoiceAmount(BigDecimal.ZERO);
			}else{
				invoiceReqL.setInvoiceAmount(pool.getCurrencyAmount());
			}
			if(!AssertHelper.isOrNotEmpty_assert(pool.getCurrencyAmountCr())){
				invoiceReqL.setAcctdAmountCr(BigDecimal.ZERO);
			}else{
				invoiceReqL.setAcctdAmountCr(pool.getCurrencyAmountCr());
			}
			if("1".equals(pool.getIsTax())){
				if(AssertHelper.isOrNotEmpty_assert(pool.getCurrencyAmount())&&AssertHelper.isOrNotEmpty_assert(pool.getTaxRate())){
					BigDecimal withOutTax=pool.getCurrencyAmount().multiply(BigDecimal.valueOf(pool.getTaxRate()));
					withOutTax = withOutTax.setScale(2, RoundingMode.HALF_UP);
					invoiceReqL.setVatAmount(withOutTax);
				}else{
					invoiceReqL.setVatAmount(BigDecimal.ZERO);
				}
			}else{
				if(AssertHelper.isOrNotEmpty_assert(pool.getCurrencyAmount())&&AssertHelper.isOrNotEmpty_assert(pool.getTaxRate())){
					BigDecimal jin_e=pool.getCurrencyAmount().divide(BigDecimal.valueOf(pool.getTaxRate()).add(BigDecimal.valueOf(1.00)));
					BigDecimal result=jin_e.multiply(BigDecimal.valueOf(pool.getTaxRate()));
					result = result.setScale(2, RoundingMode.HALF_UP);
					invoiceReqL.setVatAmount(result);
				}else{
					invoiceReqL.setVatAmount(BigDecimal.ZERO);
				}
			}
			/*if(AssertHelper.isOrNotEmpty_assert(pool.getCurrencyAmount())&&AssertHelper.isOrNotEmpty_assert(pool.getTaxRate())){
				invoiceReqL.setVatAmount(pool.getCurrencyAmount().multiply(BigDecimal.valueOf(pool.getTaxRate())));
			}else{
				invoiceReqL.setVatAmount(BigDecimal.ZERO);
			}*/
			invoiceReqL.setInvoiceCategory(pool.getInvoiceCategory());
			invoiceReqL.setInvoiceType(pool.getInvoiceType());
			/*invoiceReqL.setInvoiceAmount(((BigDecimal) (null!=pool.getCurrencyAmount()?pool.getCurrencyAmount():BigDecimal.valueOf(0.00))));
			invoiceReqL.setAcctdAmountCr(null!=pool.getCurrencyAmountCr()?pool.getCurrencyAmountCr():BigDecimal.valueOf(0.00));
			invoiceReqL.setVatAmount(((BigDecimal) (null!=pool.getCurrencyAmount()?pool.getCurrencyAmount():BigDecimal.valueOf(0.00)).multiply(null!=pool.getTaxRate()?BigDecimal.valueOf(pool.getTaxRate()):BigDecimal.valueOf(0.00))));*/
			return invoiceReqL;
		//}
	}
	
	/**   
	 * @param params
	 * @param pageIndex
	 * @param pageSize
	 * @return  
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#findInvoiceTrxPoolByParams(java.util.Map, java.lang.Integer, java.lang.Integer)  
	 * @author sqing
	 * @throws ParseException 
	 * @since 20160318
	 * 新增开票申请单，根据客户信息查找交易流水
	 */
	
	@Override
	public DaoPage findInvoiceTrxPoolByParams(Map params, Integer pageIndex,
			Integer pageSize) throws ParseException {
		if(!AssertHelper.isOrNotEmpty_assert(params))
		{
			params=new HashMap();
		}
		/*if(AssertHelper.isOrNotEmpty_assert(params.get("status"))){
			dictionaryService.loadDictionaryEntities("");
		}*/
		DaoPage daoPage= invoiceReqHDao.findInvoiceTrxPoolByParams(params, pageIndex, pageSize);
		if(AssertHelper.isOrNotEmpty_assert(daoPage.getResult())){
			daoPage.setResult(convertInvoiceTrxPoolToInParam((List<InvoiceTrxPool>) daoPage.getResult()));
		}
		return daoPage;
	}

	
	/**   
	 * @param inParam  
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#saveInvoiceReqAll(com.deloitte.tms.vat.salesinvoice.model.InvoiceReqHInParam)  
	 * @author sqing
	 * 保存申请单草稿
	 */
	
	@Override
	public void saveInvoiceReqAll(InvoiceReqHInParam inParam,Map params) {
		InvoiceReqH entity=this.convertInvoiceReqHInParamToEntity(inParam);
		//String orgId=ServiceContextUtils.getCurrentOrgId(params);
		String orgId=inParam.getOrgId();
		String isCommit=inParam.getIsCommit();
		InvoiceReqL invoiceReqL= new InvoiceReqL();
		InvoiceTrxPool pool=new InvoiceTrxPool();
		String[]ids=inParam.getIds().split(",");
		if(!AssertHelper.isOrNotEmpty_assert(entity.getId())){
			entity.setCrvatInvoiceReqNumber(IdGenerator.getPrefixTimestamp("Req", 2));
			entity.setStatus(AppFormStatuEnums.DRAFT.getValue());
			entity.setIsAllMapping("0");
			entity.setMappingStatus("0");
			entity.setOrgId(orgId);
			this.save(entity);
		}
		else{
			InvoiceReqH updEntity= (InvoiceReqH) this.get(InvoiceReqH.class, entity.getId());
			this.update(updEntity);
		}
		for (int i = 0; i < ids.length; i++) {
			pool=(InvoiceTrxPool) invoiceTrxPoolService.get(InvoiceTrxPool.class, ids[i]);
			if(pool!=null){
				invoiceReqL=this.convertInvoiceTrxPoolToInvoiceReqL(pool,entity);
				if(!AssertHelper.isOrNotEmpty_assert(invoiceReqL.getId())){
					invoiceReqL.setStatus(AppFormStatuEnums.DRAFT.getValue());
					invoiceReqL.setOrgId(orgId);
					invoiceReqLService.save(invoiceReqL);
					//String status = DictionaryCacheUtils.getCodeName("tms.base.taxsetting.buyerType", "200");
				}else{
					InvoiceReqL updInvoice= (InvoiceReqL) invoiceReqLService.get(InvoiceReqL.class, invoiceReqL.getId());
					invoiceReqLService.update(updInvoice);
				}
				pool.setStatus(CrvatTaxPoolStatuEnums.APPFORM_USED.getValue());
				invoiceTrxPoolService.update(pool);
			}
		}
	}
	public void updateCommit(String id,Map params){
		//InvoiceReqH entity=this.convertInvoiceReqHInParamToEntity(inParam);
		InvoiceReqH entity= (InvoiceReqH) this.get(InvoiceReqH.class, id);		
		String status=AppFormStatuEnums.SUBMITTED.getValue();
		entity.setStatus(status);
		invoiceReqHDao.update(entity);
		invoiceReqLDao.updateReqLStatusByReqHid(entity.getId(), AppFormStatuEnums.SUBMITTED.getValue());
		invoiceReqHDao.updateTrxPoolStatusByReqHid(entity.getId(), CrvatTaxPoolStatuEnums.APPFORM_SUBMITTED.getValue());		
	/*	String status=AppFormStatuEnums.SUBMITTED.getValue();
		entity.setStatus(status);
		List<InvoiceReqL>list=(List<InvoiceReqL>) entity.getInvoiceReqLs();
		List<InvoiceReqL>list=this.getInvoiceReqLs(entity.getId());
		for (InvoiceReqL invoiceReqL:list) {
			invoiceReqL.setStatus(AppFormStatuEnums.SUBMITTED.getValue());
			InvoiceTrxPool pool = (InvoiceTrxPool) this.get(InvoiceTrxPool.class, invoiceReqL.getCrvatTrxPoolId());
			pool.setStatus(CrvatTaxPoolStatuEnums.APPFORM_SUBMITTED.getValue());
			invoiceReqLDao.update(invoiceReqL);
			invoiceTrxPoolDao.update(pool);
		}*/
		
	}
	
	/**   
	 * @param map  
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#findInvoiceReqAll(java.util.Map)  
	 */
	@Override
	public DaoPage findInvoiceReqAll(Map<String, Object> map, Integer pageIndex,
			Integer pageSize) {
		if(map==null)
		{
			map=new HashMap();
		}
		DaoPage daoPage=this.findInvoiceReqHByParams(map, pageIndex, pageSize);
		/*if(AssertHelper.isOrNotEmpty_assert(daoPage.getResult())){
			daoPage.setResult(daoPage.getResult());
		}*/
		return daoPage;
	}

	
	/**   
	 * @param orgCode
	 * @return  
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#findOrgNameByOrgCode(java.lang.String)  
	 */
	
	@Override
	public String findOrgNameByOrgCode(String orgCode) {
		String orgName=invoiceReqHDao.fidOrgNameByOrgCode(orgCode);
		return orgName;
	}

	
	/**   
	 * @param map
	 * @return  
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#getCustomerParam(java.util.Map)  
	 */
	
	@Override
	public Customer getCustomerParam(Map<String, Object> map) {
		StringBuffer query=new StringBuffer();
		Map values=new HashMap();
		query.append(" from Customer where 1=1 ");
		Object custRegistrationNumber=map.get("custRegistrationNumber");
		Object customerNumber=map.get("customerNumber");
		Object custRegistrationCode=map.get("custRegistrationCode");
		Object custBankAccountNum=map.get("custBankAccountNum");
		//String code = dictionaryService.
		if(AssertHelper.isOrNotEmpty_assert(custRegistrationCode)){
			query.append(" and custRegistrationCode=:custRegistrationCode");
			values.put("custRegistrationCode", custRegistrationCode);
		}
		if(AssertHelper.isOrNotEmpty_assert(customerNumber)){
			query.append(" and customerNumber=:customerNumber");
			values.put("customerNumber", customerNumber.toString().trim());
		}if(AssertHelper.isOrNotEmpty_assert(custRegistrationNumber)){
			query.append(" and custRegistrationNumber=:custRegistrationNumber");
			values.put("custRegistrationNumber", custRegistrationNumber.toString().trim());
		}
		if(AssertHelper.isOrNotEmpty_assert(custBankAccountNum)){
			query.append(" and custDepositBankNumber=:custDepositBankNumber");
			values.put("custDepositBankNumber", custBankAccountNum.toString().trim());
		}
		List<Customer>list= customerService.findBy(query, values);
		if(values.size()>0){
			if(list.size()>0){
				return list.get(0);
			}else{
				return new Customer();
			}
		}
		else{
			return new Customer();
		}
	}

	
	/**   
	 * @param invoiceReqH
	 * @return  
	 * 编辑时返回所有头信息.
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#getEditInfo(com.deloitte.tms.vat.salesinvoice.model.InvoiceReqH)  
	 */
	
	@Override
	public InvoiceReqHInParam getEditInfo(String id) {
		InvoiceReqH invoiceReqH=(InvoiceReqH) get(InvoiceReqH.class, id);
		InvoiceReqHInParam inParam=convertInvoiceReqHToInParam(invoiceReqH);
		//计算申请单头表里需要显示的申请单总金额
		Long reqAmount=0L;
		/*List<InvoiceReqL>list=(List<InvoiceReqL>) invoiceReqH.getInvoiceReqLs();*/
		List<InvoiceReqL>list=this.getInvoiceReqLs(invoiceReqH.getId());
		for (int i = 0; i < list.size(); i++) {
			reqAmount=reqAmount+list.get(i).getInvoiceAmount().longValue();
		}
		inParam.setReqAmount(reqAmount.toString());
		if(AssertHelper.isOrNotEmpty_assert(invoiceReqH.getCustomer())){
			inParam.setAddress(invoiceReqH.getCustomer().getCustRegistrationAddress());
			inParam.setContactName(invoiceReqH.getCustomer().getContactName());
			inParam.setBankNum(invoiceReqH.getCustomer().getContactName());
			inParam.setCustomerName(invoiceReqH.getCustomer().getCustomerName());
			inParam.setBankBranchName(invoiceReqH.getCustomer().getCustDepositBankName());
		}
		return inParam;
	}

	
	/**   
	 * @param ids
	 * 删除申请单  
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#deleteFromReq(java.lang.String[])  
	 */
	
	@Override
	public void deleteFromReqAll(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			InvoiceReqH entity=(InvoiceReqH) invoiceReqHDao.get(InvoiceReqH.class, ids[i]);
			/*List<InvoiceReqL>list=(List<InvoiceReqL>) entity.getInvoiceReqLs();*/
			List<InvoiceReqL>list=this.getInvoiceReqLs(entity.getId());
			invoiceReqHDao.updateTrxPoolStatusByReqHid(ids[i], CrvatTaxPoolStatuEnums.APPFORM_REVOKED.getValue());
			invoiceReqHDao.remove(entity);
			/*for (int j = 0; j < list.size(); j++) {
				String poolId=list.get(j).getCrvatTrxPoolId();
				InvoiceTrxPool pool=(InvoiceTrxPool) invoiceReqLService.get(InvoiceTrxPool.class, poolId);
				pool.setStatus(CrvatTaxPoolStatuEnums.APPFORM_REVOKED.getValue());
				invoiceTrxPoolService.update(pool);
			}*/
			invoiceReqLDao.removeAll(list);
		}
		
	}

	
	/**   
	 * @param invoiceReqH  
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#saveInvoiceReqHead(com.deloitte.tms.vat.salesinvoice.model.InvoiceReqH)  
	 */
	
	@Override
	public void saveInvoiceReqHead(InvoiceReqH invoiceReqH) {
		if(!AssertHelper.isOrNotEmpty_assert(invoiceReqH.getId())){
			invoiceReqH.setCrvatInvoiceReqNumber(IdGenerator.getPrefixTimestamp("Req", 2));
			invoiceReqH.setStatus(AppFormStatuEnums.DRAFT.getValue());
			invoiceReqH.setIsAllMapping("0");
			invoiceReqH.setMappingStatus("0");
			//invoiceReqH.setOrgId(orgId);
			this.save(invoiceReqH);
		}
		else{
			InvoiceReqH updEntity= (InvoiceReqH) this.get(InvoiceReqH.class, invoiceReqH.getId());
			this.update(updEntity);
		}
	}

	@Override
	public void saveInvoiceReqHeadAndRel(InvoiceReqH invoiceReqH) {
		// TODO Auto-generated method stub
		this.save(invoiceReqH);
		List<InvoiceReqL>list=this.getInvoiceReqLs(invoiceReqH.getId());
		for(InvoiceReqL invoiceReqL:list){
			InvoiceTrxPool pool=(InvoiceTrxPool) this.get(InvoiceTrxPool.class, invoiceReqL.getCrvatTrxPoolId());
			pool.setStatus(CrvatTaxPoolStatuEnums.APPFORM_USED.getValue());
			invoiceReqLService.save(invoiceReqL);
			invoiceTrxPoolService.update(pool);
		}
		
	}

	@Override
	public InvoiceReqH getInvoiceReqH(String id) {
		// TODO Auto-generated method stub
		InvoiceReqH invoiceReqH =(InvoiceReqH) invoiceReqLDao.get(InvoiceReqH.class, id);	
		return invoiceReqH;
	}

	@Override
	public void deleteInvoiceReLByReHId(String id) {
		// TODO Auto-generated method stub
		Map<String,Object> values = new HashMap<String, Object>();
		values.put("id", id);
		invoiceReqLDao.executeHqlProduce("delete from InvoiceReqL where crvatInvoiceReqHId = :id", values);
	}

	@Override
	public void updateInvoiceReq(InvoiceReqH invoiceReqH) {
		// TODO Auto-generated method stub
		String hid = invoiceReqH.getId();
		deleteInvoiceReLByReHId(hid);
		List<InvoiceReqL>list=(List<InvoiceReqL>) invoiceReqH.getInvoiceReqLs();
		for(InvoiceReqL invoiceReqL:list){
			InvoiceTrxPool pool=(InvoiceTrxPool) this.get(InvoiceTrxPool.class, invoiceReqL.getCrvatTrxPoolId());
			pool.setStatus(CrvatTaxPoolStatuEnums.APPFORM_USED.getValue());
			invoiceTrxPoolService.update(pool);
			invoiceReqHDao.save(invoiceReqL);
		}
	}
	public InvoiceReqL convertInvoiceTrxPoolToInvoiceReqL(InvoiceTrxPool pool,InvoiceReqL entity){
		//InvoiceReqL invoiceReqL = invoiceReqLService.findInvoiceReqLByPoolId(pool.getId());
		/*if(invoiceReqL!=null){
			return invoiceReqL;
		}
		else{*/
			InvoiceReqL invoiceReqL = new InvoiceReqL();
			//invoiceReqL.setCrvatInvoiceReqHId(entity.getId());
			invoiceReqL.setLegalEntityId(pool.getLegalEntityId());
			invoiceReqL.setLegalEntityCode(pool.getLegalEntityCode());
			invoiceReqL.setLegalEntityName(pool.getLegalEntityName());
			invoiceReqL.setCrvatTrxPoolId(pool.getId());
			invoiceReqL.setTaxTrxTypeId(pool.getTaxTrxTypeId());
			invoiceReqL.setInventoryItemId(pool.getInventoryItemId());
			invoiceReqL.setInventoryItemDescripton(pool.getInventoryItemDescripton());
			invoiceReqL.setInventoryItemModels(pool.getInventoryItmeModels());
			invoiceReqL.setInventoryItemNumber(pool.getInventoryItemNumber());
			invoiceReqL.setInventoryItemQty(pool.getInventoryItemQty());
			//invoiceReqL.setVatAmount(pool.get);
			if(!AssertHelper.isOrNotEmpty_assert(pool.getExchangeRate())){
				pool.setExchangeRate(BigDecimal.ZERO);
			}
			if(!AssertHelper.isOrNotEmpty_assert(pool.getCurrencyAmount())){
				invoiceReqL.setInvoiceAmount(BigDecimal.ZERO);
			}else{
				invoiceReqL.setInvoiceAmount(pool.getCurrencyAmount());
			}
			if(!AssertHelper.isOrNotEmpty_assert(pool.getCurrencyAmountCr())){
				invoiceReqL.setAcctdAmountCr(BigDecimal.ZERO);
			}else{
				invoiceReqL.setAcctdAmountCr(pool.getCurrencyAmountCr());
			}
			if(AssertHelper.isOrNotEmpty_assert(pool.getCurrencyAmount())&&AssertHelper.isOrNotEmpty_assert(pool.getTaxRate())){
				invoiceReqL.setVatAmount(pool.getCurrencyAmount().multiply(BigDecimal.valueOf(pool.getTaxRate())));
			}else{
				invoiceReqL.setVatAmount(BigDecimal.ZERO);
			}
			invoiceReqL.setInvoiceCategory(pool.getInvoiceCategory());
			invoiceReqL.setInvoiceType(pool.getInvoiceType());
			/*invoiceReqL.setInvoiceAmount(((BigDecimal) (null!=pool.getCurrencyAmount()?pool.getCurrencyAmount():BigDecimal.valueOf(0.00))));
			invoiceReqL.setAcctdAmountCr(null!=pool.getCurrencyAmountCr()?pool.getCurrencyAmountCr():BigDecimal.valueOf(0.00));
			invoiceReqL.setVatAmount(((BigDecimal) (null!=pool.getCurrencyAmount()?pool.getCurrencyAmount():BigDecimal.valueOf(0.00)).multiply(null!=pool.getTaxRate()?BigDecimal.valueOf(pool.getTaxRate()):BigDecimal.valueOf(0.00))));*/
			return invoiceReqL;
		//}
	}
	/*@Override
	public void updateInvoiceReqH(InvoiceReqH invoiceReqH) {
		// TODO Auto-generated method stub
		String id = invoiceReqH.getId();
		InvoiceReqH model = (InvoiceReqH) invoiceReqLDao.get(InvoiceReqH.class, id);
		//invoiceReqLDao.update(model);
		for(InvoiceReqL invoiceReqL:invoiceReqH.getInvoiceReqLs()){
			invoiceReqLDao.save(invoiceReqL);
		}
	}*/

	
	/**   
	 * @param id
	 * @return  
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#getRowsids(java.lang.String)  
	 */
	
	@Override
	public String getRowsids(String id) {
		//InvoiceReqH entity=(InvoiceReqH) this.get(InvoiceReqH.class, id);
		/*List<InvoiceReqL>list=(List<InvoiceReqL>) entity.getInvoiceReqLs();*/
		List<InvoiceReqL>list=this.getInvoiceReqLs(id);
		String ids = "";
		for (int i = 0; i < list.size(); i++) {
			ids+=list.get(i).getCrvatTrxPoolId()+";";
		}
		return ids;
	}

	
	/**   
	 * @param name  
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#updateAdminStatus(java.lang.String)  
	 */
	
	@Override
	public void updateAdminStatus(String name) {
		invoiceReqHDao.updateAdminStatus(name);
	}

	
	/**   
	 * @param map
	 * @return  
	 * @throws ParseException 
	 * @see com.deloitte.tms.vat.salesinvoice.service.InvoiceReqHService#setUpHead(java.util.Map)  
	 */
	
	@Override
	public String setUpHead(Map<String, Object> map) throws ParseException {
		String trxIds = (String) map.get("rowsids");
		String trxs[] = trxIds.split(";");
		List<InvoiceTrxPool> list = new ArrayList<InvoiceTrxPool>();
		String hid="";
		String name=map.get("name").toString();
		for(int i=0;i<trxs.length;i++){
			InvoiceTrxPool invoiceTrxPool = (InvoiceTrxPool) this.get(InvoiceTrxPool.class, trxs[i]);
			if(null!=invoiceTrxPool){
				list.add(invoiceTrxPool);
			}
		}
		if(!AssertHelper.empty(map.get("id"))){
			String id = map.get("id").toString();
			InvoiceReqH invoiceReqH = this.getInvoiceReqH(id);
			List<InvoiceReqL> invoiceReqLs = new ArrayList<InvoiceReqL>();					
			for(InvoiceTrxPool invoiceTrxPool:list){
				InvoiceReqL entity=new InvoiceReqL();
				entity=this.convertInvoiceTrxPoolToInvoiceReqL(invoiceTrxPool,entity);
				entity.setId(IdGenerator.getUUID());
				entity.setCrvatInvoiceReqHId(invoiceReqH.getId());
				entity.setStatus(map.get("status").toString());
				entity.setOrgId(map.get("orgId").toString());
				invoiceReqLs.add(entity);							
			}
			invoiceReqH.setInvoiceReqLs(invoiceReqLs);
			this.updateInvoiceReq(invoiceReqH);
			hid=invoiceReqH.getId();
		}else{
			InvoiceReqH invoiceReqH = new InvoiceReqH();
			invoiceReqH.setId(IdGenerator.getUUID());
			invoiceReqH.setCustomerId(map.get("customerId").toString());
			invoiceReqH.setCustRegistrationNumber(map.get("custRegistrationNumber").toString());
			String sequece = FlowHelper.getNextFlowNo("INVOICEREQ");
			invoiceReqH.setCrvatInvoiceReqNumber(sequece);
			invoiceReqH.setStatus(map.get("status").toString());
			invoiceReqH.setIsAllMapping("0");
			invoiceReqH.setMappingStatus("0");
			invoiceReqH.setOrgId(map.get("orgId").toString());
			invoiceReqH.setCustRegistrationCode(map.get("custRegistrationCode").toString());
			String dateString = map.get("invoiceReqDate").toString();
			Date date = DateUtils.parse(dateString);
			invoiceReqH.setInvoiceReqDate(date);
			invoiceReqH.setReqInvoiceRange(map.get("reqInvoiceRange").toString());
			invoiceReqH.setInvoiceReqType(InvoiceReqTypeEnums.COUNTER.getValue());
			List<InvoiceReqL> invoiceReqLs = new ArrayList<InvoiceReqL>();
			for(InvoiceTrxPool invoiceTrxPool:list){
				InvoiceReqL entity=new InvoiceReqL();
				entity=this.convertInvoiceTrxPoolToInvoiceReqL(invoiceTrxPool,entity);
				entity.setId(IdGenerator.getUUID());
				entity.setCrvatInvoiceReqHId(invoiceReqH.getId());
				entity.setStatus(map.get("status").toString());
				entity.setOrgId(map.get("orgId").toString());
				invoiceReqLs.add(entity);
			}
			invoiceReqH.setInvoiceReqLs(invoiceReqLs);
			this.saveInvoiceReqHeadAndRel(invoiceReqH);
			hid=invoiceReqH.getId();
		}
		this.updateAdminStatus(name);
		return hid;
	}
	private List<InvoiceReqL> getInvoiceReqLs(String reqHid){
		return invoiceReqHDao.getInvoiceReqLs(reqHid);
	}
 	
}

