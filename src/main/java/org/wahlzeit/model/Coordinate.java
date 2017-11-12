/*Class name: Coordinate.java
 * 
 * Version: 1.1
 * 
 * Creation date: 29/10/2017
 * 
 * Last change date: 05/11/2017
 * 
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
	
	//declaration of cartesian coordinates
	private double x;
	private double y;
	private double z;
	
	//initialization of cartesian coordinates	
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
	
	//checks if 2 given coordinates are equal
	boolean isEqual (Coordinate coordinate) {
		if (x == coordinate.getX() && y == coordinate.getY() && z == coordinate.getZ()) return true;
		else return false;
	}
	
	//generated hashCode method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	//generated equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return isEqual(other);
	}

	
	//generated getters 
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
