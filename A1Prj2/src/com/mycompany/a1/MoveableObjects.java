package com.mycompany.a1;

import java.util.Random;

public class MoveableObjects extends GameObject implements IMoveable {

	Random random = new Random();
	
	private int speed = random.nextInt(11);
	private int direction = random.nextInt(361);
	
	@Override
	public void move() {
		double theta = 90 - (this.direction * (Math.PI / 180));
		double deltaX = Math.cos(theta) * this.speed;
		double deltaY = Math.sin(theta) * this.speed;
		this.setX(this.getX() + deltaX);
		this.setY(this.getY() + deltaY);
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		
		String originalString = super.toString();
		String moveableString = " speed=" + speed + " dir=" + direction;
		
		return originalString + moveableString;
	}
}
