<%@ include file="/include/taglibs.jsp" %>
<title>Layanan Pelanggan BBMPAY</title>
<head>
	<link rel="stylesheet" href="${ctxPath}/css/jquery.realperson.css">
	<link rel="stylesheet" type="text/css" media="screen" title="default" href="${ctxPath}/css/login.css" />
	<link rel="stylesheet" type="text/css" media="screen" title="default" href="${ctxPath}/css/login.css" />
	<style type="text/css">
		label { display: inline-block; width: 20%; }
		.realperson-challenge { display: inline-block }
		#errmsg {color: red};
	</style>
		
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

<div id="body" align="center" >
	<div id="wrapper">
		<form id="slick-login" class="login-form" action="<c:url value='j_security_check'/>" method="post" >
			

			<div class="header">
				<div align="center">
					<a class="logo" href="${ctxPath}/index.html"> <img
						src="${ctxPath}/images/BBMPAY.png" width="230" height="85">
					</a>
					<div style="font-family:'Arial'; font-size: 10pt; color: #303030; font-weight: bold">
							Selamat datang di layanan pelanggan BBMPAY</div>
				</div>
				<%-- <span><font color="red">${error}</font></span> --%>
			</div>
			
			<div style="font-size:11px;">
				<c:if test="${not empty param.error}">
					<c:set var="msg" value="${SPRING_SECURITY_LAST_EXCEPTION.message}"></c:set>
					<c:choose>
						<c:when test="${msg == 'User account has expired'}">						
							<div align=center style="color:#FF0000"> User account has expired.</div>						
						<br>
						</c:when>
						<c:when test="${msg == 'User is disabled'}">						
							<div align=center style="color:#FF0000">User is Already Inactive, Please Contact Admin</div>
							<br>
						</c:when>	
						<c:when test="${msg == 'Bad credentials'}">						
							<div align=center style="color:#FF0000">Login Failed ,we couldn't verify your MDN or OTP</div>
							<br>
						</c:when>
						<c:when test="${msg == 'Your account has been lock'}">						
							<div align=center style="color:#FF0000">Your account has been lock due to multiple fail login attemps. Please contact administrator</div>
							<br>
						</c:when>
						<c:otherwise>
							<div align=center style="color:#FF0000">${msg}</div>
						</c:otherwise>
					</c:choose>        				
				</c:if>		
			</div>
			
			<div class="content">								
				<c:choose>
					<c:when  test="${not empty param.error}">
					 	<input type="text" style="border:none" name="j_username" id="login"  class="input username" placeholder="enter mdn" readonly="readonly" 
					 		value='<c:if test="${not empty param.error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'>
					</c:when>
					<c:otherwise>
					 	<input type="text"  style="border:none" name="j_username" id="login" class="input username" placeholder="Masukkan No HP" readonly="readonly" 
					 		value="${mdn}" >
					</c:otherwise>
				</c:choose>
							
				<div align="right" style="font-family:'Arial'; font-size: 10pt; color: #d4dedf ; margin-top: 8px;">
						<a href="javascript:ResendOTP()"><img src="${ctxPath}/images/token.png" width="127" height="30"></a> </div>		
											
				<input type="password" name="j_password" id="password" class="input password" placeholder="Masukkan Kode SMS">
			</div>

			<div class="footer">
				<input type="submit" name="submit" value="Login" class="button" />
			</div>		
		</form>
		<br>
		
		<div style="font-family:'Arial'; font-size: 8pt; color: #383838 ; margin-top: 8px;">
				best viewed with Mozilla Firefox 3.6 or higher</div>
	</div>
	<div class="gradient"></div>
	
	<script type="text/javascript">
		function ResendOTP() {
			
			var mobileNumber = $("#login").val();	
			if (mobileNumber != "") {
				var params = {
					mobileNumber : mobileNumber
				};
				var param = jQuery.param(params);
				$
						.ajax({
							url : "${ctxPath}/sendotp.do?",
							dataType : "json",
							data : param,
							success : function(result) {
								
								if(result == '0'){
									alert("successfully resend OTP");										
								}									
							},
							error : function() {
								alert("Error during process");
							},
							complete : function() {									
							}
						});
			} else {
				/* $("#login").attr('readonly', false); */
				alert("Insert MDN first.");
			}			
		}
	</script>	
</div>

