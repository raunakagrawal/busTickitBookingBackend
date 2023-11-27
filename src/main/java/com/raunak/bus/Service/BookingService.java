package com.raunak.bus.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raunak.bus.Dto.AdminPassangerDto;
import com.raunak.bus.Dto.BookingDto;
import com.raunak.bus.Dto.PassangerDto;
import com.raunak.bus.Entity.Bookings;
import com.raunak.bus.Entity.Cities;
import com.raunak.bus.Entity.Passengers;
import com.raunak.bus.Repository.BookingRepository;
import com.raunak.bus.Repository.CitiesRepository;
import com.raunak.bus.Repository.PassangerRepo;

import jakarta.transaction.Transactional;

@Service
public class BookingService {
	
	@Autowired
	private final BookingRepository bookingRepository;
	private final PassangerRepo passangerRepo;
	private final CitiesRepository citiesRepository;
	
	public BookingService(BookingRepository bookingRepository, PassangerRepo passangerRepo, CitiesRepository citiesRepository) {
        this.bookingRepository = bookingRepository;
        this.passangerRepo =passangerRepo;
        this.citiesRepository= citiesRepository;
    }
	
	@Transactional
    public ResponseEntity<String> createBooking(BookingDto bookingDto) {
    	Bookings booking = new Bookings();
    	booking.setBookFrom(bookingDto.getFrom());
    	booking.setBookTo(bookingDto.getDestination());
    	booking.setDate(bookingDto.getJourneyDate());
    	booking.setNumberOfPassanger(bookingDto.getNumberOfTickets());
    	booking.setUser(bookingDto.getUser());
    	booking.setDistance(bookingDto.getDistance());
    	Bookings savedBooking = bookingRepository.save(booking);
    	
    	List<PassangerDto> passangers = bookingDto.getTickets();
    	for(PassangerDto passanger: passangers) {
    		
    		Passengers newPassanger =new Passengers();
    		newPassanger.setBookingId(savedBooking.getId());
    		newPassanger.setJourneyDate(savedBooking.getDate());
    		newPassanger.setPassangerName(passanger.getName());
    		newPassanger.setPassangerAge(passanger.getAge());
    		newPassanger.setGender(passanger.getGender());
    		newPassanger.setFare(passanger.getFare());
    		if(savedBooking.getDistance() < 0 ) {
    			newPassanger.setJourneyType(false);
    		} else {
    			newPassanger.setJourneyType(true);
    		}
    		newPassanger.setStatus(false);
    		passangerRepo.save(newPassanger);
    	}
    	
    	return new ResponseEntity<String>("Saved", HttpStatus.OK);
    }
	
	public List<AdminPassangerDto> getBookings() {
		List<Passengers> passangers = passangerRepo.findAll();
		List<Cities> cities = citiesRepository.findAll();
		List<AdminPassangerDto> adminPassangerDtos = new ArrayList<>();
		
		for(Passengers passanger : passangers) {
			AdminPassangerDto adminPassangerDto = new AdminPassangerDto();
			
			Bookings booking = bookingRepository.findById(passanger.getBookingId()).get();		
			adminPassangerDto.setDate(booking.getDate());
			
			for(Cities city: cities) {
				if(booking.getBookFrom().equals(city.getId())) {
					adminPassangerDto.setFromCity(city.getCityName());
				}
				if(booking.getBookTo().equals(city.getId())) {
					adminPassangerDto.setToCity(city.getCityName());
				}
			}
			adminPassangerDto.setPassangerId(passanger.getId());
			adminPassangerDto.setPassangerName(passanger.getPassangerName());
			adminPassangerDto.setPassangerAge(passanger.getPassangerAge());
			adminPassangerDto.setFare(passanger.getFare());
			adminPassangerDto.setStatus(passanger.getStatus());
			adminPassangerDto.setJourneyType(passanger.getJourneyType());
			adminPassangerDtos.add(adminPassangerDto);
		}
		return adminPassangerDtos;
	}
}
