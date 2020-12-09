package com.mycompany.a1;

public class FixedObjects extends GameObject {

	private int idNumber;
	private static int idNumberStatic;
	
	public FixedObjects() {
		this.idNumber = idNumberStatic;
		idNumberStatic++;
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	public static int getIdNumberStatic() {
		return idNumberStatic;
	}
	
	public static void setIdNumberStatic(int idNumberStatic) {
		FixedObjects.idNumberStatic = idNumberStatic;
	}
}
