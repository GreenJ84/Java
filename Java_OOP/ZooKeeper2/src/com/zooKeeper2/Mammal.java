package com.zooKeeper2;

public abstract class Mammal {
	public int energyLevel;
	
	public int displayEnergy() {
		System.out.println(energyLevel);
		return energyLevel;
	}
}