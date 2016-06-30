package com.rrc.junit.conversion.approach1;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;

import com.rrc.junit.utils.BeforeAndAfter;

public class JUnit3SuperClassInitializerForJUnit4 {
	JUnit3SuperClass superClassByComposition;
	
	private TestName testName = new TestName();
	
	private TestRule beforeAndAfter_EachMethod_ForJUnit3SuperClass = new BeforeAndAfter() {
		@Override
		public void before() {
			superClassByComposition = new JUnit3SuperClass(testName.getMethodName());
			superClassByComposition.setUp();
		};
		
		@Override
		public void after() {
			superClassByComposition.tearDown();
		};
	};
	
	@Rule
	public RuleChain superClassInitializer = RuleChain.outerRule(testName).around(beforeAndAfter_EachMethod_ForJUnit3SuperClass);
}
