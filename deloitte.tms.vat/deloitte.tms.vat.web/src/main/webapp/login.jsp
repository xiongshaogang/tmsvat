<%@page import="com.deloitte.tms.pl.core.commons.constant.LoginConstantDef"%>
<%@page import="com.deloitte.tms.pl.core.commons.utils.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="x-border-box x-strict"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<!--<link href="css.css" rel="stylesheet" type="text/css" />-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="content-language" content="zh-CN" />
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="resource/login_files/ext-all.css">

<link rel="stylesheet" type="text/css" href="resource/login_files/font.css">
<link rel="stylesheet" type="text/css" media="all" href="resource/login_files/default.css">
<script type="text/javascript" src="resource/login_files/base64.js"></script>
<style>
body
{
	padding:0; margin:0; 
	text-align:center;
	background-image:url('resource/login_files/bk_201104.png');
	background-repeat:no-repeat;
	background-attachment:fixed;
    background-position: 0 130px;
    font-family:"lucida Grande",Verdana,"Microsoft YaHei";
    font-size:16px;
    position:relative;	
}
.header
{
	text-align:left;
	height:120px;	
	overflow:hidden;
	zoom:1;
	/*background:white;*/	
}
.round
{
	-moz-border-radius: 3px;     
    -webkit-border-radius: 3px; 
    border-radius:3px;
}
.copyright
{
	font-family:"lucida Grande",Verdana,"Microsoft YaHei";
	font-weight:bold;
	text-align:right;
	margin-right:9px;
	margin-top:9px;
	font-size:12px;
}
.shadow
{
	-moz-box-shadow: 1px 1px 3px 1px #333333;
    -webkit-box-shadow: 1px 1px 3px 1px #333333;
    box-shadow: 1px 1px 3px 1px #333333;
    -ms-filter: "progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135, Color='#333333')";
    filter: progid:DXImageTransform.Microsoft.Shadow(Strength=4, Direction=135, Color='#333333');
    
    border: 1px solid #333333;
}
.ulogin
{
	font-family:"幼圆";
	font-weight:bold;
	font-size:24px;
	margin:0 0 0 30px;	
}
.bottomline
{
	border-bottom: 2px solid #01a0e2;
	width:275px;
	padding:0 0 10px 0;

}
.logo
{
	margin:25px 0 0 35px;
}
.inputbox
{
	height:40px;
	width:250px;
	font-family:"lucida Grande",Verdana,"Microsoft YaHei";
	padding:0 0 0 10px;
	font-size:14px;
}
.submit_button
{
	border:none;
	background:#335291;	
	height:37px;
	color:#FFF;
	font-size:18px;
	font-weight:bold;
	-moz-border-radius: 5px;     
    -webkit-border-radius: 5px; 
    border-radius: 5px;
}
.submit_button:hover
{
	background:#01a0e2;
	border:none;
}
.submit_button:active
{
	background:#272763;
	border:none;
}
.btn_login
{
	width:150px;
	margin-right:5px;
}
.btn_reset
{
	width:100px;
}
.pswrc
{
	font-size:14px;
	font-family:"幼圆";
	color:#01a0e2;
}
</style>
</head>

	<body class="x-body x-webkit x-chrome x-reset" id="ext-gen1018">
	  <div class="header">
			<img class="logo" src="resource/login_files/deloitte-logo.png" height="65px">
			<img class="logo" src="resource/login_files/insighttax-logo.png" height="77px">
		</div>	
		<div style="text-align:left;">
			<form autocomplete="off" name="form" class="form" action="security_check_" method="post">
			<div style="padding-top:24px;margin-left:720px;height:430px;width:340px;background:white;text-align:left;" class="round shadow">		
				<div class="ulogin"><div class="bottomline">用户登录</div>
				</div>	
				<div style="margin:30px 0 0 37px;">
					<div>
						<input class="inputbox" name="username" id="username" type="text" placeholder="用户名" value="admin">
					</div>
					<div style="margin-top:20px">
						<input class="inputbox" name="password" id="password" type="password" placeholder="密码" value="admin">
					</div>
					<div style="margin-top:25px">
						<input type="checkbox" name="saveLoginInfo" id="saveLoginInfo">&nbsp;记住用户名密码
				    </div>
				    <div style="margin-top:25px">
				    	<input class="submit_button btn_login" type="button" value="登 录" style="cursor:pointer;" onClick="saveForm();">
				    	<!--<input class="submit_button btn_reset" type="button" value="重 置">-->
				    </div>
				    <div id="error"></div>
				</div>
				<div style="float:right;padding-right:40px;margin-top:95px;margin-bottom:15px;">					
					<!-- <b class="pswrc">密码找回 | 使用说明</b> -->
				</div>
			</div>
			</form>
			<div class="copyright">Copyright © 2015 Deloitte 德勤中国 版权所有</div>
		</div>
	</body>
	<%
	String loginErro=CookieUtils.getCookieValue(request, LoginConstantDef.LOGIN_ERROKEY);
	CookieUtils.cancelCookie(request, response, LoginConstantDef.LOGIN_ERROKEY);
	%>
	<script language="javascript">
		var $$ = function (id) {
			return "string" == typeof id ? document.getElementById(id) : id;
		}
	 	function GetIeVar(){
		    var ua = navigator.userAgent;
			var   strBrowserName   =   navigator.appName;
			if (strBrowserName=="Microsoft Internet Explorer"){
		        	var msieOffset = ua.indexOf("MSIE");
				if (msieOffset >0){
			    	return (ua.substring(msieOffset + 5, ua.indexOf(";", msieOffset)));
				}else{ return (0);}
			}else{
				return (0);
			}
		}
	    if (GetIeVar()>=6){
	
	    }else{
	    	//alert('请使用IE6或以上版本浏览器打开！');
	    }
	    function validate() {
	    	//console.log(document.getElementById("password").value)
	    	if (document.getElementById("username").value == "") {
	    		$$("error").innerHTML='请输入用户名';
	    		return false;
	    	}
	    	if (document.getElementById("password").value == "") {
	    		$$("error").innerHTML='请输入密码';
	    		return false;
	    	}
	    	return true;
	    }

	    function saveForm() {
	    	if (validate()) {
	    		var b = new Base64();  
	    		var pas=document.getElementById("password").value;
	    		 var str = b.encode(pas);  
	    		 document.getElementById("password").value = str;
	    		 document.form.submit();
	    	}
	    }
	    //回车 确定
	    function ShortcutKey() {
	    	var eventKey = window.event || arguments[0];
	    	if (eventKey.keyCode == 13) {
	    		saveForm();
	    	}
	    }
	    document.onkeydown = ShortcutKey;
	    
	    
	    function processLoginErroCode(){
	    	var erroinfo='<%=loginErro%>';
	    	if(erroinfo!=''&&erroinfo!='null'){
	    		alert(erroinfo);
	    	}
	    	/*var LOGIN_ERROKEY="LOGIN_ERROKEY";
	    	var erroinfo = null;
	    	erroinfo = document.cookie.match(new RegExp("(^| )" + LOGIN_ERROKEY + "=([^;]*)(;|$)"));
            if(erroinfo != null){
                erroinfo=decodeURI(erroinfo[2]);
            }
	    	if(erroinfo){
	    		alert(erroinfo);
	    		var exp = new Date();
	            exp.setTime(exp.getTime() - 1);
	    		document.cookie = LOGIN_ERROKEY + "=" + '' + ";expires=" + exp.toGMTString();
	    	}*/
	    }
	    processLoginErroCode();

	</script>
</html>