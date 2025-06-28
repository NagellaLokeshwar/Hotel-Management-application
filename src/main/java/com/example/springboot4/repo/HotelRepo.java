package com.example.springboot4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot4.models.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{
	

}
