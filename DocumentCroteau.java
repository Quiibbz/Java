/*
name: Cole Croteau
date: 9/26/22
description: An emailing program that allows for modifying ever aspect of the email before sending it, as well as forwarding the emails.
self-grade: 100%: The input is 1:1 of the sample input provided, the code is organized with no useless code, and there are plenty of comments throughout the code.
 */

import java.util.*;

public class DocumentCroteau {
   //no code goes here. Must leave empty
}

//Super class contaiing the object "Document" with it's associated constructor, getters, and setters.
class Document {
 private String content;
 
 //Constructor for Document
 public Document(String text) {
	 content = text;
 }
 
 //Getter to obtain the string "content"
 public String getContent() {
 	return content;
 }
 
 //Setter to set string "content"
 public void setContent(String text) {
	 content = text;
 }
 
 //Converts the information object into a string
 public String toString() {
	 return "Content: " + content;
 }
 
 //Getter to obtain the length of string "content"
 public int getContentLength() {
	 return content.length();
 }
 
 //Setter method that sets a boolean to true if the string "content" contains a specified keyword, and false if not.
 public boolean contains(String keyword) {
	 return content.contains(keyword);
 }
 
 //Setter that sets a boolean to true if the specified Document object is equivalent in value to this Document object, and false if not.
 public boolean equals(Document other) {
	 return this.content.equalsIgnoreCase(other.content);
 }
}

//subclass containing the object Email that extends off the superclass Document.
class Email extends Document {                        
     private String sender;
     private String recipient;
     private Date date = new Date();
     private String subject;
     private String cc;
     private boolean isSent;
     
     //Constructor for the object Email
     public Email(String text, String sender, String recipient, String subject, String cc) {
    	 super(text);
    	 this.sender = sender;
    	 this.recipient = recipient;
    	 this.subject = subject;
    	 this.cc = cc;
     }
     
     //Setter method that sets the boolean isSent to true.
     public void sent() {
    	 isSent = true;
     }
     
     //Creates a new email using information from an existing email that acts as forwarding the email to the specified person.
     public Email forward(String recipient, String sender, String cc) {
    	 Email f = new Email(this.getContent(), sender, recipient, this.subject, cc);
    	 f.date = new Date();
    	 f.isSent = true;
    	 return f;
     }
     
     //Returns the value of the boolean "isSent".
     public boolean getIsSent() {
    	 return isSent;
     }
     
     //Returns the contents of the string "sender"
     public String getSender() {
    	 return sender;
     }
     
     //Returns the contents of the string "recipient"
     public String getRecipient() {
    	 return recipient;
     }
     
     //Returns the contents of the string "subject"
     public	String getSubject() {
    	 return subject;
     }
     
     //Returns the content of the string "cc"
     public String getCC() {
    	 return cc;
     }
     
     //Obtains the date given by the system clock.
     public Date getDate() {
    	 return date;
     }
     
     //Changes who the sender is as long as the email has not already been sent.
     public void setSender(String sender) {
    	 if(isSent == false) {
    		 this.sender = sender;
    	 }else {
    		 System.out.println("This email has been sent and the sender cannot be changed");
    	 }
     }
     
     //Changes who the recipient is as long as the email has not already been sent.
     public void setRecipient(String recipient) {
    	 if(isSent == false) {
    		 this.recipient = recipient;
    	 }else {
    		 System.out.println("This email has been sent and the recipient cannot be changed");
    	 }
     }
     
     //Changes what the subject is as long as the email has not already been sent.
     public void setSubject(String subject) {
    	 if(isSent == false) {
    		 this.subject = subject;
    	 }else {
    		 System.out.println("This email has been sent and the subject cannot be changed");
    	 }
     }
     
     //Changes what the cc is as long as the email has not already been sent.
     public void setCC(String cc) {
    	 if(isSent == false) {
    		 this.cc = cc;
    	 }else {
    		 System.out.println("This email has been sent the CC cannot be changed");
    	 }
     }
     
     //Returns the information given from the sub-object "Email" as well as a piece of information from the object "Document" into String form.
     public String toString() {
    	 String s = "Sender: " + sender;
    	 s = s + "\nRecipient: " + recipient;
    	 s = s + "\nCC: " + cc;
    	 s = s + "\nSubect: " + subject;
    	 s = s + "\nDate: " + date;
    	 s = s + "\n" + super.toString();
    	 return s;
     }
     
     //Changes the contents of the message as long as the email has not already been sent.
     public void modifyContent(String newText) {
    	 if (isSent == false) {
    		 super.setContent(newText);
    	 }else {
    		 System.out.println("This email has been sent and cannot be modified");
    	 }
     }
     
} 

//****************************************************************************************

//uncommnet this driver class once you have implemented the Documnet class and the Email class  
     
class EmailDriver {
    // public Email(String text, String sender,String recipiant, String subject, String cc)
    public static void main(String[] args) {
      //creating an Email object
       Email e3 = new Email("Hello everyone, we will have a meeting tomorrow at 10", "Gita Faroughi","Alex","Meeting","");
      
       //sending the email
       e3.sent();
       
       //disply the details about the email
       System.out.println(e3);
       System.out.println("\n\n");
       
       //searching the email for the email for the word tomorrow
       boolean b = e3.contains("tomorrow");
       if(b)
         System.out.println("The word tomorrow was found in the email");
       else
          System.out.println("The word tomorrow was found in the email"); 
           
      
       //displaying just the content(text) of the email
       System.out.println("\nThe content of this email is: " + e3.getContent());
       System.out.println();
       //modifying the content of the email
       e3.modifyContent("bye");
       
       //changing the recipient of the e1 email
       e3.setRecipient("Jose@yahoo.com,Mary@gmail.com");
       System.out.println();
       
       //forwarding the email
       Email forward = e3.forward("Alex", "Gita" ,"Maria");
       System.out.println();
       
       //printing the forwarded email 
       System.out.println("forwarded message\n"+ forward);
       System.out.println();
       
       //display the length of the text in the email
       System.out.println("The number of the letters in the email is: " + e3.getContentLength());
       
       System.out.println("***********************************************************************");
       //your turn, refer to the provided documnet on the codes you need to write
       System.out.println();
       
       //Creates two Email objects, e1 and e2
       Email e1 = new Email("Hello Professor, when is the final exam?", "Cole Croteau", "Professor Watkins", "Final Exam Question", "");
       Email e2 = new Email("Hey mom, just wanted to say that I love you <3", "Dylan Watkins", "Jessica Watkins", "Hello Mother", "");
       
       //Sends e1 and then prints out the the string value of e1.
       e1.sent();
       System.out.println(e1);
       System.out.println();
       
       //Changes the Sender of e1, forwards e1 to Jeremy Dunce, and then prints the contents of the forwarded email.
       e1.setSender("Dylan Daniels");
       System.out.println();
       System.out.println("Now forwarding e1 to Jeremy Dunce\n");
       Email e1forward = e1.forward("Professor Watkins", "Cole Croteau", "Jeremy Dunce");
       System.out.println(e1forward);
       System.out.println();
       
       //Changes the recipient of e2, changes the contents of the message of e2, and prints out the length of the message of e2.
       e2.setRecipient("Alexander Pen");
       e2.setContent("Hello, I was wondering if your refridgerator is running?");
       System.out.println("The number of letters in e2 is: " + e2.getContentLength());
       System.out.println();
       
       //Checks to see if the word "wondering" is in e2.
       boolean word = e2.contains("wondering");
       if(word == true) {
    	   System.out.println("e2 contains the word \"wondering\"");
       }else {
    	   System.out.println("e2 does not contain the word \"wondering\"");
       }
       System.out.println();
       
       //Sends e2 and prints out the string value of e2.
       e2.sent();
       System.out.println(e2);
       
       
    }
}