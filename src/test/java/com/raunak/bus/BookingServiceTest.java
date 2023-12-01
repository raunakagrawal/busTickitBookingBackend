package com.raunak.bus;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.raunak.bus.Dto.AcceptBookings;
import com.raunak.bus.Dto.AdminPassangerDto;
import com.raunak.bus.Dto.BookingDto;
import com.raunak.bus.Dto.PassangerDto;
import com.raunak.bus.Entity.Bookings;
import com.raunak.bus.Entity.Cities;
import com.raunak.bus.Entity.Passengers;
import com.raunak.bus.Repository.BookingRepository;
import com.raunak.bus.Repository.CitiesRepository;
import com.raunak.bus.Repository.PassangerRepo;
import com.raunak.bus.Service.BookingService;

class BookingServiceTest {
	private static List<PassangerDto> passangersDto;
	private static List<AdminPassangerDto> adminPassangers;
	private static List<Passengers> passangers;
	private static BookingDto bookingDto;
	private static BookingDto bookingDtoNegativeDistance;
	private static List<Cities> cities;
	private static Bookings booking;
    @BeforeEach
    public void setUp() {
    	passangersDto = new ArrayList<>();
    	passangersDto.add(new PassangerDto("test",20,"Male",2000));

    	adminPassangers = new ArrayList<>();
    	adminPassangers.add(new AdminPassangerDto("2023-12-01","Gondia","Pune",1,28,1,"Test","Male",2000,true,true));
    	
    	passangers  = new ArrayList<>();
    	passangers.add(new Passengers(1, 2, "2023-12-01", "Test", 28,"m", 2000, true, true, 1,1));
    	passangers.add(new Passengers(2, 2, "2023-12-01", "Test1", 28,"f", 2200, true, true, 1,1));

    	bookingDto = new BookingDto(1,2,1,1,"2023-12-01",400,3,passangersDto);
    	bookingDtoNegativeDistance = new BookingDto(1,2,1,1,"2023-12-01",-400,3,passangersDto);
    	bookingDtoNegativeDistance.setDistance(-400);

    	cities  = new ArrayList<>();
    	cities.add(new Cities(1,"Gondia", 0));
    	cities.add(new Cities(2,"Pune", 400));
    	cities.add(new Cities(3,"Nagpur", 200));
    	
    	booking = new Bookings(1,1,3,1,2,"2023-12-01",200);
    	booking.setBookFrom(1);
    	booking.setBookTo(3);
    }
    @Test
    void testCreateBooking() {

        BookingRepository bookingRepository = mock(BookingRepository.class);
        PassangerRepo passangerRepo = mock(PassangerRepo.class);
        CitiesRepository citiesRepository = mock(CitiesRepository.class);

        BookingService bookingService = new BookingService(bookingRepository, passangerRepo, citiesRepository);
        
        when(bookingRepository.save(any(Bookings.class))).thenReturn(new Bookings());

        when(passangerRepo.save(any(Passengers.class))).thenReturn(new Passengers());

        ResponseEntity<Object> response = bookingService.createBooking(bookingDto);

        verify(bookingRepository, times(1)).save(any(Bookings.class));
        verify(passangerRepo, times(1)).save(any(Passengers.class));

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    void testCreateBookingForNegativeDistance() {

        BookingRepository bookingRepository = mock(BookingRepository.class);
        PassangerRepo passangerRepo = mock(PassangerRepo.class);
        CitiesRepository citiesRepository = mock(CitiesRepository.class);

        BookingService bookingService = new BookingService(bookingRepository, passangerRepo, citiesRepository);

        when(bookingRepository.save(any(Bookings.class))).thenReturn(new Bookings());

        when(passangerRepo.save(any(Passengers.class))).thenReturn(new Passengers());

        ResponseEntity<Object> response = bookingService.createBooking(bookingDtoNegativeDistance);

        verify(bookingRepository, times(1)).save(any(Bookings.class));
        verify(passangerRepo, times(1)).save(any(Passengers.class));

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetBookings() {
        BookingRepository bookingRepository = mock(BookingRepository.class);
        PassangerRepo passangerRepo = mock(PassangerRepo.class);
        CitiesRepository citiesRepository = mock(CitiesRepository.class);
        
        BookingService bookingService = new BookingService(bookingRepository, passangerRepo, citiesRepository);
        
        when(passangerRepo.findAllByStatusFalseOrNull()).thenReturn(passangers);
        when(citiesRepository.findAll()).thenReturn(cities);
 
        for (Passengers passenger : passangers) {
            when(bookingRepository.findById(passenger.getBookingId())).thenReturn(Optional.of(booking));
        }
        ResponseEntity<Object> responseEntity = bookingService.getBookings();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateStatus() {

        BookingRepository bookingRepository = mock(BookingRepository.class);
        PassangerRepo passangerRepo = mock(PassangerRepo.class);
        CitiesRepository citiesRepository = mock(CitiesRepository.class);

        BookingService bookingService = new BookingService(bookingRepository, passangerRepo, citiesRepository);

        AcceptBookings acceptBookings = new AcceptBookings();
        acceptBookings.setPassangerIds(new ArrayList<>());
        acceptBookings.setDate("2023/12/01");

        when(passangerRepo.findAllById(anyList())).thenReturn(passangers);
        when(passangerRepo.findByJourneyDateWithStatus("2023/12/01")).thenReturn(passangers);
        
        for (@SuppressWarnings("unused") Passengers passenger : passangers) {
            
        }
        ResponseEntity<Object> response = bookingService.updateStatus(acceptBookings);

        verify(passangerRepo, times(1)).findAllById(anyList());
        verify(passangerRepo, times(1)).findByJourneyDateWithStatus("2023/12/01");

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetHistory() {
        BookingRepository bookingRepository = mock(BookingRepository.class);
        PassangerRepo passangerRepo = mock(PassangerRepo.class);
        CitiesRepository citiesRepository = mock(CitiesRepository.class);

        BookingService bookingService = new BookingService(bookingRepository, passangerRepo, citiesRepository);

        when(passangerRepo.findByBookedByUser(anyInt())).thenReturn(passangers);
        when(citiesRepository.findAll()).thenReturn(cities);
 
        for (Passengers passenger : passangers) {
            when(bookingRepository.findById(passenger.getBookingId())).thenReturn(Optional.of(booking));
        }
        
        ResponseEntity<Object> response = bookingService.getHistory(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetAllHistory() {
        BookingRepository bookingRepository = mock(BookingRepository.class);
        PassangerRepo passangerRepo = mock(PassangerRepo.class);
        CitiesRepository citiesRepository = mock(CitiesRepository.class);

        BookingService bookingService = new BookingService(bookingRepository, passangerRepo, citiesRepository);

        when(passangerRepo.findAll()).thenReturn(passangers);
        when(citiesRepository.findAll()).thenReturn(cities);
 
        for (Passengers passenger : passangers) {
            when(bookingRepository.findById(passenger.getBookingId())).thenReturn(Optional.of(booking));
        }

        ResponseEntity<Object> response = bookingService.getAllHistory();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
