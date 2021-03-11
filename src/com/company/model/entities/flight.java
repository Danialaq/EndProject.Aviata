package com.company.model.entities;

import java.sql.Date;

public class flight {

    //private variables
    private int ticketNum;
    private String name;
    private String destination;
    private Date date;
    private String time;
    private int price;

    //contractors

    public flight(int ticketNum, String name, String destination, Date date, String time, int price) {
        this.ticketNum = ticketNum;
        this.name = name;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
    }


    //getters and setters
    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    //method to return values of current object

    @Override
    public String toString(){
        return "Name: " + name + " ticket Num: " + ticketNum + " destination: " + destination + " date: " + date + " time: "+ time + " price: " + price + " KZT" + "\n -";
    }
}
