<%@ include file="/include/taglibs.jsp" %>
<head>	
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script  type="text/javascript" src="${ctxPath}/js/jquery/jquery.min.js"></script>
	<script  type="text/javascript" src="${ctxPath}/js/jquery/jquery-ui-1.10.0.custom.min.js"></script>
	<script  type="text/javascript" src="${ctxPath}/js/common.js"></script> 	
</head>
<body>	
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
				alert("Insert MDN first.");
			}
			
		}
	</script>
        	
    <form id="slick-login" action="<c:url value='j_security_check'/>" method="post" >
    	<p style="font-family:arial;color:red;font-size:13px;"><strong>Masuk</strong></p>		
       <table border="0" width=600 style="border-width: 1px; border-color:Grey;border-style: solid;">
			<tr>
				<td align="center">	
					<table width="500" border=0>
						<tr>
							<td>Nomor Telepon Genggam:</td>
							<td>
								 <c:choose>
									<c:when  test="${not empty param.error}">										
									 	<input type="text" style="border:none" name="j_username" id="login" class="span12" readonly="readonly" value='<c:if test="${not empty param.error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>' >
									</c:when>
									<c:otherwise>
									 	<input type="text"  style="border:none" name="j_username" id="login" class="span12" readonly="readonly" value="${mdn}" >
									</c:otherwise>
								</c:choose>															
							</td>
							<td> <a href="javascript:ResendOTP()">Resend OTP</a></td>
						</tr>
				     	
				     	<tr>
				     		<td>&nbsp;
				     		</td>
				     	</tr>
				     	
				     	<tr>
							<td>Kode OTP :</td>
							<td>
								<input type="password" name="j_password" id="password" class="span12">
							</td>
							<td>&nbsp;
				     		</td>
						</tr>
				
				   		<tr>
				   			<td>&nbsp;
				     		</td>
				   			<td>
				   				<button type="submit" value="submit" name="submit" class="btn btn-primary pull-right">MASUK</button>
				   			</td>
				   			<td>&nbsp;
				     		</td>
				   		</tr>				   		
	   				</table>	
				</td>
			</tr>
		</table>
			  
			    
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
	</form>	   
	
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("input[type='password']").val('');
		});
	</script>		
					
</body>
	