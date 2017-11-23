package com.paracamplus.ilp1.ilp1tme2.ex1.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.ilp1tme2.ex1.interfaces.IASTaffectation;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvisitor;

public class ASTaffectation extends ASTexpression implements IASTaffectation {
	private final String variable;
	private final IASTexpression valeur;
	
	public ASTaffectation(String variable, IASTexpression valeur){
		this.variable = variable;
		this.valeur = valeur;
	}
	
	@Override
	public String getVariable() {
		return variable;
	}

	@Override
	public IASTexpression getValeur() {
		return valeur;
	}
	
	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(
			IASTvisitor<Result, Data, Anomaly> visitor, Data data)
			throws Anomaly {
		return null;
	}
}
