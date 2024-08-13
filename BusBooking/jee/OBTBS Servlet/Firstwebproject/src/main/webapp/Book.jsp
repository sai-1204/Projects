<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Admin.css">
</head>
<body>
 <header class="header">
            <h1 class="text1">Bus Booking</h1>
            <section class="section1">
               
                <a href="Admin?action=Search" class="link1">Search Buses</a>
                <a href="Admin?action=Bookings" class="link1">MyBookings</a>
                <a href="login.html" class="link1">Logout</a>
            </section>
        </header>
<section class="section3">
       
            <form action="Admin" method="get" class="form2">
                
                <label class="label2">Busno:</label><input type="text" name="busno" value="${name.busNum}" class="input2"><br>
                <label class="label2">Source:</label><input type="text" name="source" value="${name.src}"  class="input2"><br>
                <label class="label2">Destination:</label><input type="text" name="destination"  value="${name.destination}" class="input2"><br>
               
                <label class="label2">No_Of_Seats:</label><input type="text" name="seats" class="input2"><br>
                <label class="label2">Mobile Number</label><input type="text" name="mobilenumber" class="input2"><br>
                
                <input type="submit" name="action" value="BookNow" class="input2">
            </form>
            
        </section>
</body>
</html>