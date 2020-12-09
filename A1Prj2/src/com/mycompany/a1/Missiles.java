package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Missiles extends MoveableObjects implements IMoveable {

	private int fuelLevel;
	
	public Missiles(double d, double X, double Y) {
		this.setX(512);
		this.setY(384);
		this.setColor(ColorUtil.BLUE);
		this.fuelLevel = 10;
	}
	
	public int getFuelLevel() {
		return fuelLevel;
	}
	
	public void setFuelLevel(int fuelLevel) {
		this.fuelLevel = fuelLevel;
	}
	
	@Override
	public String toString() {
		
		String originalString = super.toString();
		String moveableString = " fuel=" + fuelLevel;
		
		return "Missile:" + originalString + moveableString;
	}
}	

