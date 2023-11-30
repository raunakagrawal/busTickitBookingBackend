package com.raunak.bus.Dto;

public class UserDto {

    private Integer id;

    private String fullName;

    private String email;

    private String mobileNo;

    private String gender;

    private String role;

    private Integer age;
    
	private String dob;
    
    public UserDto() {
    }

	public UserDto(Integer id, String fullName, String email, String mobileNo, String gender, String role, Integer age,
			String dob) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.role = role;
		this.age = age;
		this.dob = dob;
	}

	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getGender() {
       return gender;
    }
	public void setGender(String gender) {
		this.gender = gender;
	}
    public String getRole() {
    	return role;
    }
    public void setRole(String role) {
		this.role = role;
	}
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	
}