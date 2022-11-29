/*
name: Cole Croteau
date: 10/10/22
description: Book list app that organizes books in a list via different sorting algorithms, depending on which is used.
 */

import java.util.*;
public class BookAppCroteau {

}

class Author implements Comparable {
	
   private String first;
   private String last;
   
   //Constructs an object Author with the given variables
   public Author(String first, String last) {
      this.first = first;
      this.last = last;
   }
   
   //Sets the first name of the Author
   public void setFirst(String first) {
      this.first = first;
   }
   
   //Sets the last name of the Author
   public void setLast(String last) {
      this.last = last;
   }
   
   //Gives the first name of the Author
   public String getFirst() {
      return first;
   }
   
   //Gives the last name of the Author
   public String getLast() {
      return last;
   }
   
   //Compares the two objects of Author for equality based on the last name
   public boolean equals(Object o) {
      if(o instanceof Author) {
    	  Author a = (Author)o;
    	  if(this.getLast().equalsIgnoreCase(a.getLast())) {
    		  return true;
    	  }
    	  return false;
      }
      return false;
   }
   
   //Returns a string representation of the object Author
   public String toString() {
      return "Author: " + first + " " + last;
   }
   
   public int compareTo(Object other) {
      if(other instanceof Author) {
    	  Author a = (Author) other;
    	  return this.getLast().compareTo(a.getLast());
      }
      return 0;
   }
}

class Book implements Comparable {

   private String title;
   private Author author;
   private String ISBN;
   private double price;
   private int pages;
   
   //Constructor of an object Book
   public Book(String title, String first, String last, String ISBN, double price, int pages) {
	   author = new Author(first, last);
	   this.title = title;
	   this.ISBN = ISBN;
	   this.price = price;
	   this.pages = pages;
   }
   
   //Gives the title of the book
   public String getTitle() {
      return title;
   }
   
   //Return a string representation of the author
   public String getAuthor() {
      String s = "Author: " + author.getFirst() + " " + author.getLast();
      return s;
   }
   
   //Gives the ISBN of the book
   public String getISBN() {
      return ISBN;
   }
   
   //Gives the price of the book
   public double getPrice() {
      return price;
   }
   
   public int getPages() {
	   return pages;
   }
   
   //Sets the title of the book
   public void setTitle(String t) {
      title = t;
   }
   
   //Sets the price of the book
   public void setPrice(double p) {
      price = p;
   }
   
   //Sets the ISBN of the book
   public void setIsbn(String sb) {
      ISBN = sb;
   }
   
   //Gives a string representation of the object Book
   public String toString() {
      String s = "";
      s += "\n" + author.toString();
      s += "\nTitle: " + getTitle();
      s += "\nPrice: " + getPrice();
      s += "\nPages: " + getPages();
      s += "\nISBN: " + getISBN();
      return s;
   }
   
   //Compares two books for equality based on their ISBN numbers
   public boolean equals(Book other) {
	   if(this.getISBN().equalsIgnoreCase(other.getISBN()) ) {
		   return true;
	   }
      return false;
   }
   
   //Adds pages to the book
   public void append(int p) {
	   pages = pages + p;
       
   }
   
   //Compares two books based on their title. Used for selection sort.
   // #1
   public int compareTo(Object o) {
	   if(o instanceof Book) {
		   Book b = (Book)o;
		   return this.getTitle().compareTo(b.getTitle());
	   }
      return 0;
   }
    //Compares two books based on their authors. Used for insertion sort.
   // #2
   public int compares(Book b) {
	   return author.compareTo(b.author);
   }
   
   //Compares two books by author, but if the author is the same, compares by price. Used for bubble sort.
   // #3
   public double compare(Book b) {
	   if(this.getAuthor().equalsIgnoreCase(b.getAuthor())) {
		   return this.price - b.price;
	   }else {
		   return author.compareTo(b.author);
	   }
   }
}

class BookStore {
	
   private ArrayList<Book> books;
   
   //Constructor for object Bookstore that creates an arraylist of books.
   public BookStore() {
      books = new ArrayList<Book>();
   }
   //Adds a book to the ArrayList books
   public void add(String title, String first, String last, double price, String isbn, int pages) {
      Book z = new Book(title, first, last, isbn, price, pages);
      books.add(z);  
   }
   
   //Returns a string representation of the arraylist of books.
   public String toString() {
      String s = "";
      for(int i = 0; i < books.size(); i++) {
    	  s += books.get(i).toString();
    	  s += "\n______________";
      }
      return s;
   }
   
   //Removes the book from the list based on ISBN.
   public boolean delete(String isbn) {
      for(int i = 0; i < books.size(); i++) {
    	  if(books.get(i).getISBN().equals(isbn)) {
    		  books.remove(i);
    		  return true;
    	  }
      }
      return false;
   }
   
   //Sorts the books based on title using selection sort
   public void selectionSort() {  
	   for(int i = 0; i < books.size(); i++) {
		   int index = 0;
		   boolean swap = false;
		   Book min = books.get(i);
		   for(int j = i + 1; j < books.size(); j++) {
			   if(books.get(j).getTitle().compareTo(min.getTitle()) < 0) {
				   index = j;
				   min = books.get(j);
				   swap = true;
			   }
		   }
		   if(swap) {
			  Book temp = books.get(i);
			  books.set(i, books.get(index));
			  books.set(index, temp);
		   }
	   }
   }
   
   //Sorts the books based on author's last name using insertion sort.
   public  void insertionSort() {
	   for(int i = 0; i < books.size() - 1; i++) {
		   int j = i + 1;
		   Book n = books.get(j);
		   while(j > 0 && n.compares(books.get(j-1)) < 0) {
			   books.set(j, books.get(j-1));
			   j--;
		   }
		   books.set(j,n);
	   }
   } 
        
   //Sorts the books based on author and price via Bubble Sort
   public void bubbleSort() {
	   for(int i = 0; i < books.size(); i++) {
		   for(int j = 0; j < books.size() - 1 - i; j++) {
			   if(books.get(j+1).compare(books.get(j)) < 0) {
				   Book temp = books.get(j);
				   books.set(j, books.get(j+1));
				   books.set(j+1, temp);
			   }
		   }
	   }
   }
   
   //Searches through the arraylist of books to find the designated book based on title. Uses binary search.
   public Book binarySearch(String title) { 
	  selectionSort();
      int first = 0;
      int last = books.size() - 1;
      while(first <= last) {
    	  int mid = (first + last) / 2;
    	  if(title.equals(books.get(mid).getTitle())) {
    		  return books.get(mid);
    	  }
    	  if(title.compareTo(books.get(mid).getTitle()) > 0) {
    		  first = mid + 1;
    	  }else {
    		  last = mid - 1;
    	  }
      }
      return books.get(0);
   }
   
   //Sequentially searches the arraylist of books, appends pages to the book when found, and returns the book modified.
   public Book append(String isbn, int pages) {
	   for(int i = 0; i < books.size(); i++) {
		   if(books.get(i).getISBN().equals(isbn)) {
			   books.get(i).append(pages);
			   return books.get(i);
		   }
	   }
	   return null;
   }
   
   //Reverses the ArrayList
   public void creativeMethod() {
	   ArrayList<Book> newbooks = new ArrayList<Book>();
	   for(int i = books.size() - 1; i >= 0; i--) {
		   newbooks.add(books.get(i));
	   }
	   books = newbooks;
	   System.out.println(books);
   }
}

//Driver to test the code
class Driver {
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      BookStore myStore = new BookStore();
      myStore.add("Java","Zoie","Zanjani", 23.56,"12345678",1234);
      myStore.add("Python","Elina","Busta",23.56,"2", 900);
    
      myStore.add("Advance Java","Stewart","Watts",98,"767676576",800);
      myStore.add("Build Java","Liang", "Lu",45,"56786565y76",700);
      myStore.add("Zip lining", "Stewart","Watts", 12,"1234566576",1200);
      myStore.add("C++","Elina", "Jackson",23.56,"2645556",1234);
      myStore.add("Programming Java","Stewart","Watts", 124,"75465666",3456);
      myStore.add("Humanity","Smith","Brown", 100.56,"234545657",1234);
      boolean b = true;
      while(b) {
         System.out.println("Enter 1 to sort based on the title");
         System.out.println("Enter 2 to sort based on the author");
         System.out.println("Enter 3 to sort based on the author, and the price");
         System.out.print("Enter your choice: ");
         int option = kb.nextInt();
         System.out.println("\n*************");
         if(option == 1) {
            System.out.println("Sorted based on the title\n");
            myStore.selectionSort();
         }else if (option == 2) {
            System.out.println("Sorted based on the author\n");
            myStore.insertionSort();
         }else {
            System.out.println("Sorted based on the author and price\n");
            myStore.bubbleSort();
         }  
         System.out.println(myStore);
         System.out.println("\n     **************     ");
         System.out.print("Enter the title of the book to search for it: ");
         kb.nextLine();
         String t = kb.nextLine();
         
         Book book = myStore.binarySearch(t);
         if(book != null) {
            System.out.println(book);
         }else {
            System.out.println("Book not found");
         }
         System.out.println("\n");
         System.out.print("Enter the isbn of the book to append pages to it: ");
         String isbn = kb.next();
         System.out.print("Enter the number of the pages to append: ");
         int pages = kb.nextInt();
         Book z  = myStore.append(isbn, pages);
         System.out.println("The " + pages + " has been added to the following book");
         System.out.println(z);
         System.out.println("Enter the information of the book you want to add to the list:");
         
         kb.nextLine();
         System.out.print("Title --> ");
         String tit = kb.nextLine();
         System.out.print("first name --> ");
         String f = kb.next();
         System.out.print("last name --> ");
         String l = kb.next();
         System.out.print("price --> ");
         double price = kb.nextDouble();
         System.out.print("ISBN --> ");
         isbn = kb.next();
         System.out.print("pages --> ");
         pages = kb.nextInt();
         myStore.add(tit,f,l,price,isbn,pages);
         myStore.selectionSort();
         System.out.println("Here is the updated list:");
         System.out.println(myStore);          
      }  
   }
}
