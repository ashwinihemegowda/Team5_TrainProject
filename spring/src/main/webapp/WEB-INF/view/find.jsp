<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Passenger Details</title>
    <link rel="stylesheet" type="text/css" href="/spring/URLToReachResourcesFolder/resources/file2.css">
</head>

<body>
<form action="take">
<div align="center">
<br>
<br>
<br>
<h2 style="color:#193498; font-family:Times New Roman;font-size:40px;">Enter Your Details</h2>
<table>
<tr>
<td><label for="num1">Enter the Train Number</label></td>
<td>
<select name="num1" id="num1">
  <option value="1001">1001</option>
  <option value="1002">1002</option>
  <option value="1003">1003</option>
  <option value="1004">1004</option>
  <option value="1005">1005</option>
  <option value="1006">1006</option>
</select>
</td>
</tr>
<br/>

<tr>
<td><label for="date">Enter the Travel Date</label></td>
<td><input type ="date" name="date" id="date" min="2021-11-08" required></td>
</tr>

<tr>
<td><label>Name</label></td>
<td><input type="text" name="name" id="name" required></td></tr>

<tr>
<td><label>Age</label></td>
<td><input type="text" name="age" id="age" required></td></tr>

<tr>
<td><label>Enter Gender</label></td>
<td>
<select name="gender" id="gender" required>
   <option></option>
  <option value="M">Male</option>
  <option value="F">Female</option>
</td>
</select>
</tr>
</table>
<br>
<br>
<button class="button">submit</button>
</div>
</form>

</body>
</html>
