package com.company.view;

import com.company.controller.FlightController;
import com.company.model.entities.flight;
import com.company.model.repository.IFlightRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private final FlightController flightController; // controller to manipulate with data base

    ArrayList < String > mon = new ArrayList<>(); // array index -> destination city
    ArrayList < String > dates = new ArrayList<>(); // array index -> date
    ArrayList < String > times = new ArrayList<>(); // array index -> time
    ArrayList < String > companies = new ArrayList<>(); // array index -> company



    int bilet_num = 1000; // number of ticket
    public Application(IFlightRepository flightRepository) { // contructor
        flightController = new FlightController(flightRepository); // we recieve repository from main

        mon.add("New-York");
        mon.add("London");
        mon.add("Beijing");
        mon.add("Tokyo");
        mon.add("Mumbai");
        mon.add("Moscow");
        mon.add("Istanbul");
        mon.add("Almaty");
        mon.add("Paris");
        mon.add("Dubai");

        dates.add("01/01/2022");
        dates.add("02/01/2022");
        dates.add("03/01/2022");
        dates.add("04/01/2022");
        dates.add("05/01/2022");
        dates.add("06/01/2022");
        dates.add("07/01/2022");


        times.add("6 a.m.");
        times.add("8 p.m.");

        companies.add("Emirates Airlines");
        companies.add("Alaska Airlines");
        companies.add("Air Astana");


    }


    // main method

    public void start(){
        int choice;
        Scanner in = new Scanner(System.in);
        while(true){ // endless loop
            System.out.println("1: I am director");
            System.out.println("2: I am client");
            System.out.println("0: Exit");
            choice = in.nextInt();


            int city, date, time, air;

            String name;

            if(choice == 1){
                System.out.println("All current flights:");
                showAllFlights(); // we call method which shows all flights
            } else if(choice == 2){

                System.out.println("Hello! You Are Welcome At AviataSales WebSite! Please, Enter Your Name For The Further Service");
                name = in.next();

                System.out.println("Choose destination: ");
                System.out.println("1: New-York");
                System.out.println("2: London");
                System.out.println("3: Beijing");
                System.out.println("4: Tokyo");
                System.out.println("5: Mumbai");
                System.out.println("6: Moscow");
                System.out.println("7: Istanbul");
                System.out.println("8: Almaty");
                System.out.println("9: Paris");
                System.out.println("10: Dubai");

                city = in.nextInt(); // store choice

                System.out.println("Your destination point is " + mon.get(city - 1) + ". PLease choose date of your flight:");

                System.out.println("1: 01/01/2022");
                System.out.println("2: 02/01/2022");
                System.out.println("3: 03/01/2022");
                System.out.println("4: 04/01/2022");
                System.out.println("5: 05/01/2022");
                System.out.println("6: 06/01/2022");
                System.out.println("7: 07/01/2022");

                date = in.nextInt(); // store choice

                System.out.println("You date is " + dates.get(date - 1) + ". Please choose departure time:");

                System.out.println("1: 6 a.m.");
                System.out.println("2: 8 p.m.");

                time = in.nextInt(); // store choice

                System.out.println("Choose the Avia Company:");

                System.out.println("1: Emirates Airlines");
                System.out.println("2: Alaska Airlines");
                System.out.println("3: Air-Astana");


                bilet_num++; // everytime we increment ticket number

                air = in.nextInt();

                int price;
                // calculate price
                if(city <= 5) {
                    price = 243540;
                } else {
                    price = 105941;
                }

                System.out.println("Your price is " + price + ", is it appropriate for you?");
                System.out.println("1: Yes");
                System.out.println("2: No");

                choice = in.nextInt(); // store choice

                if(choice == 1){

                    //output ticket
                    System.out.println("Dear " + name + ", thanks for purchasing!");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("--------Your Destination Point: " + mon.get(city - 1)+ "----");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("--------Your date: " + dates.get(date - 1)+ "------------");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("--------Your departure time: " + times.get(time - 1)+ "---------");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("--------Your ticket number: " + bilet_num+ "----");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("--------Price: " + price + "------------------------");
                    System.out.println("-----------------------------------------------------------");


                    // there we add new ticker through our controller
                    flightController.addNewFLight(new flight(bilet_num, name, mon.get(city - 1), dates.get(date - 1), times.get(time - 1), price));
                } else {
                    continue;
                }

            } else {

                //exit programm
                System.exit(0);
            }
        }
    }

    void showAllFlights(){

        // get arraylist from repository
        ArrayList < flight > flights = flightController.getAllFlights();

        if(flights == null){
            // if we not receive anything we should write no flights
            System.out.println("No flights");
        } else {
            //otherwise output all flights
            System.out.println("Total " + flights.size() + " flights"); // output number of flights through .size() function
            System.out.println("-----------------------------------------------------------");
            for (flight to : flights){
                System.out.println(to.toString()); // loop through flights and output every
            }
            System.out.println("-----------------------------------------------------------");
        }
    }
}

