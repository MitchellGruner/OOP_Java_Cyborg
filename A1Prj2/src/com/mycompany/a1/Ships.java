package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Ships extends MoveableObjects implements ISteerable {
	
	private int missileCount;
	
	public Ships(double X, double Y) {
		this.setX(512);
		this.setY(384);
		this.setColor(ColorUtil.BLUE);
		this.setSpeed(0);
		this.setDirection(0);
		this.missileCount = 10;
	}
	
	public int getMissileCount() {
		return missileCount;
	}
	
	public void setMissileCount(int missileCount) {
		this.missileCount = missileCount;
	}
	
	public void accelerateShip(int speedCount) {
		
		int currentSpeed = this.getSpeed();
		
		if(currentSpeed < 10) {
			currentSpeed += speedCount;
			this.setSpeed(currentSpeed);
		} else {
			this.setSpeed(currentSpeed);
		}
	}
	
	public void decelerateShip(int speedCount) {
		
		int currentSpeed = this.getSpeed();
		
		if(currentSpeed > 0) {
			currentSpeed -= speedCount;
			this.setSpeed(currentSpeed);
		} else {
			this.setSpeed(currentSpeed);
		}
	}
	
	public void turnLeft(int leftAmount) {
		
		int currentDirection = this.getDirection();
		int nextDirection = currentDirection - leftAmount;
		
		if(nextDirection < 0) { 
			int finalDirection = nextDirection + 360;
			this.setDirection(finalDirection);
		} else {
			int finalDirection = nextDirection;
			this.setDirection(finalDirection);
		}
	}
	
	public void turnRight(int rightAmount) {
		
		int currentDirection = this.getDirection();
		int nextDirection = currentDirection + rightAmount;
		
		if(nextDirection > 360) {
			int finalDirection = nextDirection - 360;
			this.setDirection(finalDirection);
		} else {
			int finalDirection = nextDirection;
			this.setDirection(finalDirection);
		}
	}
	
	public void removeMissile(int missileCount) {
		
		int currentMissileCount = this.getMissileCount();
		if(currentMissileCount > 0) {
			int finalMissileCount = currentMissileCount - missileCount;
			this.setMissileCount(finalMissileCount);
		}
	}
	
	@Override
	public String toString() {
		
		String originalString = super.toString();
		String moveableString = "missiles=" + missileCount;
		
		return "Ship: " + originalString + " " + moveableString;
	}
}
