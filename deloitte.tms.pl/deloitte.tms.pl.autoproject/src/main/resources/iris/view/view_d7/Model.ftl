  <Model>
    <DataType name="dataType${declarationName}Param">
      <Property name="creationType">${realPackageAndClassPath}Param</Property>
<#assign fields=pojo.getPojoFields()>
<#foreach field in fields>
<#if field.getIsSampleField()>
      <PropertyDef name="${field.getName()}">
        <Property name="dataType">${field.getDataType()}</Property>
<#if field.getDropdown()?exists><#assign dropdown=field.getDropdown()>
<#if dropdown.dropDownType()=="datasetDropDown">
		<ClientEvent name="onSet">this.onSet${dropdown.relClass()}DropDown(self,arg);&#xD;
</ClientEvent>
        <Validator type="custom">
          <ClientEvent name="onValidate">this.on${dropdown.relClass()}DropDownValidate(self,arg);&#xD;
</ClientEvent>
        </Validator>
</#if>
</#if>
      </PropertyDef>
</#if>
</#foreach>
<#foreach child in many>
<#assign childdeclarationName = child.importType(child.getDeclarationName())>
      <Reference name="rel${child.getDeclarationNameFirstLetterLower()}s">
        <Property name="dataType">[dataType${childdeclarationName}Param]</Property>
        <Property name="dataProvider">${pojoview}#load${childdeclarationName}</Property>
        <Property name="pageSize">10</Property>
        <Property name="parameter">
          <Entity>
            <Property name="${masterid}">${"$"+"$"+"{"+"this.id"+"}"}</Property>
          </Entity>
        </Property>
      </Reference>
</#foreach>
<#foreach child in ones>
<#assign childdeclarationName = child.importType(child.getDeclarationName())>
      <Reference name="rel${child.getDeclarationNameFirstLetterLower()}">
        <Property name="dataType">dataType${childdeclarationName}Param</Property>
        <Property name="dataProvider">${pojoview}#find${childdeclarationName}</Property>
        <Property name="parameter">
          <Entity>
            <Property name="${masterid}">${"$"+"$"+"{"+"this.id"+"}"}</Property>
          </Entity>
        </Property>
      </Reference>
</#foreach>
    </DataType>
    <DataType name="dataTypeQuery${declarationName}">
      <#assign fields=pojo.getPojoFields()>
<#foreach field in fields>
<#if field.getIsSampleField()>
      <PropertyDef name="${field.getName()}">
        <Property name="dataType">${field.getDataType()}</Property>
<#if field.getDropdown()?exists><#assign dropdown=field.getDropdown()>
<#if dropdown.dropDownType()=="datasetDropDown">
		<ClientEvent name="onSet">this.onSet${dropdown.relClass()}DropDown(self,arg);&#xD;
</ClientEvent>
        <Validator type="custom">
          <ClientEvent name="onValidate">this.on${dropdown.relClass()}DropDownValidate(self,arg);&#xD;
</ClientEvent>
        </Validator>
</#if>
</#if>
      </PropertyDef>
</#if>
</#foreach>
    </DataType>
<#foreach child in many>
<#assign childdeclarationName = child.importType(child.getDeclarationName())>
<#assign childpojoclassname = "${child.getPackageName()}.model.${childdeclarationName}">
<#assign childrealPackageAndClassPath = "${child.getRealPackageAndClassPath()}">
    <DataType name="dataType${childdeclarationName}Param">
      <Property name="creationType">${childrealPackageAndClassPath}Param</Property>
<#assign fields=child.getPojoFields()>
<#foreach field in fields>
<#if field.getIsSampleField()>
      <PropertyDef name="${field.getName()}">
        <Property name="dataType">${field.getDataType()}</Property>
      </PropertyDef>
</#if>      
</#foreach>
    </DataType>
</#foreach>
<#foreach child in ones>
<#assign childdeclarationName = child.importType(child.getDeclarationName())>
<#assign childpojoclassname = "${child.getPackageName()}.model.${childdeclarationName}">
<#assign childrealPackageAndClassPath = "${child.getRealPackageAndClassPath()}">
    <DataType name="dataType${childdeclarationName}Param">
      <Property name="creationType">${childrealPackageAndClassPath}Param</Property>
<#assign fields=child.getPojoFields()>
<#foreach field in fields>
<#if field.getIsSampleField()>
      <PropertyDef name="${field.getName()}">
        <Property name="dataType">${field.getDataType()}</Property>
      </PropertyDef>
</#if>      
</#foreach>
    </DataType>
</#foreach>
  </Model>