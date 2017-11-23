package com.paracamplus.ilp2.ilp2tme3.compiler;

import com.paracamplus.ilp1.compiler.Primitive;
import com.paracamplus.ilp1.compiler.interfaces.IGlobalVariableEnvironment;

public class GlobalVariableStuff {
	public static void fillGlobalVariables (IGlobalVariableEnvironment env) {
		com.paracamplus.ilp1.compiler.GlobalVariableStuff.fillGlobalVariables(env);
        env.addGlobalFunctionValue(
        		new Primitive("sinus", "ILP_sinus", 1));
    }
}
