package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Asteroids extends MoveableObjects {

	private int size;
	private Missiles dimensions;

	Random random = new Random();
	
	public Asteroids() {
		this.setX(random.nextInt(1025));
		this.setY(random.nextInt(769));
		this.setColor(ColorUtil.GREEN);
		this.setSpeed(random.nextInt(10));
		this.setDirection(random.nextInt(361));
		this.size = random.nextInt(101);
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		
		String originalString = super.toString();
		String moveableString = " size=" + size;
		
		return "Asteroid: " + originalString + moveableString;
	}
}
