package com.java.parse;

public class Data {
	private double x;
	private double y;
	private double z;
	private String dateString;
	
	public Data(double x, double y, double z, String dateString) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.dateString = dateString;
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getZ(){
		return z;
	}
	public String getDateString() {
		return dateString;
	}
} 
