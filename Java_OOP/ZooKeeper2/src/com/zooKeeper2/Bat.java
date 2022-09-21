package com.zooKeeper2;

public class Bat extends Mammal {

	public Bat() {
		// TODO Auto-generated constructor stub
		this.energyLevel = 300;
	}
	
	public int displayEnergy() {
		super.displayEnergy();
		return energyLevel;
	}
	
	public void fly() {
		if (energyLevel >= 50) {
			System.out.println("Whoosh Whoosh Whoosh \n That bat is flying! And rather fast at that!");
			energyLevel -= 50;
		} else {
			System.out.println("the bat is way to tired fly!");
		}
	}
	
	public void eatHumans() {
		System.out.println("A human taken for the life of the bat....");
		energyLevel += 25;
		
	}
	
	public void attackTown() {
		if (energyLevel >= 100) {
			System.out.println("*fire sounds* The town has been attacked *collapsing buildings* *terror shouts*");
			energyLevel -= 100;
		} else {
			System.out.println("The bat is way too tired to attack!");
		}
	}

}
