package com.paracamplus.ilp1.ilp1tme2.ex1.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTwhile extends IASTexpression {
	IASTexpression getCondition();
	IASTexpression getBody();
}
