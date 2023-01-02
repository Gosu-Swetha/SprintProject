package com.cg.ofda.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name="Address_table")

public class AddressDto {
	
		@Id
		@Column(name="Address_Id",length=10)
		@NotNull(message="Address cannot be blank")
		String addressid;
		@Column(name="Building_Name",length=20)
		@NotBlank(message="Building name cannot be blank")
		String buildingName;
		@Column(name="Street_No",length=5)
		@NotBlank(message="street number cannot be blank ")
		String streetNo;
		@Column(name="Area",length=15)
		@NotBlank(message="area cannot be blank")
		String area;
		@Column(name="City",length=15)
		@NotBlank(message="city cannot be blank")
		String city;
		@Column(name="State",length=15)
		@NotBlank(message="state cannot be blank")
		String state;
		@Column(name="Country",length=10)
		@NotBlank(message="country cannot be blank")
		String country;
		@Column(name="Pincode",length=7)
		@NotBlank(message="pincode cannot be blank")
		String pincode;
		

		public AddressDto() {
			// TODO Auto-generated constructor stub
		}


		public AddressDto(String addressid, String buildingName, String streetNo, String area, String city, String state,
				String country, String pincode) {
			super();
			this.addressid = addressid;
			this.buildingName = buildingName;
			this.streetNo = streetNo;
			this.area = area;
			this.city = city;
			this.state = state;
			this.country = country;
			this.pincode = pincode;
		}


		public String getAddressid() {
			return addressid;
		}


		public void setAddressid(String addressid) {
			this.addressid = addressid;
		}


		public String getBuildingName() {
			return buildingName;
		}


		public void setBuildingName(String buildingName) {
			this.buildingName = buildingName;
		}


		public String getStreetNo() {
			return streetNo;
		}


		public void setStreetNo(String streetNo) {
			this.streetNo = streetNo;
		}


		public String getArea() {
			return area;
		}


		public void setArea(String area) {
			this.area = area;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public String getPincode() {
			return pincode;
		}


		public void setPincode(String pincode) {
			this.pincode = pincode;
		}


		@Override
		public String toString() {
			return "AddressDto [addressid=" + addressid + ", buildingName=" + buildingName + ", streetNo=" + streetNo
					+ ", area=" + area + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode="
					+ pincode + "]";
		}


		
}

