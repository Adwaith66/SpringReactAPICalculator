package com.calculator.springapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.lang.AutoCloseable;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class CalculatedResult implements AutoCloseable  {

	private static String operation;
	private static Double firstNum;
	private static Double secondNum;
	private static Double result;
	
	
	public CalculatedResult(String operation, double firstNum, double secondNum) throws CalculatorException {

		this.operation = operation;
		this.firstNum = firstNum;
		this.secondNum = secondNum;

		result = findOperation();

	}

	

	public static Double findOperation() throws CalculatorException {

		if (operation.equals(Operation.ADD.toString())) {
			return addOperation();
		} else if (operation.equals(Operation.SUBTRACT.toString())) {
			return subtractOperation();
		} else if (operation.equals(Operation.DIVIDE.toString())) {
			return divideOperation();
		} else if (operation.equals(Operation.MULTIPLY.toString())) {
			return multiplyOperation();
		}
		else if (operation.equals(Operation.EXPONENTIATION.toString())) {
			return exponentOperation();
		}
		throw new CalculatorException("Incorrect operators " + " " + operation+ " " + firstNum+ " " + secondNum);

	}

	private static Double addOperation() {
		return firstNum + secondNum;
	}

	private static Double subtractOperation() {
		return firstNum - secondNum;
	}

	private static Double divideOperation() {
		return firstNum / secondNum;
	}

	private static Double multiplyOperation() {
		return firstNum * secondNum;
	}
	
	private static Double exponentOperation() {
		return Math.pow(firstNum, secondNum);
	}



	public static String getOperation() {
		return operation;
	}



	public static void setOperation(String operation) {
		CalculatedResult.operation = operation;
	}



	public static Double getFirstNum() {
		return firstNum;
	}



	public static void setFirstNum(Double firstNum) {
		CalculatedResult.firstNum = firstNum;
	}



	public static Double getSecondNum() {
		return secondNum;
	}



	public static void setSecondNum(Double secondNum) {
		CalculatedResult.secondNum = secondNum;
	}



	public static Double getResult() {
		return result;
	}



	public static void setResult(Double result) {
		CalculatedResult.result = result;
	}
	
	public String toString() {
		return result.toString();
	}



	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}



}
