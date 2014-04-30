<%@ include file="/include/taglibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Status</title>
</head>
<body>
	<p style="font-family:'Arial'; font-size: 8pt; color: #383838 ;font-weight: bold; margin-top: 8px;">
		Welcome, <c:out value="${listCust[0].firstName} "/>  <c:out value="${listCust[0].lastName} "/>
	</p>
	
	<p style="text-align:center;">
		<span style="font-family:'Arial'; font-size: 14pt; color: #383838 ;font-weight: bold; margin-top: 8px; ">
			Terima Kasih. </span><br />				
		<span style="font-family:'Arial'; font-size: 11pt; color: #383838 ;font-weight: bold; margin-top: 8px; ">
			Permintaan Upgrade e-Money Anda Telah Kami Terima.</span>
	</p>	
	
	<p style="text-align:center;">
		<span style="font-family:'Arial'; font-size: 11pt; color: #383838 ;font-weight: bold; margin-top: 8px; ">
			Status upgrade e-Money Anda : </span><br /> 		
		<span style="font-family:'Arial'; font-size: 11pt; color: #0066FF ;font-weight: bold; margin-top: 8px; ">
			<b><c:out value="${listCust[0].stat.customerdescription} "/></b>
		</span>
	</p>
		
	<p style="font-family:'Arial'; font-size: 8pt; color: #383838 ;font-weight: bold; margin-top: 8px; text-align:center;">
		Untuk pertanyaan / informasi lebih lanjut: <br />
		kunjungi www.smartfren.com / hubungi 888(dari nomor Smartfren) atau 021-50100000.
		<br /> <br />
				
	</p>	
	
	<p style="font-family:'Arial'; font-size: 8pt; color: #383838 ;font-weight: bold; margin-top: 8px;">
		Enjoy full features of eMoney once your application is approved
	</p>
		
	<%-- <p style="font-family:'Arial'; font-size: 12pt; color: #383838; margin-top: 8px;">
		Your Next Status is:
		<c:set var="newLine" value="\n" />
		<c:set var="stringBefore" value="${listCust[0].stat.nextstatus}"/>
		<c:set var="stringAfter" value="${fn:replace(stringBefore, newLine, '<br />')}" />	
		${stringAfter}						
	</p> --%>
	<img src="${ctxPath}/images/table.png" width="620" height="330">
	<br><br><br>
	
</body>
</html>