package com.calculator.springapi.controller;


import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
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
	String uri = "neo4j://localhost:7687";
	
	public enum NodeType implements Label{
		
	}


	@GetMapping("/calculate/{values}")
	public String getMapping(@PathVariable("values") String values) throws Exception {
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService graphDB = dbFactory.newEmbeddedDatabase("/Users/adwaithsreekumar/Desktop/CalculatorAPIReact/SpringReactAPICalculator/CalculatorApi/neo4j-community-2.1.6/data/graph.db");
		
		
		
		
		
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
