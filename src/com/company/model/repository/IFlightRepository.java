package com.company.model.repository;

import com.company.model.entities.flight;

import java.util.ArrayList;

public interface IFlightRepository {

    ArrayList<flight> getAllFlights(); // method to get all flights which return arraylist < flights >

    void addNewFlight(flight newFlight); // void method to add new flight to our data base

}
