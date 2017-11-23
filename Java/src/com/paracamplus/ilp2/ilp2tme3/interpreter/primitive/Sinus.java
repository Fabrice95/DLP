package com.paracamplus.ilp2.ilp2tme3.interpreter.primitive;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;

public class Sinus extends UnaryPrimitive {
	
	public Sinus() {
		super("sinus");
	}
	
	@Override
	public Object apply(Object argument) throws EvaluationException {
		if(argument instanceof BigDecimal){
			BigDecimal bd = (BigDecimal) argument;
			return Math.sin(bd.doubleValue());
		} else if (argument instanceof BigInteger) {
			BigInteger bd = (BigInteger) argument;
			return Math.sin(bd.doubleValue());
		} else {
			throw new EvaluationException("Call sinus with wrong argument type");
		}
	}
}