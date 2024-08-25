package com.bookstore.exception;

import java.util.Date;

public class Api_error {
	private int error_code;
	private String error_desc;
	private Date error_date;
	public Api_error(int error_code, String error_desc, Date error_date) {
		super();
		this.error_code = error_code;
		this.error_desc = error_desc;
		this.error_date = error_date;
	}
	public Api_error() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public String getError_desc() {
		return error_desc;
	}
	public void setError_desc(String error_desc) {
		this.error_desc = error_desc;
	}
	public Date getError_date() {
		return error_date;
	}
	public void setError_date(Date error_date) {
		this.error_date = error_date;
	}
	
}
