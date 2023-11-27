package com.raunak.bus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.raunak.bus.Entity.Cities;
import com.raunak.bus.Service.CitiesService;
import com.raunak.bus.Service.ValidationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private CitiesService citiesService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Cities>> getAllCities() {
        List<Cities> cities = citiesService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<Cities> getCityById(@PathVariable Integer id) {
        Optional<Cities> city = citiesService.getCityById(id);
        return city.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Cities> saveCity(@RequestBody Cities city) {
    	ValidationService.validate(city);
    	Cities savedCity = citiesService.saveCity(city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Integer id) {
        citiesService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
