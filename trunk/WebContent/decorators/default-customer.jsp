<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<%@ include file="/include/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<title>Layanan Pelanggan Uangku</title>
<head>
	<link rel="stylesheet" href="${ctxPath}/css/jquery.realperson.css">
	<style type="text/css">
		label { display: inline-block; width: 20%; }
		.realperson-challenge { display: inline-block }
		#errmsg {color: red};
	</style>		
	
	<link rel="stylesheet" type="text/css" media="screen,projection,print" href="${ctxPath}/css/all.css"/>
	<link rel="stylesheet" type="text/css" media="screen,projection,print" href="${ctxPath}/css/table_list.css"/>
	<link rel="stylesheet" type="text/css" media="screen,projection,print" href="${ctxPath}/css/layout.css"/>
	<link rel="stylesheet" type="text/css" media="screen,projection,print" href="${ctxPath}/css/south-street.css"/> 
	<script  type="text/javascript" src="${ctxPath}/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctxPath}/js/jquery.realperson.js"></script>
	
	<script type="text/javascript">
		$(function() {
			$('#defaultReal').realperson();								
		});	
		
		$(document).ready(function() {				 
			 CheckValidate();
			  //called when key is pressed in textbox
			  $("#mdn").keypress(function (e) {
			     //if the letter is not digit then display error and don't type anything
			     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {				        
			        $("#errmsg").html("Input MDN with Numeric value only!").show().fadeOut(2000);				        
			        return false;
			    }
			   });
		});
		
		function CheckValidate() {			    
		    $('#submit').click(
	    		function() {
	    			var numericExpression = /^[0-9]+$/;
	    			if ($('#defaultReal').val() == ""){          
    			      alert("Please Enter Captcha");
    			      return false;
    			    }
	    			if ($('#mdn').val() == ""){          
    			      alert("Please Enter MDN");
    			      return false;
    			    }		    					    		
	    			return true;
	    		} 
	    	);
		}					
	</script>
</head>

<div id="main">

 	 <div style="padding-top:3px;padding-left:13px">
	 	<img alt="" src="${ctxPath}/images/layanan_ pelanggan_ uangku_web_ banner.png" width="967" height="90">
	 </div>
	
	<div id="header">
	<%-- 	<img src="${ctxPath}/images/banner.png" width="990" height="95" >
        <div align="right">
			<a class="logo" href="${ctxPath}/index.html"> <img
				src="${ctxPath}/images/DIMO.png" width="200" height="70" align="top">
			</a>
		</div> --%>
		<%-- <ul id="top-navigation">        	        	
        	<sec:authorize access="hasAnyRole('ROLE_CUSTOMER')">
        		<li class="active"><span><span><a href="${ctxPath}/custstatus.do">Main Page</a></span></span></li>
        	</sec:authorize>
        </ul> --%>
	</div>
                 
    <div id="middle">
     	<div id="left-column">
     		
     		<h3>Main</h3> 
     		<ul class="nav">
				<li><a href="${ctxPath}/status.do">Status Pelanggan</a></li>
				<li><a href="${ctxPath}/detail.do">Detil Pelanggan</a></li>			
			</ul>
     		
     		<h3>Document</h3> 
     		<ul class="nav">
				<li><a href="${ctxPath}/viewid.do">Tanda Pengenal</a></li>
				<li><a href="${ctxPath}/viewform.do">Form Aplikasi</a></li>			
			</ul>
     	</div>         
	     	
     	<div id="center-column">
            <div class="top-bar">
                <h1><decorator:title/></h1>
            </div>
            <div class="table">
                <decorator:body/>
            </div>
        </div>
	        
        <div id="right-column">
            <div style="margin-left: 20px;margin-top: 10px;">
				<a class="" title="Logout" href="/KYCWebCust/j_spring_security_logout">
					<img height="30px" src="/KYCWebCust/images/logout.gif" alt="">
				</a>
			</div>
        </div>
     </div>
     
    <div id="footer">
       	<br>
       	<div style="text-align:center;">Copyright &copy; 2013 Smartfren Telecom&nbsp;&nbsp;|&nbsp;&nbsp;All Rights Reserved</div>
    </div>
</div>

