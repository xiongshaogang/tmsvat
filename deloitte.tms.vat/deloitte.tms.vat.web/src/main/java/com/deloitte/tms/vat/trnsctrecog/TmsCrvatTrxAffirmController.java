package com.deloitte.tms.vat.trnsctrecog;
// Generated by bo.wang with ling2.autoproject



import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;






import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.PageUtils;
import com.deloitte.tms.vat.controller.BaseController;
import com.deloitte.tms.vat.core.common.JsonDateValueProcessor;
import com.deloitte.tms.vat.trnsctrecog.service.TmsCrvatTrxAffirmService;
/**
 * Home object for domain model class TmsCrvatTrxAffirm.
 * @see com.deloitte.tms.vat.trnsctrecog.model
 * @author Hibernate Tools
 */
@Controller
@RequestMapping("tmsCrvatTrxAffirm")
public class TmsCrvatTrxAffirmController extends BaseController{
	@Resource
	TmsCrvatTrxAffirmService tmsCrvatTrxAffirmService;
	
	@RequestMapping(value = "/tmsCrvatTrxAffirmInit", method = RequestMethod.GET)
	public String tmsCrvatTrxAffirmInit() throws Exception {
		return "vat/trnsctrecog/tmsCrvatTrxAffirmSucess";
	}
	/**
	 * 跳转信息异常页面
	 * @return
	 */
	@RequestMapping(value = "/transactionexception")
	public String transactionexcEptions() throws Exception{
		return "vat/trnsctrecog/transactionexcEptions";
	} 
	/**
	 * 查询所有异常信息
	 * @param parameter
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/loadTransactionExceptionPage")
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public DaoPage loadTransactionExceptionPage(@RequestParam Map<String,Object> parameter,HttpServletResponse response) throws Exception {
		if(parameter.get("pageNumber")==null||"".equals(parameter.get("pageNumber"))){
			parameter.put("pageNumber", "1");
			parameter.put("pageSize", "10");
		}
		DaoPage daoPage=tmsCrvatTrxAffirmService.findTmsCrvatTrxAffirmByParams(parameter,PageUtils.getPageNumber(parameter),PageUtils.getPageSize(parameter));
	
		JSONObject result = new JSONObject();
		
		 JsonConfig jsonConfig = new JsonConfig();
		 jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd")); 
		 JSONArray jsonArray = JSONArray.fromObject(daoPage.getResult(),jsonConfig);
		
		result.put("total", daoPage.getRecordCount());
		result.put("rows", jsonArray);
		result.put("pages", daoPage.getPageCount());
		result.put("success", true);
		retJson(response, result);
		return null;
	}
	
	/**
	 * 组织下拉列表数据查询
	 * @param parameter
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/organization_id")
	public DaoPage organization_id(@RequestParam Map<String,Object> parameter,HttpServletResponse response) throws Exception {
		String pageNumber = (String) parameter.get("pageNumber");
		DaoPage  daoPage = null;
		if(pageNumber!=null){
			daoPage = tmsCrvatTrxAffirmService.findTmsCrvatTrxAffirmByOrganization_id(parameter,PageUtils.getPageNumber(parameter),PageUtils.getPageSize(parameter));
		}else{
			daoPage = tmsCrvatTrxAffirmService.findTmsCrvatTrxAffirmByOrganization_id(parameter,Integer.parseInt(parameter.get("page").toString()),Integer.parseInt(parameter.get("rows").toString()));
		}
		
		JSONObject result = new JSONObject();
		
		 JsonConfig jsonConfig = new JsonConfig();
		 jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		 JSONArray jsonArray = JSONArray.fromObject(daoPage.getResult(),jsonConfig);
		
		result.put("total", daoPage.getRecordCount());
		result.put("rows", jsonArray);//daoPage.getr
		result.put("pages", daoPage.getPageCount());
		result.put("success", true);
		retJson(response, result);
		return null;
	}
	
	
	/**
	 * 涉税交易类型下拉列表数据查询
	 * @param parameter
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/transactiontype_id")
	public DaoPage transactiontype_id(@RequestParam Map<String,Object> parameter,HttpServletResponse response) throws Exception {
		String pageNumber = (String) parameter.get("pageNumber");
		DaoPage  daoPage = null;
		if(pageNumber!=null){
			daoPage = tmsCrvatTrxAffirmService.transactiontype_id(parameter,PageUtils.getPageNumber(parameter),PageUtils.getPageSize(parameter));
		}else{
			daoPage = tmsCrvatTrxAffirmService.transactiontype_id(parameter,Integer.parseInt(parameter.get("page").toString()),Integer.parseInt(parameter.get("rows").toString()));
		}
		JSONObject result = new JSONObject();
		
		 JsonConfig jsonConfig = new JsonConfig();
		 jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		 JSONArray jsonArray = JSONArray.fromObject(daoPage.getResult(),jsonConfig);
		
		result.put("total", daoPage.getRecordCount());
		result.put("rows", jsonArray);//daoPage.getr
		result.put("pages", daoPage.getPageCount());
		result.put("success", true);
		retJson(response, result);
		return null;
	}
	
	
	
	/**
	 * 查询认定成功信息
	 * @param response
	 * @param parameter
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/loadTmsCrvatTrxAffirmSucessPage")
	public void loadTmsCrvatTrxAffirmSucessPage(HttpServletResponse response,
			@RequestParam Map<String, Object> parameter) throws Exception {
		if(parameter.get("pageNumber")==null||"".equals(parameter.get("pageNumber"))){
			parameter.put("pageNumber", "1");
			parameter.put("pageSize", "10");
		}
		DaoPage daoPage=tmsCrvatTrxAffirmService.findTmsCrvatTrxAffirmByParams(parameter,PageUtils.getPageNumber(parameter),PageUtils.getPageSize(parameter));
		
		JSONObject result = new JSONObject();
		 JsonConfig jsonConfig = new JsonConfig();
		 jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd")); 
		 JSONArray jsonArray = JSONArray.fromObject(daoPage.getResult(),jsonConfig);
		result.put("total", daoPage.getRecordCount());
		result.put("rows", jsonArray);// daoPage.getr
		result.put("pages", daoPage.getPageCount());
		result.put("success", true);
		retJson(response, result);
	}
	
	/**
	 * 手工认定
	 * @param parameter
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/loadTransactionException")
	public DaoPage loadTransactionException(@RequestParam Map<String,Object> parameter,HttpServletResponse response) throws Exception {
		tmsCrvatTrxAffirmService.loadTransactionException(parameter);
		JSONObject result = new JSONObject();
		result.put("success", "success");
		retJson(response, result);
		return null;
	}
}

