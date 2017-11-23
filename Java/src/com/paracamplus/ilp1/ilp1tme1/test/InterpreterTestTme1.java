package com.paracamplus.ilp1.ilp1tme1.test;

import java.io.File;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import com.paracamplus.ilp1.interpreter.test.InterpreterRunner;
import com.paracamplus.ilp1.interpreter.test.InterpreterTest;

public class InterpreterTestTme1 extends InterpreterTest{
	static {
		samplesDirName[0] = "SamplesTME1";
	}
	
	public InterpreterTestTme1(File file) {
		super(file);
	}
	
	@Parameters(name = "{0}")
    public static Collection<File[]> data() throws Exception {
    	return InterpreterRunner.getFileList(samplesDirName, pattern);
    }
}
