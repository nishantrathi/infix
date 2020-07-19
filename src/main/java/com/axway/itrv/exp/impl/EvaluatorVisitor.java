package com.axway.itrv.exp.impl;

import com.axway.itrv.exp.Expression;
import com.axway.itrv.exp.ExpressionVisitor;

import java.util.HashMap;
import java.util.Map;

// TODO implement an expression evaluator

public class EvaluatorVisitor implements ExpressionVisitor<Double> {

    private Map<Double, Double> factorialMap = new HashMap<>(){{
        put(0.0, 1.0);
        put(1.0,1.0);
    }};

    @Override
    public Double visit(Constant constant) {
      // TODO
        return constant.getValue();
    }

    @Override
    public Double visit(BinaryOp binaryOp) {
        var left = binaryOp.getLeft().accept(this);
        var right = binaryOp.getRight().accept(this);

        switch (binaryOp.getType()) {
            case ADD:
                return left + right;
            case SUB:
                return left - right;
            case MUL:
                return left * right;
            case DIV:
                return left / right;
        }
        throw new IllegalStateException();
    }

    @Override
    public Double visit(UnaryOp unaryOp) {

        switch (unaryOp.getType()) {
            case NEGATION:
                return -unaryOp.getOperand().accept(this);
            case FACTORIAL:
                Double num = unaryOp.getOperand().accept(this);
                if(num < 0){
                    return factorial(num * -1) * -1;
                }
                return factorial(num);
        }

        throw new IllegalStateException();
    }

    private Double factorial(Double num){
        if(num==0 || num==1) {
            return factorialMap.get(num);
        }
        if(factorialMap.containsKey(num)){
            return factorialMap.get(num);
        }
        factorialMap.put(num,  num * factorial(num-1));
        return factorialMap.get(num);
    }
}
