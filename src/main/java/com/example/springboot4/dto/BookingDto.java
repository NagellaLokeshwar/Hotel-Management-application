package com.example.springboot4.dto;

public class BookingDto {
	public BookingDto () {
		
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public BookingDto(String hotelId, String bookingDate) {
		super();
		this.hotelId = hotelId;
		this.bookingDate = bookingDate;
	}
	private String hotelId;
	private String bookingDate;
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public boolean isPaymentDone() {
		return payment;
	}
	public void setPayment(boolean payment) {
		this.payment = payment;
	}
	
	private String checkOutDate;
	private boolean payment;
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
