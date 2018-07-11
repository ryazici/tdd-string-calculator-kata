package com.yazici;

public class StringCalculator {

	public double calculate(String equation,String delimiter) {

		equation = NoOperationZeroCases(equation);

		if(equation == "0")
			return 0;
		
		if(equation.contains("-") )
			throw new RuntimeException("Numbers must be greater than zero.");

			return sumMultipleSpecialDelimiter(equation);
	}

	public String NoOperationZeroCases(String checkEquation){
		if(checkEquation == null || checkEquation.isEmpty() || !Character.isDigit(checkEquation.charAt(0)))
			checkEquation="0";
		return checkEquation;
	}
	
	public double SumOfDelimitedNumber(String equation,String delimiter) {
		double result=0.0;
		String[] numbers = equation.split(delimiter);
		 for (int i = 0; i < numbers.length; i++) {
			 if(Double.parseDouble(numbers[i])<=1000)
			 result += Double.parseDouble(numbers[i]);
		}
		return result;
	}
	
	
	
	public double sumMultipleSpecialDelimiter(String equation) {
		double result=0;
		StringBuilder sb= new StringBuilder();

		for (int i = 0; i < equation.length(); ++i) {
			if(Character.isDigit(equation.charAt(i)))
				sb.append(equation.charAt(i));
			else if( sb.length()>0 && !Character.isDigit(equation.charAt(i)))
			{
				if(Double.parseDouble(sb.toString())<=1000)
				result += Double.parseDouble(sb.toString());
				sb.setLength(0);;
			}
		}
		
		if(sb.length()>0)
				result += Double.parseDouble(sb.toString());
		
		return  result;
	}
	

}
