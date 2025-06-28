package com.example.springboot4.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	private String id;
	private String userId;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(String id, String userId, LocalDate bookingDate, LocalDate checkOutDate, Hotel hotel, boolean paymentStatus) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.hotel = hotel;
		this.checkOutDate =  checkOutDate;
		this.paymentStatus = paymentStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	private LocalDate bookingDate;
	private LocalDate checkOutDate;
	
	@ManyToOne
	@JoinColumn(name = "hotelId", nullable = false)
	private Hotel hotel;
	private boolean paymentStatus;
}
