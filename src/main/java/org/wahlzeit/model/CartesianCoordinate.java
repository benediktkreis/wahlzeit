/**Class name: CartesianCoordinate.java
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



public class CartesianCoordinate extends AbstractCoordinate{
	
	/**
	 * declaration of cartesian coordinates
	 */
	private double x;
	private double y;
	private double z;

    
	/**
	 * initialization of cartesian coordinates
	 * @methodtype Constructor
	 */
	public CartesianCoordinate (double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
		
		assertClassInvariants();
	}
	
    public CartesianCoordinate(CartesianCoordinate coordinate) {
        this(coordinate.x, coordinate.y, coordinate.z);
        assertNotNull(coordinate, CartesianCoordinate.class.getName(), "CartesianCoordinate()");
        assertClassInvariants();
    }
    
    /**
     * @methodtype get
     */
    public double getX() {
        return x;
    }

    /**
     * @methodtype set
     */
    public void setX(double x) {
    	assertClassInvariants();
        this.x = x;
    }

    /**
     * @methodtype get
     */
    public double getY() {
        return y;
    }

    /**
     * @methodtype set
     */
    public void setY(double y) {
    	assertClassInvariants();
        this.y = y;
    }

    /**
     * @methodtype get
     */
    public double getZ() {
        return z;
    }

    /**
     * @methodtype set
     */
    public void setZ(double z) {
    	assertClassInvariants();
        this.z = z;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return new CartesianCoordinate(this);
    }
    
    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt(x * x + y * y + z * z);
        if(isDoubleEqual(radius, 0) || Double.isNaN(radius)) {
            return new SphericCoordinate(0, 0, 0);
        }
        double latitude = Math.toDegrees(Math.atan2(y, x));
        double longitude = Math.toDegrees(Math.acos(z / radius));
        return new SphericCoordinate(latitude, longitude, radius);
    }

    public double getCartesianDistance(Coordinate c) {
    	assertNotNull(c, CartesianCoordinate.class.getName(), "getCartesianDistance()");
    	return this.getDistance(c);
        
    }

    @Override
    public boolean isEqual(Coordinate c) {
    	assertNotNull(c, CartesianCoordinate.class.getName(), "isEqual()");

        if(c == null) {
            return false;
        }
        if (this == c) {
            return true;
        }
        CartesianCoordinate that = c.asCartesianCoordinate();

        return isDoubleEqual(this.x, that.x) && isDoubleEqual(this.y, that.y) && isDoubleEqual(this.z, that.z);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    
	private void assertClassInvariants() {
		assert x < Double.MAX_VALUE && x > Double.MIN_VALUE;
		assert y < Double.MAX_VALUE && y > Double.MIN_VALUE;
		assert z < Double.MAX_VALUE && z > Double.MIN_VALUE;
		
		if (Double.isNaN(x)) {
		throw new IllegalArgumentException("x is not a number.");
		}
		if (Double.isNaN(y)) {
		throw new IllegalArgumentException("y is not a number.");
		}
		if (Double.isNaN(z)) {
		throw new IllegalArgumentException("z is not a number.");
		}
	}
}
