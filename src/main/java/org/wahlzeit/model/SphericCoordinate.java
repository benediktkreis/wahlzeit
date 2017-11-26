/*Class name: SphericCoordinate.java
 * 
 * Version: 1.1
 * 
 * Creation date: 19/11/2017
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

public class SphericCoordinate implements Coordinate{
	
	//declaration of cartesian coordinates
	private double latitude;
	private double longitude;
	private double radius;
	static final double Epsilon = 0.0001;

    public static boolean isDoubleEqual(double d1, double d2) {
        double difference = d1 - d2;
        return Math.abs(difference) < Epsilon;
    }
	/**
	 *
	 */
	public static final double maxLattitude = 90;
	public static final double minLattitude = -90;
	public static final double maxLongitude = 180;
	public static final double minLongitude= -180;
	private static final double radiusEarthSurface = 6371;
		
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
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


	//Calculates the spheric distance between this and the given coordinate
	@Override
	public double getDistance(Coordinate c) {
		SphericCoordinate that = c.asSphericCoordinate();

		double summand1 = this.radius * this.radius;
		double summand2 = that.radius * that.radius;
		double summand3 = 2 * this.radius * that.radius *
				(Math.sin(Math.toRadians(this.longitude)) * Math.sin(Math.toRadians(that.longitude)) * Math.cos(Math.toRadians(this.latitude - that.latitude)) +
				Math.cos(Math.toRadians(this.longitude)) * Math.cos(Math.toRadians(that.longitude)));

		return Math.sqrt(summand1 + summand2 - summand3);
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
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
	public double asCartesianDistance(Coordinate c) {
		return this.asCartesianCoordinate().getDistance(c);
	}

	@Override
	public double asSphericDistance(Coordinate c) {
		return this.getDistance(c);
	}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate)) {
            return false;
        }
        return this.isEqual((Coordinate) o);
    }

	@Override
	public boolean isEqual(Coordinate c) {
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
	 * @methodtype assertion
	 */
	//checks if radius is a correct value > 0
	private void assertRadius(double radius) {
		if(radius < 0) {
			throw new IllegalArgumentException("The longitude is smaller than zero.");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
    //checks if longitude is a correct value in [-180, 180]
	private void assertLongitude(double longitude) {
		if(longitude < SphericCoordinate.minLongitude ||
				longitude > SphericCoordinate.maxLongitude) {
			throw new IllegalArgumentException("The longitude is out of range [-180,180].");
		}
	}

	/**
	 * @methodtype assertion
	 */
	//checks if latitude is a correct value in [-90, 90]
	private void assertLatitude(double latitude) {
		if(latitude < SphericCoordinate.minLattitude ||
				latitude > SphericCoordinate.maxLattitude) {
			throw new IllegalArgumentException("The latitude is out of range [-90, 90].");
		}
	}
	

}
