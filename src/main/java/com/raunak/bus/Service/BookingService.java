package com.raunak.bus.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raunak.bus.Dto.AcceptBookings;
import com.raunak.bus.Dto.AdminPassangerDto;
import com.raunak.bus.Dto.BookingDto;
import com.raunak.bus.Dto.PassangerDto;
import com.raunak.bus.Entity.Bookings;
import com.raunak.bus.Entity.Cities;
import com.raunak.bus.Entity.Passengers;
import com.raunak.bus.ErrorResponce.ResponseHandler;
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
    public ResponseEntity<Object> createBooking(BookingDto bookingDto) {
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
    		newPassanger.setBookedByUser(savedBooking.getUser());
    		newPassanger.setDaysToDelete(0);
    		if(booking.getDistance() < 0 ) {
    			newPassanger.setJourneyType(false);
    		} else {
    			newPassanger.setJourneyType(true);
    		}
    		newPassanger.setStatus(null);
    		passangerRepo.save(newPassanger);
    	}
    	
    	return ResponseHandler.generateResponse("Booking Sucessfull", HttpStatus.OK, null);
    }
	
	public ResponseEntity<Object> getBookings() {
		
		List<Passengers> passangers = passangerRepo.findAllByStatusFalseOrNull();
		List<Cities> cities = citiesRepository.findAll();
		List<AdminPassangerDto> adminPassangerDtos = new ArrayList<>();
		
		for(Passengers passanger : passangers) {
			AdminPassangerDto adminPassangerDto = new AdminPassangerDto();
			
			Bookings booking = bookingRepository.findById(passanger.getBookingId()).get();		
			
			adminPassangerDto.setPassangerUser(booking.getUser());
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
			adminPassangerDto.setDate(passanger.getJourneyDate());
			
			if("m".equals(passanger.getGender())) {
				adminPassangerDto.setPassangerGender("Male");
			}else if ("f".equals(passanger.getGender())) {
				adminPassangerDto.setPassangerGender("Female");
			}
			
			adminPassangerDtos.add(adminPassangerDto);
		}
		return ResponseHandler.generateResponse("Sucessfull", HttpStatus.OK, adminPassangerDtos);
	}
	
	@Modifying
	@Transactional
	public ResponseEntity<Object> updateStatus(AcceptBookings  passengerIds) {

        List<Passengers> acceptedPassengers= passangerRepo.findAllById(passengerIds.getPassangerIds());
        acceptedPassengers.forEach(passenger -> passenger.setStatus(true));
        passangerRepo.saveAll(acceptedPassengers);
        
        List<Passengers> waitingPassengers = passangerRepo.findByJourneyDateWithStatus(passengerIds.getDate());
        
        for(Passengers passenger: waitingPassengers){
        	LocalDate date = LocalDate.parse(passenger.getJourneyDate());
        	String newDate = date.plusDays(2).toString();
        	passenger.setJourneyDate(newDate);
        	passenger.setStatus(false);
        	passenger.setDaysToDelete(passenger.getDaysToDelete()+1);
        }
        passangerRepo.saveAll(waitingPassengers);
        
        passangerRepo.deleteByDaysToDelete(3);
        
        return ResponseHandler.generateResponse("Update Sucessfull", HttpStatus.OK, null);
        
    }
	
	public ResponseEntity<Object> getHistory(Integer passengerId) {
		List<Passengers> passangers = passangerRepo.findByBookedByUser(passengerId);
		List<Cities> cities = citiesRepository.findAll();
		List<AdminPassangerDto> adminPassangerDtos = new ArrayList<>();
		
		for(Passengers passanger : passangers) {
			AdminPassangerDto adminPassangerDto = new AdminPassangerDto();
			
			Bookings booking = bookingRepository.findById(passanger.getBookingId()).get();		
			
			adminPassangerDto.setPassangerUser(booking.getUser());
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
			adminPassangerDto.setDate(passanger.getJourneyDate());
			
			if("m".equals(passanger.getGender())) {
				adminPassangerDto.setPassangerGender("Male");
			}else if ("f".equals(passanger.getGender())) {
				adminPassangerDto.setPassangerGender("Female");
			}
			
			adminPassangerDtos.add(adminPassangerDto);
		}
		return ResponseHandler.generateResponse("Booking Sucessfull", HttpStatus.OK, adminPassangerDtos);
	}
	
	public ResponseEntity<Object> getAllHistory() {
		List<Passengers> passangers = passangerRepo.findAll();
		List<Cities> cities = citiesRepository.findAll();
		List<AdminPassangerDto> adminPassangerDtos = new ArrayList<>();
		
		for(Passengers passanger : passangers) {
			AdminPassangerDto adminPassangerDto = new AdminPassangerDto();
			
			Bookings booking = bookingRepository.findById(passanger.getBookingId()).get();		
			
			adminPassangerDto.setPassangerUser(booking.getUser());
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
			adminPassangerDto.setDate(passanger.getJourneyDate());
			
			if("m".equals(passanger.getGender())) {
				adminPassangerDto.setPassangerGender("Male");
			}else if ("f".equals(passanger.getGender())) {
				adminPassangerDto.setPassangerGender("Female");
			}
			
			adminPassangerDtos.add(adminPassangerDto);
		}
		return ResponseHandler.generateResponse("Booking Sucessfull", HttpStatus.OK, adminPassangerDtos);
	}
	
}
