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
			return getIntFromString(numbers[0]) + getIntFromString(numbers[1]);
		}
	}
	
	//Method to convert String to int
	private int getIntFromString(String num) {
		return Integer.parseInt(num);
	}
}