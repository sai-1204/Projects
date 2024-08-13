package com.virtusa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.dto.Login;
import com.virtusa.service.LoginService;


@WebServlet("/Hello")
public class Hello extends HttpServlet {
private static final long serialVersionUID = 1L;

   
    public Hello() {
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

response.setContentType("text/html");


 LoginService ls=new LoginService();
 String action=request.getParameter("action");
 String target="";
 String ufname;
 String upwd;
 String urole;
 System.out.println(action);
 switch(action) {

 case "Signup":
 ufname=request.getParameter("ufname");
 upwd=request.getParameter("upwd");
 urole="manager";
 Login l=new Login(ufname,upwd,urole);
 boolean flag=ls.addUser(l);
 if(flag)
 target="Add.jsp";
 break;
 case "Login":
 ufname=request.getParameter("ufname");
 upwd=request.getParameter("upwd");
 urole="manager";
 request.setAttribute("ufname",ufname);
 request.setAttribute("upwd",upwd);
 Login la=new Login(ufname,upwd,urole);
 System.out.println(ufname+upwd);
 if(ufname.equals("mani") && upwd.equals("meerpet")) {
 boolean flags=ls.validateUser(la);
 System.out.println("admin");
 if(flags) {
 target="Admin.jsp";
 System.out.println("passes");
 }
 else {
 target="userregister.html";
 System.out.println("cancelled");
 }
 }
 else {
 boolean flags=ls.validateUser(la);
 if(flags)
 target="User.jsp";
 else
 target="login.html";
 break;
 
 }
 }


RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request, response);

}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}

}

