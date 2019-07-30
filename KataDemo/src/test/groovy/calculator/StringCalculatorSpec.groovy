package calculator

import spock.lang.Specification

class StringCalculatorSpec extends Specification {
    def calculator = new StringCalculator() 
	
	
	def 'API to calculate the sum of String'(){	
		given: 'String numbers'
		when: 'StringCalculator.addNumbers is called'
		 def result = calculator.addNumbers(numbers)
		then:
		result == expectedResult
		where: ''
		numbers	 |expectedResult
		''     	 | 0
		'1'	   	 | 1
		'1,2'  	 | 3
		'1\n2,3' | 6
		'1,2,3,4'| 10
	}
	 
	
	
}
