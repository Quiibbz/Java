/*
Name: Cole Croteau
Date: 9/11/2022
description: A program that reads 10 distinct numbers from the user, and displays the 10 numbers while also removing any repeats.
*/
import java.util.*;
public class DistinctNumbersCroteau {

   //Main method housing the introduction, and the empty body of the array that will house the integers inputted by the user.
   public static void main(String[] args) {
      System.out.println("Welcome to the distinct numbers. \nI will remove the repeated numbers and display the numbers you just entered. As long as you have \nnot entered 10 distinct numbers I will keep prompting you to enter a number");
      int[] num = new int[10];
      int counter = getInput(num);
      display(num, counter);
   }
   
   //Obtains an integer from the user, checks if it's identical to any of the integers already in the array, and adds it to the array if it is distinct.
   public static int getInput(int[] numbers) {
      Scanner input = new Scanner(System.in);
      //Use of a fencepost technique to obtain a starting number to look at for comparing duplicates in the for loop.
      System.out.print("Enter a number: ");
      numbers[0] = input.nextInt();
      int total = 1;
      for(int i = 1; i < 10; i++) {
         System.out.print("Enter a number: ");
         int next = input.nextInt();
         boolean unique = isDistinct(numbers, next);
         if (unique == true) {
            numbers[i] = next;
         //If the number inputed is not unique, the code will loop for an additional time on top of the minimum 10 loops.
         } else {
            i--;
         } 
         total++;
     }
     return total;
   }
   
   //Module that displays how many numbers the user inputted, as well as the filtered list of numbers they inputted.
   public static void display(int[] num, int counter) {
      System.out.println("Cole Croteau");
      System.out.println("You entered " + counter + " numbers total, I filtered out all the repeated numbers. \nHere is the list of distinct numbers you entered.");
      System.out.print(Arrays.toString(num));
    }
   
   //Module that checks to see if the inputted number is a repeat. 
   public static boolean isDistinct(int[] num, int n) {
      int count = 0;
      //If the input is identical to any numbers already in the array, it adds +1 to the int counter
      for(int i = 0; i < num.length; i++) {
         if(n == num[i]) {
            count++;
         }
      }
      //If the counter is higher than 0 (indicating the number of times the number is already in the array), it tells the program that this is a repeat, and should not be added to the array.
      if(count == 0) {
         return true;
      }
      return false;
   }
} 