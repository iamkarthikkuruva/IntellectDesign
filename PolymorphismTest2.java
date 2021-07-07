package com.intellect.oops;


class AutoMobiles{
	public void rider() {
		System.out.println("Rider: riding...");
	}
}

class LandVehicles extends AutoMobiles{
	public void rider() {
		System.out.println("Rider: riding..LandVehicles.");
	}

}
class Car extends LandVehicles{
	public void rider() {
		System.out.println("Rider: riding.car..");
	}
}

class Bike extends LandVehicles {
	public void rider() {
		System.out.println("Rider: riding..Bike.");
	}

}

class RoyalEnfield extends Bike {
	public void rider() {
		System.out.println("Rider: riding..RoyalEnfield.");
	}


}


public class PolymorphismTest2 {
	
	public static void main(String[] args) {
		LandVehicles v = new LandVehicles();
		v.rider();
		Car car= new Car();
		car.rider();
		Bike b = new Bike();
		b.rider();
		RoyalEnfield rf= new RoyalEnfield();
		rf.rider();
	}
}