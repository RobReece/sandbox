package com.rrc.junit.utils;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class BeforeAndAfter implements TestRule {
	public Statement apply(Statement base, Description description) {
		return statement(base);
	}
	
	private Statement statement(final Statement base) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				before();
				try {
					base.evaluate();
				} finally {
					after();
				}
			}
			 
		};
	}
	
	public void before() {
	}
	
	public void after() {
	}		

}
