package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long contact;
	private String email;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String address) {
		this.password = address;
	}
	public User(int id, String name, long contact, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.password = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email + ", password="
				+ password + "]";
	}
	
}
/*The @GeneratedValue(strategy = GenerationType.AUTO) annotation is used in Java Persistence API (JPA) to specify how the primary key value for an entity
will be generated.

-Annotation: Marks a field as being generated automatically by the persistence provider.

-GenerationType.AUTO: The persistence provider (e.g., Hibernate) will select the best generation strategy based on the database dialect you're using.
This means the actual strategy could vary (e.g., IDENTITY, SEQUENCE, or TABLE).  */



