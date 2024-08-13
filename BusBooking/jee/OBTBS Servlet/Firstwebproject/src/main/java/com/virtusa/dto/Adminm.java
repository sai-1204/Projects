package com.virtusa.dto;

public class Adminm {

String busName;
String busNum;
String src;
String destination;
String doj;
int seats;
int cost;
public Adminm(String busName, String busNum, String src, String destination, String doj, int seats, int cost) {
super();
this.busName = busName;
this.busNum = busNum;
this.src = src;
this.destination = destination;
this.doj = doj;
this.seats = seats;
this.cost = cost;
}
public String getBusName() {
return busName;
}
public void setBusName(String busName) {
this.busName = busName;
}
public String getBusNum() {
return busNum;
}
public void setBusNum(String busNum) {
this.busNum = busNum;
}
public String getSrc() {
return src;
}
public void setSrc(String src) {
this.src = src;
}
public String getDestination() {
return destination;
}
public void setDestination(String destination) {
this.destination = destination;
}
public String getDoj() {
return doj;
}
public void setDoj(String doj) {
this.doj = doj;
}
public int getSeats() {
return seats;
}
public void setSeats(int seats) {
this.seats = seats;
}
public int getCost() {
return cost;
}
public void setCost(int cost) {
this.cost = cost;
}
@Override
public String toString() {
return "Admin [busName=" + busName + ", busNum=" + busNum + ", src=" + src + ", destination=" + destination
+ ", doj=" + doj + ", seats=" + seats + ", cost=" + cost + "]";
}





}
