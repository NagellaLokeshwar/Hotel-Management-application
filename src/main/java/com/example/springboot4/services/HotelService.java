package com.example.springboot4.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot4.controller.BookingController;
import com.example.springboot4.exceptions.ResourceNotFoundException;
import com.example.springboot4.models.Hotel;
import com.example.springboot4.repo.HotelRepo;

@Service
public class HotelService {

	@Autowired
	private HotelRepo repo;


	public int createHotelList(List<Hotel> h) {
		for (Hotel hotel : h) {
			hotel.setId(UUID.randomUUID().toString());
			repo.save(hotel);
		}
		return h.size();
	}

	public List<Hotel> getHotels() {
		return repo.findAll();
	}

	public Hotel getHotelById(String id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	public Hotel createHotel(Hotel h) {
		h.setId(UUID.randomUUID().toString());
		return repo.save(h);
	}
	
	
	public Hotel updateHotel(Hotel hotel) {
		Hotel entity = repo.findById(hotel.getId()).orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotel.getId() + " not found."));
		entity.setName(hotel.getName());
		return repo.save(entity);
	}
	
	public String deleteHotel(String id) {
		Hotel entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + id + " not found."));
		repo.delete(entity);
		return "Hotel deleted with id: " + id ; 
	}
	
	

}
