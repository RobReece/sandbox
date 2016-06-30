package com.rrc.junit.conversion.approach1;

public class JUnit3TestClass extends JUnit3SuperClass {

	public JUnit3TestClass(String testname) {
		super(testname);
	}
	
	public void test1() {
		theTest();
	}
	
	public void test2() {
		theTest();
	}
	
	private void theTest() {
		System.out.println(ctorState);
		System.out.println(setupState);
		System.out.println(somethingStatic);
	}

}
