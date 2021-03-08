package com.tolgaozgun.lab03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskOne {

	private static int odd = 0;
	private static int even = 0;
	private static int n;
	private static int sum = 0;
	
	public static void main(String[] args) {
		

		System.out.println("Please enter a value between 0-50");
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			try {
				n = scanner.nextInt();
			}catch(InputMismatchException ex) {
				scanner.next();
				System.out.println("Please enter a value between 0-50");
				
			}
			if(n > 0 && n <= 50) {
				break;
			}else {
				System.out.println("Please enter a value between 0-50");
			}
		}
		scanner.close();
		
		for ( int x = 0; x <= 50; x++ )
		{
			
			if(n >= x) {
				sum+=x;
			}
			
			
			System.out.print(x);
			if(x < 12 || x > 25) {
				System.out.print(" out of range 12-25");
			}
			System.out.println();
			if(x%2==0) {
				even++;
			}else {
				odd++;
			}
			
			if(x%5==0) {
				System.out.println("Hi Five");
			}else if(x%2==0){
				System.out.println("Hi Two");
			}else if(x%3==0 || x%7==0) {
				System.out.println("Hi ThreeOrSeven");
			}else {
				System.out.println("Hi Others");
			}
			
			
			
			
		}
		
		int realSum =  n*(n+1)/2;
		System.out.println("Count of even numbers: " + even + 
				"\nCount of odd numbers: " + odd
				+"\nSum of numbers until " + n + " equals: " + sum
				+"\nSum should equal (according to formula): " + realSum);
		
		

	}

}
