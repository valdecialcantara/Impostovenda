package br.com.model;

import java.io.Serializable;

/**
 * @author VBA
 *
 */
public class User implements Serializable{
 
	private static final long serialVersionUID = 2948145516824892082L;
	private int id;
	private String login;
	private String password;
 
	 public int getId() {
		 return id;
	 }
	 
	 public void setId(int id) {
		 this.id = id;
	 }
	
	 public String getLogin() {
		return login;
	 }
	
	 public void setLogin(String login) {
		this.login = login;
	 }
	
	 public String getPassword() {
		return password;
	 }
	
	 public void setPassword(String password) {
		this.password = password;
	 }
 
}
