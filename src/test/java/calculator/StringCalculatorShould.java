package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

	StringCalculator stringCalculator = new StringCalculator();
    @Test
    void empty_string_should_return_0() throws Exception {
        
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() throws Exception {
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
	void string_return_sum_of_two_numbers() throws Exception {
		assertEquals(3, stringCalculator.add("1,2"));
	}
    
    @Test
	void string_return_sum_of_unknown_amount_of_numbers() throws Exception {
		assertEquals(10, stringCalculator.add("1,2,3,4"));
	}
    
    @Test
	void string_return_sum_of_numbers_separated_by_spaceline() throws Exception {
		assertEquals(6, stringCalculator.add("1,2\n3"));
	}
    
    @Test
	void string_support_different_delimiter() throws Exception {
		assertEquals(6, stringCalculator.add("//;\n1;2;3"));
	}
    
    @Test
	void throw_exception_for_single_negative_number() throws Exception {
		stringCalculator.add("-1");
	}
    
    @Test
   	void throw_exception_for_multiple_negative_number() throws Exception {
   		stringCalculator.add("-1,3,-6,-8,11");
   	}
}
