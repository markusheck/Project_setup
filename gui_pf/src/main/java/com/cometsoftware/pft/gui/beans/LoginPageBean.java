package com.cometsoftware.pft.gui.beans;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.cometsoftware.pft.core.dto.UserDTO;
import com.cometsoftware.pft.core.service.UserService;
import com.cometsoftware.pft.gui.authorization.Constants;

@Named
@SessionScoped
public class LoginPageBean implements Serializable {
	
	@Inject
	private UserService userService;
	
    private String username;
    private String password;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String doLogin() {
		UserDTO user = userService.validateLogin(username, password);
		if ( user != null ) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getApplication().createValueBinding("#{" + Constants.VISIT_KEY_SCOPE + Constants.VISIT_KEY + "}").setValue(facesContext, user);
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			session.setAttribute(Constants.VISIT_KEY, user);
			return "restricted/HomePage";
		}
		return "LoginPage";
	}
    
    

}
