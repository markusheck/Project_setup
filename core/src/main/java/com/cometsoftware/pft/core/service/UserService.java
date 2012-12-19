package com.cometsoftware.pft.core.service;

import com.cometsoftware.pft.core.dto.UserDTO;

public interface UserService {
	
	UserDTO validateLogin( String username, String password );

}
