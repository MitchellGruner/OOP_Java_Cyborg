package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends FixedObjects {

	Random random = new Random();
	private boolean lightOn = true;
	private int blinkRate = 1 + random.nextInt(11);
	
	public SpaceStation() {
		this.setX(random.nextInt(1025));
		this.setY(random.nextInt(769));
		this.setColor(ColorUtil.BLACK);
	}
	
	public boolean getLightOn() {
		return lightOn;
	}
	
	public void setLightOn(boolean lightOn) {
		this.lightOn = lightOn;
	}
	
	public int getBlinkRate() {
		return blinkRate;
	}
	
	public void setBlinkRate(int blinkRate) {
		this.blinkRate = blinkRate;
	}
	
	@Override
	public String toString() {
		
		String originalString = super.toString();
		String moveableString = " rate=" + blinkRate;
		
		return "Station: " + originalString + moveableString;
	}

}
