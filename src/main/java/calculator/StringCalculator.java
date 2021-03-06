package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {
	static {
		count = 0;
	}
	static int count;

	public int add(String input) throws Exception {
		++count;

		String[] numbers = input.split(",|\n");

		//return 0 if string is empty
		if(input.isEmpty())
		{
			return 0;
		}

		//string_with_single_number_should_return_number_as_int 
		if(input.length() == 1) {
			return getIntFromString(input);
		}
		
		//string Support Custom Delimiter
		else if(input.startsWith("//["))
		{
			return customDelimiter(input);
		}

		//string_support_different_delimiter
		else if(input.startsWith("//")){
			String[] del =  getDelimiter(input);
			return getSumOfNumbers(del);	
		}

		

		//string_return_sum_of_two_numbers & string_return_sum_of_unknown_amount_of_numbers
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
	private int getSumOfNumbers(String[] numbers) throws Exception
	{
		negativeNumberNotAllowed(numbers);

		int sum = 0;
		for(int i = 0; i < numbers.length; i++)
		{
			//ignore_number_greater_than_1000
			if(getIntFromString(numbers[i]) > 1000)
			{
				continue;
			}
			sum += getIntFromString(numbers[i]);
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

	//Method to throw exception for negative numbers
	private void negativeNumberNotAllowed(String[] numbers) throws Exception
	{
		for(String num: numbers)
		{
			Matcher matcher = Pattern.compile("/-\\d+/g").matcher(num);

			if(matcher.matches())
			{
				throw new Exception("negative not allowed" + getIntFromString(num));
			}	
		}
	}

	//Method to count how many times add() method invoked 
	public int getCalledCount()
	{
		return count;
	}

	//Method to support custom Delimiter
	private int customDelimiter(String input)
	{
		String bracket = input.substring(2, 3);
		int newLineIndex = input.indexOf("\n");
		String numberString = input.substring(newLineIndex+1, input.length());
		
		int sum = 0;

		if(bracket.contains("[")){

			int closeIndex = input.indexOf("]");
			String delimiter = input.substring(2,closeIndex);

			for(int num = 0; num<numberString.length(); ) {
				int n = getIntFromString(numberString.charAt(num)+"");
				sum += n;
				
				num += delimiter.length();
			}
		}
		return sum;
	}

}