package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	public User findUserByName(String name);
}
//insert, update, delete are handled out of the box, and reads are where you typically define custom queries,while using jpa.
//Operation	         Method	                            What JPA Provides
//
//Insert	         save(entity)	                    Automatically inserts a new record if ID is not found
//Update	         save(entity)	                    Automatically updates if the ID already exists
//Delete	         deleteById(id) or delete(entity)   Predefined methods
//Find by ID	     findById(id)	                    Predefined method
//Find all	         findAll()	                        Predefined method
//Check Existence    existsById(id)	                    Check if a record exists
//Count              count()	                        Count total number of records
