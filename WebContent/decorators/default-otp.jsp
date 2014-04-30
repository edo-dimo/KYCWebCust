<%@ include file="/include/taglibs.jsp" %>
<title>Layanan Pelanggan DIMO</title>
<head>
	<link rel="stylesheet" href="${ctxPath}/css/jquery.realperson.css">
	<link rel="stylesheet" type="text/css" media="screen" title="default" href="${ctxPath}/css/login.css" />
	
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
			 $('#countrycode').val("62");
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

<div id="body" align="center">
	<div id="wrapper">			
	
		<form action="index.do" method="post" class="login-form" 
			name="frm" onsubmit="notEmpty(document.getElementById('defaultReal'), document.getElementById('mdn'))">
	
			
			<div class="header">
				<div align="center">
					<a class="logo" href="${ctxPath}/index.html"> <img
						src="${ctxPath}/images/DIMO.png" width="230" height="85">
					</a>	
					<div style="font-family:'Arial'; font-size: 11pt; color: #303030; font-weight:bold;">
							Selamat datang di layanan pelanggan DIMO</div>												
				</div>
			</div>
			
			<div class="content">
				<div style="font-family:'Arial'; font-size: 9pt; color: red; margin-top: -8px;">${errors}</div>
				<select id="countrycode" name="countrycode" class="input username">
					<c:forEach items="${countryCodeList}" var="item">
						<option value="${item.code}">${item.description}-${item.code}</option>
					</c:forEach>
				</select>
				
				<input type="text" id="mdn" name="mdn" class="input username" placeholder="Masukkan No HP" />
				<!-- <input name="j_username" type="text" class="input username" placeholder="Username" />  -->
					
				<div>&nbsp;</div>				
				<div style="margin:top=50px;"> <input type="text" id="defaultReal" name="defaultReal" class="input username" placeholder="Masukkan kode diatas" /> </div>				
				
			</div>

			<div class="footer" align="center">
				<input type="submit" name="submit" value="Request SMS Token" class="button" />
			</div>
			
		</form>
		<div style="font-family:'Arial'; font-size: 8pt; color: #383838 ; margin-top: 8px;">
				best viewed with Mozilla Firefox 3.6 or higher</div>
	</div>
	
	<div class="gradient"></div>
</div>

