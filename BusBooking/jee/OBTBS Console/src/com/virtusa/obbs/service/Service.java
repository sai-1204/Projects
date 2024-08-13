package com.virtusa.obbs.service;



import java.util.ArrayList;



import com.virtusa.obbs.dto.Login1;
import com.virtusa.obbs.dao.LoginDAO;




public class Service {
    
     LoginDAO dao;
     
     public Login1 searchBus(String fromadd,String toadd) {
         dao=new LoginDAO();
         Login1 login=dao.searchBus(fromadd,toadd);
         return login;
     }
     
     public boolean removeBus(String busname) {
         dao=new LoginDAO();
         boolean flag=dao.removeBus(busname);
         return flag;
     }



   public boolean addBus(Login1 l) {
        dao= new LoginDAO();
        boolean flag=dao.addBus(l);
        return flag;



       }




        public ArrayList<Login1> getLoginBuses(){



           dao= new LoginDAO();



           ArrayList<Login1> al=dao.getLoginBuses();
            return al;



       }
     



}
