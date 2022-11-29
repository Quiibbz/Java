/*
name: Cole Croteau
date: 10/10/22
description: A program that examines lists and their values. This includes checking if a list is a palindrome, comparing two lists, or converting a list to ascii code.
 */

import java.util.*;
import java.lang.*;
public class RecursiveCroteau {

}
 
//This class implements some methods recursively.
class Recursive {
   
   //This method accepts an arraylist of string objects, returns true if the list is palindrome and returns false othrewise.
   public static boolean palindrome(ArrayList<String> list) {
      //1. if the list size is 0 or 1 return true 
	   if(list.size() == 0 || list.size() == 1) {
		   return true;
	   }
	   //2. compare the first element and the last element using the equals method from the string class, store it in a variable   
       Boolean fEqualL = list.get(0).equals(list.get(list.size() - 1));
       //3. remove the element at the index 0 from the list
       list.remove(0);
       //4. remove the last element from the list
       list.remove(list.size() - 1);
       //5. return (variable at step 2 && palindrom(list))
       return fEqualL && palindrome(list);
   }
   
   //This method gets a string and finds the sequence of the asccii codes in the given string.
   public static String ascii(String s) {
	   //1. if the length of the string is return ""  (base case)
	   if(s.length() == 0) {
		   return "";
	   }
	   //2. return the asccii code of the first letter at the index 0 + ascii(s.substring(1)) 
	   return (int)(s.charAt(0)) + " " + ascii(s.substring(1));
   }
   
   //This method gets an array list and a string, return the longets string in the list.
   public static String longest(ArrayList<String> list, String longest) {
	   //1. if the size of the list is zero return longest (base case)
	   if(list.size() == 0) {
		   return longest;
	   }
	   //2.if the length of the vaiable longest is less than the length of the string at index 0
	   if(longest.length() < list.get(0).length()) {
		   // set the longest to the element at index 0
		   longest = list.get(0);
		   //remove the element at index 0
		   list.remove(0);
	   }else {
		   //3. else remove the element at index 0; 
		   list.remove(0);	   
	   }             
	   return longest(list, longest);     
   }
   
   /*This method compares two arraylists to see if they conatin the same values in the same order
    this method compares the element at index 0, if they are not the same it returns false
    if the elements at the index 0 are the same, remove the elemnet at index 0 
    then call the method equals.     
   */
   public static Boolean equals(ArrayList<String> list1, ArrayList<String> list2) {
	   //1. if the size of the list1 and list2 are not the same return false(base case)
	   if(list1.size() != list2.size()) {
		   return false;
	   }
	   //2.if the size of the list1 or list2 is zero return true (base case)
       	if(list1.size() == 0 || list2.size() == 0) {
       		return true;
       	}
       	//3. if the elements at index 0 are not the same return false (base case)  
       	if(list1.get(0) != list2.get(0)) {
       		return false;
       	}
       	//4. remove the element at the index zero from the list1
       	list1.remove(0);
       	//5.remove the element at the index zero from the list2    
       	list2.remove(0);
       	return true && equals(list1,list2); 
   }
   
   /*This method gets a link list of string values. 
   finds the sum of the length of all the strings stored in the list
   at every recursive call the size of the list must get smaller.
   */
   public static int wordsSumLength(LinkedList<String> list) {
	   //1. if the size of the list is zero return 0 ( base case)
	   if(list.size() == 0) {
		   return 0;
	   }
	   //2. store the length of the first element in the list in a variable         
	   int length = list.get(0).length();
	   //remove the element at the index 0
	   list.remove(0);
	   //3. return the variable you declared at step 2 + wordsSumLength(list)
	   return length + wordsSumLength(list);
   } 
}

//Driver to test the code.
class Driver {
   public static void main(String [] args) {
      System.out.println("testing the palindrome method");
      String[] words = {"Hello","Bye","Car","Watches","Cat","Dog","Houses","Chair","Computers"};
      System.out.println(Arrays.toString(words));
      ArrayList<String> list = new ArrayList<String>();
      //filling in the arraylist
      for(int i = 0; i <words.length; i++) {
         list.add(words[i]);
      }
      //testing the palindrom method    
      System.out.print(Arrays.toString(words) + " is palindrome?  ");
      System.out.println(Recursive.palindrome(list));
      //creating another arraylist
      ArrayList<String> list2 = new ArrayList<String>();
      list2.add("1");
      list2.add("23445");
      list2.add("3455");
      list2.add("2rtrtryty");
      list2.add("1rttrt");
      //testing the palindrome method
      System.out.print(list2 + " is palindrome?  ");
      System.out.println(Recursive.palindrome(list2));
      ArrayList<String> list4 = new ArrayList<String>();
      list4.add("a");
      list4.add("b");
      list4.add("c");
      list4.add("b");
      list4.add("a");
      System.out.print(list4 + " is palindrome?  ");
      System.out.println(Recursive.palindrome(list4));
      
      //*******************testing the ascii method      
      System.out.println("\ntesting ascii method");
      String s ="abcdef"; 
      System.out.println("The list of the ascii code in the string " + s  + " is "+ Recursive.ascii(s));
      
      //**************************testing the longest method
      //filling in the array list
      for(int i = 0; i < words.length; i++)
         list.add(words[i]);
      System.out.println("\ntesting longest string in the list of string" + list.toString());
       
      System.out.println("The longest string in the list " + list.toString() + " is " + Recursive.longest(list,""));
      //*********************************************************   
        //testing the equlas method 
         
      for(int i = 0; i <words.length; i++) { // rebuilding the list
         list.add(words[i]); 
      }
      System.out.println("\ntesting the equals method on two arraylist");
      
      System.out.println("first list: " + list);
      System.out.println("second list: " + list2);
      System.out.println("Are the two lists equal: " + Recursive.equals(list,list2)); 
      ArrayList<String> list5 = new ArrayList<String>();
      for(int i = 0; i <words.length; i++) {
         list5.add(words[i]); 
      }
      System.out.println("first list: " + list);
      System.out.println("second list: " + list5);
      System.out.println("Are the two lists equal: " + Recursive.equals(list,list5));      
      
      //testing the length method     
             
      System.out.println("\ntesting the sum of the integers in a link list");
      LinkedList<String> list3 = new LinkedList<String>();
      list3.add("aaaa");
      list3.add("abababab");
      list3.add("abcabcabcabc");
      list3.add("bbbcccdddeee");
      System.out.println("The average length of the string in the list " + list3);
      System.out.println(" is " + Recursive.wordsSumLength(list3)); 
   }
}
