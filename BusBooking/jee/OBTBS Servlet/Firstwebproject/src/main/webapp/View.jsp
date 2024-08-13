
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Admin.css">
</head>
<body>

<header>
            <h1 class="text1">Bus Booking</h1>
            <section class="section1">
                <a href="mainhome.html" class="link1">Add Bus</a>
                <a href="Admin?action=View" class="link1">View Buses</a>
                <a href="Admin?action=Bookings" class="link1">Bookings</a>
                <a href="login.html" class="link1">Logout</a>
            </section>
        </header>
       <br><br>
        <section class="section3">
       
            <table class="table1">
                <tr class="thead1">
                    <td class="tdata1">Bus Name</td>
                    <td class="tdata1">Bus Number</td>
                    <td class="tdata1">Source</td>
                    <td class="tdata1">Destination</td>
                    <td class="tdata1">Date</td>
                    <td class="tdata1">Seats</td>
                    <td class="tdata1">Cost</td>
                    <td class="tdata1" colspan="2">Status</td>
                   
                </tr>
                <c:forEach var="v" items="${alm}">
                <tr>
                    <td>${v.busName}</td>
                    <td>${v.busNum }</td>
                    <td>${v.src}</td>
                    <td>${v.destination }</td>
                    <td>${v.doj}</td>
                    <td>${v.seats}</td>
                    <td>${v.cost}</td>
                   <td><a href="Admin?action=Delete&myname=${v.busName}"><input type="submit" value="Delete"/></a></td>
                    <td><a href="Admin?action=Update&mynm=${v.busName }"><input type="submit" value="Update"/></a></td>
                </tr>
                </c:forEach>
               
            </table>
        </section>
       
       

</body>
</html>
