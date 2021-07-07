package com.intellect.oops;

class Product {

	void print(int id) {
		System.out.println("Product " + id);
	}

	void print(String pCode) {
		System.out.println("Product Code" + pCode);
	}

	void print(double pCost) {
		System.out.println("Product Cost" + pCost);
	}

	void print(float pDisc, double pGst) {
		System.out.println("Product discount" + pDisc + ",Product GST" + pGst);
	}

	void print(String pVen, String pDisc) {
		System.out.println("Product Vendor" + pVen + ",Product discount" + pDisc);
	}

	void print(int id, String pComName) {
		System.out.println("Product id" + " and Company" + pComName);
	}

	void print(Object prodDetails) {
		System.out.println(prodDetails);
	}

	void print(int id, String pCode, double pCost, float pDisc, float pGst, String pVen, String pComName) {
		System.out.println(
				"Product" + id + "," + pCode + "," + pCost + "," + pDisc + "," + pGst + "," + pVen + "," + pComName);
	}

	@Override
	public String toString() {
		return "Product [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}

public class MethodOverloadingTest1 {

	public static void main(String[] args) {
		MethodOverloadingTest1 mot = new MethodOverloadingTest1();
		Product prod = new Product();
		prod.print(101);
		prod.print("developer");
		prod.print(2345000.98);
		prod.print(2, 1.5);
		prod.print(101, "Oracle Software sol");
		prod.print("oracle", "SQL dev Tool");
		prod.print(101, "developer", 2345000.98, 2, 3, "oracle", "Oracle Software sol");
		prod.print(prod);
	}
}
