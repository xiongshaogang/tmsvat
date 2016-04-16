package com.deloitte.tms.vat.salesinvoice.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

import com.deloitte.tms.base.masterdata.model.Customer;
import com.deloitte.tms.base.taxsetting.model.TmsMdContract;
import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.commons.utils.PageUtils;
import com.deloitte.tms.pl.core.context.utils.ContextUtils;
import com.deloitte.tms.pl.dictionary.model.DictionaryEntity;
import com.deloitte.tms.pl.dictionary.service.DictionaryService;
import com.deloitte.tms.pl.flow.utils.FlowHelper;
import com.deloitte.tms.vat.base.enums.AppFormStatuEnums;
import com.deloitte.tms.vat.controller.BaseController;
import com.deloitte.tms.vat.core.common.JsonDateValueProcessor;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceReqHInParam;
import com.deloitte.tms.vat.salesinvoice.service.InvoiceSpecialService;

/**
 * 特殊开票申请单，无合同
 * @author jasonjyang
 *
 */
@Controller
@RequestMapping(value="invoiceSpecial")
public class InvoiceSpecialController extends BaseController{
	@Resource
	InvoiceSpecialService invoiceSpecialServiceImpl;
	@Autowired
	DictionaryService dictionaryService;
	
	/**跳转手工发票页面
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(){
		System.out.println("invoiceSpecial");
		return "invoiceprint/specialInvoice";
	}
	
	/**
	 * 特殊申请单数据查询
	 * @param map
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/getInvoiceReqAll", method = RequestMethod.POST)
	public void getInvoiceReqAll(@RequestParam Map<String, Object>map,HttpServletResponse response) throws Exception{
		DaoPage page=invoiceSpecialServiceImpl.findInvoiceReqAll(map, PageUtils.getPageNumber(map),PageUtils.getPageSize(map));
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd")); 
		JSONArray jsonArray1 = JSONArray.fromObject(page.getResult(),jsonConfig);
		result.put("total", page.getRecordCount());
		result.put("rows", jsonArray1.toString());
		retJson(response,result);
	}
    /**
     * 申请单状态查询
     * @param response
     * @throws IOException
     */
	@RequestMapping(value = "/getdictionary", method = RequestMethod.GET)    
    public void getDictionaryEntitiesByParentCode(HttpServletResponse response) throws IOException{
          Collection<DictionaryEntity> results = dictionaryService.loadDictionaryEntities("VAT_CR_INVOICE_APPFORM_STATUS");
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
	/**
	 * 受理层级查询
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/getLeveldictionary", method = RequestMethod.GET)    
    public void getLeveldictionary(HttpServletResponse response) throws IOException{
          Collection<DictionaryEntity> results = dictionaryService.loadDictionaryEntities("VAT_CR_INVOICE_PRINT_SCOPE");
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
    /**
     * 购方证件类型数据查询
     * @param response
     * @throws IOException
     */
	@RequestMapping(value = "/getTypedictionary", method = RequestMethod.GET)    
    public void getTypedictionary(HttpServletResponse response) throws IOException{
          Collection<DictionaryEntity> results = dictionaryService.loadDictionaryEntities("VAT_CUSTOMER_DISC_OPTION");
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

	/**
	 * 根据填写购方编码，购方证件号码查询
	 * 
	 * @param map
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "getCustomerParam")
	public void getCustomerParam(@RequestParam Map<String, Object> map,
			HttpServletResponse response) throws IOException {
		Customer customer = invoiceSpecialServiceImpl
				.getCustomerParam(map);
		JSONObject object = new JSONObject();
		object.put("customer", customer);
		retJson(response, object);
	}
	
    /**
     * 商品及服务分类信息查询
     * @param map
     * @param response
     * @throws Exception
     */
	@RequestMapping(value = "/getTmsMdInventoryCategories", method = RequestMethod.POST)
	public void getTmsMdInventoryCategories(@RequestParam Map<String, Object>map,HttpServletResponse response) throws Exception{
		DaoPage page=invoiceSpecialServiceImpl.findTmsMdInventoryItemsByParams(map,Integer.parseInt((String) map.get("page")),
				Integer.parseInt((String) map.get("rows")));
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd")); 
		JSONArray jsonArray1 = JSONArray.fromObject(page.getResult(),jsonConfig);
		result.put("total", page.getRecordCount());
		result.put("rows", jsonArray1.toString());
		retJson(response,result);
	}
	
	/**
	 * 开票申请单号生成
	 */
	@RequestMapping(value="/getCreanumber")
	public void creanumber(HttpServletResponse response){
		String invoicereq = FlowHelper.getNextFlowNo("INVOICEREQ");//开票申请单号生成
		JSONObject result=new JSONObject();
		result.put("invoicereq", invoicereq);
		try {
			retJson(response,result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存申请单
	 */
	@RequestMapping(value="/saveInvoiceReqHead", method = RequestMethod.POST)
	public void saveInvoiceReqHead(@RequestParam Map<String, Object>map, HttpServletResponse response)throws IOException{
		JSONObject result = new JSONObject();
		try{
			map.put("status",AppFormStatuEnums.DRAFT.getValue());
			map.put("orgId", ContextUtils.getCurrentOrgId());
			map.put("name", ContextUtils.getCurrentUserName());
			invoiceSpecialServiceImpl.setUpHead(map);
			result.put("msg", "保存成功");
			result.put("success", "true");
		} catch (Exception e) {
			result.put("msg", "保存失败");
			result.put("success", "false");
			e.printStackTrace();
		}
		
		
		for(Map.Entry<String, Object> entry:map.entrySet()){ 
		     System.out.println(entry.getKey()+"--->"+entry.getValue());    
		}
		JSONArray jsonArray = JSONArray.fromObject(map.get("dgrequestdetaildata"));
		for(int i=0;i<jsonArray.size(); i++){
			JSONObject jsonJ = jsonArray.getJSONObject(i);
			System.out.println("jsonJ="+jsonJ);
			if(null!=jsonJ){
				System.out.println(jsonJ.getString("id"));//商品及服务id
				System.out.println(jsonJ.getString("inventoryItemDescripton"));//商品及服务名称
				System.out.println(jsonJ.getString("inventoryItemModels"));//规格型号
				System.out.println(jsonJ.getString("uomCode"));//单位
				System.out.println(jsonJ.getString("taxTrxTypeCode"));//数量
				System.out.println(jsonJ.getString("legalEntityName"));//单价
				System.out.println(jsonJ.getString("legalEntityCode"));//合计金额
				System.out.println(jsonJ.getString("taxRate"));//税率
				System.out.println(jsonJ.getString("trxDate"));//净额
				System.out.println(jsonJ.getString("inventory"));//税额
			}
		}
		
		InvoiceReqHInParam invoicereqhinparam = new InvoiceReqHInParam();//销项税开票申请单-头表数据
		//TODO

		retJson(response,result);
	}
	
	@ResponseBody
	@RequestMapping(value = "removeInvoiceReqPs", method = RequestMethod.POST)
	public void removeInvoiceReqPs(@RequestParam String ids,HttpServletResponse response) throws IOException {
		AssertHelper.notEmpty_assert(ids,"需要删除的发票不能为空");
		String[] invoiceReqHIds=ids.split(",");
		JSONObject object=new JSONObject();
		try {
			invoiceSpecialServiceImpl.deleteFromReqAll(invoiceReqHIds);
			object.put("msg", "删除成功");
			object.put("success", "true");
		} catch (Exception e) {
			object.put("msg", "删除失败");
			object.put("success", "false");
		}
		retJson(response, object);
	}
}
