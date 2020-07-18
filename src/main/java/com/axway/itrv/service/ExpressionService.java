package com.axway.itrv.service;

import com.axway.itrv.exp.Expression;
import com.axway.itrv.exp.impl.EvaluatorVisitor;
import com.axway.itrv.exp.impl.InfixParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;

@Service
public class ExpressionService {

	private InfixParser infixParser;
	private EvaluatorVisitor evaluatorVisitor;
	@Autowired
	public ExpressionService(){
		infixParser = new InfixParser();
		evaluatorVisitor = new EvaluatorVisitor();
	}

	public Double executeExpression(String expression) throws IOException, ParseException {
		Expression expressionResult = infixParser.parse(expression);
		return expressionResult.accept(evaluatorVisitor);
	}
}
