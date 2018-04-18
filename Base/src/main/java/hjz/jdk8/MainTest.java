package hjz.jdk8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> names = new HashSet<String>();
		names.add("James");
		names.add("Joe");
		names.add("Marcel");
		
		//foreach loop in this Set can not gurantee sequence
		for (String name : names) {
			System.out.println(name);
		}
		
		Iterator<String> itNames = names.iterator();
		while(itNames.hasNext()) {
			System.out.println(itNames.next());
		}
		
		
		int SEND_LOCAL = 1;
		int SEND_REMOTE = 1<<1;
		int SEND_PEER = 1<<2;
		int DEFAULT_SEND_MASK = SEND_LOCAL | SEND_REMOTE | SEND_PEER;
		
		System.out.println(SEND_LOCAL); //1
		System.out.println(SEND_REMOTE); //10
		System.out.println(SEND_PEER); //100
		System.out.println(DEFAULT_SEND_MASK); //111
		System.out.println(DEFAULT_SEND_MASK&~SEND_REMOTE); //101
		
			

	}

}
