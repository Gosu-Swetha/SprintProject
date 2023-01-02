package com.cg.ofda.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="Customer_Table")

public class CustomerDto {
	

	@Id
	@Column(name="Customer_Id",length = 5)
	@NotNull(message="customer id cannot be null")
	String customerId;
	
	@Column(name="First_Name", length = 20)
	@NotBlank(message="first name cannot be blank")
	String firstName;
	
	@Column(name="Last_Name",length = 20)
	@NotBlank(message="last name cannot be blank")
	String lastName;
	
	@Column(name="Age",length = 3)
	@NotNull(message="age cannot be null")
	int age;
	
	@Column(name="Gender",length = 10)
	@NotBlank(message="gender cannot be blank")
	String gender;
	
	@Column(name="Mobile_No",length = 12)
	@Pattern(regexp="[6-9]{1}[0-9]{9}",message="mobile number must be valid")
	String mobileNumber;
	
	@Column(name="Email",length = 30)
	@Email(regexp="^[A-Za-z][A-Za-z0-9]+@[A-Za-z]+\\.(com||org)$",message="enter valid email id")
	String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Address_Id")
			
			AddressDto address;
			
			public CustomerDto() {
				
			}



			public CustomerDto(String customerId, String firstName, String lastName, int age, String gender, String mobileNumber,
					String email, AddressDto address) {
				super();
				this.customerId = customerId;
				this.firstName = firstName;
				this.lastName = lastName;
				this.age = age;
				this.gender = gender;
				this.mobileNumber = mobileNumber;
				this.email = email;
				this.address = address;
			}



			public String getCustomerId() {
				return customerId;
			}

			public void setCustomerId(String customerId) {
				this.customerId = customerId;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

			public int getAge() {
				return age;
			}

			public void setAge(int age) {
				this.age = age;
			}

			public String getMobileNumber() {
				return mobileNumber;
			}

			public void setMobileNumber(String mobileNumber) {
				this.mobileNumber = mobileNumber;
			}

			

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getGender() {
				return gender;
			}



			public void setGender(String gender) {
				this.gender = gender;
			}



			public AddressDto getAddress() {
				return address;
			}



			public void setAddress(AddressDto address) {
				this.address = address;
			}



			@Override
			public String toString() {
				return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
						+ age + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", email=" + email + ", address="
						+ address + "]";
			}



			



}

