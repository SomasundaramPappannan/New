package com.my.bookstore.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.my.bookstore.client.BookStoreRestClient;
import com.my.bookstore.core.Book;

public class BookStoreMain {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BookStoreRestClient client = new BookStoreRestClient();
	public static void main(String[] args) throws Exception {
		BookStoreMain mainObj = new BookStoreMain();
        mainObj.login(br, client);
		mainObj.displayAvailableBooksOrSearch(br, client);

	}

    /*** -- User Login -- ***/
	private void login(BufferedReader br, BookStoreRestClient client)
			throws Exception {

        System.out.println("Enter your name ");
		String userName = br.readLine();
        System.out.println("Enter your emailid ");
		String emailId = br.readLine();
        String response = client.login(userName, emailId);

        System.out.println("::" + response + "::");
        // TODO Need to align some validation
	}

    /*** -- Display The All books and Search -- ***/
	private void displayAvailableBooksOrSearch(BufferedReader br,
			BookStoreRestClient client) throws Exception {

		System.out.println("Type 1 to display all books ");
        System.out.println("Type 2 to Search the books ");
		String s = br.readLine();
        // int option = Integer.parseInt(s);
        if ("1".equals(s)) {
			displayAll(br, client);
        } else if ("2".equals(s)) {
            System.out.println("Please Enter to Search\n");
            String searchTerm = br.readLine();
            Book book = client.search(searchTerm);
            displayBookDetails(book, br, client);

		} else {
			System.out.println("Logging out...Please login once again");
		}
	}

	private void displayAll(BufferedReader br, BookStoreRestClient client)
			throws Exception {
		List list = client.displayAll();
		Iterator itr = list.iterator();
		Book book = null;
		System.out.println("**************Available Books************");
		while (itr.hasNext()) {
			book = (Book) itr.next();
			System.out.println(book.getBookId() + "." + book.getTitle() + " "
					+ book.getAuthor());
		}
		System.out.println("Please choose one book by entering serial.no");
		String s = br.readLine();
		Book getBookDetails = client.getBook(Integer.parseInt(s));
        displayBookDetails(getBookDetails, br, client);
	}
	
    private void displayBookDetails(Book book, BufferedReader br, BookStoreRestClient client) throws Exception {
        if (book != null) {
		 System.out.println("****************************************");
         System.out.println("Book Name::" + book.getTitle());
         System.out.println("Book Author::" + book.getAuthor());

         System.out.println("Book Price::" + book.getPrice());
         System.out.println("Avalible Qunatity::" + book.getAvailableStock());
         System.out.println("****************************************");
            System.out.print("Please Enter how many quantity you wish to add to cart\n ");
         String qty = br.readLine();
            int availableStock = book.getAvailableStock();
            boolean optionSelection = false;
            String price = book.getPrice();
         int iQty = Integer.parseInt(qty);
            if (availableStock == 0) {
                System.out.print("The Stock is Not Available ..!.");
                System.out.print("Please enter 1 to purchase another book....\n ");
                System.out.print("Please enter 2 to quit..");
                String choice = br.readLine();
                if (choice.equals("1")) {
                    displayAvailableBooksOrSearch(br, client);
                } else if (choice.equals("2")) {
                    System.exit(0);
                } else {
                    System.out.print("You Have entered wrong option..!. Quiting .Please login again");
                }
            } else if (iQty > availableStock) {
                while (!optionSelection) {
                    System.out.print("Please enter less than Avalible Stock \n");
                    System.out.print("Please Enter how many quantity you wish to buy\n ");
                    String qty1 = br.readLine();
                    if (Integer.parseInt(qty1) > availableStock) {
                        optionSelection = false;
                    } else {
                        int iQty1 = Integer.parseInt(qty1);
                        addBookToCart(book, iQty1, br, client);
                    }
                }
            } else {

                addBookToCart(book, iQty, br, client);
            }
        } else {
            System.out.println("No book found!!");
        }
	}
	private void addBookToCart(Book book,int count,BufferedReader br, BookStoreRestClient client) throws Exception{
		 client.addBookToCart(book.getBookId(), count);
		 Thread.sleep(2000);
		 //show cart now
		 List cartList = client.showCart();
		Iterator itr = cartList.iterator();
		System.out.println("************Books available in your cart*********");
		while(itr.hasNext()){
			Book cartBook = (Book)itr.next();
			System.out.println(cartBook.getBookId()+" "+cartBook.getTitle()+" "+cartBook.getPrice() +" "+cartBook.getAvailableStock());
		}
        System.out.print("Please enter 1 to buy..\n ");
        System.out.print("Please enter 2 to remove this book from cart..\n");
        System.out.print("Please enter 3 to purchase more books..");
		String choice = br.readLine();
		if(choice.equals("1")){
			buy(br, client);
		}else if(choice.equals("2")){
            removeBookFromCart(book, count, br, client, cartList);
		}else if(choice.equals("3")){
			displayAvailableBooksOrSearch(br, client);
        } else {
            System.out.print("You have entered wrong Option.Quiting ... Please login Again.");
		}
		
	}
	
    private void removeBookFromCart(Book book, int count, BufferedReader br, BookStoreRestClient client, List cartList) throws Exception {

        System.out.print("Please enter Which book you want to remove from cart ...\n ");
        String bookId = br.readLine();
        List removedCartList = client.removeBookFromCart(bookId, count, cartList);
        Iterator itr = removedCartList.iterator();
        System.out.println("************Books available in your cart*********");
        while (itr.hasNext()) {
            Book cartBook = (Book) itr.next();
            System.out.println(cartBook.getBookId() + " " + cartBook.getTitle() + " " + cartBook.getPrice() + " " + cartBook.getAvailableStock());
        }
        if (removedCartList != null && !removedCartList.isEmpty()) {
		System.out.print("Please enter 1 to buy..\n ");
        }
        System.out.print("Please enter 2 to purchase more books..");
        String choice = br.readLine();
        if (removedCartList != null && !removedCartList.isEmpty() && choice.equals("1")) {
			buy(br, client);
		}else if(choice.equals("2")){
			displayAvailableBooksOrSearch(br, client);
        } else {
            System.out.print("You have entered wrong option..!. Quiting .Please login again");
		}
	}
	
	private void buy(BufferedReader br, BookStoreRestClient client) throws Exception{
		String response = client.buy();
        System.out.print("The Ordered Book Purchased::" + response + "\n");
		System.out.print("Please enter 1 to purchase more....\n ");
 		System.out.print("Please enter 2 to quit..");
		String choice = br.readLine();
		if(choice.equals("1")){
			displayAvailableBooksOrSearch(br, client);
		}else if(choice.equals("2")){
			System.exit(0);
        } else {
            System.out.print("You have entered wrong Option. ..Quiting.. Please login Again!.");
		}
	}
	
}
