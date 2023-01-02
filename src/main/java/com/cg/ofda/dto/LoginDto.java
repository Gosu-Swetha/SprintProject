package com.cg.ofda.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Login_Table")
public class LoginDto {
	
	
		@Id
		@Column(name = "Login_userid",length = 3)
		@NotBlank(message="user id cannot be blank")
		 String userid;
		
		@Column(name = "Login_userName",length = 20)
		@NotBlank(message="user name cannot be blank")
		String userName;

		@Column(name = "Login_password",length = 3)
		@NotBlank(message="password cannot be blank")
		String password;
		
		
		public LoginDto() {
			super();
			
		}
		
		public LoginDto( String userid, String userName,String password) {
			super();
			this.userid = userid;
			this.userName = userName;
			this.password = password;
			
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		
		@Override
		public String toString() {
			return "Login [userid=" + userid + ", userName=" + userName + ", password=" + password + "]";
		}

}

