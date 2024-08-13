package com.virtusa.obbs.dto;



public class Login1 {
    String busname;
    String busnum;
    String fromadd;
    String toadd;
    int price;
    int kms;
    String duration;
    public Login1(String busname, String busnum, String fromadd, String toadd, int price, int kms, String duration) {
        super();
        this.busname = busname;
        this.busnum = busnum;
        this.fromadd = fromadd;
        this.toadd = toadd;
        this.price = price;
        this.kms = kms;
        this.duration = duration;
    }
    public String getBusname() {
        return busname;
    }
    public void setBusname(String busname) {
        this.busname = busname;
    }
    public String getBusnum() {
        return busnum;
    }
    public void setBusnum(String busnum) {
        this.busnum = busnum;
    }
    public String getFromadd() {
        return fromadd;
    }
    public void setFromadd(String fromadd) {
        this.fromadd = fromadd;
    }
    public String getToadd() {
        return toadd;
    }
    public void setToadd(String toadd) {
        this.toadd = toadd;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getKms() {
        return kms;
    }
    public void setKms(int kms) {
        this.kms = kms;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    @Override
    public String toString() {
        return "Login1 [busname=" + busname + ", busnum=" + busnum + ", fromadd=" + fromadd + ", toadd=" + toadd
                + ", price=" + price + ", kms=" + kms + ", duration=" + duration + "]";
    }
    



}