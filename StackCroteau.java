/*
name: Cole Croteau
date: 10/10/22
description: A program that takes an expression, converts it into postfix form, and gives the result of the expression.
 */

import java.util.*;
public class StackCroteau {
}

//Interface used by the Stack object.
interface myStack {
   public void push(String s);
   public String peek();
   public boolean isEmpty();
   public String pop();
}

//Stack object used to create a postfix expression in the program.
class  Stack {
   
	private  String[] s;
  
   //Representing the element at the top
   private int top;
   
   //Constructor.
   public Stack() {
      s = new String[20];
      top = -1;  
   }
   
   //Adds a given value to the top of the stack.
   public void push(String token) {
      top++;
      s[top] = token;
   }
   
   //Removes the top-most value of the stack, and returns what was removed.
   public String pop() {
	   String i = s[top];
	   top--;
	   return i;
   }
   
   //Returns the top-most value of the stack, or null if its empty.
   public String peek() {
	   if (top != -1) {
		   return s[top];
	   }
	   else {
		   return null;
	   }
   }
   
   //Returns true if the Stack is empty, or false if not.
   public Boolean isEmpty() {
	   if(top == -1) {
		   return true;
	   }
	   return false;
   }
   
   //Returns a string value of the Stack object.
   public String toString() {
	   String i = "";
	   for(int j = 0; j < s.length; j++) {
		   i += s[j];
	   }
	   return i;
   }
}

//Expression object that gets turned into a postfix expression and gets its result determined later in the program.
class Expression {
   private String exp;  // instance variable
   public Expression(String s) {
      exp = s;
   }
   
   //Determines if the given operator is a '*', '/', '+', or '-'. Assigns an integer value to the operator and returns that value.
   private static int precedence(String opr) {
	  if(opr == null) {
		  return 0;
	  }else if(opr.equals("*") || opr.equals("/")) {
    	  return 3;
      }else if(opr.equals("+") || opr.equals("-")) {
    	  return 2;
      }else {
    	  return 0;
      }
   }
     
  //Calculates the output of two integers and the given operator. Returns the result.
   private int calculate(String opr , int n1, int n2) {
	   char op = opr.charAt(0);
	   if(op == '*') {
		   return n1 * n2;
	   }else if(op == '+') {
		   return n1 + n2;
	   }else if(op == '-') {
		   return n2 - n1;
	   }else if(op == '/') {
		   return n2 / n1;
	   }else {
		   return 0;
	   }
   }
   
   //Calculates the postfix of a given expression, and returns the postfix.
   public String getPostfix() {
	   String expression = "";
	   Stack postfix = new Stack();
	   StringTokenizer st = new StringTokenizer(exp, " ");
	   while(st.hasMoreTokens()) {
		   String token = st.nextToken();
		   if(token.equals("*") || token.equals("+") || token.equals("/") || token.equals("-")) {
			   int pre = precedence(token);
			   if(pre == 3) {
				   while(postfix.isEmpty() != true && precedence(postfix.peek())==3) {
					   String popped = postfix.pop();
					   expression += popped + " ";
				   }
			   }else if(pre == 2) {
				   while(postfix.isEmpty() != true && (precedence(postfix.peek()) == 2 || precedence(postfix.peek()) == 3)) {
					   String popped = postfix.pop();
					   expression += popped + " ";
				   }
			   }
			   postfix.push(token);
		   }
		   else {
			   expression += token+" ";
		   }
	   }
	   while(postfix.isEmpty() != true) {
		   String popped = postfix.pop();
		   expression += popped+" ";
	   }
	   return expression;
   }
   
   //Evaluates the postfix, and returns the result.
   public int evalPostfix() {
	   String post = this.getPostfix();
	   Stack evald = new Stack();
	   int result = 0;
	   StringTokenizer st = new StringTokenizer(post, " ");
	   while(st.hasMoreTokens()) {
		   String token = st.nextToken();
		   char o = token.charAt(0);
		   if(o != '*' && o != '+' && o != '/' && o != '-') {
			   evald.push(token);
		   }else {
			   String n1 = evald.pop();
			   String n2 = evald.pop();
			   int num1 = Integer.parseInt(n1);
			   int num2 = Integer.parseInt(n2);
			   int calc = calculate(token, num1, num2);
			   String c = "" + calc;
			   evald.push(c);
		   }
	   }
	   String popped = evald.pop();
	   result += Integer.parseInt(popped);
	   return result;
   }
}

//Driver to test the code.
class ExpDrive {
   public static void main(String[] args) {
      String[] exp = new String[11];
      exp[0] = "2 + 3 + 7 * 4 - 2 / 3 + 4";
      exp[1] = "3 - 4 / 2 + 6 * 3 + 5";
      exp[2] = "5 * 6 - 8 + 2 * 10 - 12"; 
      exp[3] = "4 + 8 * 3 - 2 / 34  * 2";
      exp[4] = "2 + 5 - 3 * 2 / 3 + 16";
      exp[5] ="6 - 3 + 6 / 2 * 4 - 8 / 2"; 
      exp[6] = "2 + 3 * 6 + 5 - 3";
      exp[7] = "2 * 3 + 4  / 3 * 2 + 6";
      exp[8] = "2 * 3 + 1 - 3 * 4 * 2";
      exp[9] = "1 + 2 * 3 - 6 * 7 + 2 * 3 + 2 * 3";
      exp[10] = "23 + 5 * 6 - 2 / 4 + 8 / 2";
      for(int i = 0; i < exp.length ; i++) {
         Expression e1 = new Expression(exp[i]);
         String post = e1.getPostfix();
         int result = e1.evalPostfix();
         System.out.println("Infix: "+ exp[i] + ",  postfix: " + post + " = " + result);
      }
   }
}
