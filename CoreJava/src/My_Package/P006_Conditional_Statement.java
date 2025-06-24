package My_Package;
import java.util.Scanner;

public class P006_Conditional_Statement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a =");
		int a = sc.nextInt();
		System.out.println("Enter b =");
		int b = sc.nextInt();
		
		
		//1. Simple if
		if (a>b) {
			System.out.println("a is greater than b");
		}
		
		//2. else if
	    if (a>b) {
			System.out.println("a is greater than b");
		} else {
			System.out.println("b is greater than a");
		}
	    //3. Nested if
	    System.out.println("Enter age = ");
	    int age = sc.nextInt();
	    if (age>18) {
			if (age<55) {
				System.out.println("You are eligible for voting");
			}else {
				System.out.println("You are not eligible");
			}
		}else {
			System.out.println("Age is less than 18*");
		}
	    
	    //4. Else if ladder
	    System.out.println("Enter marks = ");
	    int m = sc.nextInt();
	    if (m < 33) {
			System.out.println("Fail*");
		}
	    else if (m >= 33 && m <= 50) {
			System.out.println("D Grade");
		}
	    else if (m >= 51 && m <= 70) {
			System.out.println("C Grade");
		}
	    else if (m >= 71 && m <= 90) {
			System.out.println("B Grade");
		}
	    else if (m >= 91 && m <= 100) {
			System.out.println("A Grade");
		}
	    else  {
			System.out.println("Invalid");
		}
	    
	    //5. Switch case: To be used when we have one condition but many options
	    System.out.println("Enter Your choice: 1 for English, 2 for Hindi, 3 for Gujarati");
	    int c = sc.nextInt();
	    switch (c) {
		case 1: 
			System.out.println("English");
			break;
		case 2: 
			System.out.println("Hindi");
			break;
		case 3: 
			System.out.println("Gujarati");
			break;
		
		default:
			System.out.println("Invalid");
		}
	}
}
