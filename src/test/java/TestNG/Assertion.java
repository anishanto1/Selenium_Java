package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {

	@Test
	public void testEqualValues() {
		int expectedValue = 5;
		int actualValue = 5;

		// Assert that the actual value equals the expected value
		Assert.assertEquals(actualValue, expectedValue, "The values do not match!");

		System.out.println("Test Passed: Values are equal.");
	}

	@Test
	public void testTrueCondition() {
		boolean isTrue = true;

		// Assert that the condition is true
		Assert.assertTrue(isTrue, "The condition is false!");

		System.out.println("Test Passed: Condition is true.");
	}

	@Test
	public void testFalseCondition() {
		boolean isFalse = false;

		// Assert that the condition is false
		Assert.assertFalse(isFalse, "The condition is true!");

		System.out.println("Test Passed: Condition is false.");
	}

	@Test
	public void testNonEqualValues() {
		String expected = "TestNG";
		String actual = "testng";

		// Assert that two strings are not equal
		Assert.assertNotEquals(actual, expected, "The strings are equal!");

		System.out.println("Test Passed: Strings are not equal.");
	}
}


