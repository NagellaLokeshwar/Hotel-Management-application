package com.example.springboot4.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hotel {
	
	@Id
	@Column(name = "hotel_id")
	private String id;
	private String name;
	private String rating;
	private String phone;
	private String email;
	private String roomsAvail;

	@OneToMany(mappedBy="hotel", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Booking> bookings = new ArrayList<>();
	
	public List<Booking> getBookings() {
	    return bookings;
	}

	public String getName() {
		return name;
	}

	public Hotel(String id, String name, String rating, String phone, String email, String roomsAvail,
			List<Booking> bookings) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.phone = phone;
		this.email = email;
		this.roomsAvail = roomsAvail;
		this.bookings = bookings;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoomsAvail() {
		return roomsAvail;
	}

	public void setRoomsAvail(String roomsAvail) {
		this.roomsAvail = roomsAvail;
	}

	public void setBookings(List<Booking> bookings) {
	    this.bookings = bookings;
	}

	public void addBooking(Booking booking) {
	    bookings.add(booking);
	    booking.setHotel(this);
	}

	public void removeBooking(Booking booking) {
	    bookings.remove(booking);
	    booking.setHotel(null);
	}
	
	
	
	
	
	public Hotel() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
