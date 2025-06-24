package My_Package;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class P028_HashTable {
	public static void main(String[] args) {
		Map map = new Hashtable();
		map.put(1, "c");//entry
		map.put(2, "c++");
		map.put("java", "c");
		map.put(454.3, "python");
		map.put(false, "kotlin");
		map.put(6, "dart");
		System.out.println(map);
		
		Set set = map.entrySet();
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry entry = (Entry)itr.next();
			System.out.println("key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		
	}
}
