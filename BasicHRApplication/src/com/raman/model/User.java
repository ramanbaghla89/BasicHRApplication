package com.raman.model;

public class User {
	private String userID;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String country;
	
	public User() {
		
		
	}
	
	

	public User(String userID, String password, String firstName, String lastName, String address, String city,
			String country) {
		this.userID = userID;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	



	public User(String userID, String firstName, String lastName, String address, String city, String country) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
	}



	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



	@Override
	public String toString() {
		return "User [userID=" + userID + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", city=" + city + ", country=" + country + "]";
	}
	
	
	

}
