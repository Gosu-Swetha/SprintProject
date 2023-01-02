package com.cg.ofda.service;

import com.cg.ofda.dto.LoginDto;

public interface ILoginService {

	public LoginDto signIn(LoginDto login);
	public boolean signOut();

}

