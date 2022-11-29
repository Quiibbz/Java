/*
name: Cole Croteau
date: 9/10/22
descrition: A numbers matching game that asks the user for a maximum number, then generates three random numbers between 1 and that number. Any matches gives points and gives the final score at the end of the game.
*/

import java.util.*;
public class MatchingGameCroteau {
	//Main method that puts all the modules together, and says goodbye to the user when the user is done playing.
	public static void main(String[] args) {
	    Random rand = new Random();
	    Scanner kb = new Scanner(System.in);  
        String answer = "";
        //As long as the user does not input the letter q, the game will continue to loop. If they input the letter q the program says goodbye and ends.
        while (!answer.equalsIgnoreCase("q")) {
    	    description();
            System.out.print("What is your name: ");
            String name = kb.nextLine(); 
            System.out.println("\nHello " + name + " lets start playing");
            play(rand);
            System.out.print("Hit enter to let another person play or enter Q to quit the program ");
            answer = kb.nextLine();
        }
        System.out.print("Good Bye! Come Back soon to play again");    
    }
	//Module that obtains a random number between 1 and the maximum number given by the user.
	public static int getRand(Random rand, int max) {
		int random = rand.nextInt(max) + 1;
		return random;
		}
	//Module that assigns three random numbers from the getRand module and keeps score based on how many times there is a match among the numbers.
	public static void play(Random rand) {
		Scanner kb = new Scanner(System.in);
        int total = 0;
        String answer = "";
        int n1= 0, n2 = 0, n3 = 0;
        //Asks the user for a max number value to be passed into the getRand method
        System.out.print("\nEnter the max value to generate a random number: ");
        int max = kb.nextInt();
        kb.nextLine();
        //As long as the user does not input the letter q, three new random numbers are chosen and points are given to the user if there are any matches among the numbers.
        while(!answer.equalsIgnoreCase("q")) {
        	n1 = getRand(rand,max);
        	n2 = getRand(rand,max);
        	n3 = getRand(rand,max);
            System.out.println("\nYou got " + n1 + " " + n2 + " " + n3);
        	int match = match(n1,n2,n3);
        	if (match == 2) {
        		total+= 200;
        		System.out.println("You got two matches, you won 200 dollars");
        	}   
        	else if(match == 3) {
        		total+= 500;
        		System.out.println("You got three matches, you won 500 dollars");
        	} else {
        		System.out.println("Sorry no match");
        	}  
        	System.out.print("\nHit enter to continue or press q/Q to quit ");
    		answer = kb.nextLine();
       
        }
        //If the user inputs the letter q, the method prints the total score of the user, then exits back to the main method.
        System.out.println("\nTotal amount you won: " + total);
        System.out.println("\n");    
	}
	//Module that checks which numbers match, and returns either the number 2 (for 2 matching numbers), 3 (for all numbers matching), or 0 (for no matching numbers)
	public static int match(int n1, int n2, int n3) {
		if(n1 == n2 && n2 == n3) {
			return 3;
		}else if(n1 == n3) {
			return 2;
		}else if(n1 == n2) {
			return 2;
		}else if(n2 == n3) {
			return 2;
		}else {
			return 0;
		}
	}
	//Module that prints the description of the game shown at the beginning of the program
	public static void description() {
		System.out.println("*************************************************************************");
		System.out.println("*******************");
		System.out.println("* Welcome to number matching game. I will generate three random numbers");
		System.out.println("for you base on your input. If two      *");
		System.out.println("* of the numbers match you win 200, if you get three matching numbers you"); 
		System.out.println("win 500 dollars   *");
		System.out.println("***************************************************************************");
		System.out.println("*******************\n");
	}
}
