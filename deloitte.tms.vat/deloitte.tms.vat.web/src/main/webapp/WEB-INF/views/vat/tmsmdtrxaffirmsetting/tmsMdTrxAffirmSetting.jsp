<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<%@ include file="/common/global.jsp"%>
<%@ taglib uri="/tags/input" prefix="input"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
 <body class="easyui-layout" style="overflow-y: hidden"  scroll="no" id="layoutid">    
    <div region="north" split="true" border="false" style="overflow: hidden; height:22%;" data-options="region:'west'">  
        <div class="easyui-panel" title="查询条件" style="width:100%;height:100%;margin-top:0px;" data-options="collapsible: true">		
		    <form id="trxAffirmSett_searchform" method="get" scroll="no">
		    	<table>
		    		<tr style="text-align:center;align="center">
		    			<td>组织:</td>
		    			<td>					    	<input:select id="_searchform_orgInfoList_select"
												name="selectOption" value="$invoice_print_newSearch_validType"
												easyuiClass="easyui-combobox" easyuiStyle="width:120px;">
												<option value=""></option>
												<input:systemStatusOption parentCode="BASE_ORG_TYPE"/>
							</input:select>
				    	 </div>
						</td>
						<td>是否有效:<select id=""
						name="" class="easyui-combogrid"
						style="width: 150px;"></select></td>
						<td>涉税交易类型:</td>
		    			<td>
							<div>
					    	<input:select id="_searchform_taxTrsTypeList_select"name="taxTransactionType" value="$invoice_print_newSearch_validType"easyuiClass="easyui-combobox" easyuiStyle="width:120px;">
							<option value=""></option>
							<input:systemStatusOption parentCode="VAT_TAX_BIZ_CATEGORY"/>
							</input:select>
				    	 </div>	
						</td>
		    		</tr>
		    		<tr style="text-align:center;align="center">
		    		  <td align="center" colspan="6"> 
		    		  <a href="#" id="searchbtn"  class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="Searcha()">
		    		  <spring:message code='client.search.button.find'/>
		    		  </a>
		    		  <a href="#" class="easyui-linkbutton" style="width:80px" onclick="">
		    		  <spring:message code="button.Clear"/>
		    		  </a>			                     
		    		   </td>
		    		</tr>	    	
		    				
		    		<tr style="display:none">
		    		   <td><input id="pageNumber" class="easyui-textbox" type="text" style="width:0px;" name="pageNumber" value=""></input></td>
		    		   <td><input id="pageSize" class="easyui-textbox" type="text" style="width:0px;" name="pageSize" value=""></input></td>
		    		</tr>		 	    	
		    	</table>
		    	
		    	
		    </form>
	    </div>	         
    </div>
    <div data-options="region:'center',border:false" style="background-color: #E0ECFF">  
	    <div style="width:100%;height:100%">
	
	         <table  id="trxAffirmSett_dataGrid"  style="width:100%;height:100%;text-align:center;" >	
	
		   </table>  
	   </div>	 
	</div>
	
 
<div id="addOrEditTrxAffirmSett" class="easyui-dialog" title="新增" style="width:950px;height:450px;"   
        data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true" buttons="#dlg-buttons">   
      <form  method="post" id="addOrEditTrxAffirmSettForm">
           <table style="text-align:center;line-height:40px;" align="center">
            <tr>
            	<input id="id" type="hidden" name="id" style="width:200px;" >            
            	<td align="right">层级：</td>      
                <td><input:select id="globalOrLocalOgrTypeId" name="globalOrLocalOgrType" value="$invoice_print_newSearch_validType" easyuiClass="easyui-combobox" easyuiStyle="width:150px;">
					<option value=""></option>	
					<input:systemStatusOption parentCode="BASE_ORG_PARAMETER_TYPE"/>				
					</input:select></td> 
               
               
                <td align="right">组织：</td>
				<td><select id="org_addEdit" name="orgName" class="easyui-combogrid" style="width: 150px;" ></select></td>                     
                <td align="right">涉税交易类型编码：</td>
             <!--   <td><select id="taxTrxTypeCode_addEdit" name="taxTrxTypeCode" class="easyui-combogrid" style="width: 150px;" data-options="required:true"></select></td>  -->
               <td><input:select id="taxTrxTypeCode_addEdit" name="taxTrxTypeCode" value="$invoice_print_newSearch_validType" easyuiClass="easyui-combobox" easyuiStyle="width:150px;">
					<option value=""></option>				
					</input:select></td>             
            </tr>
            <tr>
               <td align="right">涉税交易类型：</td>
               <td><input id="taxTrxTypeName_addEdit" name="taxTrxTypeName" class="easyui-validatebox" type="text" name="taxTrxTypeCode" disabled="disabled" style="width:150px;" ></td>          
               <td align="right">业务大类：</td>             
               <td><input  Style="width:150px;" id="businessCategories" name="businessCategories" easyuiClass="easyui-combobox"></input></td>
               <td align="right">价税分离核算规则：</td>          
               <td><input:select id="spitRuleCode" name="spitRuleCode" value="$invoice_print_newSearch_validType" easyuiClass="easyui-combobox" easyuiStyle="width:150px;">
					<option value=""></option>
					<input:systemStatusOption parentCode="VAT_PRICE_TAX_SPLIT_CHECK_RULE"/>
					</input:select></td>                            
            </tr>
            <tr>
               <td align="right">是否启用：</td>  
               <td><input:select id="enabledFlag" name="enabledFlag" value="$invoice_print_newSearch_validType" easyuiClass="easyui-combobox" easyuiStyle="width:150px;">				  			
				   </input:select></td>
               <td align="right">税种：</td>            
               <td><select id="taxCategoryId" name="taxCategoryName" class="easyui-combogrid" style="width: 150px; " ></select></td>  
               <td align="right">税金科目编码：</td>
               <td><select id="accdSegment" name="accdSegment" class="easyui-combogrid" style="width: 150px;" data-options="required:true"></select></td>
            </tr>
            <tr>
               <td align="right">税金科目：</td>
               <td><input id="accdSegmentName" name="accdSegmentName"  class="easyui-validatebox" type="text" name="taxTrxTypeCode" disabled="disabled" style="width:150px;" ></td>    
               <td align="right">税目：</td>          
               <td><select id="taxItemId" name="taxItemName" class="easyui-combogrid" style="width: 150px; " ></select></td>  
               <td align="right">商品及服务编码：</td>
               <td><input class="easyui-validatebox" type="text" id="inventoryItemNumberId" name="inventoryItemNumber"  style="width:150px;" ></td>
            </tr>
            <tr>   
               <td align="right">商品及服务名称：</td>
               <td><input class="easyui-validatebox" type="text" id="inventoryItemDescriptonId" name="inventoryItemDescripton"  style="width:150px;" ></td>
                                    
               <td align="right">税率：</td>
               <td><input class="easyui-validatebox" type="text" id="taxRate" name="taxRate" disabled="disabled" style="width:150px;" ></td>
               <td align="right">计税方法：</td>
               <td><input class="easyui-validatebox" type="text" name="taxTrxTypeCode" disabled="disabled" style="width:150px;" ></td>
            </tr>
            <tr>
            	<td align="right">计税规则：</td>
               <td><input class="easyui-validatebox" type="text" name="taxTrxTypeCode" disabled="disabled" style="width:150px;" ></td>
               <td align="right">开票规则：</td>
              <!--  <td><select id="rule" name="taxTransactionType" class="easyui-combogrid" style="width: 150px;" data-options="required:true"></select></td> -->
               <td><input:select id="rule" name="taxTransactionType" value="$invoice_print_newSearch_validType" easyuiClass="easyui-combobox" easyuiStyle="width:150px;">
				   <option value=""></option>
				   <input:systemStatusOption parentCode="VAT_INVOICE_RULE"/>
				   </input:select></td>
               <td align="right">属地/汇总：</td>
              <!--  <td><select id="total" name="taxTransactionType" class="easyui-combogrid" style="width: 150px;" data-options="required:true"></select></td> -->
               <td><input:select id="total" name="taxTransactionType" value="$invoice_print_newSearch_validType" easyuiClass="easyui-combobox" easyuiStyle="width:150px;">
				   <option value=""></option>
				   <input:systemStatusOption parentCode="VAT_BIZ_SCOPE_TYPE"/>
				   </input:select></td>
            
            </tr>
            <tr>
            	<td align="right">是否计税：</td>
               <td><input id="isAccount" name="isAccount" class="easyui-combobox" style="width: 150px;" ></input></td>
               <td align="right">计税基础：</td>
              <!--  <td><select id="taxSettingBase" name="taxSettingBase" class="easyui-combogrid" style="width: 150px;" data-options="required:true"></select></td> -->
               <td><input:select id="taxSettingBase" name="taxSettingBase" value="$invoice_print_newSearch_validType" easyuiClass="easyui-combobox" easyuiStyle="width:150px;">
				   <option value=""></option>
				   <input:systemStatusOption parentCode="VAT_TAX_CAL_BASE"/>
				   </input:select></td>
              
               <td align="right">是否含税：</td>
             <!--   <td><select id="isTax" name="isTax" class="easyui-combogrid" style="width: 150px;" data-options="required:true"></select></td> -->
               <td><input:select id="isTax" name="isTax" value="$invoice_print_newSearch_validType" easyuiClass="easyui-combobox" easyuiStyle="width:150px;">
				  
				   <%-- <input:systemStatusOption parentCode="VAT_TAX_CAL_BASE"/> --%>
				   </input:select></td>           
            </tr>
            <tr>
            	<td align="right">生效日期：</td> 
               <td><input id="startDate" name="startDate" class="easyui-datebox" type="text" style="width:150px;" name="trxEndDate" data-options="required:true"></input></td>
               <td align="right">有效日期：</td>
               <td><input id="endDate" name="endDate"  class="easyui-datebox" type="text" style="width:150px;" name="trxEndDate" data-options="required:true"></input></td>             
            </tr>
           </table>
      </form>
    </div>  
	<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"iconCls="icon-ok" onclick="TmsMdTrxAffirmSettingEditSave()"><spring:message code="button.Save" /></a>
			<a href="javascript:void(0)"class="easyui-linkbutton" iconCls="icon-cancel"onclick="javascript:$('#addOrEditTrxAffirmSett').dialog('close')"><spring:message code="button.Close" /></a>
		</div>
     <div class="easyui-dialog" closed="true">
       <from id="getByBaseOrg" method="post">
        <table>
          	<tr style="display:none">
		        <td><input id="pageNumber1" class="easyui-textbox" type="text" style="width:0px;" name="pageNumber" value=""></input></td>
		        <td><input id="pageSize1" class="easyui-textbox" type="text" style="width:0px;" name="pageSize" value=""></input></td>
		    </tr>
        </table>
       </from>
     </div>
     
   	 
</body>
<script type="text/javascript">
$(document).keydown(function(e){
    var target = e.target ;
    var tag = e.target.tagName.toUpperCase();
    if(e.keyCode == 8){
     if((tag == 'INPUT' && !$(target).attr("readonly"))||(tag == 'TEXTAREA' && !$(target).attr("readonly"))){
      if((target.type.toUpperCase() == "RADIO") || (target.type.toUpperCase() == "CHECKBOX")){
       return false ;
      }else{
       return true ; 
      }
     }else{
      return false ;
     }
    }
}); 

$(document).ready(
		function() {
			$('#trxAffirmSett_searchform').form(//读取记录填充到表单中。数据参数可以是一个字符串或一个对象类型，如果是字符串则作为远程URL，否则作为本地记录。
					'load',
					{
						pageNumber : $('#trxAffirmSett_dataGrid')
								.datagrid('options').pageNumber,
						pageSize : $('#trxAffirmSett_dataGrid')
								.datagrid('options').pageSize
					});
			Search();
			addSelect();
		});


function addOrEditTrxAffirmSett(){
	$('#addOrEditTrxAffirmSettForm').form('submit',{
	    url:"${vat}/tmsMdTrxAffirmSetting/saveTmsMdTrxAffirmSetting.do",
	   /*  onSubmit: function(){    
	    	
	    },   */  
	    success:function(data){
	    	data = $.parseJSON(data);
	        if(data.success){
	        	$("#addOrEditTrxAffirmSett").dialog("close");
	        	//$.messager.alert("操作提示","编辑成功");
		    	Search();
		    	
	        }
	        
	    }    
	});    	
}

function addOrEditTrxAffirmSett1(){
		if ($('#trxAffirmSett_dataGrid').datagrid('getChecked').length > 1) {
			$.messager.alert("操作提示", "请选择一条数据进行修改");
		} else {
			clearSaveForm();
			var row_list = $('#trxAffirmSett_dataGrid').datagrid('getChecked');
			if (row_list) {
				var id = '';
				$.each(row_list, function(index, item) {
					if (index == 0) {
						id = item.id;
					}
				});
				if (id != '') {
					$.get(
							'${vat}/tmsMdTrxAffirmSetting/loadTmsMdTrxAffirmSetting.do?id='+id,

							function(result) {
								
								if (result.status == '0') {
									$("#addOrEditTrxAffirmSett").dialog('open').dialog('setTitle',"<spring:message code='client.dialog.clientedit.title'/>");
									$("#addOrEditTrxAffirmSettForm").form('load', result.data);
								} else if (result.status == '1') {
									$.messager.alert('<spring:message code="system.alert"/>',result.errorMsg);
								}
							}, 'json');
				} else {
					$.messager.alert('<spring:message code="system.alert"/>','请选择需要编辑的数据');
				}
			}
		}
	}
var createGridHeaderContextMenu = function(e, field) {  
	    e.preventDefault();  
	    var grid = $(this);/* grid本身 */  
	    var headerContextMenu = this.headerContextMenu;/* grid上的列头菜单对象 */  
	    var okCls = 'tree-checkbox1';//选中  
	    var emptyCls = 'tree-checkbox0';//取消  
	    if (!headerContextMenu) {  
	        var tmenu = $('<div style="width:100px;"></div>').appendTo('body');  
	        var fields = grid.datagrid('getColumnFields');  
	        for ( var i = 0; i < fields.length; i++) {  
	            var fildOption = grid.datagrid('getColumnOption', fields[i]);  
	            if (!fildOption.hidden) {  
	               $('<div iconCls="'+okCls+'" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);  
	            } else {  
	                $('<div iconCls="'+emptyCls+'" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);  
	            }  
	       }  
	        headerContextMenu = this.headerContextMenu = tmenu.menu({  
	            onClick : function(item) {  
	                var field = $(item.target).attr('field');  
	                if (item.iconCls == okCls) {  
	                    grid.datagrid('hideColumn', field);  
	                    $(this).menu('setIcon', {  
	                        target : item.target,  
	                        iconCls : emptyCls  
	                    });  
	                } else {  
	                    grid.datagrid('showColumn', field);  
	                    $(this).menu('setIcon', {  
	                        target : item.target,  
	                        iconCls : okCls  
	                    });  
	               }  
	            }  
	        });  
	    }  
	    headerContextMenu.menu('show', {  
	        left : e.pageX,  
	        top : e.pageY  
	    });  
	};  
	$.fn.datagrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;  
	$.fn.treegrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;  


//初始化异常信息显示表格
$("#trxAffirmSett_dataGrid").datagrid({
	loadMsg : "<spring:message code='client.datagrid.dataloding'/>",
	striped : true,//显示斑马线效果
	singleSelect : false, //多选
	collapsible : false,//可折叠  
	fitColumns : false,//自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
	nowrap : false,//换行
	iconCls : 'icon icon-list',//图标
	idField : 'id',//主键字段
    rownumbers:true, //显示行数
    pagination:true,//分页
    url:'',  //数据请求地址
    border: true,
    remoteSort:false,//定义从服务器对数据进行排序。
    columns:[[  
            {field:'ck',checkbox:'true',align : 'center'},
            {field:'orgName',title:'组织',width:80,align : 'center'},
            {field:'taxTrxTypeId',title:'涉税交易类型编码',width:80,align : 'center'},
            {field:'taxTrxTypeId',title:'涉税交易类型',width:80,align : 'center'} ,
            {field:'businessCategories',title:'业务大类',width:80,align : 'center'} , 
            {field:'accdSegment',title:'税金科目编码',width:80,align : 'center'} ,
            {field:'sourceCode',title:'税金科目',width:80,align : 'center'} ,
            {field:'sourceCode',title:'税价分离核算规则',width:80,align : 'center'},
            {field:'taxCategoryId',title:'税种',width:80,align : 'center'} ,
            {field:'taxItemId',title:'税目',width:80,align : 'center'} , 
            {field:'taxRate',title:'税率%',width:80,align : 'center'},
            {field:'invoiceCategories',title:'开票规则',width:80,align : 'center'} ,
            {field:'invoicingType',title:'属地/汇总',width:80,align : 'center'},
            {field:'isAccount',title:'是否计税',width:80,align : 'center'},
            {field:'taxSettingBase',title:'计税基础',width:80,align : 'center'},
            {field:'startDate',title:'生效日期',width:80,align : 'center'},
            {field:'endDate',title:'失效日期',width:80,align : 'center'},
            {field:'isTax',title:'是否含税',width:80,align : 'center'},
            {field:'enabledFlag',title:'是否启用',width:80,align : 'center'}
          ]],
         	toolbar : [ {
				text : "新增",
				iconCls : 'icon-add',
				handler : function() {
					clearSaveForm();
			
					tablePanl();
					 $('#enabledFlag').combobox('setValue',"是");
					 $('#isTax').combobox('setValue',"是");
					$("#addOrEditTrxAffirmSett").dialog("open");
				}
			}, '-', {
				text : "编辑",
				iconCls : 'icon-edit',
				handler : function() {
					tablePanl();
					addOrEditTrxAffirmSett1();
					
				}
			}, '-', {
				text : "删除",
				iconCls : 'icon-remove',
				handler : function() {
					//$("#qudialog").dialog("open");
					Remove();
					
				}
			}, '-', {
				text : "导入",
				iconCls : 'icon-edit',
				handler : function() {
					
				}
			}, '-', {
				text : "下载导入模板",
				iconCls : 'icon-edit',
				handler : function() {
					
				}
			}, '-'],
	
	
	});
//得到分页控件
var p = $('#trxAffirmSett_dataGrid').datagrid('getPager');
//设置分页控件	
$(p).pagination({
	pageSize: 10,//每页显示的记录条数，默认为10           
	beforePageText: '<spring:message code="pagination.beforePageText"/>',//页数文本框前显示的汉字           
	afterPageText: '<spring:message code="pagination.afterPageText"/>',           
	displayMsg: '<spring:message code="pagination.displayMsg"/>',
	onSelectPage: function (pageNumber, pageSize) {//用户选择一个新页面的时候触发	
    	 find(pageNumber,pageSize);//改变后的页数传给后台
		 Search(); 
     }
});
//对分页数数据条数改编后进行操作
function find(pageNumber, pageSize) {
	$('#trxAffirmSett_searchform').form('load', {//读取记录填充到表单中。数据参数可以是一个字符串或一个对象类型，如果是字符串则作为远程URL，否则作为本地记录。
		pageNumber : pageNumber,
		pageSize : pageSize
	});
}

/*
 * 表格下拉面板的生成
 */
function tablePanl(){
    initTaxEntity();
    initTaxCategoryPanl();
    initItemsPanl();
}


/**
 * 请求查询涉税交易类型定义
 */
function Search() {
	$("#trxAffirmSett_dataGrid").datagrid("loading");//显示载入状态。
	$('#trxAffirmSett_searchform').form('submit', {//提交form表单
		url : '${vat}/tmsMdTrxAffirmSetting/loadTmsMdTrxAffirmSettingPage.do',
		success : function(result) {//成功之后
			//数据加载以及绑定
			var result = $.parseJSON(result);//将数据格式化成json
			$("#trxAffirmSett_dataGrid").datagrid('loadData', result);//加载本地数据，旧的行将被移除。
			$("#trxAffirmSett_dataGrid").datagrid("loaded");//隐藏载入状态。
		}
	});
}

//保存
	function TmsMdTrxAffirmSettingEditSave() {
		$.messager.confirm("<spring:message code='client.datacommit.formsave.confirm.title'/>","<spring:message code='client.datacommit.formsave.confirm.text'/>",
		function(result) {
			if (result) {
				$('#addOrEditTrxAffirmSettForm').form(
				'submit',
				{
					url : '${vat}/tmsMdTrxAffirmSetting/saveTmsMdTrxAffirmSetting.do',
					onSubmit : function() {
						return $(this).form('enableValidation').form('validate');
					},
					success : function(result) {
						var result = $.parseJSON(result);
					
							clearSaveForm();
							Search();
							$('#addOrEditTrxAffirmSett').dialog('close');
							$.messager.alert('<spring:message code="system.alert"/>','保存成功');
						

					}
				});
			}
		});

	}



/**
 * 根据检索条件查询信息
 */
function Searcha() {
	$('#trxAffirmSett_searchform').form('submit', {
		url : '${vat}/tmsMdTrxAffirmSetting/queryTransactionExceptionPage.do',
		success : function(result) {
			var result = $.parseJSON(result);
			$("#trxAffirmSett_dataGrid").datagrid('loadData', result);
			$("#trxAffirmSett_dataGrid").datagrid("loaded");
		}
	});
}

 
/**
 * 通用下拉列表数据生成
 */
function build_common_combo(id,id_field_name,field1,title1,field2,title2,url){
	$(id).combogrid({
			panelWidth : 300,
			pagination:true,//分页
			url : "",
			onSelect: function(rec){
			},
			toolbar : [ {
				text : '<input type="text" id="taxTransactionTypeInput_id"/>'
			}, {
				text : "查询",
				iconCls : 'icon-search',
				handler : function() {
				}
			}, '-' ],
			columns : [ [ {
				field:id_field_name,
				hidden:'true'
				},{
				field : field1,
				title : title1,
				width : 80
			}, {
				field : field2,
				title : title2,
				width : 120
			} ] ]
		});
		var page = $(id).combogrid('options').pageNumber;
		var pageSizes = $(id).combogrid('options').pageSize;
		var data = "pageNumber="+page +"&pageSize="+pageSizes +
		"&taxTransactionTypeInput_id =" + $('#taxTransactionTypeInput_id').val(); 
		$.ajax({
			url : "${vat}/"+url,//     tmsMdTaxTrxType/loadTaxTransactionType_id.do
			type : "POST",
			data : data,
			dataType : "json", 
			cache : false,
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
				   },
			success : function(result) {
				$(id).combogrid('grid').datagrid(
						'loadData', result);
			}
		});
}

/**
 * 初始化通用下拉框
 */
 function init_common_combo(obj_id){
  	build_common_combo(obj_id,'id','taxTrxTypeCode','涉税交易类型编码','taxTrxTypeName','涉税交易类型名称','tmsMdTaxTrxType/loadTaxTransactionType_id.do');
	  $(obj_id).combogrid('grid').datagrid('options').onClickRow = 
		function(index, row) {
          search = false;
          $(obj_id).combogrid('hidePanel');
          $(obj_id).combogrid('setText', row.taxTrxTypeName);
	}
}

$(document).ready(
		function() {
		
			 init_common_combo("#org");
			 init_common_combo("#businessCategories");
			 init_common_combo("#taxTrxTypeCode_addEdit");
			 init_common_combo("#taxTrsType");
			 init_common_combo("#spitRuleCode");
			 init_common_combo("#taxCategoryId");
			 init_common_combo("#taxItemId");
			 init_common_combo("#accdSegment");
			 init_common_combo("#rule");
			 init_common_combo("#total");
			 init_common_combo("#taxSettingBase");
	        
});
	
function clearSaveForm() {
	$('#addOrEditTrxAffirmSettForm').form('clear');
}

function Remove() {
	if (($('#trxAffirmSett_dataGrid').datagrid('getChecked').length == 0)
			|| ($('#trxAffirmSett_dataGrid').datagrid('getChecked').length > 1)) {
		$.messager.alert("操作提示", "请选择需要删除的数据");
	} else {
		$.messager.confirm("<spring:message code='client.datacommit.delete.confirm.title'/>","<spring:message code='client.datacommit.delete.confirm.text'/>",
		function(result) {
			if (result) {
				var row_list = $('#trxAffirmSett_dataGrid').datagrid('getChecked');
				//var row=$('#clientManageInit_dataGrid').datagrid('getSelected');
				if (row_list) {
					var urlString = "";
					$.each(row_list, function(index, item) {
						if (index == 0)
							urlString += "ids=" + item.id;
						else
							urlString += "&ids=" + item.id;
					});
					
					alert(urlString);
					if (urlString != '') {
						$.ajax({
									url : "${vat}/tmsMdTrxAffirmSetting/removeTmsMdTaxTrxTypes.do",
									type : "POST",
									async : true,
									data : urlString, //不能直接写成 {id:"123",code:"tomcat"}  
									dataType : "json",
									// contentType: "charset=utf-8",  
									cache : false,
									success : function(
											result) {
										Search();
										clearSaveForm();
									}
								});
					}
				}
			}

		});
	}
}



function initTaxEntity() {
	$('#org_addEdit').combogrid(
					{
						required:true,
					    valueField: 'value',
						panelWidth : 600,
						idField : 'id', //ID字段  
						textField : 'orgName', //显示的字段  
						url : "",
						fitColumns : true,
						striped : true,
				//		pageSize:'10',
						editable : false,
						pagination : true, //是否分页
						rownumbers : true, //序号
						collapsible : false, //是否可折叠的
						fit : false, //自动大小
						method : 'post',
						columns : [ [ {
							field : 'orgName',
							title : '组织',
							width : 300
						},{
							field : 'id',
							title : '组织ID',
							width : 300
						} ] ],
						toolbar : [
								{
									text : '数据结构说明:<input type="text" id="taxEntityId" class="easyui-textbox"/>'
								}, {
									text : "查询",
									iconCls : 'icon-search',
									handler : function() {
										findTaxEntity();
									}
								}, '-' ],
						keyHandler : {
							up : function() { //【向上键】押下处理
								//取得选中行
								var selected = $('#org_addEdit').combogrid('grid').datagrid('getSelected');
								if (selected) {
									//取得选中行的rowIndex
									var index = $('#org_addEdit').combogrid('grid').datagrid('getRowIndex',selected);
									//向上移动到第一行为止
									if (index > 0) {
										$('#org_addEdit').combogrid('grid').datagrid('selectRow',index - 1);
									}
								} else {
									var rows = $('#org_addEdit').combogrid('grid').datagrid('getRows');
									$('#org_addEdit').combogrid('grid').datagrid('selectRow',rows.length - 1);
								}
							},
							down : function() { //【向下键】押下处理
								//取得选中行
								var selected = $('#org_addEdit').combogrid('grid').datagrid('getSelected');
								if (selected) {
									//取得选中行的rowIndex
									var index = $('#org_addEdit').combogrid('grid').datagrid('getRowIndex',selected);
									//向下移动到当页最后一行为止
									if (index < $('#org_addEdit').combogrid('grid').datagrid('getData').rows.length - 1) {
										$('#org_addEdit').combogrid('grid').datagrid('selectRow',index + 1);
									}
								} else {
									$('#org_addEdit').combogrid('grid').datagrid('selectRow', 0);
								}
							},

						},

					});

	//取得分页组件对象
	var pager = $('#org_addEdit').combogrid('grid').datagrid('getPager');

	if (pager) {
		$(pager).pagination(
						{
							pageSize : 10,//每页显示的记录条数，默认为10           
							//pageList: [5,10,15,20],//可以设置每页记录条数的列表           
							beforePageText : '<spring:message code="pagination.beforePageText"/>',//页数文本框前显示的汉字           
							afterPageText : '<spring:message code="pagination.afterPageText"/>',
							displayMsg : '<spring:message code="pagination.displayMsg"/>',
							//选择页的处理
							onSelectPage : function(pageNumber, pageSize) {
								//按分页的设置取数据
								$('#getByBaseOrg').form('clear');
								$("#pageNumber1").textbox('setValue',pageNumber);
								$("#pageSize1").textbox('setValue',pageSize);										
								searchBaseOrg();
							},
							//改变页显示条数的处理
					
			/* 				onChangePageSize : function(pageNumber, pageSize) {
								$("#pageNumber1").textbox('setValue',pageNumber);
								$("#pageSize1").textbox('setValue',pageSize);										
								searchBaseOrg();
							}, */
						
						onRefresh : function(pageNumber, pageSize) {
								//按分页的设置取数据
							$('#getByBaseOrg').form('clear');
							$("#pageNumber1").textbox('setValue',pageNumber);
							$("#pageSize1").textbox('setValue',pageSize);										
							searchBaseOrg();
							}
						});
	}
	$('#getByBaseOrg').form('clear');
	$('#getByBaseOrg').form('load',
			{
				pageNumber : $('#org_addEdit').combogrid("grid").datagrid('options').pageNumber,
				  pageSize : $('#org_addEdit').combogrid("grid").datagrid('options').pageSize
			});
	searchBaseOrg();
}
	
function searchBaseOrg(){	
		$.ajax({
			url : "${vat}/baseOrg/loadBaseOrgPage.do",
			type : "POST",
			async : true,
			data : "pageNumber="+$("#pageNumber1").textbox('getValue')+"&pageSize="+$("#pageSize1").textbox('getValue'), //不能直接写成 {id:"123",code:"tomcat"}  
			dataType : "json",
			// contentType: "charset=utf-8",  
			cache : false,
			success : function(result) {
				//clearSaveForm();
				$('#org_addEdit').combogrid('grid')
						.datagrid('loadData', result.data);
			}
		});
}

//##########################################################################################################
function addSelect(){
	
	//全局/组织
	$("#globalOrLocalOgrTypeId").combobox({
		panelHeight:'auto',
		 required:true,
		valueField: 'value',
		textField: 'text',
		editable:false	
	});
	
	$("#businessCategories").combobox({
		panelHeight:'auto',
		 required:true,
		valueField: 'value',
		textField: 'text',
		editable:false,
		data: [{
			text: '进项业务',
			value: '进项业务'
		},{
			text: '销项业务',
			value: '销项业务'
		},{
			text: '不适用',
			value: '不适用'
		}]	
	});
	
	//是否计税
	$("#isAccount").combobox({
		panelHeight:'auto',
		 required:true,
		valueField: 'value',
		textField: 'text',
		editable:false,
		data: [{
			text: '否',
			value: '0'
		},{
			text: '是',
			value: '1'
		}]
	
	});
	
	//价税分离核算规则
	$("#spitRuleCode").combobox({
		panelHeight:'auto',
		 required:true,
		valueField: 'value',
		textField: 'text',
		editable:false,
	});
	
	//开票规则
	$("#rule").combobox({
		panelHeight:'auto',
		 required:true,
		valueField: 'value',
		textField: 'text',
		editable:false,
	});
	
	//计税基础
	$("#taxSettingBase").combobox({
		panelHeight:'auto',
		 required:true,
		valueField: 'value',
		textField: 'text',
		editable:false,
	});
	
	//是否启用
	$("#enabledFlag").combobox({
		panelHeight:'auto',
		 required:true,
		valueField: 'value',
		textField: 'text',
		editable:false,
		data: [{
			text: '否',
			value: '0'
		},{
			text: '是',
			value: '1'
		}]
	});
	//是否含税
	$("#isTax").combobox({
		panelHeight:'auto',
		 required:true,
		valueField: 'value',
		textField: 'text',
		editable:false,
		data: [{
			text: '否',
			value: '0'
		},{
			text: '是',
			value: '1'
		}]
	});
	//属地/汇总
	$("#total").combobox({
		panelHeight:'auto',
		 required:true,
		valueField: 'value',
		textField: 'text',
		editable:false,
	});
	
	 
}
//###############################################################################################################
//税种下拉面板
function initTaxCategoryPanl() {
	$('#taxCategoryId').combogrid(
					{
						required:true,
					    valueField: 'value',
						panelWidth : 600,
						idField : 'id', //ID字段  
						textField : 'categoryName', //显示的字段  
						url : "",
						fitColumns : true,
						striped : true,
				//		pageSize:'10',
						editable : false,
						pagination : true, //是否分页
						rownumbers : true, //序号
						collapsible : false, //是否可折叠的
						fit : false, //自动大小
						method : 'post',
						columns : [ [ {
							field : 'categoryName',
							title : '税种',
							width : 300
						},{
							field : 'id',
							title : '税种ID',
							width : 300
						} ] ],
						toolbar : [
								{
									text : '税种:<input type="text" id="taxEntityId" class="easyui-textbox"/>'
								}, {
									text : "查询",
									iconCls : 'icon-search',
									handler : function() {
										findTaxEntity();
									}
								}, '-' ],
						keyHandler : {
							up : function() { //【向上键】押下处理
								//取得选中行
								var selected = $('#taxCategoryId').combogrid('grid').datagrid('getSelected');
								if (selected) {
									//取得选中行的rowIndex
									var index = $('#taxCategoryId').combogrid('grid').datagrid('getRowIndex',selected);
									//向上移动到第一行为止
									if (index > 0) {
										$('#taxCategoryId').combogrid('grid').datagrid('selectRow',index - 1);
									}
								} else {
									var rows = $('#taxCategoryId').combogrid('grid').datagrid('getRows');
									$('#taxCategoryId').combogrid('grid').datagrid('selectRow',rows.length - 1);
								}
							},
							down : function() { //【向下键】押下处理
								//取得选中行
								var selected = $('#taxCategoryId').combogrid('grid').datagrid('getSelected');
								if (selected) {
									//取得选中行的rowIndex
									var index = $('#taxCategoryId').combogrid('grid').datagrid('getRowIndex',selected);
									//向下移动到当页最后一行为止
									if (index < $('#taxCategoryId').combogrid('grid').datagrid('getData').rows.length - 1) {
										$('#taxCategoryId').combogrid('grid').datagrid('selectRow',index + 1);
									}
								} else {
									$('#taxCategoryId').combogrid('grid').datagrid('selectRow', 0);
								}
							},

						},

					});

	//取得分页组件对象
	var pager = $('#taxCategoryId').combogrid('grid').datagrid('getPager');

	if (pager) {
		$(pager).pagination(
						{
							pageSize : 10,//每页显示的记录条数，默认为10           
							//pageList: [5,10,15,20],//可以设置每页记录条数的列表           
							beforePageText : '<spring:message code="pagination.beforePageText"/>',//页数文本框前显示的汉字           
							afterPageText : '<spring:message code="pagination.afterPageText"/>',
							displayMsg : '<spring:message code="pagination.displayMsg"/>',
							//选择页的处理
							onSelectPage : function(pageNumber, pageSize) {
								//按分页的设置取数据
								$('#getByBaseOrg').form('clear');
								$("#pageNumber1").textbox('setValue',pageNumber);
								$("#pageSize1").textbox('setValue',pageSize);										
								searchTaxCategory();
							},
							//改变页显示条数的处理
					
			/* 				onChangePageSize : function(pageNumber, pageSize) {
								$("#pageNumber1").textbox('setValue',pageNumber);
								$("#pageSize1").textbox('setValue',pageSize);										
								searchBaseOrg();
							}, */
						
						onRefresh : function(pageNumber, pageSize) {
								//按分页的设置取数据
							$('#getByBaseOrg').form('clear');
							$("#pageNumber1").textbox('setValue',pageNumber);
							$("#pageSize1").textbox('setValue',pageSize);										
							searchTaxCategory();
							}
						});
	}
	$('#getByBaseOrg').form('clear');
	$('#getByBaseOrg').form('load',
			{
				pageNumber : $('#taxCategoryId').combogrid("grid").datagrid('options').pageNumber,
				  pageSize : $('#taxCategoryId').combogrid("grid").datagrid('options').pageSize
			});
	searchTaxCategory();
}
	
function searchTaxCategory(){	
		$.ajax({
			url : "${vat}/taxCategory/LoadTaxCategorysName.do",
			type : "POST",
			async : true,
			data : "pageNumber="+$("#pageNumber1").textbox('getValue')+"&pageSize="+$("#pageSize1").textbox('getValue'), //不能直接写成 {id:"123",code:"tomcat"}  
			dataType : "json",
			// contentType: "charset=utf-8",  
			cache : false,
			success : function(result) {
				//clearSaveForm();
				$('#taxCategoryId').combogrid('grid').datagrid('loadData', result.data);
			}
		});
}

//###############################################################
//税目下拉面板
function initItemsPanl() {
	$('#taxItemId').combogrid(
					{
						required:true,
					    valueField: 'value',
						panelWidth : 600,
						idField : 'id', //ID字段  
						textField : 'taxItemName', //显示的字段  
						url : "",
						fitColumns : true,
						striped : true,
				//		pageSize:'10',
						editable : false,
						pagination : true, //是否分页
						rownumbers : true, //序号
						collapsible : false, //是否可折叠的
						fit : false, //自动大小
						method : 'post',
						columns : [ [ {
							field : 'itemName',
							title : '税目',
							width : 300
						},{
							field : 'id',
							title : '税目ID',
							width : 300
						} ] ],
						toolbar : [
								{
									text : '税目:<input type="text" id="taxEntityId" class="easyui-textbox"/>'
								}, {
									text : "查询",
									iconCls : 'icon-search',
									handler : function() {
										findTaxEntity();
									}
								}, '-' ],
						keyHandler : {
							up : function() { //【向上键】押下处理
								//取得选中行
								var selected = $('#taxItemId').combogrid('grid').datagrid('getSelected');
								if (selected) {
									//取得选中行的rowIndex
									var index = $('#taxItemId').combogrid('grid').datagrid('getRowIndex',selected);
									//向上移动到第一行为止
									if (index > 0) {
										$('#taxItemId').combogrid('grid').datagrid('selectRow',index - 1);
									}
								} else {
									var rows = $('#taxItemId').combogrid('grid').datagrid('getRows');
									$('#taxItemId').combogrid('grid').datagrid('selectRow',rows.length - 1);
								}
							},
							down : function() { //【向下键】押下处理
								//取得选中行
								var selected = $('#taxItemId').combogrid('grid').datagrid('getSelected');
								if (selected) {
									//取得选中行的rowIndex
									var index = $('#taxItemId').combogrid('grid').datagrid('getRowIndex',selected);
									//向下移动到当页最后一行为止
									if (index < $('#taxItemId').combogrid('grid').datagrid('getData').rows.length - 1) {
										$('#taxItemId').combogrid('grid').datagrid('selectRow',index + 1);
									}
								} else {
									$('#taxItemId').combogrid('grid').datagrid('selectRow', 0);
								}
							},

						},

					});

	//取得分页组件对象
	var pager = $('#taxItemId').combogrid('grid').datagrid('getPager');

	if (pager) {
		$(pager).pagination(
						{
							pageSize : 10,//每页显示的记录条数，默认为10           
							//pageList: [5,10,15,20],//可以设置每页记录条数的列表           
							beforePageText : '<spring:message code="pagination.beforePageText"/>',//页数文本框前显示的汉字           
							afterPageText : '<spring:message code="pagination.afterPageText"/>',
							displayMsg : '<spring:message code="pagination.displayMsg"/>',
							//选择页的处理
							onSelectPage : function(pageNumber, pageSize) {
								//按分页的设置取数据
								$('#getByBaseOrg').form('clear');
								$("#pageNumber1").textbox('setValue',pageNumber);
								$("#pageSize1").textbox('setValue',pageSize);										
								searchTaxCategory();
							},
							//改变页显示条数的处理
					
			/* 				onChangePageSize : function(pageNumber, pageSize) {
								$("#pageNumber1").textbox('setValue',pageNumber);
								$("#pageSize1").textbox('setValue',pageSize);										
								searchBaseOrg();
							}, */
						
						onRefresh : function(pageNumber, pageSize) {
								//按分页的设置取数据
							$('#getByBaseOrg').form('clear');
							$("#pageNumber1").textbox('setValue',pageNumber);
							$("#pageSize1").textbox('setValue',pageSize);										
							searchTaxCategory();
							}
						});
	}
	$('#getByBaseOrg').form('clear');
	$('#getByBaseOrg').form('load',
			{
				pageNumber : $('#taxCategoryId').combogrid("grid").datagrid('options').pageNumber,
				  pageSize : $('#taxCategoryId').combogrid("grid").datagrid('options').pageSize
			});
	searchItems();
}
	
function searchItems(){	
		$.ajax({
			url : "${vat}/taxitems/LoadgetItemsName.do",
			type : "POST",
			async : true,
			data : "pageNumber="+$("#pageNumber1").textbox('getValue')+"&pageSize="+$("#pageSize1").textbox('getValue'), //不能直接写成 {id:"123",code:"tomcat"}  
			dataType : "json",
			// contentType: "charset=utf-8",  
			cache : false,
			success : function(result) {
				//clearSaveForm();
				$('#taxItemId').combogrid('grid').datagrid('loadData', result.data);
			}
		});
}



</script>


</html>