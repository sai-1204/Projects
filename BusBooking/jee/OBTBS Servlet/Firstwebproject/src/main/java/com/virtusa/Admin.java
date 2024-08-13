package com.virtusa;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.ParseDateSupport;

import com.virtusa.dto.Adminm;
import com.virtusa.dto.Booking;
import com.virtusa.service.AdminService;


@WebServlet("/Admin")
public class Admin extends HttpServlet {
private static final long serialVersionUID = 1L;
       
   
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.setContentType("text/html");
AdminService as=new AdminService();
boolean flag;
String bn;
String bno;
String src;
String des;
String doj;
int s;
int c;
String target="";
String action=request.getParameter("action");
request.setAttribute("act", action);


 switch(action){
 
 case "Bookings":
	 ArrayList<Booking> bb=as.getAllBookings();
	 request.setAttribute("alm", bb);
	 target="Booking.jsp";
	 break;
 
 
 
 case "BookNow":
	 bn=request.getParameter("busno");
	 src=request.getParameter("source");
	 des=request.getParameter("destination");
	 s=Integer.parseInt(request.getParameter("seats"));
	 String mb=request.getParameter("mobilenumber");
	 Adminm cd=as.searchBusByNum(bn);
	 c=cd.getCost()*s;
	 Booking book=new Booking(bn,src,des,s,mb,c);
	 flag=as.addBooking(book);
	 if(flag)
	 target="User.jsp";
	 break;
 case "SearchBus":
	 System.out.println("searchbus");
	src=request.getParameter("src");
	des=request.getParameter("dest");
	String src1=src.toLowerCase();
	String des1=des.toLowerCase();
	Adminm asd=as.searchBusBySrcDest(src1,des1);
	System.out.println(asd);
	request.setAttribute("v", asd);
	target="searchbus.jsp";
	break;
	
 case "Search":
	 ArrayList<Adminm> am=as.getAllBuses();
	 request.setAttribute("alm", am);
	 target="Search.jsp";
	 break;
 case "Book":
	 String busnum=request.getParameter("myname");
	 Adminm ad=as.searchBusByNum(busnum);
	 request.setAttribute("name", ad);
	 target="Book.jsp";
	 break;
	 
 case "Add":
 bn=request.getParameter("busname");
 bno=request.getParameter("busno");
 src=request.getParameter("source");
 des=request.getParameter("destination");
 doj=(String)request.getParameter("date");
 s=Integer.parseInt(request.getParameter("seats"));
 c=Integer.parseInt(request.getParameter("cost"));
 Adminm a=new Adminm(bn,bno,src,des,doj,s,c);
  flag=as.addBus(a);
 if(flag)
 target="Add.jsp";
 break;
 case "View":
 ArrayList<Adminm> am1=as.getAllBuses();
 request.setAttribute("alm", am1);
 target="View.jsp";
 break;
 
 case "Delete":
 String busname=request.getParameter("myname");
 flag=as.removeBus(busname);
 ArrayList<Adminm> ams=as.getAllBuses();
 request.setAttribute("alm", ams);
 if(flag)
 target="View.jsp";
 break;
 case "Update":
 String busnm=request.getParameter("mynm");
 Adminm flags=as.searchBus(busnm);
 request.setAttribute("name", flags);
 target="Update.jsp";
 break;
 case "Modify":
 bn=request.getParameter("busname");
 bno=request.getParameter("busno");
 src=request.getParameter("source");
 des=request.getParameter("destination");
 doj=(String)request.getParameter("date");
 s=Integer.parseInt(request.getParameter("seats"));
 c=Integer.parseInt(request.getParameter("cost"));
 Adminm aa=new Adminm(bn,bno,src,des,doj,s,c);
 flag=as.modifyUser(aa);
 ArrayList<Adminm> amm=as.getAllBuses();
 request.setAttribute("alm", amm);
 if(flag)
 target="View.jsp";
 else
 target="Welcome.jsp";
 break;
 
 
 
 }



RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request, response);
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}

}
