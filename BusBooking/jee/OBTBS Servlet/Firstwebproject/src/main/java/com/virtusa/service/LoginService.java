
package com.virtusa.service;

import java.util.ArrayList;

import com.virtusa.dbao.LoginDAO;
import com.virtusa.dto.Login;

public class LoginService {


    LoginDAO dao;

    public boolean validateUser(Login l) {
        dao= new LoginDAO();

        boolean flag=dao.validateUser(l);
        return flag;

    }


    public boolean addUser(Login l) {
    dao= new LoginDAO();
    boolean flag=dao.addUser(l);
    return flag;

    }


    public ArrayList<Login> getLoginUsers(){

        dao= new LoginDAO();

        ArrayList<Login> al=dao.getLoginUsers();
        return al;

    }
 

}

