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

import java.util.Map;
import java.util.HashMap;
import org.wahlzeit.utils.PatternInstance;

@PatternInstance( 
		patternName = "Template", 
		participants = {"Template = AbstractCoordinate", "Implementation = CartesianCoordinate", "Implementation = SphericCoordinate"} 
)
public final class SphericCoordinate extends AbstractCoordinate {

	/**
	 * declaration of cartesian coordinates
	 */
	private final double latitude;
	private final double longitude;
	private final double radius;

	private static final double maxLattitude = 90;
	private static final double minLattitude = -90;
	private static final double maxLongitude = 180;
	private static final double minLongitude = -180;
	private static final double radiusEarthSurface = 6371;

	private static final Map<String, SphericCoordinate> sharedCoordinateMap = new HashMap<String, SphericCoordinate>();

	public static synchronized SphericCoordinate create(double latitude, double longitude, double radius) {
		SphericCoordinate checkedCoordinate = sharedCoordinateMap.get(toString(latitude, longitude, radius));

		if (null == checkedCoordinate) {
			SphericCoordinate createCoordinate = new SphericCoordinate(latitude, longitude, radius);
			sharedCoordinateMap.put(createCoordinate.toString(), createCoordinate);
			return createCoordinate;
		}

		return checkedCoordinate;
	}

	public static synchronized SphericCoordinate create(double latitude, double longitude) {
		return SphericCoordinate.create(latitude, longitude, SphericCoordinate.radiusEarthSurface);
	}

	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.radius = radius;

		assertClassInvariants(longitude, latitude, radius);
	}

	/**
	 * @methodtype constructor
	 * @methodproperty convenience
	 * 
	 */
	public SphericCoordinate(SphericCoordinate coordinate) {
		this(coordinate.latitude, coordinate.longitude, coordinate.radius);
		assertNotNull(coordinate, SphericCoordinate.class.getName(), "SphericCoordinate()");
		assertClassInvariants(longitude, latitude, radius);
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
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return toString(latitude, longitude, radius);
	}

	private static String toString(double latitude, double longitude, double radius) {
		return "SphericCoordinate{" + "latitude=" +  latitude + ", longitude=" + longitude + ", radius=" + radius + '}';
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius * Math.sin(Math.toRadians(longitude)) * Math.cos(Math.toRadians(latitude));
		double y = radius * Math.sin(Math.toRadians(longitude)) * Math.sin(Math.toRadians(latitude));
		double z = radius * Math.cos(Math.toRadians(longitude));
		assertClassInvariants(longitude, latitude, radius);
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return new SphericCoordinate(this);
	}

	@Override
	public boolean isEqual(Coordinate c) {
		assertNotNull(c, SphericCoordinate.class.getName(), "isEqual()");
		if (c == null) {
			return false;
		}
		if (this == c) {
			return true;
		}
		SphericCoordinate that = c.asSphericCoordinate();

		return isDoubleEqual(this.latitude, that.latitude) && isDoubleEqual(this.longitude, that.longitude)
				&& isDoubleEqual(this.radius, that.radius);
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
	 * 
	 * @methodtype assertion
	 */
	private void assertRadius(double radius) {
		if (radius < 0) {
			// Exception already exists
			throw new IllegalArgumentException(
					"The radius is smaller than zero. It has to be greater than zero or equal.");
		}
	}

	/**
	 * checks if longitude is a correct value in [-180, 180]
	 * 
	 * @methodtype assertion
	 */
	private void assertLongitude(double longitude) {
		if (longitude < SphericCoordinate.minLongitude || longitude > SphericCoordinate.maxLongitude) {
			// Exception already exists
			throw new IllegalArgumentException("The longitude is out of range [-180,180].");
		}
	}

	/**
	 * checks if latitude is a correct value in [-90, 90]
	 * 
	 * @methodtype assertion
	 */
	private void assertLatitude(double latitude) {
		if (latitude < SphericCoordinate.minLattitude || latitude > SphericCoordinate.maxLattitude) {
			// Exception already exists
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

		// Exception already exists
		if (!Double.isFinite(longitude)) {
			throw new IllegalArgumentException("Longitude is not a number.");
		}
		if (!Double.isFinite(latitude)) {
			throw new IllegalArgumentException("Latitude is not a number.");
		}
		if (!Double.isFinite(radius)) {
			throw new IllegalArgumentException("Radius is not a number.");
		}

	}

}
