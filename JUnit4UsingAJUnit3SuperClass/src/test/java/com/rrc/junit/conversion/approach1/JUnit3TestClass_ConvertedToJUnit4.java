package com.rrc.junit.conversion.approach1;
import org.junit.Test;

public class JUnit3TestClass_ConvertedToJUnit4 extends JUnit3SuperClassInitializerForJUnit4 {

	@Test
	public void test1() {
		theTest();		
	}

	@Test
	public void test2() {
		theTest();
	}
	
	private void theTest() {
		System.out.println(superClassByComposition.ctorState);
		System.out.println(superClassByComposition.setupState);
		System.out.println(JUnit3SuperClass.somethingStatic);
		System.out.println(superClassByComposition.somethingStatic);
	}

}
