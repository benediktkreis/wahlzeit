/*
 * Copyright (c) 2017 by Benedikt Kreis
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

public class Coordinate {
	
	private double x;
	private double y;
	private double z;
	
	public Coordinate (double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// direct distance
	double getDistance(Coordinate coordinate) {	
		double difX = x-coordinate.getX();
		double difY = y-coordinate.getY();
		double difZ = z-coordinate.getZ();
		
		double distance = Math.sqrt(difX*difX+difY*difY+difZ*difZ);
		
		return distance;
		
	}
	
	boolean isEqual (Coordinate coordinate) {
		if (x == coordinate.getX() && y == coordinate.getY() && z == coordinate.getZ()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean equals (Coordinate coordinate) {
		return isEqual(coordinate);
	}


	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

}
