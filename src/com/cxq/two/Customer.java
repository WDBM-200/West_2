package com.cxq.two;
import java.time.LocalDate;

public class Customer {
    String name;
    int ruaNum;
    LocalDate timeGet;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", ruaNum=" + ruaNum +
                ", timeGet=" + timeGet +
                '}';
    }

    public Customer(){

    }
    public Customer(String name,int ruaNum,LocalDate timeGet){
        this.name = name;
        this.ruaNum = ruaNum;
        this.timeGet = timeGet;
    }
}
