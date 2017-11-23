package com.paracamplus.ilp1.ilp1tme1.test;

import java.io.File;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import com.paracamplus.ilp1.compiler.test.CompilerRunner;
import com.paracamplus.ilp1.compiler.test.CompilerTest;

public class CompilerTestTme1 extends CompilerTest{
	static{
		samplesDirName[0] = "SamplesTME1";
	}
	public CompilerTestTme1(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}
	
	@Parameters(name = "{0}")
    public static Collection<File[]> data() throws Exception {
    	return CompilerRunner.getFileList(samplesDirName, pattern);
    }
}
