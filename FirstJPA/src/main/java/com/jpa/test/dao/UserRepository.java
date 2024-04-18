package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.test.entities.User;
//extends CrudRepository or JpaRepository

public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name,String city);
	public List<User> findByNameStartingWith(String name);
	public List<User> findByNameEndingWith(String name);
	public List<User> findByCityStartingWith(String city);
	public List<User> findByCityEndingWith(String city);
	public List<User> findByNameContaining(String name);
	
//	@Query("select u from User u")
//	public List<User> getAllUser();
	
	@Query(value = "select * from user", nativeQuery = true)
	public List<User> getAllUsers();

}
