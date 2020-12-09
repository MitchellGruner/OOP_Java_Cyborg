package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {

	private double X;
	private double Y;
	private int color;
	
	public double getX() {
		return X;
	}
	
	public void setX(double X) {
		this.X = X;
	}
	
	public double getY() {
		return Y;
	}
	
	public void setY(double Y) {
		this.Y = Y;
	}
	
	public double getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public String toString() {
		String myDesc = "loc=" + Math.round(getX()*10.0)/10.0 + "," + Math.round(getY()*10.0)/10.0 + " color=[" + 
				ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]";
		return myDesc;
	}
}
