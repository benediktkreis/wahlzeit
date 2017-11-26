/*Class name: CartesianCoordinate.java
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



public class CartesianCoordinate implements Coordinate{
	
	//declaration of cartesian coordinates
	private double x;
	private double y;
	private double z;
	public static final double Epsilon = 0.0001;
	
    public static boolean isDoubleEqual(double d1, double d2) {
        double difference = d1 - d2;
        return Math.abs(difference) < Epsilon;
    }
    
	/**
	 * @methodtype Constructor
	 */
	//initialization of cartesian coordinates	
	public CartesianCoordinate (double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
    public CartesianCoordinate(CartesianCoordinate coordinate) {
        this(coordinate.x, coordinate.y, coordinate.z);
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
        this.z = z;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return new CartesianCoordinate(this);
    }
    
    //Calculates the cartesian distance between this and the given coordinate.
    @Override
	public double getDistance(Coordinate c) {
    	CartesianCoordinate that = c.asCartesianCoordinate();
    	
        double deltaX = that.getX() - this.getX();
        double deltaY = that.getY() - this.getY();
        double deltaZ = that.getZ() - this.getZ();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt(x * x + y * y + z * z);
        if(isDoubleEqual(radius, 0) || Double.isNaN(radius)) {
            return new SphericCoordinate(0, 0, 0);
        }
        // atan2 respects devision by zero
        double latitude = Math.toDegrees(Math.atan2(y, x));
        double longitude = Math.toDegrees(Math.acos(z / radius));
        return new SphericCoordinate(latitude, longitude, radius);
    }

    @Override
    public double asCartesianDistance(Coordinate c) {
        return this.getDistance(c);
    }

    @Override
    public double asSphericDistance(Coordinate c) {
        return this.asSphericCoordinate().getDistance(c);
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
}
