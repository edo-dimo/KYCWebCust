<%@ include file="/include/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dokumen - id</title>
</head>
<body>
	<img src="${pathIDImage}${customer.customerIDPhoto}" width="300" height="300" />
	
	<br>
	<table border="0" width="1000">
		<tr>
			<td >
				<form:form action="" enctype="multipart/form-data" commandName="uploadItem" method="POST" name="form">
					<c:choose>
						<c:when test="${customer.stat.statusid == '3' || customer.stat.statusid == '5' || customer.stat.statusid == '6' || customer.stat.statusid == '7'}">
							<div class="table">
							<table class="listing form">
								<tr>
					                <th class="full" colspan="4">Upload Scanned Document</th>
					            </tr>  								
								<tr>									
									<td> <form:input path="fileData" type="file" /> </td>
								</tr>
								<tr>
									<td align="right"> <input type="submit" value="UNGGAH" name="submit"> </td>
								</tr>
							</table>
							</div>
						</c:when>
					</c:choose>
				</form:form>
			</td>
		</tr>
	</table>
</body>
</html>