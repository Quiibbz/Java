/*
name: Cole Croteau
date: 10/10/22
description: Social Media app that allows you basic social media controls like editing your information, following, and unfollowing others.
self-grade: 100%: The input is 1:1 of the sample input provided, the code is organized with no useless code, and there are plenty of comments throughout the code.
 */

import java.util.*;

public class InstaCroteau {

}

//Creation of the User object
class User implements Comparable {
   private String first;
   private String last;
   private String username;
   private boolean followBack; 
     
   //Constructor of User object
   public User(String first, String last, String username, boolean followBack){
       this.first = first;
       this.last = last;
       this.username = username;
       this.followBack = followBack;
   }
   
   //Returns boolean value of whether you are following someone or not
   public boolean getFollow() {
      return followBack;
   }
   
   //Assigns you to unfollow someone
   public void unfollow() {
      followBack = false;
   }
   
   //Assigns you to following someone
   public void  follow() {
      followBack = true;
   }
   
   //Returns the first name of the user
   public String getFirst() {
      return first;
   }
   
   //Returns the last name of the user
   public String getLast() {
      return last;
   }
   
   //Sets the first name of the user
   public void setFirst(String first) {
      this.first = first;
   }
   
   //Sets the last name of the user
   public void setLast(String last) {
      this.last = last;
   }
   
   //Returns the username of the user
   public String getUsername() {
      return username;
   }
   
   //Comparable method for comparing two objects alphabetically
   public int compareTo(Object o) {
	   if(o instanceof User) {
		   User u = (User) o;
		   return this.getUsername().compareTo(u.getUsername());
	   }
       return 0;
   }
   
   //Returns true if two users are equal to eachother
   public boolean equals(User other) {
	   if(this.username.equalsIgnoreCase(other.username)) {
		   return true;
	   }
	   return false;
   }
   
   //Returns a string value of the user object
   public String toString() {
	  String s = "";
	  s += "\nUser name : " + username;
	  s += "\nName : " + first;
	  s += "\nLast name : " + last;
	  if(followBack == true) {
		  s += "\nYou follow back this person";
	  }else {
		  s += "\nYou are not following this person";
	  }
	  
	  return s;
           
   }
}

//Creation of the SocialMedia object
class SocialMedia{
		
   private ArrayList<User> app;
     
   //Constructor
   SocialMedia(){
      app = new ArrayList<User>();
   }
   
   //Follows back one of your followers
   public void followBack(String username) {
       String s = username;
       for(int i = 0; i < app.size(); i++) {
    	   String s1 = app.get(i).getUsername();
    	   if(s.equalsIgnoreCase(s1)) {
    		   app.get(i).follow();
    	   }
       }
   }
   
   //Adds a new user to your follower list
   public boolean follow(String first, String last, String username, boolean followBack) {
	   boolean added = false;
	   if(search(first,last) == false) {
		   User s = new User(first,last,username,followBack);
		   if(app.size() == 0) {
			   app.add(s);
			   return true;
		   }
		   for(int i = 0; i < app.size(); i++) {
			   if(s.compareTo(app.get(i)) < 0) {
				   app.add(i,s);
				   added = true;
				   break;
			   }
		   }
		   if(!added) {
			   app.add(s);
			   return true;
		   }
	   }
       return false;                   	
   }
     
   //Removes a user from your follower list
   public boolean remove(String first, String last) {
       if(search(first,last) == true) {
    	   for(int i = 0; i < app.size(); i++) {
    		   if(app.get(i).getFirst() == first && app.get(i).getLast() == last) {
    			   app.get(i).unfollow();
    			   app.remove(i);
    			   break;
    		   }
    	   }
    	   return true;
       }
       return false;
   }
           
   //Searches for a user on your follower list 
   public boolean search(String first, String last) {
	   for(User s: app) {
		   if(s.getFirst() == first && s.getLast() == last) {
			   return true;
		   }
	   }
       return false;
   }
   
   //Returns what app the list of followers is for
   public ArrayList<User>getList(){
      return app;
   }
   
   //Checks how many followers you have
   public int followerCounts() {
       return app.size();
   }
   
   //Checks how nany users you are following
   public int followingCounts() {
      int count = 0;
      for(int i = 0; i < app.size(); i++) {
    	 if(app.get(i).getFollow() == true) {
    		 count++;
    	 }
      }
      return count;      
   } 
   
   //Returns a string value of the ArrayList of followers
   public String toString() { 
       String s = "";
       for(int i = 0; i < app.size(); i++) {
    	   s += app.get(i).toString();
    	   s += "\n***************************************************************";
       }
       return s;
   }
}

/* create your own driver here */
class MyDriver {
   public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
      SocialMedia myTwitter = new SocialMedia();
      
      //Assigning followers
      myTwitter.follow("Diane", "Roberta", "DiaRo", false);
      myTwitter.follow("Cameron", "Walty", "CamWa", true);
      myTwitter.follow("Jeremy", "Price", "JerPri", true);
      myTwitter.follow("Edith", "Finch", "EdiFi", false);
      myTwitter.follow("Roberto", "Gonzales", "RobGo", false);
      
      //Displaying followers
      System.out.println("Your followers informations \n");
      System.out.println(myTwitter);
      
      //Following back one of your followers
      System.out.print("\nInput the username of one of your followers that you'd like to follow back : ");
      String s = input.next();
      myTwitter.followBack(s);
      
      //Adding a follower
      System.out.println("\nAbraham Lincoln has decided to follow you!");
      myTwitter.follow("Abraham", "Lincoln", "AbrLinc", false);
      
      //Searching for a follower
      System.out.println("\nNow searching for Jeremy Price in your followers list...");
      if(myTwitter.search("Jeremy","Price") == false) {
    	  System.out.println("Jeremy Price is not in your followers list.");
      }else {
    	  System.out.println("Jeremy Price is in your followers list.");
      }
      
      //User unfollows you
      System.out.println("\nCameron Walty is no longer following you.");
      myTwitter.remove("Cameron", "Walty");
      
      //Displaying the list of followers
      System.out.println("\nHere is your final list of followers!");
      System.out.println(myTwitter);
      
      //Displays followers and following
      System.out.println("\n You are being followed by " + myTwitter.followerCounts() + " people.");
      System.out.println("You are following " + myTwitter.followingCounts() + " people.");
   }
}

/*below is a sample driver. Do not remove this driver from your code when submitting it*/
class Driver {
	
   public static void main(String[]args) {
      SocialMedia myInsta = new SocialMedia();
      
    	/*Adding followers to your list*/
      /*the boolean field indicates whether you want to follow them back*/
      myInsta.follow("Matthew", "Philips", "MatPhil", true);
      myInsta.follow("Gary", "Kane",  "GKane", false); 
      myInsta.follow("Bill", "Fitch", "BillF",true);
      myInsta.follow("Robert", "Kenny",  "RKenny", true); 
      myInsta.follow("Trevor", "Schlulz", "TrevorS", false);
      
    	/*Displaying your followers*/
      System.out.println("Your followers informations\n");
      System.out.println(myInsta);
    	
      /*Unfollowing a user*/
      System.out.println("\nRemoving Robert Kenny from your followers list");
      myInsta.remove("Robert", "Kenny");
   	
      /*Displaying the list*/
      System.out.println("List of followers after removing Robert Kenny");
      System.out.println(myInsta);
   	
      /*adding a new follower*/
      System.out.println("\nAdding Elon Musk to your list of followers");
      myInsta.follow("Elon", "Musk", "ElonM", true);
      
      /*Dipslying the followers*/
      System.out.println("List of your followers:");
      System.out.println(myInsta);
   	
      /*Searching for a follower*/
      System.out.println("\nSearching for Stonewall Jackson(StonW) in your followers list");
      if(myInsta.search("Jackson", "Stonewall") == false) {
         System.out.println("Stonewall Jackson is not in your list of followers");
         System.out.println("\n***************************");   
         System.out.println("You are following " + myInsta.followerCounts() + " people");
      
         System.out.println("You have " + myInsta.followingCounts() + " followers");  
         System.out.println(myInsta);
         Scanner kb = new Scanner(System.in);
         System.out.println("\nEnter the username of the person that you want to follow back: ");
      
         String username = kb.next();
          
         myInsta.followBack(username);
      
         System.out.println(myInsta);
      
      }
   	
   }
}