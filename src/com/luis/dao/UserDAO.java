package com.luis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luis.entities.User;

@Repository
public class UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void createUser(User user) {
		user.setRole("ROLE_USER");
		//user.setRole("ROLE_USERhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		user.setEnabled(1);
		user.setPassWord(passwordEncoder.encode(user.getPassWord()));
		getSession().saveOrUpdate(user);
	}
	
	
	
	
}
