package com.virtusa.dbao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.virtusa.dto.Login;
import com.virtusa.util.DbUtil;


public class LoginDAO {
 public boolean validateUser(Login l) {

       try {

             Connection con=DbUtil.getConnection();
   String cmd="select * from login where username=? and pwd=?";

     PreparedStatement ps= con.prepareStatement(cmd);

     ps.setString(1,l.getUserName());
     ps.setString(2, l.getPassWord());
   

     ResultSet rs = ps.executeQuery();

     if(rs.next())
          return true;
     return false;


       }
       catch(Exception e) {
           e.printStackTrace();
       }
       return false;

   }

    public boolean addUser(Login l) {

            try {

              Connection con=DbUtil.getConnection();
              String cmd="insert into login values(?,?,?)";

             PreparedStatement ps= con.prepareStatement(cmd);
             ps.setString(1,l.getUserName() );
             ps.setString(2, l.getPassWord());
             ps.setString(3, l.getUserRole());

             ps.executeUpdate();
             ps.close();
             return true;


                }
            catch(Exception e) {
                e.printStackTrace();
            }

            return false;


    }


public  ArrayList<Login> getLoginUsers() {
try {

ArrayList<Login> all=new ArrayList<Login>();

Connection con=DbUtil.getConnection();
        String cmd="select * from Login";
        PreparedStatement ps= con.prepareStatement(cmd);

        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
        String uname=rs.getString(1);
            String pwd=rs.getString(2);
            String role=rs.getString(3);
            Login lg=new Login(uname,pwd,role);
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
