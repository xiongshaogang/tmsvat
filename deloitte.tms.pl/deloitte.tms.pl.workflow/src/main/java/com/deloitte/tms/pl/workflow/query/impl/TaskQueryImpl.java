package com.deloitte.tms.pl.workflow.query.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deloitte.tms.pl.workflow.command.CommandService;
import com.deloitte.tms.pl.workflow.command.impl.QueryCountCommand;
import com.deloitte.tms.pl.workflow.command.impl.QueryListCommand;
import com.deloitte.tms.pl.workflow.model.task.Task;
import com.deloitte.tms.pl.workflow.model.task.TaskState;
import com.deloitte.tms.pl.workflow.model.task.TaskType;
import com.deloitte.tms.pl.workflow.query.QueryJob;
import com.deloitte.tms.pl.workflow.query.TaskQuery;

/**
 * @author Jacky.gao
 * @since 2013年8月14日
 */
public class TaskQueryImpl implements TaskQuery,QueryJob{
	private String url;
	private String businessId;
	private String assignee;
	private String owner;
	private long processInstanceId;
	private Date createDateLessThen;
	private Date createDateLessThenOrEquals;
	private Date createDateGreaterThen;
	private Date createDateGreaterThenOrEquals;
	private long rootProcessInstanceId;
	private Date dueDateLessThen;
	private Date dueDateLessThenOrEquals;
	private Date dueDateGreaterThen;
	private Date dueDateGreaterThenOrEquals;
	private Boolean countersign;
	private TaskType type;
	private long processId;
	private String name;
	private String nodeName;
	private int firstResult;
	private int maxResults;
	private List<TaskState> states=new ArrayList<TaskState>();
	private List<TaskState> prevstates=new ArrayList<TaskState>();
	private List<String> ascOrders=new ArrayList<String>();
	private List<String> descOrders=new ArrayList<String>();
	private List<String> participators=new ArrayList<String>();
	private CommandService commandService;
	public TaskQueryImpl(CommandService commandService){
		this.commandService=commandService;
	}
	public List<Task> list() {
		return commandService.executeCommand(new QueryListCommand<List<Task>>(this));
	}

	public int count() {
		return commandService.executeCommand(new QueryCountCommand(this));
	}

	public Criteria getCriteria(Session session,boolean queryCount) {
		Criteria criteria=session.createCriteria(Task.class);
		buildCriteria(criteria,queryCount);
		return criteria;
	}

	private void buildCriteria(Criteria criteria,boolean queryCount){
		if(!queryCount && firstResult>0){
			criteria.setFirstResult(firstResult);			
		}
		if(!queryCount && maxResults>0){
			criteria.setMaxResults(maxResults);			
		}
		if(processId>0){
			criteria.add(Restrictions.eq("processId",processId));
		}
		if(StringUtils.isNotEmpty(owner)){
			criteria.add(Restrictions.eq("owner", owner));
		}
		if(StringUtils.isNotEmpty(assignee)){
			criteria.add(Restrictions.eq("assignee", assignee));
		}
		if(countersign!=null){
			criteria.add(Restrictions.eq("countersign", countersign));
		}
		if(type!=null){
			criteria.add(Restrictions.eq("type", type));
		}
		if(processInstanceId>0){
			criteria.add(Restrictions.eq("processInstanceId",processInstanceId));
		}
		if(rootProcessInstanceId>0){
			criteria.add(Restrictions.eq("rootProcessInstanceId",rootProcessInstanceId));
		}
		if(StringUtils.isNotEmpty(url)){
			criteria.add(Restrictions.like("url", url));
		}
		if(StringUtils.isNotEmpty(name)){
			criteria.add(Restrictions.like("taskName", name));
		}
		if(StringUtils.isNotEmpty(nodeName)){
			criteria.add(Restrictions.eq("nodeName", nodeName));
		}
		if(StringUtils.isNotEmpty(businessId)){
			criteria.add(Restrictions.eq("businessId", businessId));
		}
		if(createDateLessThen!=null){
			criteria.add(Restrictions.lt("createDate", createDateLessThen));
		}
		if(createDateGreaterThen!=null){
			criteria.add(Restrictions.gt("createDate", createDateGreaterThen));
		}
		if(createDateLessThenOrEquals!=null){
			criteria.add(Restrictions.le("createDate", createDateLessThenOrEquals));
		}
		if(createDateGreaterThenOrEquals!=null){
			criteria.add(Restrictions.ge("createDate", createDateGreaterThenOrEquals));
		}
		
		if(dueDateLessThen!=null){
			criteria.add(Restrictions.lt("duedate", dueDateLessThen));
		}
		if(dueDateGreaterThen!=null){
			criteria.add(Restrictions.gt("duedate", dueDateGreaterThen));
		}
		if(dueDateLessThenOrEquals!=null){
			criteria.add(Restrictions.le("duedate", dueDateLessThenOrEquals));
		}
		if(dueDateGreaterThenOrEquals!=null){
			criteria.add(Restrictions.ge("duedate", dueDateGreaterThenOrEquals));
		}
		
		if(!queryCount){
			for(String ascProperty:ascOrders){
				criteria.addOrder(Order.asc(ascProperty));
			}
			for(String descProperty:descOrders){
				criteria.addOrder(Order.desc(descProperty));
			}
		}
		for(TaskState state:states){
			criteria.add(Restrictions.eq("state", state));
		}
		for(TaskState state:prevstates){
			criteria.add(Restrictions.eq("prevState", state));
		}
		if(participators.size()>0){
			Criteria participatorCriteria=criteria.createCriteria("taskParticipators");
			Disjunction disjunction=Restrictions.disjunction();
			for(String user:participators){
				disjunction.add(Restrictions.eq("user",user));
			}
			participatorCriteria.add(disjunction);
		}
	}
	
	public TaskQuery businessId(String businessId) {
		this.businessId=businessId;
		return this;
	}
	
	public TaskQuery addOrderAsc(String property){
		ascOrders.add(property);
		return this;
	}

	public TaskQuery addOrderDesc(String property){
		descOrders.add(property);
		return this;
	}
	
	public TaskQuery assignee(String assignee) {
		this.assignee=assignee;
		return this;
	}

	public TaskQuery owner(String owner) {
		this.owner=owner;
		return this;
	}

	public TaskQuery addTaskState(TaskState state) {
		states.add(state);
		return this;
	}

	public TaskQuery addPrevTaskState(TaskState state) {
		prevstates.add(state);
		return this;
	}

	public TaskQuery processInstanceId(long processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}

	public TaskQuery createDateLessThen(Date createDateLessThen) {
		this.createDateLessThen=createDateLessThen;
		return this;
	}

	public TaskQuery createDateLessThenOrEquals(Date createDateLessThenOrEquals) {
		this.createDateLessThenOrEquals=createDateLessThenOrEquals;
		return this;
	}

	public TaskQuery createDateGreaterThen(Date createDateGreaterThen) {
		this.createDateGreaterThen=createDateGreaterThen;
		return this;
	}

	public TaskQuery createDateGreaterThenOrEquals(Date createDateGreaterThenOrEquals) {
		this.createDateGreaterThenOrEquals=createDateGreaterThenOrEquals;
		return this;
	}
	public TaskQuery dueDateLessThen(Date dueDateLessThen) {
		this.dueDateLessThen=dueDateLessThen;
		return this;
	}
	
	public TaskQuery dueDateLessThenOrEquals(Date dueDateLessThenOrEquals) {
		this.dueDateLessThenOrEquals=dueDateLessThenOrEquals;
		return this;
	}
	
	public TaskQuery dueDateGreaterThen(Date dueDateGreaterThen) {
		this.dueDateGreaterThen=dueDateGreaterThen;
		return this;
	}
	
	public TaskQuery dueDateGreaterThenOrEquals(Date dueDateGreaterThenOrEquals) {
		this.dueDateGreaterThenOrEquals=dueDateGreaterThenOrEquals;
		return this;
	}

	public TaskQuery urlLike(String url) {
		this.url=url;
		return this;
	}

	public TaskQuery countersign(boolean countersign) {
		this.countersign=countersign;
		return this;
	}
	

	public TaskQuery taskType(TaskType type) {
		this.type=type;
		return this;
	}

	public TaskQuery addParticipator(String user) {
		participators.add(user);
		return this;
	}
	
	public TaskQuery processId(long processId) {
		this.processId=processId;
		return this;
	}
	public TaskQuery rootProcessInstanceId(long rootProcessInstanceId) {
		this.rootProcessInstanceId=rootProcessInstanceId;
		return this;
	}

	public TaskQuery nameLike(String name) {
		this.name=name;
		return this;
	}
	
	public TaskQuery nodeName(String nodeName) {
		this.nodeName=nodeName;
		return this;
	}
	
	public TaskQuery page(int firstResult, int maxResults) {
		this.firstResult=firstResult;
		this.maxResults=maxResults;
		return this;
	}
}
