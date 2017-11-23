package com.paracamplus.ilp2.ilp2tme6.transform;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASToperator;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperator;
import com.paracamplus.ilp2.interfaces.IASTassignment;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.interfaces.IASTvisitor;

public class CallAnalysis implements IASTvisitor<Void, Set<String>, CompilationException>{
	protected Set<String> recursive = null;
	
	public boolean isRecursive(IASTvariable f){
		return recursive.contains(f.getName());
	}
	
	
public Void visit(IASTprogram p) throws CompilationException {
		
		//Ensemble des fonctions appelées par chaque fonction
		Map<String, Set<String>> calls = new HashMap<>();
		
		//visite de chaque fonction
		for(IASTfunctionDefinition f: p.getFunctionDefinitions()){
			Set<String> set = new HashSet<>();
			visit(f, set);
			calls.put(f.getFunctionVariable().getName(), set);
		}
		
		//Détection des cycles (algorithme naif)
		recursive = new HashSet<String>();
		
		//pour chaque variable v
		for(String v: calls.keySet()){
			//variables accessibles depuis v, par recherche en profondeur
			Set<String> reachable = new HashSet<>();
			Stack<String> todo = new Stack<>();
			
			//initialisation
			todo.push(v);
			
			//tant qu'il reste des noeuds à traiter
			while(!todo.empty()){
				String cur = todo.pop();
				if(reachable.contains(cur)){
					continue;
				}
				reachable.add(cur);
				
				//pour chaque successeur next
				Set<String> nexts = calls.get(cur);
				if(nexts != null){
					for(String next: nexts){
						//cycle détecté
						if(v.equals(next)){
							recursive.add(v);
						}
						//marquage des successeurs
						todo.push(next);
					}
				}
			}
		}
		return null;
	}
	
	private Void visit(IASTfunctionDefinition f, Set<String> set) {
		
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Void visit(IASTalternative iast, Set<String> data)
			throws CompilationException {
		iast.getCondition().accept(this, data);
		iast.getConsequence().accept(this, data);
		iast.getAlternant().accept(this, data);
		
		return null;
	}


	@Override
	public Void visit(IASTbinaryOperation iast, Set<String> data)
			throws CompilationException {
		iast.getLeftOperand().accept(this, data);
        iast.getRightOperand().accept(this, data);
		return null;
	}






	@Override
	public Void visit(IASTblock iast, Set<String> data)
			throws CompilationException {
		for ( IASTbinding binding : iast.getBindings() ) {
			binding.getInitialisation().accept(this, data);
        }
		iast.getBody().accept(this, data);
		return null;
	}



	@Override
	public Void visit(IASTboolean iast, Set<String> data)
			throws CompilationException {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public Void visit(IASTfloat iast, Set<String> data)
			throws CompilationException {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public Void visit(IASTinteger iast, Set<String> data)
			throws CompilationException {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public Void visit(IASTinvocation iast, Set<String> data)
			throws CompilationException {
		
		//visite des expressions argument réel
		for(IASTexpression e: iast.getArguments()){
			e.accept(this, data);
		}
		
		//détermination de la fonction appelée
		/*
		 * LIMITATION
		 * On suppose que l'expression dénotant la fonction appelée est
		 * réduite à une variable, qui dénote une fonction globale...
		 */
		IASTexpression function = iast.getFunction();
		if(function instanceof IASTvariable){
			data.add(((IASTvariable)function).getName());
		}else{
			throw new CompilationException("unsupported function call");
		}
		return null;
	}






	@Override
	public Void visit(IASTsequence iast, Set<String> data)
			throws CompilationException {
		IASTexpression[] expressions = iast.getExpressions();
        for ( IASTexpression e : expressions ) {
            e.accept(this, data);
        }
		return null;
	}






	@Override
	public Void visit(IASTstring iast, Set<String> data)
			throws CompilationException {
		// TODO Auto-generated method stub
		return null;
	}
	




	@Override
	public Void visit(IASTunaryOperation iast, Set<String> data)
			throws CompilationException {
		 iast.getOperand().accept(this, data);
		 return null;
	}






	@Override
	public Void visit(IASTvariable iast, Set<String> data)
			throws CompilationException {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public Void visit(IASTassignment iast, Set<String> data)
			throws CompilationException {
		iast.getExpression().accept(this, data);
		return null;
	}






	@Override
	public Void visit(IASTloop iast, Set<String> data)
			throws CompilationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
