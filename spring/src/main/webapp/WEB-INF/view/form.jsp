<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>
<title>Train Details</title>
<link rel="stylesheet" type="text/css" href="/spring/URLToReachResourcesFolder/resources/file2.css">
</head>
<body>

<div align="center">
<br>
<br>
<h1 style="color:#193498; font-family:Times New Roman;font-size:40px;"><i>Train Details</i></h1>

<form action="">
<table border="1">
    <tr>
    <th>Train Number</th>
    <th>Train Name</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Ticket Price</th>
    </tr>

    <c:forEach var="train" items="${trains}">
    <tr>
    <td>${train.trainNo}</td>
    <td>${train.trainName}</td>
    <td>${train.source}</td>
    <td>${train.destination}</td>
    <td>${train.ticketPrice}</td>
    </tr>
    </c:forEach>
    </table>

<br>
    <a href="index.jsp" class="button">main menu</a>
</div>
</form>
</body>

</html>