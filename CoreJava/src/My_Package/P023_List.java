package My_Package;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P023_List {
//	<generics>
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("java");
		list.add("12");
		list.add("false");
		list.add("34.34");
		list.add('d');
		list.add("668566354");
		list.add("12");
		System.out.println(list);
		list.add("798776765654");
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
		
		Iterator itr = list.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
	}
}
