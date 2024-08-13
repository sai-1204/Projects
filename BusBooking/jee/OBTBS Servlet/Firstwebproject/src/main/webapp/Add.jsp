<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="Admin.css">
</head>
<body>
        <header>
            <h1 class="text1">Bus Booking</h1>
            <section class="section1">
                
                <a href="Add.jsp" class="link1">Add Bus</a>
                <a href="Admin?action=View" class="link1">View Buses</a>
                <a href="Admin?action=Bookings" class="link1">Bookings</a>
                <a href="login.html" class="link1">Logout</a>
            </section>
        </header>
        
        <section class="section3">
       
            <form action="Admin" method="get" class="form2">
                <label class="label2" >Busname:</label><input type="text" name="busname"  class="input2"><br>
                <label class="label2">Busno:</label><input type="text" name="busno" class="input2"><br>
                <label class="label2">Source:</label><input type="text" name="source" class="input2"><br>
                <label class="label2">Destination:</label><input type="text" name="destination" class="input2"><br>
                <label class="label2">Date of Journey:</label><input type="date" name="date" class="input2"><br>
                <label class="label2">Seats:</label><input type="text" name="seats" class="input2"><br>
                <label class="label2">Cost:</label><input type="text" name="cost" class="input2"><br>
                
                <input type="submit" name="action" value="Add" class="input2">
            </form>
            
        </section>
        
        
</body>
</html>
    