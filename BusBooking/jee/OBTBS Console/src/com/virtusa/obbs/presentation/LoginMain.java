package com.virtusa.obbs.presentation;



import java.util.ArrayList;
import java.util.Scanner;



import com.virtusa.obbs.dto.Login1;
import com.virtusa.obbs.service.Service;



public class LoginMain {



   public static void main(String[] args) {
        // TODO Auto-generated method stub
        int op=0;



       String busname;
        String busnum;
        String fromadd;
        String toadd;
        int kms;
        int price;
        String duration;
        Service service = new Service();
        Scanner sc = new Scanner(System.in);



       while(op!=4) {
        System.out.println("Login DataBase");
        System.out.println("1-List buses");
        System.out.println("2-Add bus");
        System.out.println("3-delete bus");
        System.out.println("4-search bus by entering fromadd and toadd");
        System.out.println("5-Exit");



       op = sc.nextInt();



       switch(op) {



       case 1:{



           ArrayList<Login1> al=service.getLoginBuses();



           for(Login1 l:al)
              System.out.println(l);
            break;
        }



       case 2:{
            System.out.println("Enter busname");
            busname = sc.next();
            System.out.println("Enter busnum");
            busnum = sc.next();
            System.out.println("Enter fromadd");
            fromadd = sc.next();
            System.out.println("enter toadd");
            toadd=sc.next();
            System.out.println("enter kms");
            kms=sc.nextInt();
            System.out.println("enter price");
            price=sc.nextInt();
            System.out.println("enter duration");
            duration=sc.next();
            Login1 l = new Login1(busname,busnum,fromadd,toadd,price,kms,duration);



           boolean flag=service.addBus(l);



           if(flag)
              System.out.println("Hey User!.. Welcome u r at right Place");
            else
              System.out.println("Sorry User!.... u r  not the one we are looing for");
            break;
        }
        case 3:System.out.println("enter busname to delete");
        busname=sc.next();
        boolean flag=service.removeBus(busname);
        if(flag)
            System.out.println("mentinoed bus removed succesfully");
        else
            System.out.println("sorry bus not found");
        break;
        case 4:System.out.println("Enter the fromadd...");
        fromadd = sc.next();
        System.out.println("Enter the toadd...");
        toadd=sc.next();
        
        Login1 login = service.searchBus(fromadd,toadd);
        if(login==null)
            System.out.println("User doesn't exist");
        else
            System.out.println(login);
        break;




       



       case 5:
            System.out.println("Exit");
            break;
        default:
            System.out.println("Sorry you choice wrong option! Plz try again");
        }
        }




    }



}