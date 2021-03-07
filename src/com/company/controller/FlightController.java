package com.company.controller;

import com.company.model.entities.flight;
import com.company.model.repository.IFlightRepository;

import java.util.ArrayList;

public class FlightController {

    private final IFlightRepository repository;

    public FlightController(IFlightRepository repository) {
        this.repository = repository;
    }

    public void addNewFLight(flight newFlight){
        repository.addNewFlight(newFlight);
    }

    public ArrayList< flight > getAllFlights(){
        return repository.getAllFlights();
    }
}
