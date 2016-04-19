package com.deloitte.tms.vat.invoice.send;
// Generated by bo.wang with ling2.autoproject

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import javassist.expr.NewArray;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.commons.utils.reflect.ReflectUtils;
import com.deloitte.tms.pl.core.commons.utils.PageUtils;
import com.deloitte.tms.pl.core.dao.IDao;
import com.deloitte.tms.pl.core.dao.impl.BaseDaoSimple;
import com.deloitte.tms.vat.controller.BaseController;
import com.deloitte.tms.vat.core.common.IdGenerator;
import com.deloitte.tms.vat.core.common.JsonDateValueProcessor;
import com.deloitte.tms.vat.salesinvoice.model.InvoicePrintPoolH;
import com.deloitte.tms.vat.salesinvoice.model.InvoicePrintPoolHInParam;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceSendH;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceSendHInParam;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceSendL;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceSendLInParam;
import com.deloitte.tms.vat.salesinvoice.service.InvoicePrintPoolHService;
import com.deloitte.tms.vat.salesinvoice.service.InvoiceSendHService;
import com.deloitte.tms.vat.salesinvoice.service.InvoiceSendLService;
/**
 * Home object for domain model class InvoiceSendL.
 * @see com.deloitte.tms.vat.salesinvoice.model
 * @author Hibernate Tools
 */
@Controller
@RequestMapping("invoiceSendL")
public class InvoiceSendLController extends BaseController{
	@Resource
	InvoiceSendLService invoiceSendLService;
	@Resource
	InvoicePrintPoolHService invoicePrintPoolHService;
	@Resource(name = BaseDaoSimple.BEAN_ID)
	IDao dao;

	@ResponseBody
	@RequestMapping(value = "/loadInvoiceSendLPage", method = RequestMethod.POST)
	public void loadInvoiceSendLPage(HttpServletResponse response,@RequestParam Map<String,Object> parameter) throws Exception {
		//获取发票池数据
		List<InvoicePrintPoolHInParam> invoicePrintPoolHList=  invoicePrintPoolHService.findInvoicePrintPoolHByParams(parameter);
		//List<InvoiceSendLInParam> currentTable=invoiceSendLService.findInvoiceSendLByParams(parameter);//拿出当前表数据
		List<InvoiceSendL> currentTable=invoiceSendLService.findInvoiceSendLByParams(parameter);//拿出当前表数据
		
		List<String> ids =new ArrayList<String>();//当前表数据ID列表
		List<InvoicePrintPoolHInParam>  frontList =new ArrayList<InvoicePrintPoolHInParam>();
		//Iterator<InvoiceSendLInParam> idIterator=currentTable.iterator();
		Iterator<InvoiceSendL> idIterator=currentTable.iterator();
		while(idIterator.hasNext())
		{
			ids.add(idIterator.next().getInvoicePrtPoolHId());//打印池ID集合
		}
		for(Object send:invoicePrintPoolHList)
		{
			if(!ids.contains(((InvoicePrintPoolHInParam)send).getId()))//过滤已经有的数据
			{
			frontList.add((InvoicePrintPoolHInParam) send);
			}
		}
		JsonConfig jsonConfig = new JsonConfig();  
		 jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		 JSONArray jsonArray = JSONArray.fromObject(frontList,jsonConfig);
		JSONObject result = new JSONObject();
		result.put("total", frontList.size());
		result.put("rows", jsonArray);//不要用InvoicePrintPoolH以免jason死循环
		result.put("success", true);
		result.put("result", true);
		retJson(response, result);		
	}
	
	@ResponseBody
	@RequestMapping(value = "/loadInvoiceSendLPageBySelected", method = RequestMethod.POST)
	public void loadInvoiceSendLPageBySelected(HttpServletResponse response,@RequestParam Map<String,Object> parameter) throws Exception {
		//获取发票池数据
		List<InvoicePrintPoolHInParam> invoicePrintPoolHList=  invoicePrintPoolHService.findInvoicePrintPoolHByParams(parameter);
		//List<InvoiceSendLInParam> currentTable=invoiceSendLService.findInvoiceSendLByParams(parameter);//拿出当前表数据
		List<InvoiceSendL> currentTable=invoiceSendLService.findInvoiceSendLByParams(parameter);//拿出当前表数据
		
		List<String> ids =new ArrayList<String>();//当前表数据ID列表
		List<InvoicePrintPoolHInParam>  frontList =new ArrayList<InvoicePrintPoolHInParam>();
		//Iterator<InvoiceSendLInParam> idIterator=currentTable.iterator();
		Iterator<InvoiceSendL> idIterator=currentTable.iterator();
		while(idIterator.hasNext())
		{
			ids.add(idIterator.next().getInvoicePrtPoolHId());//打印池ID集合
		}
		for(Object send:invoicePrintPoolHList)
		{
			if(!ids.contains(((InvoicePrintPoolHInParam)send).getId()));//过滤已经有的数据
			frontList.add((InvoicePrintPoolHInParam) send);
		}
		JsonConfig jsonConfig = new JsonConfig();  
		 jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		 JSONArray jsonArray = JSONArray.fromObject(frontList,jsonConfig);
		JSONObject result = new JSONObject();
		result.put("total", frontList.size());
		result.put("rows", jsonArray);//不要用InvoicePrintPoolH以免jason死循环
		result.put("success", true);
		result.put("result", true);
		retJson(response, result);		
	}
	//导入发票并返回快递单方法
	@ResponseBody
	@RequestMapping(value = "/loadVoicesToTable", method = RequestMethod.POST)
	public void loadVoicesToTable(@RequestParam("id") String clientKeys,HttpServletResponse response) throws IOException
	{
		AssertHelper.notEmpty_assert(clientKeys,"需要保存的数据ID不能为空");
		List<InvoicePrintPoolHInParam> inParams =new ArrayList<InvoicePrintPoolHInParam>();
		InvoicePrintPoolHInParam convertHInParam = new InvoicePrintPoolHInParam();
		InvoicePrintPoolH invoicePrintPoolH = new InvoicePrintPoolH();
		List<InvoiceSendL> invoiceSendLTempList = new ArrayList<InvoiceSendL>();
		InvoiceSendL tempInvoiceSendL = new InvoiceSendL();//寄送单列信息, 跟发票一对一关联
		String sendId = clientKeys.split(",")[clientKeys.split(",").length-1];//把 寄送单头ID提取出来
		String[] clientIdStrings = clientKeys.split(",");
		for(int i=0;i<clientKeys.split(",").length-1;i++)
		{
			invoicePrintPoolH=(InvoicePrintPoolH) invoicePrintPoolHService.findById(InvoicePrintPoolH.class, clientIdStrings[i]);
			ReflectUtils.copyProperties(invoicePrintPoolH, tempInvoiceSendL);
			tempInvoiceSendL.setId(IdGenerator.getUUID());
			tempInvoiceSendL.setInvoicePrtPoolHId(clientIdStrings[i]);//把发票打印池ID添加到寄送单 列信息
			tempInvoiceSendL.setInvoiceDeliveryHId(sendId);//关联头表
			invoiceSendLService.save(tempInvoiceSendL);
			//invoiceSendLTempList.add(tempInvoiceSendL);
		}
		//invoiceSendLService.saveAll(invoiceSendLTempList);//批量保存
		 JsonConfig jsonConfig = new JsonConfig();  
		 jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		 JSONArray jsonArray = JSONArray.fromObject(inParams,jsonConfig);
		JSONObject result = new JSONObject();
		result.put("result", "true");
		result.put("success", "true");
		result.put("msg", "导入成功");
		result.put("rows", jsonArray);//不要用InvoicePrintPoolH以免jason死循环
		retJson(response, result);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/saveInvoiceSendL", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public void saveInvoiceSendL(@RequestParam("id") String clientKeys,HttpServletResponse response) throws Exception {
		AssertHelper.notEmpty_assert(clientKeys,"需要保存的数据ID不能为空");
		InvoiceSendL tempInvoiceSendL =new InvoiceSendL();
		for(String clientId:clientKeys.split(",")){
			//InvoicePrintPoolH entity=(InvoicePrintPoolH)invoicePrintPoolHService.get(InvoicePrintPoolH.class,clientId);
			tempInvoiceSendL.setId(IdGenerator.getUUID());//当前表ID
			tempInvoiceSendL.setInvoicePrtPoolHId(clientId);//发票池ID
			tempInvoiceSendL.setInvoiceDeliveryHId("");
			tempInvoiceSendL.setDescription("发票111");
			Date date =new Date();
			tempInvoiceSendL.setFlag("sended");
			tempInvoiceSendL.setStatDate(date);
			tempInvoiceSendL.setEndDate(date);
			invoiceSendLService.save(tempInvoiceSendL);
		}
		JSONObject object = new JSONObject();
		object.put("result", "true");
		object.put("success", "true");
		object.put("msg", "保存成功");
		retJson(response, object);
	}	
	@ResponseBody
	@RequestMapping(value = "/removeInvoiceSendLs", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public void removeInvoiceSendLs(@RequestParam("id") String clientKeys,HttpServletResponse response) throws IOException {
		AssertHelper.notEmpty_assert(clientKeys,"需要删除的用户不能为空");
		for (String clientId : clientKeys.split(",")) {
			InvoiceSendL entity = (InvoiceSendL) invoiceSendLService.get(
					InvoiceSendL.class, clientId);
			if(entity!=null)
			{
			dao.remove(entity);
			}
		}
		JSONObject object = new JSONObject();
		object.put("result", "true");
		object.put("success", "true");
		object.put("msg", "删除成功");
		retJson(response, object);
	}
	@ResponseBody
	@RequestMapping(value = "/loadInvoiceSendL", method = RequestMethod.POST)
	//	url : '${vat}/invoiceSend/loadInvoiceSendHPage.do',
	public void loadInvoiceByH(@ModelAttribute("invoiceSendHInParam") InvoiceSendLInParam invoiceSendLInParam , HttpServletResponse response
			) throws Exception {
		StringBuffer sqlBuffer=new StringBuffer();
		//根据H id去拿L列表
		List<InvoiceSendL> daoPage=invoiceSendLService.findInvoiceSendLByHID(sqlBuffer.append(invoiceSendLInParam.getEntityID()));
		List<InvoicePrintPoolHInParam> inParams =new ArrayList<InvoicePrintPoolHInParam>();
		InvoicePrintPoolHInParam convertHInParam = new InvoicePrintPoolHInParam();
		InvoicePrintPoolH invoicePrintPoolH = new InvoicePrintPoolH();
		for(InvoiceSendL entity:daoPage)
		{//根据L里面的pool ID 去pool 里面拿到发票数据
			invoicePrintPoolH=(InvoicePrintPoolH) invoicePrintPoolHService.findById(InvoicePrintPoolH.class, entity.getInvoicePrtPoolHId());
			if(invoicePrintPoolH!=null)
			{
			ReflectUtils.copyProperties(invoicePrintPoolH, convertHInParam);
			
			inParams.add(convertHInParam);
			}
			//;
		}
		 JsonConfig jsonConfig = new JsonConfig();  
		 jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		 JSONArray jsonArray = JSONArray.fromObject(inParams,jsonConfig);
		JSONObject result = new JSONObject();
		result.put("total", inParams.size());
		result.put("rows", jsonArray);// daoPage.getr
		//result.put("pages", daoPage.getPageCount());
		result.put("success", true);
		retJson(response, result);
	}
	
	public InvoiceSendLInParam loadAddInvoiceSendL(Map<String, Object> map) throws Exception {
		InvoiceSendLInParam inParam=new InvoiceSendLInParam();
		return inParam;
	}
	
	public InvoiceSendLInParam loadModifyInvoiceSendL(Map<String, Object> map) throws Exception {
		Object id=map.get("id");
		AssertHelper.notEmpty_assert(id,"编辑的主键不能为空");
		InvoiceSendL entity=(InvoiceSendL)invoiceSendLService.get(InvoiceSendL.class,Long.parseLong(id.toString()));
		InvoiceSendLInParam inParam=invoiceSendLService.convertInvoiceSendLToInParam(entity);
		return inParam;
	}
	
	
	
	public void updateModifyInvoiceSendL(InvoiceSendLInParam inParam) throws Exception {
		InvoiceSendL entity=(InvoiceSendL)invoiceSendLService.get(InvoiceSendL.class,inParam.getId());
		ReflectUtils.copyProperties(inParam, entity);
		invoiceSendLService.update(entity);
	}
}

