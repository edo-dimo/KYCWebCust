<%@ include file="/include/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		
		<link rel="stylesheet" href="${ctxPath}/css/jquery.realperson.css">
		<style type="text/css">
			label { display: inline-block; width: 20%; }
			.realperson-challenge { display: inline-block }
			#errmsg {color: red};
			
			.boxed {
			  border: 5px solid green ;
			}
		</style>		
		
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script type="text/javascript" src="${ctxPath}/js/jquery.realperson.js"></script>
		
		<script type="text/javascript">
			/* $(function() {
					
				
			});	 */
			
			$(document).ready(function() {	
				$('#defaultReal').realperson();	
				 CheckValidate();
				  //called when key is pressed in textbox
				  $("#mdn").keypress(function (e) {
				     //if the letter is not digit then display error and don't type anything
				     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {				        
				        $("#errmsg").html("Input MDN with Numeric value only!").show().fadeOut(2000);				        
				        return false;
				    }
				   });
				  
				  $('#countrycode').val("62");
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
	
	<body >	
		<form action="index.do" method="post" name="frm" onsubmit="notEmpty(document.getElementById('defaultReal'), document.getElementById('mdn'))">
			
			
				<c:forEach items="${errors}" var="error">   
				    <div align=left style="color:#FF0000">${error}</div>
				</c:forEach>
						
				<div align=left style="color:#FF0000" id=errmsg></div>
				
				<p style="font-family:arial;color:red;font-size:13px;"><strong>Minta OTP</strong></p>
				
				<table border="0" width=500 style="border-width: 1px; border-color:Grey;border-style: solid;">
					<tr><td align="center">
					<table width="400" border=0>
						<tr>
							<td width="50%" align="left">
								Masukkan Nomor Telepon 5:
							</td>
							<td width="50%" align="left">
								<select id="countryCode" name="countryCode">
									<c:forEach items="${countryCodeList}" var="item">
										<option value="${item.code}">${item.country}-${item.code}</option>
										<%-- <c:choose>
											<c:when test="${item.code==62}">
						                      	<option value="${role.id}" selected="selected"><c:out value="${role.displayName}" /></option>
						                      	<option value="${item.code}" selected="selected"><c:out value="${item.country}-${item.code}"/></option>
						                    </c:when>
						                    <c:otherwise>
						                      	<option value="${item.code}"><c:out value="${item.country}-${item.code}"/></option>
						                    </c:otherwise>
					                    </c:choose> --%>
									</c:forEach>
								</select>
								<input type="text" id="mdn" name="mdn" align="left">
							</td>														
						</tr>
						
						<tr>
							<td>&nbsp;</td>
						</tr>
						
						<tr>
							<td width="50%" valign="bottom" align="left">
								Masukkan Nilai Captcha   :
							</td>
							<td width="50%" align="left">
								<input type="text" id="defaultReal" name="defaultReal">
							</td>
						</tr>
						
						
						<tr>
							<td></td>
							<td align="left"><input type="submit" value="KIRIM" id="submit"></p></td>
						</tr>
					</table>
					</td></tr>
				</table>				
								
		</form>
	</body>
</html>