package com.example.demo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Equation implements Serializable {
	private static final long serialVersionUID = 1L;

	private double coefficientA;
	private double coefficientB;
	private double coefficientC;
	
}
