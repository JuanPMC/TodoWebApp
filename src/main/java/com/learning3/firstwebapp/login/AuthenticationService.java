package com.learning3.firstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String name, String password) {
		boolean name_ver = name.equals("pepe");
		boolean passord_ver = password.equals("pepe");
		return name_ver && passord_ver;
	}
}
