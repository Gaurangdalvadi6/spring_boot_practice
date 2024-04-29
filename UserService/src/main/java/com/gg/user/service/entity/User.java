package com.gg.user.service.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(name="Name",length = 15)
	private String name;
	@Column(name = "Email")
	private String email;
	@Column(name = "About")
	private String about;
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getAbout() {
//		return about;
//	}
//
//	public void setAbout(String about) {
//		this.about = about;
//	}
//
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public User(int userId, String name, String email, String about) {
//		super();
//		this.userId = userId;
//		this.name = name;
//		this.email = email;
//		this.about = about;
//	}
//
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", about=" + about + "]";
//	}

}
