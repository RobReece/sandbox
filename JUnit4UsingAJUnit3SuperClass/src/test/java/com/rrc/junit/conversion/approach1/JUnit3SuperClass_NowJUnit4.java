package com.rrc.junit.conversion.approach1;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;

import com.rrc.junit.utils.BeforeAndAfter;

public class JUnit3SuperClass_NowJUnit4  {

	String ctorState;
	String setupState;
	
	static String somethingStatic;
	
	static {
		somethingStatic = getTestData();
	}
	
	private TestName testName = new TestName();
	
	private TestRule junit3Bridge = new BeforeAndAfter() {
		@Override
		public void before() {
			setUp();
		};
		
		@Override
		public void after() {
			tearDown();
		};
	};
	
	@Rule
	public RuleChain superClassInitializer = RuleChain.outerRule(testName).around(junit3Bridge);

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
	
	public void failWithJUnit3Assert() {
		assertNotNull("always fails.", null);
	}
}
