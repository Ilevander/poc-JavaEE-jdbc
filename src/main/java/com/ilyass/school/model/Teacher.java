package com.ilyass.school.model;



public class Teacher {

	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName;
	private String lastName;
	private String subject;
	private String email;
	private String username;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	protected Teacher() {

	}
	
	public Teacher(int id, String firstName, String lastName, String subject, String email, String username,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject = subject;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public Teacher(String firstName, String lastName, String subject, String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject = subject;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	
	
}     
