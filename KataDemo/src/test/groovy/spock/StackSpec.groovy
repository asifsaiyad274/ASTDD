package spock

import spock.lang.Specification

class StackSpec extends Specification {
	Stack trainingTest = new Stack();
	
	String stringObject = "Stack String";
	int intObject = 1;
	
	def "push_object_into_stack"() {
		expect:
			trainingTest.push(stringObject);
			trainingTest.push(intObject);
			trainingTest.pop() == intObject;
	}
	
	def "pop_object_from_empty_stack"() {
		when:
			trainingTest.pop()
		then:
			thrown(EmptyStackException)
	
	}
	
	def "pop_object_from_stack"() {
		expect:
			trainingTest.push(stringObject);
			trainingTest.pop() == stringObject;
	}
	
}
