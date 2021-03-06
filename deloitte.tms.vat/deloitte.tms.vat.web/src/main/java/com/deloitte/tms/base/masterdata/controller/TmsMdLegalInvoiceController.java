package com.deloitte.tms.base.masterdata.controller;
// Generated by bo.wang with ling2.autoproject

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deloitte.tms.vat.controller.BaseController;
import com.deloitte.tms.vat.core.common.JsonDateValueProcessor;
import com.deloitte.tms.base.masterdata.model.TmsMdLegalEntity;
import com.deloitte.tms.base.masterdata.model.TmsMdLegalInvoice;
import com.deloitte.tms.base.masterdata.model.TmsMdLegalInvoiceInParam;
import com.deloitte.tms.base.masterdata.service.TmsMdLegalInvoiceService;
import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.commons.utils.PageUtils;
import com.deloitte.tms.pl.core.commons.utils.reflect.ReflectUtils;
import com.deloitte.tms.pl.dictionary.model.DictionaryEntity;
import com.deloitte.tms.pl.dictionary.service.DictionaryService;
/**
 * Home object for domain model class TmsMdLegalInvoice.
 * @see com.deloitte.tms.base.masterdata.model
 * @author Hibernate Tools
 */
@Controller
public class TmsMdLegalInvoiceController extends BaseController{
	@Resource
	TmsMdLegalInvoiceService tmsMdLegalInvoiceService;
	@Autowired
	DictionaryService dictionaryService;
	@RequestMapping(value="taxpayerinvoicetype/getindex.do")
	public String getIndex() throws Exception{
		return "vat/invoicetaxpayer/invoicetaxpayer";
	}
	//@ResponseBody
	@RequestMapping(value = "taxpayerinvoicetype/loadTmsMdLegalInvoicePage", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public void loadTmsMdLegalInvoicePage(@RequestParam Map<String,Object> parameter,HttpServletResponse response) throws Exception {
		DaoPage daoPage=tmsMdLegalInvoiceService.findTmsMdLegalInvoiceByParams(parameter,PageUtils.getPageNumber(parameter),PageUtils.getPageSize(parameter));
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd")); 
		JSONArray jsonArray1 = JSONArray.fromObject(daoPage.getResult(),jsonConfig);
		JSONObject result=new JSONObject();
		result.put("total", daoPage.getRecordCount());
		result.put("rows", jsonArray1.toString());
		retJson(response,result);
		//return daoPage;
	}
	@ResponseBody
	@RequestMapping(value = "taxpayerinvoicetype/saveTmsMdLegalInvoice")
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public void saveTmsMdLegalInvoice(TmsMdLegalInvoiceInParam inParam,HttpServletResponse response) throws Exception {
		JSONObject object = new JSONObject();
		try {
			TmsMdLegalInvoice entity=tmsMdLegalInvoiceService.convertTmsMdLegalInvoiceInParamToEntity(inParam);
			if(!AssertHelper.isOrNotEmpty_assert(entity.getId())){
				tmsMdLegalInvoiceService.save(entity);
			}
			else{
				TmsMdLegalInvoice invoiceType=(TmsMdLegalInvoice) tmsMdLegalInvoiceService.get(TmsMdLegalInvoice.class, inParam.getId());
				invoiceType.setInvoiceCategory(inParam.getInvoiceCategory());
				invoiceType.setInvoiceLimitAmountValue(inParam.getInvoiceLimitAmountValue());
				if(AssertHelper.isOrNotEmpty_assert(inParam.getLegalEntityCode())){
					Map<String, Object>params=new HashMap<String, Object>();
					params.put("legalEntityCode", inParam.getLegalEntityCode());
					TmsMdLegalEntity legalEntity=tmsMdLegalInvoiceService.findLegalEntity(params);
					invoiceType.setLegalEntityId(legalEntity.getId());
				}
				invoiceType.setEnabledFlag(inParam.getEnabledFlag());
				invoiceType.setStartDate(inParam.getStartDate());
				invoiceType.setEndDate(inParam.getEndDate());
				tmsMdLegalInvoiceService.update(invoiceType);
			}
			object.put("msg", "保存成功");
			inParam.setId(entity.getId());
		} catch (Exception e) {
			object.put("msg", "保存失败");
		}
		
		
		retJson(response, object);
	}	
	@ResponseBody				
	@RequestMapping(value = "taxpayerinvoicetype/removeTmsMdLegalInvoices", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public void removeTmsMdLegalInvoices(@RequestParam("ids") String ids,HttpServletResponse response) throws IOException {
		AssertHelper.notEmpty_assert(ids,"需要删除的用户不能为空");
		String[] tmsMdLegalInvoiceIds=ids.split(",");
		tmsMdLegalInvoiceService.removeTmsLegalInvoices(tmsMdLegalInvoiceIds);
		JSONObject object=new JSONObject();
		String successMsg="删除成功";
		object.put("result", "true");
		object.put("msg", successMsg);
		retJson(response, object);
		//for(String tmsMdLegalInvoiceId:tmsMdLegalInvoiceIds){
			
		//}
	}
	@ResponseBody
	@RequestMapping(value = "/loadTmsMdLegalInvoice", method = RequestMethod.GET)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public Collection<TmsMdLegalInvoiceInParam> loadTmsMdLegalInvoice(Map<String, Object> map) throws Exception {
		List result=tmsMdLegalInvoiceService.findTmsMdLegalInvoiceByParams(map);
		return result;
	}
	
	public TmsMdLegalInvoiceInParam loadAddTmsMdLegalInvoice(Map<String, Object> map) throws Exception {
		TmsMdLegalInvoiceInParam inParam=new TmsMdLegalInvoiceInParam();
		return inParam;
	}
	
	public TmsMdLegalInvoiceInParam loadModifyTmsMdLegalInvoice(Map<String, Object> map) throws Exception {
		Object id=map.get("id");
		AssertHelper.notEmpty_assert(id,"编辑的主键不能为空");
		TmsMdLegalInvoice entity=(TmsMdLegalInvoice)tmsMdLegalInvoiceService.get(TmsMdLegalInvoice.class,Long.parseLong(id.toString()));
		TmsMdLegalInvoiceInParam inParam=tmsMdLegalInvoiceService.convertTmsMdLegalInvoiceToInParam(entity);
		return inParam;
	}
	
	
	
	public void updateModifyTmsMdLegalInvoice(TmsMdLegalInvoiceInParam inParam) throws Exception {
		TmsMdLegalInvoice entity=(TmsMdLegalInvoice)tmsMdLegalInvoiceService.get(TmsMdLegalInvoice.class,inParam.getId());
		ReflectUtils.copyProperties(inParam, entity);
		tmsMdLegalInvoiceService.update(entity);
	}
	
	@RequestMapping(value = "taxpayerinvoicetype/getLegalInfoList")
	public void getLegalInfoList(@RequestParam Map<String, Object>map,HttpServletResponse response) throws Exception {
		//System.out.println(legalEntityCode);
		TmsMdLegalEntity entity=tmsMdLegalInvoiceService.findLegalEntity(map);
		JSONObject object=new JSONObject();
		object.put("legalEntityName", entity.getLegalEntityName());
		object.put("legalEntityId", entity.getId());
		retJson(response, object);
	}
	@RequestMapping(value = "taxpayerinvoicetype/getdictionary", method = RequestMethod.GET)    
    public void getDictionaryEntitiesByParentCode(HttpServletResponse response) throws IOException{
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
}

