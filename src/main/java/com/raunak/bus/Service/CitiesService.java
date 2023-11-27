package com.raunak.bus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raunak.bus.Entity.Cities;
import com.raunak.bus.Repository.CitiesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesService {

    @Autowired
    private CitiesRepository citiesRepository;


    public List<Cities> getAllCities() {
        return (List<Cities>) citiesRepository.findAll();
    }

    public Optional<Cities> getCityById(Integer id) {
        return citiesRepository.findById(id);
    }


    public Cities saveCity(Cities city) {
        return citiesRepository.save(city);
    }

    public void deleteCity(Integer id) {
        citiesRepository.deleteById(id);
    }
}

