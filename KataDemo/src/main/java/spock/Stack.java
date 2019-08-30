package spock;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack {

	private List<Object> objects = new ArrayList<>();
	
	public void push(Object object) {
		objects.add(object);
	}
	
	public Object pop() {
		if(objects.isEmpty()) {
			throw new EmptyStackException();
		}
		return objects.remove(objects.size()-1);
	}
}
