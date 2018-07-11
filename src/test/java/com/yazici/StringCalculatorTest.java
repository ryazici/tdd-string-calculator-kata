package com.yazici;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

	private static final double delta = 0.01;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void whenIHaveNullThenIGetDoubleZero() {
		
		String equation = null;
		double expectedResult = 0.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, ",");

		assertEquals(expectedResult, actualResult, delta);

	}

	@Test
	public void whenIHaveEmptyStringThenIGetDoubleZero() {

		String equation = "";
		double expectedResult = 0.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, ",");

		assertEquals(expectedResult, actualResult, delta);

	}

	@Test
	public void whenIHaveInitialNonNumericStringThenIGetDoubleZero() {
		
		String equation = "A";
		double expectedResult = 0.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, ",");

		assertEquals(expectedResult, actualResult, delta);

	}

	@Test
	public void whenIHaveStringZeroThenIGetDoubleZero() {

		String equation = "0";
		double expectedResult = 0.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, ",");

		assertEquals(expectedResult, actualResult, delta);

	}

	@Test
	public void whenIHaveStringNumberThenIGetDoubleNumber() {
		
		String equation = "1";
		double expectedResult = 1.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, ",");

		assertEquals(expectedResult, actualResult, delta);
	}

	@Test
	public void whenIHaveCommaDelimiterNumberThenIGetSumOfNumbers() {
		
		String equation = "1,9";
		double expectedResult = 10.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, ",");

		assertEquals(expectedResult, actualResult, delta);
	}

	@Test
	public void whenIHaveNewLineDelimiterThenIGetSumOfNumber() {
		
		String equation = "1\n9";
		double expectedResult = 10.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, "\n");

		assertEquals(expectedResult, actualResult, delta);

	}

	@Test
	public void whenIHaveMoreThanTwoNumbersWithSingleDelimiterThenIGetSumOfNumbers() {
		
		String equation = "1\n9\n3";
		String equation2 = "1,9,3";

		double expectedResult = 13.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, "\n");
		double actualResult2 = calc.calculate(equation2, ",");

		assertEquals(expectedResult, actualResult, delta);
		assertEquals(expectedResult, actualResult2, delta);

	}

	@Test
	public void whenIHaveANegativeNumberThenThrowException() {

		String equation = "2,-2";

		StringCalculator calc = new StringCalculator();
		calc.calculate(equation, ",");

		thrown.expectMessage("Numbers must be greater than zero.");

	}

	@Test
	public void whenIHaveAnyNumberGreaterThanThousandThenIgnoreForCalculation() {
		
		String equation = "1001,2134,2,5,7";
		double expectedResult = 14.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, ",");

		assertEquals(expectedResult, actualResult, delta);
	}

	@Test
	public void whenIHaveSpecialDelimiterThanThenIGetSumOfNumber() {
		
		String equation = "10del2del25";
		double expectedResult = 37.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, "del");

		assertEquals(expectedResult, actualResult, delta);

	}

	@Test
	public void whenIHaveMultipleSpecialDelimiterThenIGetSumOfNumber() {
		
		String equation = "10del2*25+3";
		double expectedResult = 40.0;

		StringCalculator calc = new StringCalculator();
		double actualResult = calc.calculate(equation, "");

		assertEquals(expectedResult, actualResult, delta);
	}

}
