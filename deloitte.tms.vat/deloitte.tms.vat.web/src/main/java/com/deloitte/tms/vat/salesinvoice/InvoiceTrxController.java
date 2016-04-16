package com.deloitte.tms.vat.salesinvoice;
// Generated by bo.wang with ling2.autoproject

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deloitte.tms.base.cache.model.LegalEntityNode;
import com.deloitte.tms.base.cache.utils.LegalEntityCacheUtils;
import com.deloitte.tms.base.masterdata.model.TmsMdLegalEntity;
import com.deloitte.tms.pl.cache.utils.DictionaryCacheUtils;
import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.commons.utils.PageUtils;
import com.deloitte.tms.pl.core.commons.utils.reflect.ReflectUtils;
import com.deloitte.tms.pl.core.context.utils.ContextUtils;
import com.deloitte.tms.pl.dictionary.model.DictionaryEntity;
import com.deloitte.tms.pl.dictionary.service.DictionaryService;
import com.deloitte.tms.pl.security.model.SecurityDept;
import com.deloitte.tms.pl.security.service.IDeptService;
import com.deloitte.tms.vat.controller.BaseController;
import com.deloitte.tms.vat.core.common.IdGenerator;
import com.deloitte.tms.vat.core.common.JsonDateValueProcessor;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxD;
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
@Controller
@RequestMapping("invoiceTrx")
public class InvoiceTrxController extends BaseController{
	@Resource
	InvoiceTrxService invoiceTrxService;
	
	@Resource
	DictionaryService dictionaryService;

	@Resource
	IDeptService deptService;
	
	@RequestMapping(value = "/loadPage")
	public String getIndex() throws Exception{
		return "vat/salesinvoice/invoicetrx";
	}
	
	public String generateInvoiceTrxNumber() throws Exception {
		List<InvoiceTrxH> list = invoiceTrxService.getLatestInvoiceTrxH();
		
		String invoiceTrxNumber = "";
		for(InvoiceTrxH invoiceTrxH:list){
			invoiceTrxNumber = invoiceTrxH.getCrvatInvoiceTrxNumber();
			if (!AssertHelper.empty(invoiceTrxNumber)) {
				break;
			}
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
		Date dd=new Date();
		String finalNumber = sdf.format(dd);
		if (AssertHelper.empty(invoiceTrxNumber)) {
			finalNumber = "REC" + finalNumber + String.format("%04d", 1);
		}else{
			invoiceTrxNumber = invoiceTrxNumber.substring(11);
			int no = Integer.parseInt(invoiceTrxNumber);
			no++;
			finalNumber = "REC" + finalNumber + String.format("%04d", no);
		}
		return finalNumber;
	}
	
	@RequestMapping(value = "/loadDataDict.do", method = RequestMethod.POST)    
    public void loadDataDict(HttpServletResponse response) throws IOException{
          Collection<DictionaryEntity> results = dictionaryService.loadDictionaryEntities("VAT_CR_INVOICE_TYPE");
          List<Map<String, String>> reList = new ArrayList<Map<String,String>>();
          for(DictionaryEntity dictionaryEntity:results){
               Map<String,String> map = new HashMap<String,String>();                             
               map.put("value", dictionaryEntity.getCode());
               map.put("text", dictionaryEntity.getName());
               reList.add(map);
          }            
          JSONArray jsonArray = JSONArray.fromObject(reList);
          retJsonArray(response, jsonArray);
    }
	
	@RequestMapping(value = "/loadInvoiceTrxPage", method = RequestMethod.POST)
	public void loadInvoiceTrxPage(@RequestParam Map<String,Object> parameter,HttpServletResponse response) throws Exception {
		DaoPage daoPage=invoiceTrxService.findInvoiceTrxByParams(parameter,PageUtils.getPageNumber(parameter),PageUtils.getPageSize(parameter));
	
		List<InvoiceTrxHInParam> list = (List<InvoiceTrxHInParam>) daoPage.getResult();
	
		Map<String,String> map = DictionaryCacheUtils.getCodesByCvalueMap("VAT_CR_INVOICE_REQUEST_STATUS");
		SecurityDept dep = deptService.loadUserDefaultDept(ContextUtils.getCurrentUserCode());
		List<InvoiceTrxHInParam> finalList = new ArrayList<InvoiceTrxHInParam>();
		
		for (Iterator<InvoiceTrxHInParam> i = list.iterator(); i.hasNext(); ) {
			InvoiceTrxHInParam entity = i.next();
			entity.setApprovalStatus(map.get(entity.getApprovalStatus()));
			if(!AssertHelper.empty(dep)){
				entity.setOrgName(dep.getOrgName());
			}
			finalList.add(entity);
		}
		daoPage.setResult(finalList);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(daoPage.getResult(), jsonConfig);
		JSONObject result = new JSONObject();
		result.put("total", daoPage.getRecordCount());
		result.put("rows", jsonArray.toString());
		retJson(response, result);
	}
	
	@RequestMapping(value = "/loadInvoiceTrxLPage", method = RequestMethod.POST)
	public void loadInvoiceTrxLPage(@RequestParam Map<String,Object> parameter,HttpServletResponse response) throws Exception {
		DaoPage daoPage=invoiceTrxService.findInvoiceTrxLByParams(parameter,PageUtils.getPageNumber(parameter),PageUtils.getPageSize(parameter));
		
		List<InvoiceTrxLInParam> list = (List<InvoiceTrxLInParam>) daoPage.getResult();
		
		Map<String,String> map = DictionaryCacheUtils.getCodesByCvalueMap("VAT_CR_INVOICE_TYPE");
		
		List<InvoiceTrxLInParam> finalList = new ArrayList<InvoiceTrxLInParam>();
		
		for (Iterator<InvoiceTrxLInParam> i = list.iterator(); i.hasNext(); ) {
			InvoiceTrxLInParam entity = i.next();
			entity.setInvoiceCategory(map.get(entity.getInvoiceCategory()));
			LegalEntityNode legalEntityNode = LegalEntityCacheUtils.getLegalNodeByLegalId(entity.getLegalEntityId());			
			if(!AssertHelper.empty(legalEntityNode)){
				entity.setLegalEntityId(legalEntityNode.getName());
			}
			finalList.add(entity);
		}
		daoPage.setResult(finalList);		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(daoPage.getResult(), jsonConfig);
		JSONObject result = new JSONObject();
		result.put("total", daoPage.getRecordCount());
		result.put("rows", jsonArray.toString());
		retJson(response, result);
	}
	
	@RequestMapping(value = "/saveInvoiceTrxH", method = RequestMethod.POST)
	public void saveInvoiceTrxH(@ModelAttribute("trxForm") InvoiceTrxHInParam inParam,
			HttpServletResponse response) throws Exception {				
		Date date = invoiceTrxService.getDatabaseServerDate();
		if (AssertHelper.empty(inParam.getId())) {
			InvoiceTrxH invoiceTrxH = new InvoiceTrxH();
			
			invoiceTrxH=invoiceTrxService.convertInvoiceTrxInParamToEntity(inParam);
			invoiceTrxH.setId(IdGenerator.getUUID());
			invoiceTrxH.setApprovalStatus("draft");			
			invoiceTrxH.setInvoiceTrxDate(date);
			invoiceTrxH.setCrvatInvoiceTrxNumber(generateInvoiceTrxNumber());
			
			List<InvoiceTrxL> invoiceTrxLs = new ArrayList<InvoiceTrxL>();
			String details = inParam.getDetails();
			JSONArray data = JSONArray.fromObject(details);
			
			for(int i=0;i<data.size();i++){
				JSONObject obj = JSONObject.fromObject(data.get(i));
				InvoiceTrxLInParam inParaml = (InvoiceTrxLInParam)JSONObject.toBean(obj,InvoiceTrxLInParam.class);
				inParaml.setIsUsage("0");
				InvoiceTrxL invoiceTrxl = invoiceTrxService.convertInvoiceTrxLInParamToEntity(inParaml);
				invoiceTrxl.setCrvatInvoiceTrxHid(invoiceTrxH.getId());
				invoiceTrxl.setId(IdGenerator.getUUID());
				invoiceTrxLs.add(invoiceTrxl);							
			}
			invoiceTrxH.setList(invoiceTrxLs);
			invoiceTrxService.saveInvoiceTrxH(invoiceTrxH);
		
		}			
	}	

	@RequestMapping(value = "/getTrxById")
	public void getTrxById(@RequestParam("id") String id,
			HttpServletResponse response) throws IOException {
		InvoiceTrxH trx = (InvoiceTrxH) invoiceTrxService.get(
				InvoiceTrxH.class, id);
		
		Map<String,String> map = DictionaryCacheUtils.getCodesByCvalueMap("VAT_CR_INVOICE_REQUEST_STATUS");
		trx.setApprovalStatus(map.get(trx.getApprovalStatus()));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject = JSONObject.fromObject(trx, jsonConfig);
		retJson(response, jsonObject);
	}
	
	@RequestMapping(value = "/getTrxLById")
	public void getTrxLById(@RequestParam("id") String id,
			HttpServletResponse response) throws IOException {
		InvoiceTrxL trx = (InvoiceTrxL) invoiceTrxService.get(
				InvoiceTrxL.class, id);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject = JSONObject.fromObject(trx, jsonConfig);
		retJson(response, jsonObject);
	}
	
	@RequestMapping(value = "/deleteTrx")
	public void deleteTrx(@RequestParam("id") String id,
			HttpServletResponse response) throws IOException {
		JSONObject result = new JSONObject();
		invoiceTrxService.deleteTrHById(id);
		
		String successMsg = "删除成功！";
		result.put("success", "true");
		result.put("msg", successMsg);

		retJson(response, result);
	}
	
	@ResponseBody
	@RequestMapping(value = "/loadInvoiceTrx", method = RequestMethod.GET)
	public Collection<InvoiceTrxHInParam> loadInvoiceTrx(Map<String, Object> map) throws Exception {
		List result=invoiceTrxService.findInvoiceTrxByParams(map);
		return result;
	}
	
	@RequestMapping(value = "/approveById")
	public void approveById(@RequestParam("id") String id,
			HttpServletResponse response) throws IOException {	
		invoiceTrxService.auditInvoiceTrhById(id);

		JSONObject result = new JSONObject();
		String successMsg = "审批成功！";
		result.put("success", "true");
		result.put("msg", successMsg);
		retJson(response, result);
	}
}
