package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.model.User;

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
