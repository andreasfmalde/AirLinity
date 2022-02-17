package no.ntnu.airlinity.backend;

import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {

  private LocalTime departureTime;
  private String origin;
  private String endLocation;
  private String status;
  private ArrayList<Ticket> passengers;
  //TODO: Add flightnumber i.e "DY413"

  public Flight(LocalTime departureTime, String endLocation) {
    this.departureTime = departureTime;
    this.endLocation = endLocation;
    this.status = "";
    this.passengers = new ArrayList<>();
  }

  public boolean addPassenger(String firstName, String lastName, String email, int age,
                              String type){
    try{
      passengers.add(new Ticket(firstName,lastName,email,age,type,this.origin,this.endLocation, this.departureTime));
    }catch (IllegalArgumentException e){
      System.err.println(e.getMessage());
      return false;
    }
    return true;
  }



  // TODO: 17.02.2022 Add the final methods to the ticket class
  public boolean removePassenger(){
    return false;
  }




}
