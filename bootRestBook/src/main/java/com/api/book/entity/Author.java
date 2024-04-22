package com.api.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorId;
	@Column(name = "fname")
	private String firstname;
	@Column(name = "lname")
	private String lastname;
	private String language;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int authorId, String firstname, String lastname, String language) {
		super();
		this.authorId = authorId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.language = language;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstname=" + firstname + ", lastname=" + lastname + ", language="
				+ language + "]";
	}

}
