package com.paracamplus.ilp1.ilp1tme2.ex1.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTfactory extends com.paracamplus.ilp1.interfaces.IASTfactory {
	 IASTexpression newAffectation(
	            String var,
	            IASTexpression val);
	 
	 IASTexpression newWhile(
	            IASTexpression condition,
	            IASTexpression body);
	 
	 IASTfunction newFunction(
	            String nom,
	            IASTexpression[] params,
	            IASTexpression[] instructions);
}
