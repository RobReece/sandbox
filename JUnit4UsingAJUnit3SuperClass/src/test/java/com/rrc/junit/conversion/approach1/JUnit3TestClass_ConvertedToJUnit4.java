package com.rrc.junit.conversion.approach1;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnit3TestClass_ConvertedToJUnit4 extends JUnit3SuperClass_NowJUnit4 {

	@Test
	public void test1() {
		theTest();		
	}

	@Test
	public void test2() {
		theTest();
	}
	
	@Test
	public void testAlwaysFail() {
		failWithJUnit3Assert();
	}

	@Test
	public void testJUnit4AssertFailure() {
		assertNotNull("this will always fail.", null);
	}
	
	private void theTest() {
		System.out.println(ctorState);
		System.out.println(setupState);
		System.out.println(JUnit3SuperClass_NowJUnit4.somethingStatic);
		System.out.println(somethingStatic);
	}

}
