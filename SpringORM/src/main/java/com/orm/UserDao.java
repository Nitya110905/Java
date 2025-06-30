package com.orm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDao {
	private HibernateTemplate hibernatetemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernatetemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernatetemplate = hibernateTemplate;
	}
	
	@Transactional
	public void saveOrUpdateUser(User u) {
		this.hibernatetemplate.saveOrUpdate(u);
	}
	
	@Transactional
	public void deleteUser(int id) {
		User u = this.hibernatetemplate.get(User.class, id);
		this.hibernatetemplate.delete(u);
	}
	
	public User getUserById(int id) {
		return this.hibernatetemplate.get(User.class, id);
	}
	
	
	public List<User> getAllUser(){
		return this.hibernatetemplate.loadAll(User.class);
	}
	
	
}


/* -HibernateTemplate is a helper class provided by Spring ORM that simplifies Hibernate interactions. It helps manage Hibernate SessionFactory and reduces
the need for repetitive boilerplate code when working with Hibernate.
 - @Transcational is an annotation in Spring ORM (Object-Relational Mapping) that is used to manage transactions declaratively. It ensures that a method or
  class is executed within a transactional context, handling commit, rollback, and propagation automatically.
  
 - In Spring XML configuration, the ref attribute inside <property> is used to inject a reference to another bean by its ID. It allows one bean to depend on
   and use another bean.
 -In Spring ORM, props and prop are elements used inside the <bean> definition in Spring XML configuration to inject multiple key-value pairs as properties in
  a bean. These are particularly useful when configuring Hibernate properties, database settings, or any configurable key-value pairs.   

  */
