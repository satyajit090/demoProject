package com.example.demo.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Responses {
	
	private int id;
	private String response;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Responses(int id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	public Responses() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Responses [id=" + id + ", response=" + response + "]";
	}
	
	
	
	

}
