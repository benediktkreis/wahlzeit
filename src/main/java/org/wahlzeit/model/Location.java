/* Class name: Location.java
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

public class Location {

	public Coordinate coordinates = null;
	
	//constructor for a coordinate
	public Location (Coordinate co) {
		assertNotNull(co, AbstractCoordinate.class.getName(), "Location");
		assertCoordinateObject(co, AbstractCoordinate.class.getName(), "Location");
		coordinates = co;
	}
	
	//constructor for a coordinate with x,y,z information
	public Location (double x, double y, double z) {
		
		assert x < Double.MAX_VALUE && x > Double.MIN_VALUE;
		assert y < Double.MAX_VALUE && y > Double.MIN_VALUE;
		assert z < Double.MAX_VALUE && z > Double.MIN_VALUE;
		
		if (!Double.isNaN(x)||!Double.isNaN(y)||!Double.isNaN(z)) {
			coordinates = new CartesianCoordinate (x,y,z);
		}
	}
	
	public void assertNotNull(Object o, String className, String method) {
		if(o == null) {
			//Exception already exists
			throw new IllegalArgumentException("Illegal null object in class: " + className + "; method: " + method);
		}
	}
	
	public void assertCoordinateObject(Object o, String className, String method) { 
	if (!(o instanceof Coordinate)) { 
		throw new IllegalArgumentException("Not a Coordinate object" + className + "; method: " + method);
		} 
	}
	
}
