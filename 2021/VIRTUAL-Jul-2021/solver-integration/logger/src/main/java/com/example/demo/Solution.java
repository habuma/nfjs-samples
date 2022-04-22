package com.example.demo;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class Solution implements Serializable {

	private static final long serialVersionUID = 1L;

	private double x1;
	private double x2;
	
	public Solution() {}

	public Solution(double x1, double x2) {
		this.x1 = x1;
		this.x2 = x2;
	}

	public double getX1() {
		return x1;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public double getX2() {
		return x2;
	}
	public void setX2(double x2) {
		this.x2 = x2;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
