package calculator;

class StringCalculator {

	public int add(String input) {
		String[] numbers = input.split(",");

		if(input.isEmpty())
		{
			return 0;
		}
		if(input.length() == 1) {
			return getIntFromString(input);
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
}