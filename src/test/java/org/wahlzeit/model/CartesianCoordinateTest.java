/*Class name: CartesianCoordinateTest.java
 * 
 * Version: 1.0
 * 
 * Creation date: 20/11/2017
 * 
 * Last change date: 20/11/2017
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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    double x;
    double y;
    double z; 
    static final double Epsilon = 0.0001;	
    CartesianCoordinate coordinateXYZ;

    @Before
    public void setUp() {
        x = 1.;
        y = 2.;
        z = 3.;
        coordinateXYZ = new CartesianCoordinate(x, y, z);
    }

    @Test
    public void testConstructor() {
        assertEquals(x, coordinateXYZ.getX(), Epsilon);
        assertEquals(y, coordinateXYZ.getY(), Epsilon);
        assertEquals(z, coordinateXYZ.getZ(), Epsilon);
    }

    @Test
    public void testSetterAndGetter() {
        coordinateXYZ.setX(x + 1);
        coordinateXYZ.setY(y + 1);
        coordinateXYZ.setZ(z + 1);
        assertEquals(x + 1, coordinateXYZ.getX(), Epsilon);
        assertEquals(y + 1, coordinateXYZ.getY(), Epsilon);
        assertEquals(z + 1, coordinateXYZ.getZ(), Epsilon);
    }

    @Test
    public void testEqualsNull() {
        assertNotEquals(null, coordinateXYZ);
    }

    @Test
    public void testEqualsSelf() {
        assertEquals(coordinateXYZ, coordinateXYZ);
    }

    @Test
    public void testEqualsNotEqualCoordinates() {
        Coordinate unequalCoordinate = new CartesianCoordinate(x + 1, y + 1, z + 1);
        assertNotEquals(unequalCoordinate, coordinateXYZ);
    }

    @Test
    public void testEqualsEqualCoordinates() {
        Coordinate equalCoordinate = new CartesianCoordinate(x, y, z);
        assertEquals(equalCoordinate, coordinateXYZ);
    }

    @Test
    public void testIsEqualNull() {
        assertFalse(coordinateXYZ.isEqual(null));
    }

    @Test
    public void testIsEqualSelf() {
        assertTrue(coordinateXYZ.isEqual(coordinateXYZ));
    }

    @Test
    public void testIsEqualNotEqualCoordinates() {
        CartesianCoordinate unequalCoordinate = new CartesianCoordinate(x, z, y);
        assertFalse(coordinateXYZ.isEqual(unequalCoordinate));
    }

    @Test
    public void testIsEqualEqualCoordinates() {
        CartesianCoordinate equalCoordinate = new CartesianCoordinate(x, y, z);
        assertTrue(coordinateXYZ.isEqual(equalCoordinate));
    }

    @Test
    public void testGetDistanceZero() {
        assertEquals(0, coordinateXYZ.getDistance(coordinateXYZ), Epsilon);
    }

    @Test
    public void testGetDistanceOneX() {
        CartesianCoordinate coordinateChangedX = new CartesianCoordinate(x + 1, y, z);
        assertEquals(1, coordinateXYZ.getDistance(coordinateChangedX), Epsilon);
    }

    @Test
    public void testGetDistanceOneY() {
        CartesianCoordinate coordinateChangedY = new CartesianCoordinate(x, y + 1, z);
        assertEquals(1, coordinateXYZ.getDistance(coordinateChangedY), Epsilon);
    }

    @Test
    public void testGetDistanceOneZ() {
        CartesianCoordinate coordinateChangedY = new CartesianCoordinate(x, y, z + 1);
        assertEquals(1, coordinateXYZ.getDistance(coordinateChangedY), Epsilon);
    }

    @Test
    public void testGetDistanceXYZ() {
        CartesianCoordinate coordinateIncrXYZ = new CartesianCoordinate(x + 1, y + 1, z + 1);
        assertEquals(Math.sqrt(3), coordinateXYZ.getDistance(coordinateIncrXYZ), Epsilon);
    }

    @Test
    public void testAsSphericCoordinateAsCartesian() {
        assertEquals(coordinateXYZ, coordinateXYZ.asSphericCoordinate().asCartesianCoordinate());
    }

    @Test
    public void testAsSphericCoordinate1() {
        CartesianCoordinate coordinate1 = new CartesianCoordinate(5, 0, 0);
        SphericCoordinate coordinate2 = new SphericCoordinate(0, 90, 5);
        assertEquals(coordinate2, coordinate1.asSphericCoordinate());
    }

    @Test
    public void testAsSphericCoordinate2() {
        CartesianCoordinate coordinate1 = new CartesianCoordinate(0, 5, 0);
        SphericCoordinate coordinate2 = new SphericCoordinate(90, 90, 5);
        assertEquals(coordinate2, coordinate1.asSphericCoordinate());
    }
    @Test
    public void testAsSphericDistanceZero() {
        assertEquals(0, coordinateXYZ.asSphericDistance(coordinateXYZ), Epsilon);
    }

    @Test
    public void testAsSphericDistanceOneX() {
        CartesianCoordinate coordinateChangedX = new CartesianCoordinate(x + 1, y, z);
        assertEquals(1, coordinateXYZ.asSphericDistance(coordinateChangedX), Epsilon);
    }

    @Test
    public void testAsSphericDistanceOneY() {
        CartesianCoordinate coordinateChangedY = new CartesianCoordinate(x, y + 1, z);
        assertEquals(1, coordinateXYZ.asSphericDistance(coordinateChangedY), Epsilon);
    }

    @Test
    public void testAsSphericDistanceOneZ() {
        CartesianCoordinate coordinateChangedY = new CartesianCoordinate(x, y, z + 1);
        assertEquals(1, coordinateXYZ.asSphericDistance(coordinateChangedY), Epsilon);
    }

    @Test
    public void testAsSphericDistanceXYZ() {
        CartesianCoordinate coordinateIncrXYZ = new CartesianCoordinate(x + 1, y + 1, z + 1);
        assertEquals(Math.sqrt(3), coordinateXYZ.asSphericDistance(coordinateIncrXYZ), Epsilon);
    }
    
    @Test
    public void testAsCartesianCoordinate1() {
        assertEquals(coordinateXYZ, coordinateXYZ.asCartesianCoordinate());
    }

    @Test
    public void testAsCartesianDistanceZero() {
        assertEquals(0, coordinateXYZ.asCartesianDistance(coordinateXYZ), Epsilon);
    }

    @Test
    public void testAsCartesianDistanceOneX() {
        CartesianCoordinate coordinateChangedX = new CartesianCoordinate(x + 1, y, z);
        assertEquals(1, coordinateXYZ.asCartesianDistance(coordinateChangedX), Epsilon);
    }

    @Test
    public void testAsCartesianDistanceOneY() {
        CartesianCoordinate coordinateChangedY = new CartesianCoordinate(x, y + 1, z);
        assertEquals(1, coordinateXYZ.asCartesianDistance(coordinateChangedY), Epsilon);
    }

    @Test
    public void testAsCartesianDistanceOneZ() {
        CartesianCoordinate coordinateChangedY = new CartesianCoordinate(x, y, z + 1);
        assertEquals(1, coordinateXYZ.asCartesianDistance(coordinateChangedY), Epsilon);
    }

    @Test
    public void testAsCartesianDistanceXYZ() {
        CartesianCoordinate coordinateIncrXYZ = new CartesianCoordinate(x + 1, y + 1, z + 1);
        assertEquals(Math.sqrt(3), coordinateXYZ.asCartesianDistance(coordinateIncrXYZ), Epsilon);
    }


}
