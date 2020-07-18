package com.axway.itrv.controller;

import com.axway.itrv.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class ExpressionController {

	private ExpressionService expressionService;

	@Autowired
	public ExpressionController(ExpressionService expressionService) {
		this.expressionService = expressionService;
	}

	@RequestMapping(value = "expression", method = RequestMethod.GET)
	public ResponseEntity<String> executeExpression(@RequestBody String expression) {
		try {
			Double result = expressionService.executeExpression(expression);
			if(result!=null){
				return ResponseEntity.status(HttpStatus.OK).body(result.toString());
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to calculate the expression - "+expression);
			}
		} catch (ParseException ex) {
			return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(ex.getMessage());
		}catch (Exception ex){
			return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ex.getMessage());
		}
	}
}
