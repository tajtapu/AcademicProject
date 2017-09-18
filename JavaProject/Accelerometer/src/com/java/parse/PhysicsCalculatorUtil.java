package com.java.parse;

public final class PhysicsCalculatorUtil {
	public static double calculateByAxis(double previousValue, double previousValueFromExcel, double currentValue) {
		return previousValue+previousValueFromExcel+((currentValue - previousValueFromExcel) / 2.00);
	}
}
