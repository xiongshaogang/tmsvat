<#assign classbody>
<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<?xml version="1.0" encoding="UTF-8"?>
<view>
  <Datasets>
    <Dataset type="Form" id="dsQuery" objectClazz="${pojo.getPackageName()}.model.${declarationName}">
      <MasterLink/>
      <Fields>
        <#foreach field in pojo.getAllPropertiesIterator()>
		<#if pojo.getMetaAttribAsBool(field, "gen-property", true)> 
				<#if field.getValue().getClass().getName() == "org.hibernate.mapping.SimpleValue">
					<#foreach col in field.getValue().getConstraintColumns()>
		<Field name="${field.name}" <#if col.comment?exists>label="${col.comment}"</#if> dataType="${pojo.getJavaTypeName(field, jdk5).toLowerCase()}">
          <Properties/>
        </Field>
					</#foreach>
				</#if>			
		 </#if>
		</#foreach>
      </Fields>
      <Parameters/>
      <Properties/>
    </Dataset>
    <Dataset method="load${declarationName}Page" type="Wrapper" async="false" autoLoadData="true" id="dsEntity" objectClazz="${pojo.getPackageName()}.model.${declarationName}" wrappedType="Marmot" showLoadingTip="false" dataProvider="${pojo.getDeclarationNameFirstLetterLower()}View">
      <MasterLink/>
      <Fields>
        <Field name="select" type="Dummy" dataType="boolean">
          <Properties/>
        </Field>
        <#foreach field in pojo.getAllPropertiesIterator()>
		<#if pojo.getMetaAttribAsBool(field, "gen-property", true)> 
				<#if field.getValue().getClass().getName() == "org.hibernate.mapping.SimpleValue">
					<#foreach col in field.getValue().getConstraintColumns()>
		<Field name="${field.name}" <#if col.comment?exists>label="${col.comment}"</#if> dataType="${pojo.getJavaTypeName(field, jdk5).toLowerCase()}">
          <Properties/>
        </Field>
					</#foreach>
				</#if>
				<#if field.getValue().getClass().getName() == "org.hibernate.mapping.Set">
				</#if>
				<#if field.getValue().getClass().getName() == "org.hibernate.mapping.ManyToOne">
		<Field name="${field.name}.id" dataType="long">
          <Properties/>
        </Field>
				</#if>				
		 </#if>
		</#foreach>
		</Fields>
      <Parameters/>
      <Properties/>
    </Dataset>
    <#--<Dataset method="loadDatasetEnum" type="Wrapper" id="datasetPadStatu" objectClazz="com.newtouch.common.DictionaryEntity" wrappedType="Marmot" dataProvider="enumView">
      <MasterLink/>
      <Fields>
        <Field name="name" dataType="string" property="name">
          <Properties/>
        </Field>
        <Field name="code" dataType="string" property="code">
          <Properties/>
        </Field>
      </Fields>
      <Parameters>
        <Parameter dataType="string" name="categoryCode" value="pad_statu"/>
      </Parameters>
      <Properties/>
    </Dataset>
    -->
  </Datasets>
  <Controls>
    <Control type="AutoForm" dataset="dsQuery" id="frmQuery" width="100%">
      <FormGroup name="group0" title="查询条件">
      <#foreach field in pojo.getAllPropertiesIterator()>
		<#if pojo.getMetaAttribAsBool(field, "gen-property", true)> 
				<#if field.getValue().getClass().getName() == "org.hibernate.mapping.SimpleValue">
					<#foreach col in field.getValue().getConstraintColumns()>
        <Element name="${field.name}" type="TextEditor" field="${field.name}">
          <FieldLabel/>
          <TextEditor/>
        </Element>      
					</#foreach>
				</#if>		
		</#if>
	  </#foreach>
      </FormGroup>
    </Control>
    <Control id="btnQuery" width="80" command="cmdQuery" type="Button" value="查询"/>
    <Control id="cmdQuery" queryDataset="dsEntity" type="QueryCommand" conditionDataset="dsQuery">
      <Parameters/>
      <Events>
        <Event name="beforeExecute">/*&#xD; var value = dsQuery.getValue(&quot;FIELD_NAME&quot;);&#xD; var parameters = command.parameters();&#xD; if (value){&#xD; parameters.setValue(&quot;FIELD_NAME&quot;,	&quot;%&quot; + value + &quot;%&quot;)&#xD; }&#xD;*/&#xD;
				</Event>
        <Event name="onSuccess">//cmdQuery.parameters().clear();
				</Event>
      </Events>
    </Control>
    <Control id="btnReset" width="80" type="Button" value="重置">
      <Events>
        <Event name="onClick">window.location.reload();&#xD;
				</Event>
      </Events>
    </Control>
    <Control id="btnNew" width="80" type="Button" value="新建">
      <Events>
        <Event name="onClick">dsEntity.setCurrent(dsEntity.insertRecord());&#xD;&#xD; win1.setTitle(&quot;新增&quot;);&#xD;win1.show(true,true);				</Event>
      </Events>
    </Control>
    <Control id="btnDelete" width="80" command="cmdDelete" type="Button" value="删除选中">
      <Events/>
    </Control>
    <Control method="execCommandRemove" id="cmdDelete" action="/update.do?resolver=${pojo.getDeclarationNameFirstLetterLower()}View" type="UpdateCommand">
      <DatasetInfos>
        <DatasetInfo dataset="dsEntity"/>
      </DatasetInfos>
      <Parameters/>
      <Events>
        <Event name="beforeExecute">&#xD;if (!confirm(&quot;确认删除?&quot;)) {&#xD;    return false;&#xD;}&#xD;dsEntity.disableControls();&#xD;try {&#xD;    dsEntity.moveFirst();&#xD;    while (!dsEntity.isLast()) {&#xD;        if (dsEntity.getCurrent() &amp;&amp; dsEntity.getValue(&quot;select&quot;)) {&#xD;            dsEntity.deleteRecord();&#xD;        }&#xD;        else {&#xD;            dsEntity.moveNext();&#xD;            &#xD;        }&#xD;    }&#xD;}&#xD;finally {&#xD;    dsEntity.enableControls();&#xD;}&#xD;</Event>
      </Events>
    </Control>
    <Control width="100%" readOnly="true" height="100%" showHScrollBar="false" id="tblEntity" dataset="dsEntity" type="DataTable">
      <Column field="select" name="select"/>
      <#foreach field in pojo.getAllPropertiesIterator()>
		<#if pojo.getMetaAttribAsBool(field, "gen-property", true)> 
				<#if field.getValue().getClass().getName() == "org.hibernate.mapping.SimpleValue">
					<#foreach col in field.getValue().getConstraintColumns()>
      <Column field="${field.name}" name="${field.name}"/>
					</#foreach>
				</#if>		
		</#if>
	  </#foreach>
    </Control>
    <Control id="pageEntity" dataset="dsEntity" type="PagePilot"/>
    <Control type="AutoForm" dataset="dsEntity" id="frmEntity">
      <FormGroup name="group0" showBevel="false">
      <#foreach field in pojo.getAllPropertiesIterator()>
		<#if pojo.getMetaAttribAsBool(field, "gen-property", true)> 
				<#if field.getValue().getClass().getName() == "org.hibernate.mapping.SimpleValue">
					<#foreach col in field.getValue().getConstraintColumns()>
        <Element name="${field.name}" type="TextEditor" field="${field.name}">
          <FieldLabel/>
          <TextEditor/>
        </Element>      
					</#foreach>
				</#if>		
		</#if>
	  </#foreach>
      </FormGroup>
    </Control>
    <Control method="execCommandSave" id="cmdSave" action="/update.do?resolver=${pojo.getDeclarationNameFirstLetterLower()}View" type="UpdateCommand">
      <DatasetInfos>
        <DatasetInfo submitScope="all-change" dataset="dsEntity"/>
      </DatasetInfos>
      <Parameters/>
      <Events/>
    </Control>
    <Control id="btnSave" width="80" type="Button" value="保存">
      <Events>
        <Event name="onClick">if(dsEntity.postRecord()){&#xD;
	  win1.hide();&#xD;	  cmdSave.execute();&#xD;
	  dsEntity.flushData();&#xD;
	}&#xD;
	</Event>
      </Events>
    </Control>
    <Control id="btnCancel" width="80" type="Button" value="取消">
      <Events>
        <Event name="onClick">dsEntity.cancelRecord();&#xD;
	win1.hide();</Event>
      </Events>
    </Control>
    <Control id="buttonModify" width="80" type="Button" value="修改">
      <Events>
        <Event name="onClick">var record = getFirstSelected(dsEntity);&#xD;
if (record != null) {&#xD;
    win1.setTitle(&quot;修改&quot;);&#xD;
    win1.show(true, true);&#xD;
}&#xD;</Event>
      </Events>
    </Control>
    <#--<Control valueField="code" type="DatasetDropDown" fixed="true" labelField="name" dataset="datasetpadios" id="dropdownpadios" mapValue="true"/>
  -->
  </Controls>
  <Properties/>
  <Events>
    <Event name="functions">function getFirstSelected(dsEntity){&#xD;
    var record = dsEntity.getFirstRecord();&#xD;
    while (record != null) {&#xD;
        if (record.getValue(&quot;select&quot;)) &#xD;
            return record;&#xD;
        record = record.getNextRecord();&#xD;
    }&#xD;
    alert(&quot;你没有选择一条记录&quot;);&#xD;
    return null;&#xD;
}&#xD;function getselectids(dsEntity) {&#xD;
  var record = dsEntity.getFirstRecord();&#xD;
  var selectids=&quot;&quot;;&#xD;
  var i=0;&#xD;
  while (record != null) {&#xD;
    if(record.getValue(&quot;select&quot;)) {&#xD;
      if(i==0)&#xD;
        selectids=record.getValue(&quot;operatorid&quot;);&#xD;
      else&#xD;
        selectids=selectids+&quot;,&quot;+record.getValue(&quot;operatorid&quot;);&#xD;
      i++;&#xD;
    }&#xD;
    record = record.getNextRecord();&#xD;
  }&#xD;
  if(i==0) {&#xD;
    alert(&quot;没有选择记录&quot;);&#xD;
    return null;&#xD;
  }&#xD;
  else {&#xD;
    return selectids;&#xD;
  }&#xD;
}</Event>
  </Events>
</view>
</#assign>
${classbody}
