package My_Package;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class P027_Map {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(1,"c");
		map.put(2,"c++");
		map.put("java","c"); 
		map.put(454.3,"python");
		map.put(false,"kotlin");
		map.put(6,"dart");
		map.put(null,null);
		System.out.println(map);
		
		Set set = map.entrySet();
		Iterator itr= set.iterator();
		while(itr.hasNext()) {
			Map.Entry entry = (Entry)itr.next();
			System.out.println("key : "+entry.getKey()+" value : "+entry.getValue());
		}
		
	}
}
