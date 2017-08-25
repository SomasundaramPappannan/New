package com.my.bookstore.core;

 
import java.util.ArrayList;
import java.util.List;

public class BookStoreCache {
	
	private static BookStoreCache cache = null;
	
	
	public static BookStoreCache getInstance(){
		if(cache==null){
			cache = new BookStoreCache();
		}
		return cache;
	}

	private List cartList = new ArrayList();
	
	private List booksInStock = new ArrayList();
	
	public List getBooksInStock() {
		return booksInStock;
	}

	public void setBooksInStock(List booksInStock) {
		this.booksInStock = booksInStock;
	}

	private String userName;
	
	private String emailid;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public List getCartList() {
		return cartList;
	}

	public void setCartList(List cartList) {
		this.cartList = cartList;
	}
}
