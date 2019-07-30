package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
 
	public int addNumbers(String numbers){
		int sum = 0;
		if(!numbers.isEmpty()){
       		List<String> numberlist = Arrays.asList(numbers.split(",|\n"));
       		for (String number : numberlist) {
       		 sum +=Integer.parseInt(number);
			}
       		
		}
		return sum;
	}
	
}
