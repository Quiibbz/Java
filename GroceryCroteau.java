/*
name: Cole Croteau
date: 10/10/22
description: Grocery app that manages the items in your cart with the ability to add or remove items while keeping the order in which items were added.
self-grade: 100%: The input is 1:1 of the sample input provided, the code is organized with no useless code, and there are plenty of comments throughout the code.
 */

import java.util.*;
public class GroceryCroteau {

}

class Item implements Comparable<Object> {
	
	//List of instance variables
	private String name = "";
	private double price = 0;
	private String expDate = "";
	private String barcode = "";
   
	//Constructor for the object Item
	Item(String name, double price, String expDate, String barcode) {
      this.name = name;
      this.price = price;
      this.expDate = expDate;
      this.barcode = barcode;
   	}
	
	//Returns the name of the item
   	public String getName() {
	   return name;
   	}
   	
   	//Returns the price of the item
   	public double getPrice() {
	   return price;
   	}
   
   	//Returns the expiration date of the item
   	public String getExpDate() {
	   return expDate;
   	}
   	
   	//Returns the barcode of the item
   	public String getBarcode() {
	   return barcode;
   	}
   
   	//Sets the name of the item
   	public void setName(String name) {
	   this.name = name;
   	}
   
   	//Sets the price of the item
   	public void setPrice(double price) {
      this.price = price;
   	}
   	
   	//Sets the expiration date of the item
   	public void setExpDate(String expDate) {
       this.expDate = expDate;
   	}
   
   	//Sets the barcode of the item
   	public void setBarcode(String barcode) {
       this.barcode = barcode;
   	}
   
   	//Compares the two objects for equality based on the barcode of the object
   	public boolean equals(Object o) {
   		if(o instanceof Item) {
   			Item u = (Item) o;
   			if(this.barcode.equalsIgnoreCase(u.barcode)) {
   				return true;
   			}
   		}
   		return false;
   	}
   
   /* Compares the two objects based on the name of the objects, if the names are 
    * the same then it compares based on the barcode*/
   	public int compareTo(Object o) {
   		if(o instanceof Item) {
   			Item u = (Item) o;
   			if(this.getName().equalsIgnoreCase(u.getName())) {
   				return this.getBarcode().compareTo(u.getBarcode());
   			}
   			return this.getName().compareTo(u.getName());
   		}
   		return 0;
   }
   
   //Returns String representation of the object Item
   public String toString() {
	   String s = "";
	   s += "\nBarcode: " + barcode;
	   s += "\nName: " + name;
	   s += "\nPrice: " + price;
	   s += "\nExpiration Date: " + expDate + "\n";
 	   return  s;
   }
}

class ListNode {
	private Item item;
    private ListNode next;
    
    //Constructor 1
    public ListNode() {
    	
    }
    
    //Constructor 2
    public ListNode(Item item) {
    	this.item = item;
    }
    
    //Constructor 3
    public ListNode(Item item, ListNode next) {
    	this.item = item;
    	this.next = next;
    }
    
    //Initializes the pointer to the next node in the list
    public void setNext(ListNode n) {
    	this.next = n;
    }
    
    //Returns the item
    public Item getItem() {
    	return item;
    }
    
    //Returns where the pointer is in the list
    public ListNode getNext() {
    	return next;
    } 
}

interface List {
	public void add(String food, double price, String expDate, String barcode);
	public void add(int index, String name, double price, String expDate, String barcode);
	public int indexOf(String barcode);
	public Item remove(String barcode);
	public int getSize();
	public String toString();
	public Item get(int index);
	public Item mostExpensive();
	public Item leastExpensive();
}

//GroceryList class that organizes a list of Items
class GroceryList implements List {
	
	//List of instance variables
	private ListNode head;
	public static int size = 0;
 
	//Constructor 1
	public GroceryList() {
		head = null;
	}
	
	//Constructor 2
	public GroceryList(Item i) {
		head = new ListNode(i);
		size++;
	}
	
	/* This method creates an Item object, finds the end of the list and adds it to 
	the end*/
	public void add(String name, double price, String expDate, String barcode) {
		Item i = new Item(name, price, expDate, barcode);
		ListNode curr = head;
		if(head == null) {
			head = new ListNode(i);
			size++;
			return;
		}
		ListNode n = new ListNode(i);
		while(curr.getNext() != null) {
			curr = curr.getNext();
		}
		curr.setNext(n);
		size++;
	}
	
	/* creates an item object, finds the given index, adds the item at the given 
	index*/
	public void add(int index, String name, double price, String expDate, String barcode) {
       Item k = new Item(name, price, expDate, barcode);
       if(index > size) {
    	   return;
       }
       if(index == 0) {
    	   ListNode n = new ListNode(k);
    	   n.setNext(head);
    	   head = n;
    	   size++;
    	   return;
       }
       ListNode curr = head;
       int i = 0;
       while(curr.getNext() != null && i < index-1) {
    	   curr = curr.getNext();
    	   i++;
       }
       ListNode n = new ListNode(k);
       n.setNext(curr.getNext());
       curr.setNext(n);
       size++;
	}
        
	/*searches the list for the given barcode and returns the index of the item with
	the given barcode*/   
	public int indexOf(String barcode) {
		if(head == null) {
			return -1;
		}
		if(barcode.equals(head.getItem().getBarcode())) {
			return 0;
		}
		ListNode curr = head;
		int index = 0;
		while(curr != null && index <= size) {
			if(curr.getItem().getBarcode().equals(barcode)) {
				return index;
			}
			curr = curr.getNext();
			index++;
		}
		return -1;
	}
	
	/* searches the list for the given barcode, removes the item from the list and 
	returns the removed item*/
	public Item remove(String barcode) {
		if(head == null) {          
			return null;
		}
		if(head.getItem().getBarcode().equals(barcode)) {
			head = head.getNext();
		}
		ListNode pre = head;
		ListNode curr = head;
		while(curr != null && !(curr.getItem().getBarcode().equals(barcode))) {
			pre = curr;
			curr = curr.getNext();
		}
		if(curr != null && curr.getNext() == null && (curr.getItem().getBarcode().equals(barcode))) {
			Item s = curr.getItem();
			pre.setNext(null);
			size--;
			return s;
		}else {
			Item s = curr.getItem();
			pre.setNext(curr.getNext());
			size--;
			return s;
		}
	}
	
	//Returns the size of the list
	public int getSize() {
		return size;
	}
	
	/*goes through the list, calls the toString method on each item in the list, 
	returns a String representing all
  	the objects in the list*/
	public String toString() {
		if(head == null) {
			return "";
		}
		ListNode curr = head;
		int i = 1;
		String s = "";
		while(curr != null) {
			s += i + "." + curr.getItem().toString() + "\n";
			curr = curr.getNext();
			i++;
		}
		return s;
	}
	
	/* returns the item at the given index, goes through the list, finde the given 
	index, returns the item at the index*/
	public Item get(int index) {
		if(head == null) {
			return null;
		}
		if(index > size) {
			return null;
		}
		ListNode curr = head;
		int i = 0;
		while(curr != null && index != i) {
			i++;
			curr = curr.getNext();
		}
		if(curr == null) {
			return null;
		}
		return curr.getItem();
	}
   
	/*Returns the most expensive item in the list. goes through the list and finds 
	the expensive one. This is very similar to the least expensive method*/
	public Item mostExpensive() {
		if(head == null) {
			return null;
		}else {
			ListNode curr = head;
			Item mostExpensive = null;
			double price = Integer.MIN_VALUE;
			while(curr != null) {
				if(curr.getItem().getPrice() > price) {
					mostExpensive = curr.getItem();
					price = curr.getItem().getPrice();
				}
				curr = curr.getNext();
			}
			return mostExpensive;
		}
	}
      
	/* returns the least expensive item in the list
   	Some code along with commnets  is provided
   	follow the commnets to complete the code*/
	public Item leastExpensive() {
		if(head == null) {
			return null;
		}else {
			ListNode curr = head;
			Item leastExpensive = null;
			double price = Integer.MAX_VALUE;   
			while(curr != null) { 
				if(curr.getItem().getPrice() < price) {
					leastExpensive = curr.getItem();
					price = curr.getItem().getPrice();
				}
            
				curr = curr.getNext();
			}
       return leastExpensive;
      }  
   }
   
   /*implement your own driver similar to the given driver. DO NOT REMOVE THE GIVEN 
	DRIVER*/
   	class yourDriver {
   		public static void main(String []args) {
   			Scanner kb = new Scanner(System.in);
   			GroceryList list = new GroceryList();
   			
   			//Adding items to the grocerylist
   			list.add("Cake", 8.99, "5/02/2023", "8576033941");
   			list.add("Brownies", 6.99, "3/32/24", "8472019876");
   			list.add("Bananas", 2.99, "12/02/22", "4217894462");
   			list.add("Cookie Dough", 7.99, "12/28/22", "0957821634");
   			
   			boolean repeat = true;
   			while(true) {
   				//Prints the list of items
   				System.out.println("Here is the list of food items:");
   				System.out.println(list);
   				System.out.println("**************************************");
   				
   				//Removes something from your list
   				System.out.println("Seems you don't have enough money to purchase everything on this list...");
   				boolean removed = false;
   				while(removed == false) {
   					System.out.print("Enter the barcode of an item you want to remove from the list: ");
   					String barcode = kb.next();
   					Item i = list.remove(barcode);
   					if (i != null) {
   						System.out.println(i + " has been removed from the list.");
   						removed = true;
   					} else {
   						System.out.println("That's not an item on the list.");
   					}
   				}
   				System.out.println("**************************************");
   				
   				//Adding an item to the list
   				System.out.println("Oh, you found a $100 bill on the floor. Guess you can afford that now ... oh well");
   				System.out.print("Enter the information of a new item to add into your shopping cart");
   				System.out.println("Index must be in the range 0 - " + (list.getSize()-1));
   				System.out.print("Index --> ");
   				int index = kb.nextInt(); 
   				System.out.print("Name --> ");
   				String name = kb.next();
   				System.out.print("Price --> ");
   				double price = kb.nextDouble();
   				System.out.print("Expiration Date --> ");
   				String date = kb.next();
   				System.out.print("Barcode --> " );
   				String barcode = kb.next();   
   				list.add(index, name, price, date, barcode);
   				System.out.println("**************************************");
   				
   				//Looking up the most and least expensive items on the list
   				System.out.println("Hmm, I wonder what the most expensive item on the grocery list is...");
   				System.out.println("Let's find out! Now displaying the most expensive item on the grocery list:");
   				System.out.println(list.mostExpensive());
   				System.out.println("While we are at it, let's find out the least expensive item on the list.");
   				System.out.println("Now displaying the least expensive item on the grocery list:");
   				System.out.println(list.leastExpensive());
   				System.out.println("**************************************");
   				
   				//Looking up the description of an item on the list
   				System.out.println("How about we look up the information of one more item of your choice.");
   				System.out.println("Please enter the index of an item on the grocery list.");
   				System.out.println("Index must be in the range 0 - " + (list.getSize()-1));
   				System.out.print("Index --> ");
            	index = kb.nextInt();
            	System.out.println("Here is the item at the index " + index);
            	System.out.println(list.get(index));
            	System.out.println("**************************************");
   			
            	//Displaying the final list of items
            	System.out.println("Here is the finalized list of items in the grocery list:");
            	System.out.println(list);
            	System.out.println("**************************************");
            	kb.nextLine();
            	System.out.println("Press any key to continue");
            	kb.nextLine();
   			}
   		}
   	}
   	
   	class Driver {
   		public static void main(String []args) {
   			Scanner kb = new Scanner(System.in);
   			GroceryList list = new GroceryList();
      
   			list.add("Chicken", 5.99, "3/20/2022", "1234567890");
   			list.add("Chocolate", 3.99, "2/1/2002", "22334455667788");
   			list.add("Icecream", 2.99, "12/30/2025", "125467890");
   			list.add("Steak", 35.50, "8/15/2030", "78956223445");
      
   			boolean repeat = true;
   			while (true) {
         
   				System.out.println("Here is the list of food items");
   				System.out.println(list);
   				System.out.println("**************************************");
   				System.out.println("Here is the most expensive item on the list");
   				System.out.println(list.mostExpensive());
   				System.out.println("**************************************");
   				System.out.print("Enter the barcode of the item to remove from the list: ");
   				String barcode = kb.next();
   				// System.out.println("Removing Milk from the list and adding a new expensive item on the list in the 2nd node");
   				Item i = list.remove(barcode);
   				if (i != null) {
   					System.out.println("This item has been void: \n" + i);
   				} else {
   					System.out.println("This item is not in the list");
   				}
   				System.out.println("**************************************");
   				System.out.println("enter the info for the item to add it to the list ");
   				System.out.println("index must be in the range 0 - " + (list.getSize()-1));
   				System.out.print("Index -> ");
   				int index = kb.nextInt(); 
   				System.out.print("name --> ");
   				String name = kb.next();
   				System.out.print("Price --> " );
   				double price = kb.nextDouble();
   				System.out.print("Expiration date --> " );
   				String date = kb.next();
   				System.out.print("barcode--> " );
   				barcode = kb.next();   
   				list.add(index, name, price, date, barcode);
   				System.out.println("**************************************");
   				System.out.println("Here is the items in your list: ");
   				System.out.println(list);
   				System.out.println("**************************************");
         
   				System.out.println("Testing the mostExpensive method to see what is the most expensive item now");
   				System.out.println(list.mostExpensive());
   				System.out.println("**************************************");
   				System.out.println("Testing the leastExpensive method to see what is the most expensive item now");
   				System.out.println(list.leastExpensive());
            	System.out.println("**************************************");
         
            	System.out.println("Enter the index of the item in the list(list is zero based) to display the item");
            	System.out.println("index must be in the range 0 - " + (list.getSize()-1));
            	System.out.print("Index --> " );
         
            	index = kb.nextInt();
            	System.out.println("Here is the item at the index " + index);
            	System.out.println(list.get(index));
            	System.out.println("**************************************");
            	kb.nextLine();
            	System.out.println("Press any key to continue");
            	kb.nextLine();
   			} 
   		} 
   	}
}