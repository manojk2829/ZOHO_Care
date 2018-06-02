package AntTestNG;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetHashClass {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		System.out.println(s.size());
		s.add("A1");
		s.add("A2");
		s.add("A3");
		s.add("A4");
		s.add("A5");
		System.out.println(s.size());
		s.add("A4");
		s.add("A5");
		System.out.println(s.size());
		
		Iterator<String> it = s.iterator();
		System.out.println(it.next());
		System.out.println(it.next());
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
