package com.company.model.repository;

import com.company.model.entities.flight;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface IFlightRepository {

    ArrayList<flight> getAllFlights(); // method to get all flights which return arraylist < flights >

    void addNewFlight(flight newFlight); // void method to add new flight to our data base
    boolean deleteFlightByid(int id); // boolean method to delete flight by id
    String getFlightsByDate(Date date); // method that searches flight by date
    String getFlightById(int id); // method that searches flight by id
    List<flight> getFlightByDestination(String destination); // method that searches flight by destination point
}
