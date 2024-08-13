<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Admin.css">
</head>
<body>
 <header class="header">
            <h1 class="text1">Bus Booking</h1>
            <section class="section1">
               
                <a href="Admin?action=Search" class="link1">View Buses</a>
                <a href="Admin?action=Bookings" class="link1">MyBookings</a>
                <a href="login.html" class="link1">Logout</a>
            </section>
        </header>
        <section class="section2">
            <h1 class="text2">BUS LIST</h1>
            <form action="Admin" method="get" class="form1">
                <label class="label1" >Source:</label><input type="text" name="src"  class="input1">
                <label class="label1">Destination:</label><input type="text" name="dest"  class="input1">
               
                <input type="submit" name="action" value="SearchBus">
            </form>
            
                    <table class="table1">
                <tr class="thead1">
                    <td class="tdata1">Bus Name</td>
                    <td class="tdata1">Bus Number</td>
                    <td class="tdata1">Source</td>
                    <td class="tdata1">Destination</td>
                    <td class="tdata1">Date</td>
                    <td class="tdata1">Seats</td>
                    <td class="tdata1">Cost</td>
                    <td class="tdata1">Status</td>
                   
                </tr>
          
                <tr>
                    
                <tr>
                    <td>${v.busName}</td>
                    <td>${v.busNum }</td>
                    <td>${v.src}</td>
                    <td>${v.destination }</td>
                    <td>${v.doj}</td>
                    <td>${v.seats}</td>
                    <td>${v.cost}</td>
                    <td><a href="Admin?action=Book&myname=${v.busNum}"><button>Book</button></a></td>
                </tr>
                 
               
            </table>
        </section>
</body>
</html>