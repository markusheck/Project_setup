package com.cometsoftware.pft.gui.beans;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Data;

import com.cometsoftware.pft.core.service.AccordionService;

@Data
@Named
@SessionScoped
public class HomePageBean implements Serializable {

	// public AccordionBean() {
	//
	// System.out.println( "Bin im Constructor");
	//
	// FacesContext facesContext=FacesContext.getCurrentInstance();
	// ApplicationAssociate application =
	// ApplicationAssociate.getInstance(facesContext.getExternalContext());
	// BeanManager beanManager = application.getBeanManager();
	// Map<String, BeanBuilder> beanMap=beanManager.getRegisteredBeans();
	// Set<Map.Entry<String, BeanBuilder>>beanEntries=beanMap.entrySet();
	// for(Map.Entry<String, BeanBuilder> bean:beanEntries){
	// String beanName=bean.getKey();
	// if(!beanManager.isManaged(beanName)){
	// continue;
	// }
	// BeanBuilder builder=bean.getValue();
	// System.out.println( builder.getBeanClass() );
	// }
	//
	//
	// WebApplicationContext ctx =
	// FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
	// service = ctx.getBean(AccordionServiceImpl.class);
	// }

	@Inject
	private AccordionService service;

	private String accordionText1 = "bla1";

	private String accordionText2 = "bla2";

	public String getAccordionText1() {
		return service.getAccordionText(Long.valueOf("1"));
	}

	public String getAccordionText2() {
		return service.getAccordionText(Long.valueOf("2"));
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
