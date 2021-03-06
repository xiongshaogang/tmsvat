package com.deloitte.tms.vat.purchinvoice.controller;
// Generated by bo.wang with ling2.autoproject

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deloitte.tms.pl.core.commons.support.DaoPage;

import com.deloitte.tms.pl.core.commons.utils.AssertHelper;
import com.deloitte.tms.pl.core.commons.utils.reflect.ReflectUtils;
import com.deloitte.tms.pl.core.commons.utils.PageUtils;
import com.deloitte.tms.pl.core.commons.springmvc.controller.BaseController;
import com.deloitte.tms.vat.purchinvoice.model.TmsDrvatInvoiceTrxH;
import com.deloitte.tms.vat.purchinvoice.model.TmsDrvatInvoiceTrxHInParam;
import com.deloitte.tms.vat.purchinvoice.model.TmsDrvatInvoiceTrxL;
import com.deloitte.tms.vat.purchinvoice.model.TmsDrvatInvoiceTrxLInParam;
import com.deloitte.tms.vat.purchinvoice.service.TmsDrvatInvoiceTrxHService;
/**
 * Home object for domain model class TmsDrvatInvoiceTrxH.
 * @see com.deloitte.tms.vat.purchinvoice.model
 * @author Hibernate Tools
 */
@Controller
@RequestMapping("tmsDrvatInvoiceTrxH")
public class TmsDrvatInvoiceTrxHController extends BaseController{
	@Resource
	TmsDrvatInvoiceTrxHService tmsDrvatInvoiceTrxHService;
	
	@RequestMapping(value = "/initTmsDrvatInvoiceTrxH", method = RequestMethod.GET)
	public String initTmsDrvatInvoiceTrxH()throws Exception{
		return "vat/tmsdrvatinvoicetrxh/tmsDrvatInvoiceTrxH";
	}
	/**
	 * 查询数据
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/loadTmsDrvatInvoiceTrxHPage", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public DaoPage loadTmsDrvatInvoiceTrxHPage(@RequestParam Map<String,Object> parameter) throws Exception {
		DaoPage daoPage=tmsDrvatInvoiceTrxHService.findTmsDrvatInvoiceTrxHByParams(parameter,PageUtils.getPageNumber(parameter),PageUtils.getPageSize(parameter));
		return daoPage;
	}
	@ResponseBody
	@RequestMapping(value = "/saveTmsDrvatInvoiceTrxH", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public void saveTmsDrvatInvoiceTrxH(TmsDrvatInvoiceTrxHInParam inParam) throws Exception {
		TmsDrvatInvoiceTrxH entity=tmsDrvatInvoiceTrxHService.convertTmsDrvatInvoiceTrxHInParamToEntity(inParam);
		if(entity.getId()==null){
			tmsDrvatInvoiceTrxHService.save(entity);
		}
		else{
			tmsDrvatInvoiceTrxHService.update(entity);
		}
		inParam.setId(entity.getId());
	}	
	@ResponseBody
	@RequestMapping(value = "/removeTmsDrvatInvoiceTrxHs", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public void removeTmsDrvatInvoiceTrxHs(@RequestParam String ids) {
		AssertHelper.notEmpty_assert(ids,"需要删除的用户不能为空");
		String[] tmsDrvatInvoiceTrxHIds=ids.split(",");
		//for(String tmsDrvatInvoiceTrxHId:tmsDrvatInvoiceTrxHIds){
			
		//}
	}
	@ResponseBody
	@RequestMapping(value = "/loadTmsDrvatInvoiceTrxH", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public Collection<TmsDrvatInvoiceTrxHInParam> loadTmsDrvatInvoiceTrxH(@RequestParam Map<String, Object> map) throws Exception {
		List result=tmsDrvatInvoiceTrxHService.findTmsDrvatInvoiceTrxHByParams(map);
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/loadAddTmsDrvatInvoiceTrxH", method = RequestMethod.POST)
	public TmsDrvatInvoiceTrxHInParam loadAddTmsDrvatInvoiceTrxH(@RequestParam Map<String, Object> map) throws Exception {
		TmsDrvatInvoiceTrxHInParam inParam=new TmsDrvatInvoiceTrxHInParam();
		return inParam;
	}
	@ResponseBody
	@RequestMapping(value = "/loadModifyTmsDrvatInvoiceTrxH", method = RequestMethod.POST)
	public TmsDrvatInvoiceTrxHInParam loadModifyTmsDrvatInvoiceTrxH(@RequestParam Map<String, Object> map) throws Exception {
		Object id=map.get("id");
		AssertHelper.notEmpty_assert(id,"编辑的主键不能为空");
		TmsDrvatInvoiceTrxH entity=(TmsDrvatInvoiceTrxH)tmsDrvatInvoiceTrxHService.get(TmsDrvatInvoiceTrxH.class,id.toString());
		TmsDrvatInvoiceTrxHInParam inParam=tmsDrvatInvoiceTrxHService.convertTmsDrvatInvoiceTrxHToInParam(entity);
		return inParam;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateModifyTmsDrvatInvoiceTrxH", method = RequestMethod.POST)
	public void updateModifyTmsDrvatInvoiceTrxH(TmsDrvatInvoiceTrxHInParam inParam) throws Exception {
		TmsDrvatInvoiceTrxH entity=(TmsDrvatInvoiceTrxH)tmsDrvatInvoiceTrxHService.get(TmsDrvatInvoiceTrxH.class,inParam.getId());
		ReflectUtils.copyProperties(inParam, entity);
		tmsDrvatInvoiceTrxHService.update(entity);
	}
	@ResponseBody
	@RequestMapping(value = "loadTmsDrvatInvoiceTrxLPage", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public DaoPage loadTmsDrvatInvoiceTrxLPage(@RequestParam Map<String,Object> parameter) throws Exception {
		DaoPage daoPage=tmsDrvatInvoiceTrxHService.findTmsDrvatInvoiceTrxLByParams(parameter,PageUtils.getPageIndex(parameter),PageUtils.getPageSize(parameter));
		return daoPage;
	}
	@ResponseBody
	@RequestMapping(value = "loadTmsDrvatInvoiceTrxL", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public Collection loadTmsDrvatInvoiceTrxL(Map<String, Object> map) throws Exception {
		List result=tmsDrvatInvoiceTrxHService.findTmsDrvatInvoiceTrxLByParams(map);
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/saveTmsDrvatInvoiceTrxL", method = RequestMethod.POST)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public void saveTmsDrvatInvoiceTrxL(TmsDrvatInvoiceTrxLInParam inParam) throws Exception {
		TmsDrvatInvoiceTrxL entity=tmsDrvatInvoiceTrxHService.convertTmsDrvatInvoiceTrxLInParamToEntity(inParam);
		if(entity.getId()==null){
			tmsDrvatInvoiceTrxHService.save(entity);
		}
		else{
			tmsDrvatInvoiceTrxHService.update(entity);
		}
		inParam.setId(entity.getId());
	}
}

