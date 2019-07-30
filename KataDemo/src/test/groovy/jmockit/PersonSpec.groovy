package jmockit

import mockit.Mock
import mockit.MockUp
import spock.lang.Specification

class PersonSpec extends Specification {

	def person = new Person()
	MockUp<NameValidator> mockNameValidator
	
	public mockIsNameValid(Boolean result){
		mockNameValidator = new MockUp<NameValidator>(){
			@Mock
			 Boolean isNameValid(String name){
				return result
			}
		}
	}
	
	
	
	def 'API to set names'(){
		given: 'String name'
		when: 'Person.setName is called'
			mockIsNameValid(returnValue)
		def name = person.setName('apurva')
		then:
		name == expectedResult
			cleanup: mockNameValidator?.tearDown()
		where:
		returnValue| expectedResult
		true       | 'apurva'
		false	   | 'DEFAULT'
	}
}
