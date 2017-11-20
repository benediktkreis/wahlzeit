/*Class name: Coordinate.java
 * 
 * Version: 2.0
 * 
 * Creation date: 29/10/2017
 * 
 * Last change date: 19/11/2017
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

public interface Coordinate {
	
	/**
	 * @methodtype conversion
	 */
	//spheric coordinates
	public SphericCoordinate asSphericCoordinate();
	  
	/** 
	 * @methodtype conversion
	 */
	//cartesian coordinates
	public CartesianCoordinate asCartesianCoordinate();
		
	/**
	 * @methodtype boolean-query.
	 */
	//isEqual()
	public boolean isEqual(Coordinate c);
	  
	/**
	 * @methodtype query-method
	 */
	//gets the distance between 2 coordinates
	public double getDistance(Coordinate c);
	 
	/**
	 * @methodtype query-method
	 */
	//gets the distance between 2 cartesian coordinates
	public double asCartesianDistance(Coordinate c);
	 
	/**
	 * @methodtype query-method
	 */
	//gets the distance between 2 sphericcoordinates
	public double asSphericDistance(Coordinate c);
	
}
