<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<br><br>
        <section class="section3">
       
            <table class="table1">
                <tr class="thead1">
                    
                    <td class="tdata1">Bus Number</td>
                    <td class="tdata1">Source</td>
                    <td class="tdata1">Destination</td>
                   
                    <td class="tdata1">Seats</td>
                     <td class="tdata1">MobiltNumber</td>
                    <td class="tdata1">Cost</td>
                   
                   
                </tr>
                <c:forEach var="v" items="${alm}">
                <tr>
                    
                    <td>${v.busno }</td>
                    <td>${v.source}</td>
                    <td>${v.destination }</td>
                    <td>${v.seats}</td>
                    <td>${v.mobilenumber}</td>
                    <td>${v.cost}</td>
                   
                </tr>
                </c:forEach>
               
            </table>
        </section>
</body>
</html>