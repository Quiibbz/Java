/*
name: Cole Croteau
date: 9/19/22
description: A program that tracks the number of passengers on an airplane, with ways to remove or add passengers depending on whether the plane has taken off or not.
 */

import java.util.*;

public class AirplaneCroteau {
  
}
//Person Object, complete with a constructor, setters, and getters.
class Person {
	
	//Private variables
	private String firstName = "";
	private String lastName = "";
	private String phone = "";
	
	//Constructor
	public Person(String name, String last, String phone) {
		this.firstName = name;
		this.lastName = last;
		this.phone = phone;
	}
	
	//Set first name
	public void setFirst(String name) {
		this.firstName = name;
	}
	
	//Set last name
	public void setLast(String last) {
		this.lastName = last;
	}
	
	//Checks what the first name is
	public String getFirst() {
		return firstName;
	}
	
	//Checks what the last name is
	public String getLast() {
		return lastName;
	}
	
	//Sets the phone number
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//Checks what the phone number is
	public String getPhone() {
		return phone;
	}
	
	//Convers information of the object into a string
	public String toString() {
		String s = "";
		s += "Name: " + firstName;
		s += "\nLast: " + lastName;
		s += "\nPhone: " + phone;
		return s;
	}
	
	//Checks if two people share the same first and last name
	public boolean equals(Object o) {
		if(o instanceof Person) {
			Person p = (Person) o;
			return this.firstName == p.firstName && this.lastName == p.lastName;
		}
		return false;
	}
}

//Passenger object that is a subclass of Person, complete with a constructor, setters, and getters.
class Passenger extends Person {
	
	//Private variables
	private int seatNumber = 0;
	private String classType = "";
	private String ticketID = "";
	
	//Constructor
	public Passenger(String first, String last, String ticketID, int seatNumber, String classType, String phone) {
		super(first, last, phone);
		this.ticketID = ticketID;
		this.seatNumber = seatNumber;
		this.classType = classType;
	}
	
	//Changes the seat number
	public void changeSeatNumber(int num) {
		this.seatNumber = num;
	}
	
	//Changes the class type
	public void setClassType(String classType) {
		this.classType = classType;
	}
	
	//Checks what the class type is
	public String getClassType() {
		return classType;
	}
	
	//Checks what the seat number is
	public int getSeat() {
		return seatNumber;
	}
	
	//Checks what the ticketID is
	public String getTicketID() {
		return ticketID;
	}
	
	//Changes what the ticketID is
	public void setTicketID(String phone) {
		this.ticketID = phone;
	}
	
	//Turns the information on a Passenger into a String
	public String toString() {
		String s = "";
		s += super.toString();
		s += "\nSeat Number: " + seatNumber;
		s += "\nClass: " + classType;
		s += "\nTicketID: " + ticketID;
		return s;
	}
	
}

//Interface Method
interface list {   
   public boolean add(Object o);
   public Object search(Object o);
   public boolean delete(Object o);
   public void printLast();
   public void takeOff();
}

//Airplane object, complete with a constructor, getters, and setters. Uses methods from the interface list.
class Airplane implements list {
	//Instanced Variable
	public static int count = 0;
	//Private variables
	private Passenger[] plane = new Passenger[10];
	private boolean takenOff = false;
    private int planeNum = 0;
      
   //Constructor
   public Airplane(int planeNum) {
	   this.planeNum = planeNum; 
   }
   
   //Checks what the plane number is
   public int getPlaneNumber() {
	   return planeNum;
   }
      
   //Assigns a new plane number
   public void setPlaneNumber(int num) {
	   this.planeNum = num;
   }
   
   //Turns the information on the airplane into a String
   public String toString() {
	   String s = "";
	   for(int i = 0; i < 10; i++) {
		   if(plane[i] != null) {
			   s+= "\n" + plane[i].toString();
			   s+= "\n-------";
		   }
	   }
	   return s;
   }
     
   //Checks how many passengers are in the airplane
   public int getCount() {
	   return count;
   }
      
   
   //Adds a new passenger to the plane
   public boolean add(Object o) {
	   if(o instanceof Passenger && takenOff == false) {
		   Passenger p = (Passenger)o;
		   plane[count] = p;
		   count++;
		   return true;
	   }
	   return false;
   }

   //Searches up the information on a passenger of the plane
   public Object search(Object o) {
	   if(o instanceof String) {
		   String name = (String)o;
		   for(int i = 0; i < plane.length; i++) {
			   if(plane[i] != null && plane[i].getLast().equalsIgnoreCase(name)) {
				   return plane[i];
			   }
		   }
	   }
       return null;
   }

   //Deletes a passenger of the plane
   public boolean delete(Object o) {
   		if(o instanceof String) {
   			String last = (String)o;
   			for(int i = 0; i < plane.length; i++) {
   				if(plane[i] != null && plane[i].getLast().equalsIgnoreCase(last)) {
   					plane[i] = null;
   					count--;
   					return true;
   				}
   			}
   		}
	   return false;
   }

   //Prints a list of the last names of all passengers of the plane
   public void printLast() {
	   for(int i = 0; i < plane.length; i++) {
		   if(plane[i] != null) {
			   System.out.println(plane[i].getLast());
		   }
	   }
   }
   
   //Signals that the plane has taken off.
   public void takeOff() {
   	takenOff = true;
   }
	
}

//Driver to test the code
class Driver {
   public static void main(String[]args) {
      Scanner in = new Scanner(System.in);
      Scanner kb = new Scanner(System.in);
      Airplane plane = new Airplane(817345);
      Passenger p1 = new Passenger("Bobbys", "Smith", "123456789", 1, "First class", "916-222-3333");
      Passenger p2 = new Passenger("Johnny", "Apples", "987654321", 8, "Business class", "818-000-1234");
      Passenger p3 = new Passenger("Tommy", "Jerrys", "567123489", 32, "Economy class","202-222-3333");
      Passenger p4 = new Passenger("Candy", "Cruze", "982134567", 15, "Premium Economy class","707-444-5555");
      
      //this passenger will be added after take off
      Passenger p5 = new Passenger("Kalotiii", "Aaronn", "762134589", 5, "Economy plus","817-222-6666");
      
      plane.add(p1);
      plane.add(p2);
      plane.add(p3);
      plane.add(p4);
      System.out.println("The plane is about to take off");
      plane.takeOff();
      System.out.println("adding a passenger after take off");
      plane.add(p5);
      String repeat = "";
      while(plane.getCount() > 0) 
      {
      
         System.out.println("Here is the list of the passengers in this plane");
         System.out.println("There are " + plane.getCount() + " Passengers on this plane"); 
         System.out.println(plane + "\n");
      
         System.out.println("Testing the printLast method to display the last names");
         plane.printLast();  
         System.out.println();
         
         System.out.println("Testing the static method getCount");
         System.out.println("This plane has " + plane.getCount() + " Passengers\n");
         
         System.out.print("Enter the last name of the passenger to search for: ");
         String lastName = in.nextLine();
         System.out.println("\n" + plane.search(lastName));
         System.out.println("-------");
         System.out.println();
         
         System.out.println("Testing the delete method");
         System.out.print("Enter the last name of the passenger to be deleted: ");
         String last = in.nextLine();
         plane.delete(last);
         System.out.println("Passenger " + last + " has been removed from the list\n");
         
         System.out.println("Here is the updated list");
         System.out.println(plane);
         System.out.println("*********************");
         System.out.print("Press any key to continue : ");
         repeat = kb.nextLine();
      }
      System.out.println("No passenger left on this airplane");
   	
   }
}
