package net.codejava;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(nullable=false)
	private Long phone_number;
	

	@Column(nullable = false, length = 64)
	private String password;
	
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	
	@Column(name = "society_name", nullable = false, length = 20)
	private String society_name;
	
	@Column(name = "house_identity", nullable = false, length = 100)
	private String house_identity;
	
	@Column(name = "role", nullable = false, length = 20)
	private String role;
	
	@Column(nullable = false, length = 64)
	private String unique_id;
	
	public User() {
		this.unique_id=RandGeneratedStr(10);
	}









	public String getUnique_id() {
		return unique_id;
	}









	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}









	static String RandGeneratedStr(int l)
	 {
	 // a list of characters to choose from in form of a string
	 String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
	 // creating a StringBuffer size of AlphaNumericStr
	 StringBuilder s = new StringBuilder(l);
	 int i;
	 for ( i=0; i<l; i++) {
	   //generating a random number using math.random()
	   int ch = (int)(AlphaNumericStr.length() * Math.random());
	   //adding Random character one by one at the end of s
	   s.append(AlphaNumericStr.charAt(ch));
	  }
return s.toString();
}

	
	
	
	
	
	


	public String getRole() {
		return role;
	}

	public String getSociety_name() {
		return society_name;
	}

	public void setSociety_name(String society_name) {
		this.society_name = society_name;
	}

	public String getHouse_identity() {
		return house_identity;
	}

	public void setHouse_identity(String house_identity) {
		this.house_identity = house_identity;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
    
	
	
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	
	
}
