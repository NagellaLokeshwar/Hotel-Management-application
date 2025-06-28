package com.example.springboot4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot4.models.Hotel;
import com.example.springboot4.services.HotelService;

@RestController
@RequestMapping("/")
public class HotelController {
	
	@Autowired
	private HotelService service;
	@PostMapping
	public Hotel createHotel(@RequestBody Hotel h) {
		System.out.println(h);
		return service.createHotel(h);
	}
	
	
	@GetMapping("/{id}")
	public Hotel getHotelById(@PathVariable("id") String id)
	{
		return service.getHotelById(id);
	}
	
	@PostMapping("/many")
	public int createMultipleHotels(@RequestBody List<Hotel> h) {
		return service.createHotelList(h);
	}
	
	@PutMapping("/update")
	public Hotel updateHotelDetails(@RequestBody Hotel hotel) {
		
		return service.updateHotel(hotel);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteHotel(@PathVariable("id") String id) {
		return service.deleteHotel(id);
	}
}
