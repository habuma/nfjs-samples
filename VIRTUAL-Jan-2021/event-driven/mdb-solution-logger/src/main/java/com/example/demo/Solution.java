package com.example.demo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solution implements Serializable {
	private static final long serialVersionUID = 1L;

	private double x1;
	private double x2;
	
}
