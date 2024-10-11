package com.crudOp.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Books")
@NoArgsConstructor
@Data
@Builder
public class Books {
	
	public int getBookid() {
		return bookid;
	}

	public Books(String bookname, String password, int price) {
		super();
		this.bookname = bookname;
		this.password = password;
		this.price = price;
	}

	public Books(int bookid, String bookname, String password, int price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.password = password;
		this.price = price;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookname=" + bookname + ", author=" + password + ", price=" + price + "]";
	}


	public Books(int bookid, String bookname, String username, String role, String password, int price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.username = username;
		this.role = role;
		this.password = password;
		this.price = price;
	}

	@Id
	@Column(name="book_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid;
	
	@Column(name="book_name")
	private String bookname;

	@Column(name="user_name")
	private String username;

	@Column(name="role")
	private String role;
	
	@Column(name="pass_word")
	private String password;
	
	@Column(name="price")
	private int price;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
