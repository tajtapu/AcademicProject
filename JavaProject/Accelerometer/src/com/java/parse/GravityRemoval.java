package com.java.parse;

public final class GravityRemoval {
	private static double[] gravity = {0,0,9.81};

	public static Data removeGravity(Data d) {
		final double alpha = 0.8;
		
		gravity[0] = alpha * gravity[0] + (1- alpha)* d.getX();
		gravity[1] = alpha * gravity[1] + (1- alpha)* d.getY();
		gravity[2] = alpha * gravity[2] + (1- alpha)* d.getZ();
		
		Data withoutGravity = new Data(d.getX() - gravity[0],
				d.getY() - gravity[1], d.getZ() - gravity[2], d.getDateString());
		return withoutGravity;
	}
	
}
