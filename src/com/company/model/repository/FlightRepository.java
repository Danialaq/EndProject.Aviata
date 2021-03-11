package com.company.model.repository;

import com.company.model.database.IDB;
import com.company.model.entities.flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
                res.add(new flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getInt(6)));
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
            st.setDate(4, newFlight.getDate()); // insert from our newFlight variable which we recieve from our application
            st.setString(5, newFlight.getTime()); // insert from our newFlight variable which we recieve from our application
            st.setInt(6, newFlight.getPrice());// insert from our newFlight variable which we receive from our application


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

    @Override
    public boolean deleteFlightByid(int id) {
        Connection con = null; // create connection

        try {
            con = db.getConnection(); // connect

            String sql = "delete from flights where ticket_id=?"; // sql
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);


            st.execute(); // execute statement
            return true;

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public String getFlightsByDate(Date date) {
        Connection con = null; // create connection

        try {
            con = db.getConnection(); // connect

            String sql = "Select*from flights where date=?"; // sql
            PreparedStatement st = con.prepareStatement(sql);
            st.setDate(1,date);

            ResultSet rs= st.executeQuery();

            if(rs.next()){
                flight f=new flight(rs.getInt("ticket_id"),rs.getString("name"),rs.getString("destination"),rs.getDate("date"),rs.getString("time"),rs.getInt("cost"));
                return f.toString();
            }



        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String getFlightById(int id){
        Connection con = null; // create connection

        try {
            con = db.getConnection(); // connect

            String sql = "Select*from flights where ticket_id=?"; // sql
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);

            ResultSet rs= st.executeQuery();

            if(rs.next()){
                flight f=new flight(rs.getInt("ticket_id"),rs.getString("name"),rs.getString("destination"),rs.getDate("date"),rs.getString("time"),rs.getInt("cost"));
                return f.toString();
            }



        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<flight> getFlightByDestination(String destination) {
        Connection con = null; // create connection

        try {
            con = db.getConnection(); // connect

            String sql = "Select*from flights where destination=?"; // sql
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,destination);

            ResultSet rs= st.executeQuery();
            List<flight> flights=new LinkedList<>();
            while(rs.next()){
                flight f=new flight(rs.getInt("ticket_id"),rs.getString("name"),rs.getString("destination"),rs.getDate("date"),rs.getString("time"),rs.getInt("cost"));
                flights.add(f);
            }
            return flights;


        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
