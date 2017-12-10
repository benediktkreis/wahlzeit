/**Class name: SphericCoordinate.java
 * 
 * Version: 1.2
 * 
 * Creation date: 19/11/2017
 * 
 * Last change date: 10/12/2017
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

public class SphericCoordinate extends AbstractCoordinate{
	
	/**
	 *declaration of cartesian coordinates
	 */
	private double latitude;
	private double longitude;
	private double radius;

	public static final double maxLattitude = 90;
	public static final double minLattitude = -90;
	public static final double maxLongitude = 180;
	public static final double minLongitude= -180;
	private static final double radiusEarthSurface = 6371;
		
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		assertClassInvariants(longitude, latitude, radius);
		
		setLatitude(latitude);
		setLongitude(longitude);
		setRadius(radius);
	}

	/**
	 * @methodtype constructor
	 * @methodproperty convenience

	 */
	public SphericCoordinate(SphericCoordinate coordinate) {
		this(coordinate.latitude, coordinate.longitude, coordinate.radius);
		assertNotNull(coordinate, SphericCoordinate.class.getName(), "SphericCoordinate()");
	}

	/**
	 * @methodproperty convenience
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude) {
		this(latitude, longitude, SphericCoordinate.radiusEarthSurface);
	}
	
	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * 
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		assertLongitude(longitude);
		this.longitude = longitude;
	}

	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @methodtype set
	 */
	public void setLatitude(double latitude) {
		assertLatitude(latitude);
		this.latitude = latitude;
	}

	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @methodtype set
	 */
	public void setRadius(double radius) {
		assertRadius(radius);
		this.radius = radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants(longitude, latitude, radius);
		
		double x = radius * Math.sin(Math.toRadians(longitude)) * Math.cos(Math.toRadians(latitude));
		double y = radius * Math.sin(Math.toRadians(longitude)) * Math.sin(Math.toRadians(latitude));
		double z = radius * Math.cos(Math.toRadians(longitude));
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return new SphericCoordinate(this);
	}

	@Override
	public boolean isEqual(Coordinate c) {
		assertNotNull(c, SphericCoordinate.class.getName(), "isEqual()");
    	if(c == null) {
    		return false;
    	}
        if (this == c) {
        	return true;
        }
        SphericCoordinate that = c.asSphericCoordinate();

        return isDoubleEqual(this.latitude, that.latitude) && isDoubleEqual(this.longitude, that.longitude) && isDoubleEqual(this.radius, that.radius);
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
    
	/**
	 * checks if radius is a correct value > 0
	 * @methodtype assertion
	 */
	private void assertRadius(double radius) {
		if(radius < 0) {
			throw new IllegalArgumentException("The radius is smaller than zero. It has to be greater than zero or equal.");
		}
	}
	
	/**
	 * checks if longitude is a correct value in [-180, 180]
	 * @methodtype assertion
	 */
	private void assertLongitude(double longitude) {
		if(longitude < SphericCoordinate.minLongitude ||
				longitude > SphericCoordinate.maxLongitude) {
			throw new IllegalArgumentException("The longitude is out of range [-180,180].");
		}
	}

	/**
	 * checks if latitude is a correct value in [-90, 90]
	 * @methodtype assertion
	 */
	private void assertLatitude(double latitude) {
		if(latitude < SphericCoordinate.minLattitude ||
				latitude > SphericCoordinate.maxLattitude) {
			throw new IllegalArgumentException("The latitude is out of range [-90, 90].");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertClassInvariants(double longitude, double latitude, double radius) {
		assertLongitude(longitude);
		assertLatitude(latitude);
		assertRadius(radius);
		
		if (Double.isNaN(longitude)) {
		throw new IllegalArgumentException("Longitude is not a number.");
		}
		if (Double.isNaN(latitude)) {
		throw new IllegalArgumentException("Latitude is not a number.");
		}
		if (Double.isNaN(radius)) {
		throw new IllegalArgumentException("Radius is not a number.");
		}
		
	}
	
}
