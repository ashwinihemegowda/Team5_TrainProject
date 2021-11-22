<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
  <title>Ticket Details</title>
<link rel="stylesheet" type="text/css" href="/spring/URLToReachResourcesFolder/resources/file2.css">
</head>

<body>
<div align="center">
<form action="confirm">
<h2 style="color:#193498; font-family:Times New Roman;font-size:40px;">Ticket Details</h2>
<table>
 <c:forEach var="train" items="${find}">
     <tr>
     <td>Train no:</td>
     <td><input type="text" value="${train.trainNo}" name="trainNo"readonly></td>
     </tr>
     <tr>
     <td>Train name:</td>
     <td><input type="text" value=${train.trainName} name="trainName" readonly></td>
     </tr>
    <tr>
   <td> Source:</td>
   <td><input type="text" value=${train.source} name="source" readonly></td>
     </tr>
     <tr>
     <td>Destination:</td>
     <td><input type="text" value=${train.destination} name="destination" readonly></td>
     </tr>
          </c:forEach>

      <tr>
       <td><label for="pnr">PNR:</label> </td>
        <td><input type="text" id="pnr" name="pnr" value="${pnr}"> </td>
      </tr>

       <tr>
       <td>Name:</td>
       <td><input type="text" value="${name}" name="name"></td>
       </tr>

       <tr>
       <td>Age:</td>
        <td><input type="text" value="${age}" name="age"></td>
       </tr>

       <tr>
       <td>Gender:</td>
       <td><input type="text" value="${gender}" name="gender"></td>
       </tr>

       <tr>
       <td>Amount:</td>
       <td><input type="text" value="${amount}" name="amount"></td>
       </tr>

       <tr>
        <td>Travel Date:</td>
        <td><input type="text" value="${date}" name="date"></td>
       </tr>

</table>
</div>

<br>
<div align="center">
<button class="button">Book Ticket</button>
</div>

</form>
</body>
</html>











