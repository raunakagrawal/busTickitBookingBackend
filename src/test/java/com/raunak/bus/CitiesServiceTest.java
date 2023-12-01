package com.raunak.bus;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.raunak.bus.Entity.Cities;
import com.raunak.bus.Repository.CitiesRepository;
import com.raunak.bus.Service.CitiesService;

@SpringBootTest
class CitiesServiceTest {

    @Test
    void testGetAllCities() {
        CitiesRepository citiesRepository = mock(CitiesRepository.class);

        CitiesService citiesService = new CitiesService(citiesRepository);

        List<Cities> citiesList = new ArrayList<>();
        Cities city = new Cities();
        city.setId(1);
        city.setCityName("Pune");
        city.setDistance(1000);
        Cities city1 = new Cities();
        city.setId(2);
        city.setCityName("Gondia");
        city.setDistance(100);
        Cities city2 = new Cities();
        city.setId(2);
        city.setCityName("Nagpur");
        city.setDistance(500);
        
        citiesList.add(city);
        citiesList.add(city1);
        citiesList.add(city2);

        when(citiesRepository.findAll()).thenReturn(citiesList);

        List<Cities> resultCities = citiesService.getAllCities();

        verify(citiesRepository, times(1)).findAll();

        assertEquals(citiesList.size(), resultCities.size());
    }

    @Test
    void testGetCityById() {
        CitiesRepository citiesRepository = mock(CitiesRepository.class);

        CitiesService citiesService = new CitiesService(citiesRepository);

        Cities city = new Cities();
        city.setId(1);
        city.setCityName("Pune");
        city.setDistance(1000);

        when(citiesRepository.findById(1)).thenReturn(Optional.of(city));

        Optional<Cities> resultCity = citiesService.getCityById(1);

        verify(citiesRepository, times(1)).findById(1);

        assertTrue(resultCity.isPresent());
        assertEquals(city.getId(), resultCity.get().getId());
    }

    @Test
    void testGetCityByIdNotFound() {
        CitiesRepository citiesRepository = mock(CitiesRepository.class);

        CitiesService citiesService = new CitiesService(citiesRepository);

        when(citiesRepository.findById(1)).thenReturn(Optional.empty());

        Optional<Cities> resultCity = citiesService.getCityById(1);

        verify(citiesRepository, times(1)).findById(1);

        assertFalse(resultCity.isPresent());
    }

    @Test
    void testSaveCity() {
        CitiesRepository citiesRepository = mock(CitiesRepository.class);
        CitiesService citiesService = new CitiesService(citiesRepository);

        Cities city = new Cities();
        city.setId(1);
        city.setCityName("Pune");
        city.setDistance(1000);

        when(citiesRepository.save(any(Cities.class))).thenReturn(city);

        Cities resultCity = citiesService.saveCity(city);

        verify(citiesRepository, times(1)).save(any(Cities.class));

        assertEquals(city.getId(), resultCity.getId());
    }

    @Test
    void testDeleteCity() {
        CitiesRepository citiesRepository = mock(CitiesRepository.class);
        CitiesService citiesService = new CitiesService(citiesRepository);

        citiesService.deleteCity(1);

        verify(citiesRepository, times(1)).deleteById(1);
    }
}

