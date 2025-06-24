package My_Package;

public class P004_Type_Casting {
	public static void main(String[] args) {
		int i = (int)12.456;
		System.out.println("i="+i);
		double d = 3;
		System.out.println("d="+d);
	}
}


/*In Java, type casting is the process of converting one data type into another. It's a common practice
when you need to interact with different data types within your code. There are two main types of type
casting: implicit casting (also known as widening conversion) and explicit casting (also known as narrowing
 conversion)*/

//Implicit casting happens automatically when a smaller data type is converted to a larger data type.

//Explicit casting is required when you want to convert a larger data type into a smaller data type.