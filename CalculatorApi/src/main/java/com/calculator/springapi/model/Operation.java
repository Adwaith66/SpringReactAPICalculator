package com.calculator.springapi.model;

import lombok.Getter;

@Getter
public enum Operation {
	ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("|"), EXPONENTIATION("^");

	private String value;

	private Operation(String value)
	   {
	      this.value = value;
	   }

	public String toString() {
		return this.value; // will return , or ' instead of COMMA or APOSTROPHE
	}

}
