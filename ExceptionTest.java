package com.intellect.exceptions;

import java.util.Scanner;

class NotEligibleException extends RuntimeException // Ex-1
{
	public NotEligibleException(String msg) {
		System.out.println(msg);
	}
}

class AgeGapException extends RuntimeException // Ex-2
{
	public AgeGapException(String msg) {
		System.out.println(msg);
	}
}

class InsufficientBalException extends RuntimeException {
	public InsufficientBalException(String msg) {
		System.out.println(msg);
	}
}

public class ExceptionTest {

	public static void main(String[] args) {
		// ---------InsufficientBalException-------
		System.out.println("Enter available balance in account : ");
		Scanner s = new Scanner(System.in);
		double avlbal = s.nextDouble();
		System.out.println("Available balance : " + avlbal);
		System.out.println("Enter the amount to withdraw : ");
		double wdramt = s.nextDouble();
		if (wdramt > avlbal) {
			throw new InsufficientBalException("Exceeding the limit in the account");
		} else {
			System.out.println("Collect the amount");
		}

		// --------NotEligibleException-------
		float percentage = 56.5f;
		if (percentage < 60) {
			throw new NotEligibleException("Not Eligible for drive");
		} else {
			System.out.println("Register before end of the day");
		}

		// -----------AgeGapException---------

		int bage = 10, gage = 27;
		if (bage < 15 && gage >= 27) {
			throw new AgeGapException("He is small kid enjoying life");
		} else {
			System.out.println("Go out with girl friend and destroy life");
		}

	}
}
