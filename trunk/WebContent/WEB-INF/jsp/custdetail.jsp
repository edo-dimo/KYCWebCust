<%@ include file="/include/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Detail</title>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("input[type=submit], input[type=button]").button();
		});			
			
	</script>
	&nbsp;&nbsp;

	<br>
	<div class="table">
		<form:form commandName="customer" name="form"
			action="approverprocess.do">
			<font size="3" color="red">Status:
				${customer.stat.customerdescription}</font>
			<table width="100%" class="listing form">
				<tr>
					<th class="full" colspan="4">Customer Details</th>
				</tr>
				<tr>
					<td class="first" width="25%">First Name</td>
					<td class="last" width="25%"><form:input path="firstName"
							readonly="true" /> <form:hidden path="id" /></td>
					<td class="first" width="25%">Last Name</td>
					<td class="last" width="25%"><form:input readonly="true"
							path="lastName" /></td>
				</tr>
				<tr>
					<td class="first" width="25%">Mobile Number</td>
					<td class="last" width="25%"><form:input readonly="true"
							path="mobileNumber" /></td>
					<td class="first" width="25%">Other Mobile Number</td>
					<td class="last" width="25%"><form:input readonly="true"
							path="otherMobileNumber" /></td>
				</tr>
				<tr>
					<td class="first" width="25%">Place Of Birth</td>
					<td class="last" width="25%"><form:input readonly="true"
							path="placeOfBirth" /></td>
					<td class="first" width="25%">Date Of Birth</td>
					<td class="last" width="25%"><form:input readonly="true"
							path="dateOfBirth" /></td>
				</tr>
				<tr>
					<td class="first" width="25%">ID Type</td>
					<td class="last" width="25%"><c:choose>
							<c:when test="${customer.typeId == '1'}">
								<input type="text" readonly="readonly" value="KTP" />
							</c:when>
							<c:when test="${customer.typeId == '2'}">
								<input type="text" readonly="readonly" value="SIM" />
							</c:when>
							<c:when test="${customer.typeId == '3'}">
								<input type="text" readonly="readonly" value="Passport" />
							</c:when>
							<c:when test="${customer.typeId == '4'}">
								<input type="text" readonly="readonly" value="KITAS" />
							</c:when>
						</c:choose> <form:hidden path="typeId" /></td>
					<td class="first" width="25%">ID Number</td>
					<td class="last" width="25%"><form:input readonly="true"
							path="numberId" /></td>
				</tr>
				<tr>
					<td class="first" width="25%">Citizenship</td>
					<td class="last" width="25%"><c:choose>
							<c:when test="${customer.citizenshipFromID == '1'}">
								<input type="text" readonly="readonly" value="WNI" />
							</c:when>
							<c:when test="${customer.citizenshipFromID == '2'}">
								<input type="text" readonly="readonly" value="WNA" />
							</c:when>
						</c:choose> <form:hidden path="citizenshipFromID" /></td>
					<td class="first" width="25%">Occupation (Based on ID)</td>
					<td class="last" width="25%"><c:choose>
							<c:when test="${customer.occupationFromID == '1'}">
								<input type="text" readonly="readonly" value="Civil Servant" />
							</c:when>
							<c:when test="${customer.occupationFromID == '2'}">
								<input type="text" readonly="readonly" value="Private Employee" />
							</c:when>
							<c:when test="${customer.occupationFromID == '3'}">
								<input type="text" readonly="readonly" value="Professional" />
							</c:when>
							<c:when test="${customer.occupationFromID == '4'}">
								<input type="text" readonly="readonly" value="Student" />
							</c:when>
							<c:when test="${customer.occupationFromID == '5'}">
								<input type="text" readonly="readonly" value="Housewife" />
							</c:when>
						</c:choose> <form:hidden path="occupationFromID" /></td>
				</tr>
				
				<tr>
					<td class="first" width="25%">Email</td>
					<td colspan="3" class="last"><form:input readonly="true"
							path="email" cssStyle="width:20em" /></td>
				</tr>
				<tr>
					<th class="full" colspan="4">Address (as per ID)</th>
				</tr>
				<tr>
					<td class="first" width="25%">Address 1</td>
					<td colspan="3" class="last"><form:textarea rows="2"
							readonly="true" path="address1FromID"
							cssStyle="width:30em;  font-size:12" /></td>
				</tr>
				<tr>
					<td class="first" width="25%">Address 2</td>
					<td colspan="3" class="last"><form:textarea rows="2"
							readonly="true" path="address2FromID"
							cssStyle="width:30em; font-size:12" /></td>

				</tr>
				<tr>
					<td class="first" width="25%">City</td>
					<td colspan="3" class="last"><form:input readonly="true"
							path="cityFromID" cssStyle="width:20em" /></td>
				</tr>
				<tr>
					<td class="first" width="25%">Province</td>
					<td class="last" width="25%"><form:input readonly="true"
							path="provinceFromID" cssStyle="width:13em" />
					<td class="first" width="25%">Postal Code</td>
					<td class="last" width="25%"><form:input readonly="true"
							path="postalCodeFromID" /></td>
				</tr>
				<tr>
					<th class="full" colspan="4">Residential Address</th>
				</tr>
				<tr>
					<td class="first" width="25%">Address 1</td>
					<td colspan="3" class="last"><form:textarea rows="2"
							readonly="true" path="address1Resident"
							cssStyle="width:30em; font-size:12" /></td>
				</tr>
				<tr>
					<td class="first" width="25%">Address 2</td>
					<td colspan="3" class="last"><form:textarea readonly="true"
							path="address2Resident" cssStyle="width:30em; font-size:12" /></td>
				</tr>
				<tr>
					<td class="first" width="25%">City</td>
					<td colspan="3" class="last"><form:input readonly="true"
							path="cityResident" cssStyle="width:20em" /></td>
				</tr>
				<tr>
					<td class="first" width="25%">Province</td>
					<td class="last" width="25%"><form:input readonly="true"
							path="provinceResident" cssStyle="width:13em" /></td>
					<td class="first" width="25%">Postal Code</td>
					<td class="last" width="25%"><form:input readonly="true"
							path="postalCodeResident" /></td>
				</tr>
				
			</table>
		</form:form>
	</div>
</body>
</html>
