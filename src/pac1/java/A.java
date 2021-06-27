package pac1.java;
public class A {
	public static int i = 100;
	//protected static int i=100; 
	 //protected int j=200; 

	public static void main(String[] args) {
		B.fly();
		System.out.println(i);
	}
}

class B {
	public static void fly() {
		System.out.println(A.i);
	}
}