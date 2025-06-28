package com.example.springboot4.services;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot4.controller.BookingController;
import com.example.springboot4.dto.BookingDto;
import com.example.springboot4.exceptions.ResourceNotFoundException;
import com.example.springboot4.models.Booking;
import com.example.springboot4.models.Hotel;
import com.example.springboot4.models.User;
import com.example.springboot4.repo.BookingRepository;
import com.example.springboot4.repo.HotelRepo;
import com.example.springboot4.repo.UserRepository;

@Service
public class BookingService {

	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private HotelRepo hotelRepo;
	
	@Autowired
	private UserRepository userRepository;

	
	public Booking createBooking(BookingDto dto) {
		Booking b = new Booking();
		b.setUserId(dto.getUserId());
		b.setId(UUID.randomUUID().toString());
		
		Hotel hotel = hotelRepo.findById(dto.getHotelId()).orElseThrow(() -> new ResourceNotFoundException("Hotel with id not found"));
		if(Integer.parseInt(hotel.getRoomsAvail()) < 1) {
			throw new RuntimeException("Rooms not available");
		} 
		hotel.setRoomsAvail( Integer.toString(Integer.parseInt(hotel.getRoomsAvail()) - 1 ));
		b.setHotel(hotel);
		hotelRepo.save(hotel);
		b.setCheckOutDate(LocalDate.parse(dto.getCheckOutDate()));
		b.setBookingDate(LocalDate.parse(dto.getBookingDate()));
		b.setPaymentStatus(dto.isPaymentDone());
		b.setUserId(dto.getUserId());
		return bookingRepository.save(b); 
	}
	
	public List<Booking> getAllByHotelId(String hotelId) {
	    if (hotelId == null || hotelId.trim().isEmpty()) {
	        throw new IllegalArgumentException("Hotel ID cannot be null or empty");
	    }

	    Hotel hotel = hotelRepo.findById(hotelId)
	            .orElseThrow(() -> new ResourceNotFoundException("Hotel with ID " + hotelId + " not found"));

	    return bookingRepository.findAllByHotel(hotel);
	}
	
	public String cancelBooking(String bookingId) {
		Booking b = bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
		Hotel h = hotelRepo.findById(b.getHotel().getId()).orElseThrow(() -> new ResourceNotFoundException("Hotel not found associated with Booking id: " + bookingId));
		
		int roomsAvail = Integer.parseInt(h.getRoomsAvail());
		h.setRoomsAvail(Integer.toString(roomsAvail+1));
		
		hotelRepo.save(h);
		bookingRepository.deleteById(bookingId);
		return "Booking deleted with ID: " + bookingId;
	}

	
	public List<Booking> getAllByUserId(String userId) {
		return bookingRepository.findAllByUserId(userId);
	}
	
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	public Booking getBookingById(String id) {
		return bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
	}

}	
