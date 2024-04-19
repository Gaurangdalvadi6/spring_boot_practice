package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
//	JPQL query means java persistance query language
//	@Query("select u from User u")
//	public List<User> getAllUser();
	
//	native query
	@Query(value = "select * from user", nativeQuery = true)
	public List<User> getAllUsers();
	
	@Query("select u From User u where u.name =:n")
	public List<User> getUserByName(@Param("n") String name);
	
	@Query("select u From User u where u.name =:n and u.city =:c")
	public List<User> getUserByNameAndCity(@Param("n") String name, @Param("c") String city );

}
