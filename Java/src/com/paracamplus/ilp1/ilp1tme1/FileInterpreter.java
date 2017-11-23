package com.paracamplus.ilp1.ilp1tme1;

import java.io.File;
import java.io.IOException;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.test.InterpreterTest;
import com.paracamplus.ilp1.parser.ParseException;

public class FileInterpreter {
	
	public static void main(String[] args) throws ParseException, IOException, EvaluationException {
		InterpreterTest fi = new InterpreterTest(new File(args[0]));
		fi.processFile();
	}
}
