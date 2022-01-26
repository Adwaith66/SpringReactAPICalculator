package com.calculator.springapi.model;

import lombok.Getter;

@Getter
public class CalculatorException extends Exception {
	public CalculatorException(String errorMessage) {
        super(errorMessage);
    }

	public CalculatorException() {
	}

	
}
