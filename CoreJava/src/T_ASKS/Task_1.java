package T_ASKS;

import java.util.Scanner;

public class Task_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello! Dear Customer");
		System.out.println("Deal of the Day: On 3* sm. Pizzas, one #Coke FREE!");
		System.out.println(" On 3* med. Pizzas, one #Cake FREE!");
		System.out.println("On 3 lg. Pizzas, one #lg.Pizza FREE!");
		System.out.println("Below is the menu:");
		System.out.println("200/- for Small Pizza");
		System.out.println("300/- for Medium Pizza");
		System.out.println("400/- for Large Pizza");
		System.out.println("Enter 1 for Small Pizza... 2 for Med. Pizza... and 3 for Large Pizza");
		int i = sc.nextInt();
		switch(i) {
		case 1:
			System.out.println("Enter the Quantity for Sm. Pizza:");
			break;
		case 2:
			System.out.println("Enter the Quantity for Med. Pizza:");
			break;
		case 3:
			System.out.println("Enter the Quantity for Lg. Pizza:");
			break;
			default:
				System.out.println("Invalid Input");
				break;
		}
		int q = sc.nextInt();
		if(i == 1 && q>=3 ) {
			System.out.println("Congrats! You have a #Coke FREE");
			System.out.println("Your Order:"+q+"Small Pizzas");
			System.out.println("Your Bill:"+q*200+"/- only");
		}
		else if (i==1 && q<3  && q>0) {
			System.out.println("Your Order:"+q+"Small Pizaas");
		}
		else if(i == 2 && q>=3 ) {
			System.out.println("Congrats! You have a #Cake FREE");
			System.out.println("Your Order:"+q+"Med. Pizzas");
			System.out.println("Your Bill:"+q*300+"/- only");
		}
		else if (i==2 && q<3 && q>0) {
			System.out.println("Your Order:"+q+"Med. Pizaas");
		}
		else if(i == 3 && q>=3 ) {
			System.out.println("Congrats! You have a #lg.Pizza FREE");
			System.out.println("Your Order:"+q+"Large Pizzas");
			System.out.println("Your Bill:"+q*400+"/- only");
		}
		else if (i==3 && q<3 && q>0) {
			System.out.println("Your Order:"+q+"Lg. Pizaas");
		}
		if(q==0) {
			System.out.println("Kindly enter proper quantity!");
		}
		System.out.println("Would you like to order anything else? Y/N");
		char c = sc.next().charAt(0);
		if(c=='Y' || c== 'y') {
			
		}
			
	}
		
}
