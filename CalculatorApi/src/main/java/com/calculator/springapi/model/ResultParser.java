package com.calculator.springapi.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;


@Getter
public class ResultParser implements AutoCloseable{

	public static String query;

	public ResultParser(String query) {
		this.query = query;
	}

	public CalculatedResult parseQuery() throws CalculatorException {
        
		Pattern pattern = Pattern.compile("[^0-9]+");   
        Matcher matchOperator = pattern.matcher(query);        
        if (matchOperator.find())
        {
            String operator = matchOperator.group(0);
            String[] values = query.split("\\"+operator);
            return new CalculatedResult(operator, Double.parseDouble(values[0]),
    				Double.parseDouble(values[1]));
   
        }
        
		return null;

	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
