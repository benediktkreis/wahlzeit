/**Class name: AbstractCoordinate.java
 * 
 * Version: 1.0
 * 
 * Creation date: 26/11/2017
 * 
 * Last change date: 26/11/2017
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

public abstract class AbstractCoordinate implements Coordinate{
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * declaration of globally used Epsilon parameter
	 */
	public static final double Epsilon = 0.0001;
	
	/**
	 * @methodtype query
	 */
    public static boolean isDoubleEqual(double d1, double d2) throws IllegalArgumentException {
		if ( !Double.isFinite(d1)|| !Double.isFinite(d2)) {
			throw new IllegalArgumentException("d1 or d2 is not a number.");
		}
		
        double difference = d1 - d2;
        return Math.abs(difference) < Epsilon;
		
    }
    
	/**
	 * spheric coordinates
	 * @methodtype conversion
	 */
	public abstract SphericCoordinate asSphericCoordinate();
	  
	/** 
	 * cartesian coordinates
	 * @methodtype conversion
	 */
	public abstract CartesianCoordinate asCartesianCoordinate();
		
	/**
	 * isEqual()
	 * @methodtype boolean-query.
	 */
	public boolean isEqual(Coordinate c) {
		assertNotNull(c, AbstractCoordinate.class.getName(), "isEqual()");
		assertCoordinateObject(c, AbstractCoordinate.class.getName(), "isEqual()");
		if (c != null) {
			return isDoubleEqual(this.getDistance(c), 0.0);
		}
		return false;
	}
	
    //@Override
    public boolean equals(Object o) {
    	assertNotNull(o, AbstractCoordinate.class.getName(), "equals()");
        if (!(o instanceof Coordinate)) {
            return false;
        }
        return this.isEqual((Coordinate) o);
    }
	 
	public double getDistance(Coordinate c) {
		assertNotNull(c, AbstractCoordinate.class.getName(), "getDistance()");
		assertCoordinateObject(c, AbstractCoordinate.class.getName(), "getDistance()");
		
		CartesianCoordinate that = c.asCartesianCoordinate();
    	
        double deltaX = that.getX() - this.getX();
        double deltaY = that.getY() - this.getY();
        double deltaZ = that.getZ() - this.getZ();
        
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

	protected double getX() {
		return x;
	}

	protected double getY() {
		return y;
	}

	protected double getZ() {
		return z;
	}
	
	/**
	 * Checks for null objects
	 * @methodtyp assertion
	 */
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
