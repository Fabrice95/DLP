/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp2.ilp2tme5.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.ilp2tme5.interfaces.IASTfactory;



public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory 
	implements IASTfactory{

	@Override
	public IASTexpression newBreak() {
		return new ASTbreak();
	}


	@Override
	public IASTexpression newContinue() {
		return new ASTcontinue();
	}

}
