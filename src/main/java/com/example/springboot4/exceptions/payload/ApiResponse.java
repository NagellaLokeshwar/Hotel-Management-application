package com.example.springboot4.exceptions.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	
	private String msg;
	private boolean sucess;
	private HttpStatus status;
	
	
	
	



	



	public ApiResponse(String msg, boolean sucess, HttpStatus status) {
		super();
		this.msg = msg;
		this.sucess = sucess;
		this.status = status;
	}







	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public boolean isSucess() {
		return sucess;
	}



	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}



	public HttpStatus getStatus() {
		return status;
	}



	public void setStatus(HttpStatus status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "ApiResponse [msg=" + msg + ", sucess=" + sucess + "]";
	}

}
