package com.company.view;

import com.company.controller.FlightController;
import com.company.model.entities.flight;
import com.company.model.repository.IFlightRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private final FlightController flightController; // controller to manipulate with data base

    ArrayList < String > mon = new ArrayList<>(); // array index -> destination city
    ArrayList <Date> dates = new ArrayList<>(); // array index -> date
    ArrayList < String > times = new ArrayList<>(); // array index -> time
    ArrayList < String > companies = new ArrayList<>(); // array index -> company



    int bilet_num = 1000; // number of ticket
    public Application(IFlightRepository flightRepository) { // constructor
        flightController = new FlightController(flightRepository); // we receive repository from main

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

        dates.add(Date.valueOf("2022-01-01"));
        dates.add(Date.valueOf("2022-01-02"));
        dates.add(Date.valueOf("2022-01-03"));
        dates.add(Date.valueOf("2022-01-04"));
        dates.add(Date.valueOf("2022-01-05"));
        dates.add(Date.valueOf("2022-01-06"));
        dates.add(Date.valueOf("2022-01-07"));


        times.add("6 a.m.");
        times.add("8 p.m.");

        companies.add("Emirates Airlines");
        companies.add("Alaska Airlines");
        companies.add("Air Astana");


    }


    // main method

    public void start() throws IOException {
        int choice;
        Scanner in = new Scanner(System.in);
        while(true){ // endless loop
            String password;
            System.out.println("1: I am director");
            System.out.println("2: I am client");

            System.out.println("0: Exit");
            choice = in.nextInt();

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int city, date, time, air;

            String name;
            String tempP;

            if(choice == 1){
                System.out.println("Enter Password: ");
                password=(input.readLine());
                if(!password.equals("201291")) {
                    System.out.println("Sorry, entered password is unknown!");
                    System.exit(1);
                }else {
                    System.out.println("1: All current flights ");
                    System.out.println("2: Delete flight by ticket id");
                    System.out.println("3: Get flight by date");
                    System.out.println("4: Search ticket by id");
                    System.out.println("5: Search ticket by destination");
                    Scanner sc=new Scanner(System.in);
                    int dirchoice=sc.nextInt();
                    if(dirchoice==1) {
                        showAllFlights(); // we call method which shows all flights
                    }
                    else if(dirchoice==2){
                        System.out.println(deleteById());
                    }
                    else if(dirchoice==3){
                        System.out.println(getFlightByDate());
                    }
                    else if(dirchoice==4){
                        System.out.println(GetFlightById());
                    }
                    else if(dirchoice==5){
                        System.out.println(GetFlightByDestination());
                    }
                }

            }else if(choice == 2){

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
                } else if(choice==2){
                    System.out.println("Thanks for using our service");

                } else{
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
    String getFlightByDate(){
        System.out.println("Please enter date:");
        Scanner sc=new Scanner(System.in);
        Date dates= Date.valueOf(sc.next());
        return flightController.getFlightsByDate(dates);

    }
    public String deleteById(){
        System.out.println("Please enter ticket id:");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        return flightController.deleteFlightById(id);

    }

    public String  GetFlightById(){
        System.out.println("Please enter id:");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        return flightController.getFlightbyId(id);
    }
    public String  GetFlightByDestination(){
        System.out.println("Please enter destination:");
        Scanner sc=new Scanner(System.in);
        String  destination=sc.next();
        return flightController.getFlightsByDestination(destination);
    }
}

