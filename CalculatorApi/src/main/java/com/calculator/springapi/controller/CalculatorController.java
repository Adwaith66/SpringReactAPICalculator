package com.calculator.springapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.springapi.model.CalculatedResult;
import com.calculator.springapi.model.ResultParser;

@CrossOrigin("*")
@RestController
@RequestMapping(
		produces = "application/json"
)
public class CalculatorController {
	
	private CalculatedResult cr;

	@GetMapping("/calculate/{values}")
	public String getMapping(@PathVariable("values") String values) throws Exception {
		try(ResultParser rs = new ResultParser(values)){
			cr = rs.parseQuery();
			return cr.toString();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			return "Please enter two numbers as input";
		}
		catch(NumberFormatException e){
			return "Please ensure that all numbers are formatted correctly";
		}
		
		
		
	
	}
	
}
