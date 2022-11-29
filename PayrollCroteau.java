/*
name: Cole Croteau
date: 9/19/22
description: A user defined data type called Payroll that organizes the payroll information for any number of employees. Comes complete with different ways to manipulate the information.
self-grade: 100%: The input is 1:1 of the sample input provided, the code is organized with no useless code, and there are plenty of comments throughout the code.
 */
public class PayrollCroteau {

}

//A blank template for the data type Payroll for when no data is specified during creation of a new Payroll.
class Payroll {
   private String name = "";
   private String id = "";
   private double hourlyRate = 0;
   private double hoursWorked = 0;
   
 //Constructor that takes the information given and turns it into the data type Payroll
   public Payroll(String name, String id, double hourlyRate, double hoursWorked) {
	   this.name = name;
	   this.id = id;
	   this.hourlyRate = hourlyRate;
	   this.hoursWorked = hoursWorked;
   }
   
 //Getter method that returns the name in the Payroll.
   public String getName() {
	   return name;
   }
   
 //Getter method that returns the id in the Payroll.
   public String getId() {
	   return id;
   }
   
 //Getter method that returns the hourlyRate in the Payroll.
   public double getHourlyRate() {
	   return hourlyRate;
   }
   
 //Getter method that returns the hoursWorked in the Payroll.
   public double gethoursWorked() {
	   return hoursWorked;
   }
   
 //Setter method that changes the name in the Payroll.
   public void setName(String name) {
	   this.name = name;
   }
   
 //Setter method that changes the hourlyRate in the Payroll.
   public void setHourlyRate(double rate) {
	   hourlyRate = rate;
   }
   
 //Setter method that changes the hoursWorked in the Payroll.
   public void setHoursWorked(double hours) {
	   hoursWorked = hours;
   }
   
 //Method that returns the pay that the person in the Payroll receives based on their hourlyRate and their hoursWorked.
   public double getPay() {
	   if(hoursWorked <= 40) {
		   return hourlyRate * hoursWorked;
	   }
	   else {
		   return 40 * hourlyRate + (hoursWorked - 40) * (hourlyRate + hourlyRate * .20);
	   }
   }
   
 //Setter method that updates the hourlyRate of the person in the Payroll. Prints a statement saying input is invalid if raiseAmount is less than 0.
   public void getRaise(double raiseAmount) {
	   if(raiseAmount < 0) {
		   System.out.println("Invalid raiseAmount");
	   }else {
		   hourlyRate += raiseAmount;
	   }
   }   
   
 //Method that returns the overtime pay of the person in the Payroll.
   public double getOvertimePay() {
	   return (hoursWorked - 40 ) * (hourlyRate + hourlyRate * .20);
   }
 
 //Method that returns the string value of the information in the Payroll.
   public String toString() {
	   return ("Name: " + name + "\nID: " + id + "\nHours Worked: " + hoursWorked + "\nHourly Rate: " + hourlyRate);
   }
}

//Class showing example code that uses the Payroll method
class PayrollDriver {
  public static void main(String[] args) {
   
  //uncommnet  the provided code below
    System.out.println("Creating payroll objects");
    Payroll p1 = new Payroll("Alex Martinez" ,"123456", 25, 20);
    Payroll p2 = new Payroll("Ali Santos" ,"986747", 125, 45);
    Payroll p3 = new Payroll("Jose Busta" ,"45678", 55, 30);
    System.out.println("testing the toString method\n");
    
    System.out.println(p1);
    System.out.println("Salary is: " + p1.getPay());  //calling the getPay method
    System.out.println("\n*******************");
    System.out.println(p2);
    System.out.println("Salary is: "+ p2.getPay());
    System.out.println("\n*******************");
    System.out.println(p3);
    System.out.println("Salary is: "+ p3.getPay());
    System.out.println("\n*******************");
    System.out.println("\nTesting the setter methods");
    System.out.println("The hourly pay of " + p1.getName()  + " is being changed");
    p1.setHoursWorked(80);  // changing the hours worked for the object p1
    System.out.println(p1);
    
    
      
    
    
    
//***********************************************************************************

    //Custom code
    
    System.out.println("\n*******************");
    //1. create two objects of the payroll class
    Payroll pr1 = new Payroll("Cole Croteau", "251642", 16.75, 32);
    Payroll pr2 = new Payroll("Amanda Croteau", "268402", 21, 40);
    
    //2. display the objects on the screen by calling the toString method
    System.out.println(pr1.toString());
    System.out.println("\n*******************");
    System.out.println(pr2.toString());
    System.out.println("\n*******************");
    
    //2. display the salary of each person by calling the getPay method
    System.out.println("Cole Croteau's salary is: " + pr1.getPay());
    System.out.println("Amanda Croteau's salary is: " + pr2.getPay());
    System.out.println("\n*******************");
    
    //change the hourlyRate of the objects you created
    pr1.setHourlyRate(20);
    pr2.setHourlyRate(25);
    
    //display the objects again to see the changes you made by calling the toString method
    System.out.println(pr1.toString());
    System.out.println("\n*******************");
    System.out.println(pr2.toString());
    System.out.println("\n*******************");
    
    //change the hoursworked for the objects you created by calling the setter methods
    pr1.setHoursWorked(40);
    pr2.setHoursWorked(42);
    //display your objects again to see the changes you made
    System.out.println(pr1.toString());
    System.out.println("\n*******************");
    System.out.println(pr2.toString());
    System.out.println("\n*******************");
   
    //add another code you want
    pr1.getRaise(9999);
    System.out.println(pr1.toString());
    System.out.println("\nI'm rich!");
    
  }
}