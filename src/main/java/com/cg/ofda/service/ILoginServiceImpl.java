package com.cg.ofda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.dto.LoginDto;
import com.cg.ofda.exception.UserNotFoundException;
import com.cg.ofda.repository.ILoginRepository;

@Service

public class ILoginServiceImpl implements ILoginService {


   @Autowired
   ILoginRepository loginRepository;


/* @author : Satya 
 * @return : true 
 * @description : This method signin user  in the repository and returns true
 */
  
  public  LoginDto signIn(LoginDto login1) {
	  	String userid = login1.getUserid() ;
		String userName = login1.getUserName();
		String password = login1.getPassword();

		Optional<LoginDto> login = loginRepository.findById(userid);

		if (login.isEmpty() || !login.get().getPassword().equals(password)) {

			throw new UserNotFoundException("Bad Credentials");
		}
		return  login.get();
	}
  /* @author : Satya 
   * @return : login
   * @description : This method returns login if it has that userid
   */
   public LoginDto viewUser(String userId) {
	   return loginRepository.findById(userId).get();
   }

/* @author : Satya 
 * @return : true 
 * @description : This method signout user  in the repository and returns true
 */
  public boolean signOut() {
	  
	return true;

	 }
}