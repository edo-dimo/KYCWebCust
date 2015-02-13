<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<title></title>
<head>
	<link rel="stylesheet" href="${ctxPath}/css/jquery.realperson.css">
	<style type="text/css">
		label { display: inline-block; width: 20%; }
		.realperson-challenge { display: inline-block }
		#errmsg {color: red};
	</style>		
	
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
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

<div id="body" align="center" >
	<img src="${ctxPath}/img/DIMO.png" alt="DIMO"> 	
	<p style="font-family:arial;color:blue;font-size:13px;"> Selamat Datang di Layanan Pelanggan </p>
	<div style="margin-top:80px" ></div>
	<decorator:body />
</div>

