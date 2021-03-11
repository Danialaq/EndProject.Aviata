package com.company;

import com.company.model.database.IDB;
import com.company.model.database.PostgresDB;
import com.company.model.repository.FlightRepository;
import com.company.model.repository.IFlightRepository;
import com.company.view.Application;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IDB db = new PostgresDB();

        IFlightRepository flightRepository = new FlightRepository(db);

        Application app = new Application(flightRepository);

        app.start();


    }
}
