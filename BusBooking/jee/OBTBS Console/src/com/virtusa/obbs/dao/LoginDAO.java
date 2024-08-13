package com.virtusa.obbs.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import com.virtusa.obbs.dto.Login1;



import com.virtusa.obbs.util.DbUtil;



public class LoginDAO {
    public Login1 searchBus(String fromadd,String toadd) {
        Login1 login = null;
        try {
            Connection con = DbUtil.getConnection();
            String query = "select * from bustable where fromadd=? and toadd=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, fromadd);
            ps.setString(2, toadd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                login = new Login1(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(7),rs.getInt(5),rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }
    public boolean removeBus(String busname) {
        try {
            Connection con = DbUtil.getConnection();
            String query = "delete from bustable where busname=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, busname);
            int n = ps.executeUpdate();
            if (n > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     public boolean addBus(Login1 l) {



        try {



          Connection con=DbUtil.getConnection();
           String cmd="insert into bustable values(?,?,?,?,?,?,?)";



         PreparedStatement ps= con.prepareStatement(cmd);
          ps.setString(1, l.getBusname());
          ps.setString(2, l.getBusnum());
          ps.setString(3, l.getFromadd());
          ps.setString(4, l.getToadd());
          ps.setInt(5,l.getKms());
          ps.setString(6,l.getDuration());
          ps.setInt(7,l.getPrice());
          ps.executeUpdate();
          ps.close();
          return true;




             }
         catch(Exception e) {
             e.printStackTrace();
         }



        return false;
}
     public  ArrayList<Login1> getLoginBuses() {
            try {
                
                ArrayList<Login1> all=new ArrayList<Login1>();
                
            Connection con=DbUtil.getConnection();
            String cmd="select * from bustable";
            PreparedStatement ps= con.prepareStatement(cmd);



           ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                String busname=rs.getString(1);
                String busnum=rs.getString(2);
                String fromadd=rs.getString(3);
                String toadd=rs.getString(4);
                int kms=rs.getInt(5);
                String duration=rs.getString(6);
                int price=rs.getInt(7);
                
                Login1 lg=new Login1(busname,busnum,fromadd,toadd,price,kms,duration);
                all.add(lg);
            }
            rs.close();
            ps.close();
            return all;
            
        }
            catch(Exception e) {
                
            }
            return null;
        }
     
}