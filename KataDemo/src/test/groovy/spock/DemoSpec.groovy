package spock

import javax.servlet.http.HttpServletRequest
import spock.lang.Shared
import spock.lang.Specification

class DemoSpec extends Specification {
      
    @Shared DAO dao 
	Demo demo = new Demo()
	
	def setup() {
		dao=Stub()
		demo.dao=dao
	}
	
	
	def 'API to get Name'(){
	given : 'httpServletRequest request'
	HttpServletRequest request = Stub()
	request.getParameter("name") >> 'apurva'
	when: 'Demo.getName is called'
	    String name = demo.getName(request)
	then: "It should return name"
	    name == 'apurva'
	}
	
	
	def 'API to save the user'(){
		given: 'name'
		dao.saveUser(_) >> 6
		when: "demo.saveuser is called"
		int result = demo.saveUser(name)
		then:'It should return the count'
		result == expectedResult
		where: 'value assigned to name'
		name    |expectedResult
		'apurva'| 6
		''      |0
	}
	
	def 'API to set Name'(){
		given: 'request'
			HttpServletRequest request = Mock()		
		when:'demo.setName is called'
			demo.setName(request)
		then:'It should return name'
		 1 * request.getParameter("name") >> 'apurva'
	}
	
	def 'API to get User Id'(){
		given: 'name'
		def DemoSpy = Spy(Demo.class)
		DemoSpy.isValid(_) >> true
		DemoSpy.getId(_) >> 11
		when:'demo.getUserId is called'
		String name ="test"
		int result = DemoSpy.getUserId(name)
		then:'It should return id'
		result == 11
		
	}
	
	
	
}
