package com.rrc.junit.conversion.approach1;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;

import com.rrc.junit.utils.BeforeAndAfter;

public class JUnit3SuperClass_Junit4Bridge {
	JUnit3SuperClass superClassByComposition;
	
	@Rule
	public TestName testName = new TestName();
	
	class SuperClassSetUpAndTearDownBridge extends BeforeAndAfter {
		@Override
		public void before() {
			superClassByComposition.setUp();
		};
		
		@Override
		public void after() {
			superClassByComposition.tearDown();
		};
	};
	
	public TestRule getDefaultSuperClassCreator() {
		return new SuperClassSetUpAndTearDownBridge() {
			@Override
			public void before() {
				superClassByComposition = new JUnit3SuperClass(testName.getMethodName());
				super.before();
			}
		};
	}
	
	public TestRule getSuperClassCreator(final String username, final String password) {
		return new SuperClassSetUpAndTearDownBridge() {
			@Override
			public void before() {
				superClassByComposition = new JUnit3SuperClass(username, password);
				super.before();
			};			
		};
	}
	
	// pass through method to use composed object, allows existing test classes to remain unchanged
	public void failWithJUnit3Assert() {
		superClassByComposition.failWithJUnit3Assert();
	}
	
}
