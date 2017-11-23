package com.paracamplus.ilp2.ilp2tme3.interpreter;

import java.io.Writer;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp2.ilp2tme3.interpreter.primitive.Sinus;

public class GlobalVariableStuff {
	public static void fillGlobalVariables (
            IGlobalVariableEnvironment env,
            Writer out ) {
		com.paracamplus.ilp1.interpreter.GlobalVariableStuff.fillGlobalVariables(env, out);
        env.addGlobalVariableValue(new Sinus());
    }
}
