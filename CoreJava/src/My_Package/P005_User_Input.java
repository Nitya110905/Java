package My_Package;

import java.util.Scanner;

class ABC{
	public void show() {
		System.out.println("Show in ABC class");

	}
}

public class P005_User_Input {
	public static void main(String[] args) {
		System.out.println("main method");
		ABC a = new ABC();
		a.show();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter i =");
		int i = sc.nextInt();
		System.out.println(i);
		System.out.println("Enter j =");
		int j = sc.nextInt();
		int k = i+j;
		System.out.println("Addition of i and j = "+ k);
		
		
	}
}
