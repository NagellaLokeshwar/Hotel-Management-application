package com.example.springboot4.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot4.models.Booking;
import com.example.springboot4.models.Hotel;

public interface BookingRepository extends JpaRepository<Booking, String>{
	public List<Booking> findAllByUserId(String userId);
	public List<Booking> findAllByHotel(Hotel hotel);
}
