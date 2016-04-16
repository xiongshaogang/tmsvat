package com.deloitte.tms.vat.salesinvoice;
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
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxH;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxHInParam;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxH;
import com.deloitte.tms.vat.salesinvoice.model.InvoiceTrxHInParam;
import com.deloitte.tms.vat.salesinvoice.service.InvoiceTrxHService;
/**
 * Home object for domain model class InvoiceTrxH.
 * @see com.deloitte.tms.vat.salesinvoice.model
 * @author Hibernate Tools
 */
@Controller
@RequestMapping("invoiceTrxH")
public class InvoiceTrxHController extends BaseController{
	@Resource
	InvoiceTrxHService invoiceTrxHService;
	
	@ResponseBody
	@RequestMapping(value = "/loadInvoiceTrxHPage", method = RequestMethod.GET)
	//@RoleAnnotation(roles=RoleDef.ECOMMERCE_ADMIN)
	public DaoPage loadInvoiceTrxHPage(@RequestParam Map<String,Object> parameter) throws Exception {
		DaoPage daoPage=invoiceTrxHService.findInvoiceTrxHByParams(parameter,PageUtils.getPageIndex(parameter),PageUtils.getPageSize(parameter));
		return daoPage;
	}
	
}
