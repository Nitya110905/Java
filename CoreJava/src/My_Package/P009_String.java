package My_Package;
import java.util.Scanner;

public class P009_String {
		public static void main(String[] args) {
			char name[] = { 'J', 'A', 'V', 'A' };
			System.out.println(name);
			String n1 = "java3465*U^&%%*   sgrfg";
			System.out.println(n1);
			System.out.println(n1.length());
			String name1 = "java";
			String name2 = "tech";
			System.out.println(name1.concat(name2));
			System.out.println(name1);// String is immutable
			// StringBuffer,StringBuilder
			String s = "java tech is best to learn";
			System.out.println(s.charAt(2));
			System.out.println(s.contains("is b"));
			System.out.println(s.startsWith("jav"));
			String s1 = "java";
			String s2 = "jAva";
			System.out.println(s1.compareTo(s2));//Compares as per ASCII values
			System.out.println(s1.compareToIgnoreCase(s2));//Ignores capital letters o/p: 0 for true
			System.out.println(s1.equals(s2));//Gives o/p as true and false
			System.out.println(s1.equalsIgnoreCase(s2));
			System.out.println(s1.toUpperCase());
			
//			System.out.println("enter name : ");
			Scanner sc= new Scanner(System.in);
//			String nn = sc.next();//used to enter a string
			
			System.out.println("enter character : ");
			char c = sc.next().charAt(0);// used to enter a single character
			System.out.println(c);
			
			StringBuffer ss = new StringBuffer("java");
			System.out.println(ss);
			ss.append(" tech is best");
			System.out.println(ss);
		}
}


/*
  Sure! Both StringBuffer and StringBuilder are classes in Java used to create mutable sequences of characters.
  
Thread Safety:
StringBuffer is synchronized, meaning it is thread-safe and can be used in multi-threaded environments.
StringBuilder is not synchronized, making it more efficient but not thread-safe.

Performance:
StringBuilder is generally faster than StringBuffer because it does not have the overhead of synchronization.

Usage:
Use StringBuffer when you need thread safety in your application.
Use StringBuilder when thread safety is not a concern, and you need better performance.
*/
