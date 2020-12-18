package com.example.demo;

import java.io.Serializable;

public class Equation implements Serializable {

	private static final long serialVersionUID = 1L;
	private double coefficientA;
	private double coefficientB;
	private double coefficientC;

	
	public Equation() {}
	
	public Equation(
			double coefficientA, 
			double coefficientB, 
			double coefficientC) {
		this.coefficientA = coefficientA;
		this.coefficientB = coefficientB;
		this.coefficientC = coefficientC;
	}
	
	public double getCoefficientA() {
		return coefficientA;
	}

	public void setCoefficientA(double coefficientA) {
		this.coefficientA = coefficientA;
	}

	public double getCoefficientB() {
		return coefficientB;
	}

	public void setCoefficientB(double coefficientB) {
		this.coefficientB = coefficientB;
	}

	public double getCoefficientC() {
		return coefficientC;
	}

	public void setCoefficientC(double coefficientC) {
		this.coefficientC = coefficientC;
	}
	
}
