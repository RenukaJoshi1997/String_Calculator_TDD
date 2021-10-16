package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {

	public int add(String input) throws Exception {
		String[] numbers = input.split(",|\n");

		if(input.isEmpty())
		{
			return 0;
		}
		if(input.length() == 1) {
			if(getIntFromString(input) < 0)
			{
				throw new Exception("negative not allowed" + getIntFromString(input));
			}
			return getIntFromString(input);
		}
		else if(input.startsWith("//")){
			String[] del =  getDelimiter(input);
			return getSumOfNumbers(del);
		}
		else
		{
			return getSumOfNumbers(numbers);
		}
	}

	//Method to convert String to int
	private int getIntFromString(String num) {
		return Integer.parseInt(num);
	}

	//Method to get sum of multiple numbers
	private int getSumOfNumbers(String[] numbers)
	{
		int sum = 0;
		for(String str:numbers)
		{
			sum += getIntFromString(str);
		}
		return sum;
	}
	
	//Method to support different delimiters
		private String[] getDelimiter(String input)
		{
			Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
			
			if(matcher.matches())
			{
				String delimiter = matcher.group(1);
				String toSplit = matcher.group(2);
				return toSplit.split(delimiter);
			}
			throw new RuntimeException("Wrong custom delimiter format");
		}

}