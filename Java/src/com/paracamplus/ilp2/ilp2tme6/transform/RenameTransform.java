package com.paracamplus.ilp2.ilp2tme6.transform;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.compiler.normalizer.NoSuchLocalVariableException;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;

public class RenameTransform extends CopyTransform<INormalizationEnvironment> {

	protected int compteur;

	public RenameTransform(IASTfactory factory) {
		super(factory);
		compteur = 0;
	}
	
	@Override
	public IASTexpression visit(IASTblock iast, INormalizationEnvironment data)
			throws CompilationException {
		
		IASTbinding[] oldbinding = iast.getBindings();
		IASTbinding[] binding = new IASTbinding[oldbinding.length];
		INormalizationEnvironment data2 = data;
		
		for (int i = 0; i < oldbinding.length; i++) {
			
			IASTvariable oldv = oldbinding[i].getVariable();
			IASTvariable newv = factory.newVariable(oldv.getMangledName()+compteur);
			data2 = data2.extend(oldv,newv);
			
			IASTexpression exp = oldbinding[i].getInitialisation().accept(this, data);
			binding[i] = factory.newBinding(newv, exp);
			
			compteur++;
		}
		IASTexpression body = iast.getBody().accept(this,data2);
		return factory.newBlock(binding, body);
	}
	
	@Override
	public IASTfunctionDefinition visit(IASTfunctionDefinition iast, INormalizationEnvironment data) 
			throws CompilationException {
		
		IASTvariable functionVariable  = (IASTvariable) iast.getFunctionVariable().accept(this,data);
		
		IASTvariable[] oldvariables = iast.getVariables();
		IASTvariable[] variables = new IASTvariable[oldvariables.length];
		
		for (int i = 0; i < oldvariables.length; i++) {
			
			IASTvariable oldv = oldvariables[i];
			IASTvariable newv = factory.newVariable(oldv.getMangledName()+compteur);
			data = data.extend(oldv, newv);
			
			variables[i] = newv;
			compteur++;
		}
		
		IASTexpression body = iast.getBody().accept(this, data);
		return factory.newFunctionDefinition(functionVariable, variables, body);
	}

	@Override
	public IASTexpression visit(IASTvariable iast,
			INormalizationEnvironment data) throws CompilationException {
			try {
				return data.renaming(iast);
			}catch(NoSuchLocalVariableException e){
				return iast;
			}
					
	}
}
