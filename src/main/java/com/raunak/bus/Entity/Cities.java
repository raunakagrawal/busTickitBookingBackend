package com.raunak.bus.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cities")
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotBlank(message = "City Name is required")
    @Column(nullable = false, unique = true, length = 45)
    private String cityName;

    @NotBlank(message = "Distance is required")
    @Column(nullable = false, length = 64)
    private Integer distance;

	public Cities(Integer id, @NotBlank(message = "City Name is required") String cityName,
			@NotBlank(message = "Distance is required") Integer distance) {
		this.id = id;
		this.cityName = cityName;
		this.distance = distance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
    
}
