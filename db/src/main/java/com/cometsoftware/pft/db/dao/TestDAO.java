package com.cometsoftware.pft.db.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.cometsoftware.pft.db.JpaDAO;
import com.cometsoftware.pft.db.dbo.TestDBO;

@Repository
public class TestDAO extends JpaDAO<Long, TestDBO> {

	private static final long serialVersionUID = -6270160301960765564L;

	@PersistenceUnit(unitName="PFT")
	EntityManagerFactory entityManagerFactory;
	
	@PostConstruct
	public void init(){
		setEntityManagerFactory(entityManagerFactory);
	}

}
