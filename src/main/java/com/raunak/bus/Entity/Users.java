package com.raunak.bus.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Column(nullable = false, length = 64)
    private String password;

    @NotBlank(message = "First name is required")
    @Size(max = 20, message = "First name must be at most 20 characters long")
    @Column(name = "fname", nullable = false, length = 20)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 20, message = "Last name must be at most 20 characters long")
    @Column(name = "Lname", nullable = false, length = 20)
    private String lastName;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]+$", message = "Mobile number must contain only digits")
    @Size(max = 10, message = "Invalid Mobile Number")
    @Column(name = "p_number", nullable = false, length = 20)
    private String mobileNo;

    @NotBlank(message = "Gender is required")
    @Size(max = 1, message = "Invalid Gender")
    @Column(name = "gender", nullable = false, length = 20)
    private String gender;
    
    @NotBlank(message = "Date of birth is required")
    @Column(name = "dob", nullable = false, length = 20)
    private String dob;

    @NotBlank(message = "Role is required")
    @Size(max = 20, message = "Role must be Integer")
    @Column(name = "role", nullable = false, length = 20)
    private String role;
    
    

    public Users(Integer id,
			@Email(message = "Please provide a valid email address") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters long") String password,
			@NotBlank(message = "First name is required") @Size(max = 20, message = "First name must be at most 20 characters long") String firstName,
			@NotBlank(message = "Last name is required") @Size(max = 20, message = "Last name must be at most 20 characters long") String lastName,
			@NotBlank(message = "Mobile number is required") @Pattern(regexp = "^[0-9]+$", message = "Mobile number must contain only digits") @Size(max = 10, message = "Invalid Mobile Number") String mobileNo,
			@NotBlank(message = "Gender is required") @Size(max = 1, message = "Invalid Gender") String gender,
			@NotBlank(message = "Date of birth is required") String dob,
			@NotBlank(message = "Role is required") @Size(max = 20, message = "Role must be Integer") String role,
			String passwordConfirm) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dob = dob;
		this.role = role;
		this.passwordConfirm = passwordConfirm;
	}

	public Users() {

	}

	@Transient
    private String passwordConfirm;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDob() {

		return dob;
	}

	public void setDob(String birthDate) {
		this.dob = birthDate;
	}
	public String getRole() {

		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
}
