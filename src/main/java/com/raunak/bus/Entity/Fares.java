package com.raunak.bus.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "fares")
public class Fares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotBlank(message = "Fare Name is required")
    @Column(nullable = false, length = 45)
    private String fareName;

    @NotBlank(message = "age is required")
    private Integer age;

	public Fares(Integer id, @NotBlank(message = "Fare Name is required") String fareName,
			@NotBlank(message = "age is required") Integer age) {
		this.id = id;
		this.fareName = fareName;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFareName() {
		return fareName;
	}

	public void setFareName(String fareName) {
		this.fareName = fareName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
    
    
}
