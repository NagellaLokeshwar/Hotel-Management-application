package com.example.springboot4.controller;

import com.example.springboot4.dto.BookingDto;
import com.example.springboot4.models.Booking;
import com.example.springboot4.services.BookingService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/")
    public Booking bookHotel(@RequestBody BookingDto dto) {
        return bookingService.createBooking(dto);
    }

    @GetMapping("/all/hotel/{hotelId}")
    public List<Booking> getAllByHotelId(@PathVariable String hotelId) {
        return bookingService.getAllByHotelId(hotelId);
    }

    @GetMapping("/all/user/{userId}")
    public List<Booking> getAllByUserId(@PathVariable String userId) {
        return bookingService.getAllByUserId(userId);
    }
    
    
    @DeleteMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable String id) {
    	return bookingService.cancelBooking(id);
    }
}
