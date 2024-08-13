package com.virtusa.service;


import java.util.ArrayList;

import com.virtusa.dbao.AdminDAO;
import com.virtusa.dto.Adminm;
import com.virtusa.dto.Booking;


public class AdminService {
    AdminDAO dao;
   
    public Adminm searchBus(String busName) {
    dao= new AdminDAO();
   Adminm flag=dao.searchBus(busName);
   return flag;
   
   
    }
   
public boolean modifyUser(Adminm ad) {
dao= new AdminDAO();
   boolean flag=dao.modifyUser(ad);
   return flag;
}
    public boolean addBus(Adminm a) {
    dao= new AdminDAO();
    boolean flag=dao.addBus(a);
    return flag;

    }
    
    public boolean addBooking(Booking b) {
    	
    	dao=new AdminDAO();
    	 boolean flag=dao.addBooking(b);
    	    return flag;
    	
    	
    }
    
    
    
    
    public Adminm searchBusByNum(String busNum) {
    	dao=new AdminDAO();
    	Adminm al=dao.searchBusByNum(busNum);
    	
    	return al;
    	
    }
    public Adminm searchBusBySrcDest(String src,String dest) {
    	dao=new AdminDAO();
    	Adminm al=dao.searchBusBySrcDest(src,dest);
    	
    	return al;
    	
    }
    public boolean removeBus(String busname) {
dao=new AdminDAO();
boolean flag=dao.removeBus(busname);
return flag;
}

    public  ArrayList<Adminm> getAllBuses(){
    dao=new AdminDAO();
    ArrayList<Adminm> al=dao.getAllBuses();
    return al;
    }
    
    public  ArrayList<Booking> getAllBookings() {
    	
    	
    	dao=new AdminDAO();
        ArrayList<Booking> al=dao.getAllBookings();
        return al;
    	
    }
    
    
    
    
    
}

