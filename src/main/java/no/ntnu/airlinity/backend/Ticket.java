package no.ntnu.airlinity.backend;

import java.time.LocalTime;

public class Ticket {
  private String firstName;
  private String lastName;
  private String email;
  private int age;
  private String origin;
  private String destination;
  private String type;
  private LocalTime departureTime;

  private static final String[] TYPES ={"Economy","Business","First"};

  public Ticket(String firstName, String lastName, String email, int age,
                String type, String origin,String destination,LocalTime departureTime) {

    //Check first- and last name
    if(firstName.isBlank()||firstName.isEmpty()||lastName.isEmpty()||lastName.isBlank()){
      throw new IllegalArgumentException("Name can not be empty or blank");
    }
    this.firstName = firstName;
    this.lastName = lastName;


    //Check email
    if(!email.contains("@")){
      throw new IllegalArgumentException("Invalid email.");
    }
    this.email = email;

    // Verify the age to be between 0 and 130
    if(age<0 || age > 130){
      throw new IllegalArgumentException("Invalid age.");
    }
    this.age = age;

    //Check valid destination and origin
    if(origin.isBlank()||origin.isEmpty()||destination.isBlank()||destination.isEmpty()){
      throw new IllegalArgumentException("Origin and destination has to be filled out");
    }
    this.origin = origin;
    this.destination = destination;

    //Check valid ticket type
    if(!validType(type)){
      //Economy/Business/First
      throw new IllegalArgumentException("Not a valid ticket type. ["+ String.join("/",TYPES)+"] ");
    }
    this.type = type;


    // TODO: 17.02.2022 Check time(?)
    this.departureTime = departureTime;
  }

  private boolean validType(String type){
    for(String valid : TYPES){
      if(type.equals(valid)){
        return true;
      }
    }
    return false;
  }




}
