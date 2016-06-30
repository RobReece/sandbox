package com.rrc.junit.conversion.approach1;
import java.util.Date;

import junit.framework.TestCase;

public class JUnit3SuperClass extends TestCase {

	String ctorState;
	String setupState;
	
	static String somethingStatic;
	
	static {
		somethingStatic = getTestData();
	}
	
	public JUnit3SuperClass(String name) {
		super(name);
		init();
	}
	
	public void init() {
		ctorState = getTestData();
	}

	private static String getTestData() {
		return Long.toString(System.nanoTime());
	}
	
	public void setUp() {
		setupState = getTestData();
	}
	
	public void tearDown() {
		System.out.println("Tearing it down");
	}
}
