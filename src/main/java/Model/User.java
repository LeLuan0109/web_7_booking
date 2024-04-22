/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public class User {

	private int id, is_admin, is_sell;
	private String username, pass, fullname, gender, address, email, phone;

	public User() {

	}

	public User(int id, int is_admin, int is_sell, String username, String pass, String fullname, String gender,
			String address, String email, String phone) {
		super();
		this.id = id;
		this.is_admin = is_admin;
		this.is_sell = is_sell;
		this.username = username;
		this.pass = pass;
		this.fullname = fullname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public boolean isAdmin() {
		return this.is_admin != 0 ? true : false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}

	public int getIs_sell() {
		return is_sell;
	}

	public void setIs_sell(int is_sell) {
		this.is_sell = is_sell;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
