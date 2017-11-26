/*Class name: AbstractCoordinate.java
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
	
	public AbstractCoordinate() {
		
	}
	
	//declaration of globally used Epsilon parameter
	public static final double Epsilon = 0.0001;
	
	/**
	 * @methodtype query
	 */
    public static boolean isDoubleEqual(double d1, double d2) {
        double difference = d1 - d2;
        return Math.abs(difference) < Epsilon;
    }
    
	/**
	 * @methodtype conversion
	 */
	//spheric coordinates
	public abstract SphericCoordinate asSphericCoordinate();
	  
	/** 
	 * @methodtype conversion
	 */
	//cartesian coordinates
	public abstract CartesianCoordinate asCartesianCoordinate();
		
	/**
	 * @methodtype boolean-query.
	 */
	//isEqual()
	public boolean isEqual(Coordinate c) {
		if (c != null) {
			return isDoubleEqual(this.getDistance(c), 0.0);
		}
		return false;
	}
	  
	/**
	 * @methodtype query-method
	 */
	//gets the distance between 2 coordinates
	public abstract double getDistance(Coordinate c);
	 
	/**
	 * @methodtype query-method
	 */
	//gets the distance between 2 cartesian coordinates
	public abstract double getCartesianDistance(Coordinate c);
	 
	/**
	 * @methodtype query-method
	 */
	//gets the distance between 2 sphericcoordinates
	public abstract double getSphericDistance(Coordinate c);
	

}
