package com.company.controller;

import com.company.model.entities.flight;
import com.company.model.repository.IFlightRepository;

import java.sql.Date;
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

    public String deleteFlightById(int id){
        boolean deleted= repository.deleteFlightByid(id);

        return (deleted ? "Flight was deleted!" : "Flight deletion was failed! ");

    }
    public String getFlightsByDate(Date date){
        return  repository.getFlightsByDate(date);



    }
    public String getFlightbyId(int id){
        return repository.getFlightById(id);
    }
    public String getFlightsByDestination(String destination){
        return repository.getFlightByDestination(destination).toString();
    }

}
