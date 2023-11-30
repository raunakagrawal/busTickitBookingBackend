package com.raunak.bus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.bus.Dto.AcceptBookings;
import com.raunak.bus.Dto.BookingDto;
import com.raunak.bus.Service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingservice;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public ResponseEntity<Object> createBooking(@RequestBody BookingDto bookingDto) {
        ResponseEntity<Object> booking = bookingservice.createBooking(bookingDto);
        return booking;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<Object>  getBooking() {   
        return bookingservice.getBookings();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/accept")
    public ResponseEntity<Object>  updateStatus(@RequestBody AcceptBookings passengerIds) {   
        return bookingservice.updateStatus(passengerIds);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/history/{userId}")
    ResponseEntity<Object>  getHistory(@PathVariable Integer userId) {   
        return bookingservice.getHistory(userId);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/history/all")
    ResponseEntity<Object>  getAllHistory() {   
        return bookingservice.getAllHistory();
    }
}
