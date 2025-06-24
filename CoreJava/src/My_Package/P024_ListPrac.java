package My_Package;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class mobile{
	int ram;
	String model;
	double price;


       public mobile(int ram, String model, double price) {
      	super();
	    this.ram = ram;
	    this.model = model;
	    this.price = price;
    }
       
       public String toString() {
    		return "Mobile [ram=" + ram + ", model=" + model + ", price=" + price + "]";
    	}
}
public class P024_ListPrac {
	public static void main(String[] args) {
		mobile m1 = new mobile(8,"vivo",7988);
		mobile m2 = new mobile(6,"samsung",8799);
		mobile m3 = new mobile(4,"one+",9899);
		mobile m4 = new mobile(2,"apple",8988);
		
		List<mobile> list = new ArrayList<mobile>(); 
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		System.out.println(list);
		
//		Iterator itr = list.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		for(mobile m:list) {
			System.out.println(m);
		}
	}
}
