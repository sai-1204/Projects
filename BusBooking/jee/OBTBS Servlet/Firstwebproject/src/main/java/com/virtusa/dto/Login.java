package com.virtusa.dto;

public class Login {
String userName;
String passWord;
String userRole;
public Login(String userName, String passWord, String userRole) {
super();
this.userName = userName;
this.passWord = passWord;
this.userRole = userRole;
}
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public String getPassWord() {
return passWord;
}
public void setPassWord(String passWord) {
this.passWord = passWord;
}
public String getUserRole() {
return userRole;
}
public void setUserRole(String userRole) {
this.userRole = userRole;
}
@Override
public String toString() {
return "Login [userName=" + userName + ", passWord=" + passWord + ", userRole=" + userRole + "]";
}



}
