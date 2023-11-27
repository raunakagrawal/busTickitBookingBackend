package com.raunak.bus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.bus.Dto.AdminPassangerDto;
import com.raunak.bus.Dto.BookingDto;
import com.raunak.bus.Service.BookingService;


@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingservice;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public ResponseEntity<String> createBooking(@RequestBody BookingDto bookingDto) {
        ResponseEntity<String> booking = bookingservice.createBooking(bookingDto);
        return booking;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<AdminPassangerDto> getBooking() {   
        return bookingservice.getBookings();
    }
}
