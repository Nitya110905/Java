package My_Package;

import java.util.InputMismatchException;
import java.util.Scanner;

//checked - compile-time
//unchecked - run-time
//1. try 2. catch 3. finally 4. throw 5. throws

class Divide{
	public void division()throws ArithmeticException,InputMismatchException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a = ");
		int a = sc.nextInt();
		System.out.println("enter b = ");
		int b = sc.nextInt();
		if(b>0) {
			int c = a / b;
			System.out.println(c);
		}else {
			throw new ArithmeticException();
		}
		
	}
}

public class P017_Exception {
	public static void main(String[] args) {
		try {
			Divide d = new Divide();
			d.division();
		} catch (ArithmeticException e) {
			System.out.println("deno should be > 0");
		}catch(InputMismatchException e) {
			System.out.println("deno should numeric");
		}
		
		
		
		
		
//		try {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter a = ");
//		int a = sc.nextInt();
//		System.out.println("Enter b = ");
//		int b = sc.nextInt();
//		int c = a/b;
//		System.out.println(c);
//		System.exit(12);
//		} catch(ArithmeticException e ) {
//			System.out.println("Deno should be greater than numer");
//		}
//		catch(InputMismatchException e ) {
//			System.out.println("Deno should be a numeric value");
//		}
//		catch(Exception e ) {
//			System.out.println(e);
//		}finally {
//			System.out.println("this will exectues everytime");
//		}
		}
}

//Unchecked exceptions (like ArithmeticException) → Use throw, but throws isn’t needed. 🔹 Checked exceptions (like IOException) → You must declare them with
//throws or handle them with try-catch.
