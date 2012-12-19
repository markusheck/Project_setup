package com.cometsoftware.pft.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cometsoftware.pft.core.service.AccordionService;
import com.cometsoftware.pft.db.dao.TestDAO;
import com.cometsoftware.pft.db.dbo.TestDBO;

@Service("accordionService")
public class AccordionServiceImpl implements AccordionService {

	@Autowired
	private TestDAO dao;

	@Override
	public String getAccordionText(Long id) {
		TestDBO dbo = dao.findById( id );		
		return id + ": " + (dbo == null  ? "id not found" : dbo.getTabName() ) + " " + new java.util.Date();
	}

}
