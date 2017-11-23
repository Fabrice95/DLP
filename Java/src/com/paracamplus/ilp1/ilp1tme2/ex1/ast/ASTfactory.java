package com.paracamplus.ilp1.ilp1tme2.ex1.ast;

import com.paracamplus.ilp1.ilp1tme2.ex1.interfaces.IASTfactory;
import com.paracamplus.ilp1.ilp1tme2.ex1.interfaces.IASTfunction;
import com.paracamplus.ilp1.interfaces.IASTexpression;

public class ASTfactory extends com.paracamplus.ilp1.ast.ASTfactory implements IASTfactory{

	@Override
	public IASTexpression newAffectation(String var, IASTexpression val) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IASTexpression newWhile(IASTexpression condition, IASTexpression body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IASTfunction newFunction(String nom, IASTexpression[] params,
			IASTexpression[] body) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
