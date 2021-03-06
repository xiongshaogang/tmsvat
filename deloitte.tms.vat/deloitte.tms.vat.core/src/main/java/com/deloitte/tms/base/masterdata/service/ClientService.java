package com.deloitte.tms.base.masterdata.service;
// Generated by bo.wang with ling2.autoproject

import java.util.List;
import java.util.Map;

import com.deloitte.tms.base.masterdata.model.Client;
import com.deloitte.tms.base.masterdata.model.ClientInParam;
import com.deloitte.tms.base.masterdata.model.ClientSec;
import com.deloitte.tms.base.masterdata.model.ClientSecInParam;
import com.deloitte.tms.pl.core.commons.support.DaoPage;
import com.deloitte.tms.pl.core.service.IService;
/**
 * Home object for domain model class Client.
 * @see com.deloitte.tms.base.masterdata.model
 * @author Hibernate Tools
 */
public interface ClientService extends IService{
	public static final String BEAN_ID="clientService";
	
	public DaoPage findClientByParams(Map params, Integer pageIndex,Integer pageSize);
	
	public List<ClientInParam> findClientByParams(Map params);
	
	public void saveClientDataListsMap(Map dataListsMap);
	
	public ClientInParam convertClientToInParam(Client model);
	
	public Client convertClientInParamToEntity(ClientInParam inParam);
	
	public DaoPage findClientSecByParams(Map params, Integer pageIndex,Integer pageSize);
	
	public List<ClientSecInParam> findClientSecByParams(Map params);
	
	public void saveClientSecDataListsMap(Map dataListsMap);
	
	public ClientSecInParam convertClientSecToInParam(ClientSec model);
	
	public ClientSec convertClientSecInParamToEntity(ClientSecInParam inParam);
	
}

