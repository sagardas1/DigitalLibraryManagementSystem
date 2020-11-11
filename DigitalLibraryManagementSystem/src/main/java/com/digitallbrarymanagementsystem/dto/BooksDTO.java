package com.digitallbrarymanagementsystem.dto;

public class BooksDTO {

	private long BID;
	private String bookName;
	private Double price;
	private String Genre;

	
	public BooksDTO(long bID, String bookName, Double price, String genre) {
		BID = bID;
		this.bookName = bookName;
		this.price = price;
		Genre = genre;
	}

	public long getBID() {
		return BID;
	}

	public void setBID(long bID) {
		BID = bID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

}
