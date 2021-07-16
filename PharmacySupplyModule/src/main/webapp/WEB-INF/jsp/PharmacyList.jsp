<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Stock Availed</title>
</head>

<body>
<table>
<caption>Stock Supply</caption>
	<thead>
				<tr>
					<th id="element">Pharmacy</th>
					<th id="element">Medicine</th>
					<th id="element">Stock Available</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pharmacyList}" var="ph"><br>
					<tr>
						<td>${ph.pharmacyName}</td>
						<td>${ph.medicineName}</td>
						<td>${ph.supplyCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>