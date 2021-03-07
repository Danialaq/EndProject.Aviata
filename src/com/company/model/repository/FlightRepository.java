package com.company.model.repository;

import com.company.model.database.IDB;
import com.company.model.entities.flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FlightRepository implements IFlightRepository {

    private final IDB db;

    public FlightRepository(IDB db) {
        this.db = db;
    }

    public ArrayList<flight> getAllFlights(){ // method to get all flights which return arraylist < flights >

        Connection con = null; // create connection
        Statement st = null; // create statement
        ResultSet rs = null; // create resultset to store table

        ArrayList < flight > res = new ArrayList<>(); // create ArrayList < flights > res to store answer

        try {

            con = db.getConnection(); // connect
            st = con.createStatement();
            rs = st.executeQuery("select * from flights"); // sql

            while(rs.next()){ // add all rows from  sql table
                res.add(new flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }

            return res; // return answer


        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return null;
    }

    public void addNewFlight(flight newFlight) {  // void method to add new flight to our data base

        Connection con = null; // create connection

        try {
            con = db.getConnection(); // connect

            String sql = "insert into flights values (?, ?, ?, ?, ?, ?)"; // sql
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, newFlight.getTicketNum()); // insert from our newFlight variable which we recieve from our application
            st.setString(2, newFlight.getName()); // insert from our newFlight variable which we recieve from our application
            st.setString(3, newFlight.getDestination()); // insert from our newFlight variable which we recieve from our application
            st.setString(4, newFlight.getDate()); // insert from our newFlight variable which we recieve from our application
            st.setString(5, newFlight.getTime()); // insert from our newFlight variable which we recieve from our application
            st.setInt(6, newFlight.getPrice());// insert from our newFlight variable which we recieve from our application


            st.execute(); // execute statement

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
