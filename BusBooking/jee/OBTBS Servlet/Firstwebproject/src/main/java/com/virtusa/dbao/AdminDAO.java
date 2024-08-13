package com.virtusa.dbao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.virtusa.dto.Adminm;
import com.virtusa.dto.Booking;
import com.virtusa.util.DbUtil;

public class AdminDAO {


public boolean addBus(Adminm a) {

        try {

          Connection con=DbUtil.getConnection();
          String cmd="insert into BusTable values(?,?,?,?,?,?,?)";

         PreparedStatement ps= con.prepareStatement(cmd);
         ps.setString(1,a.getBusName() );
         ps.setString(2,a.getBusNum());
         ps.setString(3,a.getSrc());
         ps.setString(4,a.getDestination());
         ps.setString(5,a.getDoj());
        ps.setInt(6,a.getSeats());
        ps.setInt(7,a.getCost());

         ps.executeUpdate();
         ps.close();
         return true;


            }
        catch(Exception e) {
            e.printStackTrace();
        }

        return false;


}


public boolean addBooking(Booking b) {

    try {

      Connection con=DbUtil.getConnection();
      String cmd="insert into Booking values(?,?,?,?,?,?)";

     PreparedStatement ps= con.prepareStatement(cmd);
     ps.setString(1,b.getBusno() );
     ps.setString(2,b.getSource());
 
     ps.setString(3,b.getDestination());
 
    ps.setInt(4,b.getSeats());
    ps.setString(5,b.getMobilenumber());
    ps.setInt(6,b.getCost());

     ps.executeUpdate();
     ps.close();
     return true;


        }
    catch(Exception e) {
        e.printStackTrace();
    }

    return false;


}






public Adminm searchBusBySrcDest(String src,String dest) {
Adminm am = null;
try {
Connection con = DbUtil.getConnection();
String query = "select * from BusTable where src=? and destination=?";
PreparedStatement ps = con.prepareStatement(query);
ps.setString(1,src);
ps.setString(2,dest);

ResultSet rs = ps.executeQuery();
if (rs.next()) {
am = new Adminm(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
}
} catch (Exception e) {
e.printStackTrace();
}
return am;
}
public Adminm searchBusByNum(String busNum) {
Adminm am = null;
try {
Connection con = DbUtil.getConnection();
String query = "select * from BusTable where busnum=?";
PreparedStatement ps = con.prepareStatement(query);
ps.setString(1,busNum);

ResultSet rs = ps.executeQuery();
if (rs.next()) {
am = new Adminm(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
}
} catch (Exception e) {
e.printStackTrace();
}
return am;
}
public Adminm searchBus(String busName) {
Adminm am = null;
try {
Connection con = DbUtil.getConnection();
String query = "select * from BusTable where busname=?";
PreparedStatement ps = con.prepareStatement(query);
ps.setString(1,busName);

ResultSet rs = ps.executeQuery();
if (rs.next()) {
am = new Adminm(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
}
} catch (Exception e) {
e.printStackTrace();
}
return am;
}

public boolean modifyUser(Adminm ad) {
try {
Connection con = DbUtil.getConnection();
String query = "update BusTable set busname=? , busnum=?,src=?,destination=?,dob=?,seats=?,cost=? where busname=?";
PreparedStatement ps = con.prepareStatement(query);
ps.setString(1, ad.getBusName());
ps.setString(2, ad.getBusNum());
ps.setString(3, ad.getSrc());
ps.setString(4, ad.getDestination());
ps.setString(5, ad.getDoj());
ps.setInt(6, ad.getSeats());
ps.setInt(7, ad.getCost());
ps.setString(8, ad.getBusName());
int n = ps.executeUpdate();
if (n > 0)
return true;
} catch (Exception e) {
e.printStackTrace();
}
return false;
}
public boolean removeBus(String busname) {
try {
Connection con = DbUtil.getConnection();
String query = "delete from BusTable where busname=?";
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

public  ArrayList<Adminm> getAllBuses() {
try {

ArrayList<Adminm> all=new ArrayList<Adminm>();

Connection con=DbUtil.getConnection();
        String cmd="select * from BusTable";
        PreparedStatement ps= con.prepareStatement(cmd);

        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
        String bname=rs.getString(1);
            String bno=rs.getString(2);
            String src=rs.getString(3);
            String des=rs.getString(4);
            String doj=rs.getString(5);
            int s=rs.getInt(6);
            int c=rs.getInt(7);
            Adminm am=new Adminm(bname,bno,src,des,doj,s,c);
            all.add(am);
        }
        rs.close();
        ps.close();
        return all;
       
}
catch(Exception e) {

}
return null;
}

public  ArrayList<Booking> getAllBookings() {
try {

ArrayList<Booking> all=new ArrayList<Booking>();

Connection con=DbUtil.getConnection();
        String cmd="select * from Booking";
        PreparedStatement ps= con.prepareStatement(cmd);

        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
       
            String bno=rs.getString(1);
            String src=rs.getString(2);
            String des=rs.getString(3);
            int s=rs.getInt(4);
            String mb=rs.getString(5);
            int c=rs.getInt(6);
            Booking b=new Booking(bno,src,des,s,mb,c);
            all.add(b);
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
