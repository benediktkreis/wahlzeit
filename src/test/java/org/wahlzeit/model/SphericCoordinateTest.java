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

public class SphericCoordinateTest {

    double latitude;
    double longitude;
    double radius;
    static final double Epsilon = 0.0001;
    SphericCoordinate defaultCoordinate;

    @Before
    public void setUp() {
        latitude = 1.;
        longitude = 2.;
        radius = 3.;
        defaultCoordinate = new SphericCoordinate(latitude, longitude, radius);
    }

    @Test
    public void testConstructor() {
        assertEquals(latitude, defaultCoordinate.getLatitude(), Epsilon);
        assertEquals(longitude, defaultCoordinate.getLongitude(), Epsilon);
        assertEquals(radius, defaultCoordinate.getRadius(), Epsilon);
    }
    
    public void testConstructorDefaultRadius() {
    	SphericCoordinate coordinate = new SphericCoordinate(latitude, longitude);
    	assertNotEquals(0, coordinate.getRadius(), Epsilon);
    }

    @Test
    public void testSetterAndGetterValid() {
        defaultCoordinate.setLatitude(latitude + 1);
        defaultCoordinate.setLongitude(longitude + 1);
        defaultCoordinate.setRadius(radius + 1);
        assertEquals(latitude + 1, defaultCoordinate.getLatitude(), Epsilon);
        assertEquals(longitude + 1, defaultCoordinate.getLongitude(), Epsilon);
        assertEquals(radius + 1, defaultCoordinate.getRadius(), Epsilon);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetLatitudeInvalidTooSmall() {
    	defaultCoordinate.setLatitude(-180.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetLatitudeInvalidTooGreat() {
    	defaultCoordinate.setLatitude(180.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetLongitudeInvalidTooSmall() {
    	defaultCoordinate.setLatitude(-90.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetLongitudeInvalidTooGreat() {
    	defaultCoordinate.setLatitude(90.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusInvalidSmallerZero() {
    	defaultCoordinate.setRadius(-0.01);
    }

    @Test
    public void testEqualsNull() {
        assertNotEquals(null, defaultCoordinate);
    }

    @Test
    public void testEqualsSelf() {
        assertEquals(defaultCoordinate, defaultCoordinate);
    }

    @Test
    public void testEqualsNotEqualCoordinates() {
        Coordinate unequalCoordinate = new SphericCoordinate(latitude + 1, longitude + 1, radius + 1);
        assertNotEquals(unequalCoordinate, defaultCoordinate);
    }

    @Test
    public void testEqualsEqualCoordinates() {
        Coordinate equalCoordinate = new SphericCoordinate(latitude, longitude, radius);
        assertEquals(equalCoordinate, defaultCoordinate);
    }

    @Test
    public void testIsEqualNull() {
        assertFalse(defaultCoordinate.isEqual(null));
    }

    @Test
    public void testIsEqualSelf() {
        assertTrue(defaultCoordinate.isEqual(defaultCoordinate));
    }

    @Test
    public void testIsEqualNotEqualCoordinates() {
        SphericCoordinate unequalCoordinate = new SphericCoordinate(latitude, radius, longitude);
        assertFalse(defaultCoordinate.isEqual(unequalCoordinate));
    }

    @Test
    public void testIsEqualEqualCoordinates() {
        SphericCoordinate equalCoordinate = new SphericCoordinate(latitude, longitude, radius);
        assertTrue(defaultCoordinate.isEqual(equalCoordinate));
    }

    @Test
    public void testAsSphericCoordinate() {
        assertEquals(defaultCoordinate, defaultCoordinate.asSphericCoordinate());
    }

    @Test
    public void testAsCartesianCoordinateAsSpheric() {
        assertEquals(defaultCoordinate, defaultCoordinate.asCartesianCoordinate().asSphericCoordinate());
    }

    @Test
    public void testAsCartesianCoordinate1() {
        SphericCoordinate coordinate = new SphericCoordinate(90, 0, 5);
        CartesianCoordinate coordinateExpected = new CartesianCoordinate(0, 0, 5);
        assertEquals(coordinateExpected, coordinate.asCartesianCoordinate());
    }

    @Test
    public void testAsCartesianCoordinate2() {
        SphericCoordinate coordinate = new SphericCoordinate(0, 90, 5);
        CartesianCoordinate coordinateExpected = new CartesianCoordinate(5, 0, 0);
        assertEquals(coordinateExpected, coordinate.asCartesianCoordinate());
    }

    @Test
    public void testAsCartesianCoordinate3() {
        SphericCoordinate coordinate = new SphericCoordinate(70, -10, 5);
        CartesianCoordinate coordinateExpected = new CartesianCoordinate(-0.2969558731, -0.8158795558, 4.924038765);
        assertEquals(coordinateExpected, coordinate.asCartesianCoordinate());
    }

    @Test
    public void testGetDistanceZero() {
        assertEquals(0, defaultCoordinate.getDistance(defaultCoordinate), Epsilon);
    }

    @Test
    public void testGetDistanceLatitude() {
        SphericCoordinate coordinate1 = new SphericCoordinate(0, 0, 5);
        SphericCoordinate coordinate2 = new SphericCoordinate(0, 0, 5);
        assertEquals(0, coordinate1.getDistance(coordinate2), Epsilon);
    }

    @Test
    public void testGetDistanceLongitude() {
        SphericCoordinate coordinate1 = new SphericCoordinate(0, 90, 5);
        SphericCoordinate coordinate2 = new SphericCoordinate(0, -90, 5);
        assertEquals(2 * 5, coordinate1.getDistance(coordinate2), Epsilon);
    }

    @Test
    public void testGetDistanceOneRadius() {
        SphericCoordinate coordinateChangedY = new SphericCoordinate(latitude, longitude, radius + 1);
        assertEquals(1, defaultCoordinate.getDistance(coordinateChangedY), Epsilon);
    }

    @Test
    public void testGetDistanceAllParameters() {
        SphericCoordinate coordinate1 = new SphericCoordinate(90, 0, 5);
        SphericCoordinate coordinate2 = new SphericCoordinate(0, 180, 5);
        // pythagoras: 1 is top center; 2 is "left" on äquator
        assertEquals(2 * 5, coordinate1.getDistance(coordinate2), Epsilon);
    }
    @Test
    public void testAsSphericDistanceZero() {
        assertEquals(0, defaultCoordinate.asSphericDistance(defaultCoordinate), Epsilon);
    }

    @Test
    public void testAsSphericDistanceLatitude() {
        SphericCoordinate coordinate1 = new SphericCoordinate(0, 0, 5);
        SphericCoordinate coordinate2 = new SphericCoordinate(0, 0, 5);
        assertEquals(0, coordinate1.asSphericDistance(coordinate2), Epsilon);
    }

    @Test
    public void testAsSphericDistanceLongitude() {
        SphericCoordinate coordinate1 = new SphericCoordinate(0, 90, 5);
        SphericCoordinate coordinate2 = new SphericCoordinate(0, -90, 5);
        assertEquals(2 * 5, coordinate1.asSphericDistance(coordinate2), Epsilon);
    }

    @Test
    public void testAsSphericDistanceOneRadius() {
        SphericCoordinate coordinateChangedY = new SphericCoordinate(latitude, longitude, radius + 1);
        assertEquals(1, defaultCoordinate.asSphericDistance(coordinateChangedY), Epsilon);
    }

    @Test
    public void testAsSphericDistanceAllParameters() {
        SphericCoordinate coordinate1 = new SphericCoordinate(90, 0, 5);
        SphericCoordinate coordinate2 = new SphericCoordinate(0, 180, 5);
        assertEquals(2 * 5, coordinate1.asSphericDistance(coordinate2), Epsilon);
    }
    
    @Test
    public void testAsCartesianDistanceZero() {
        assertEquals(0, defaultCoordinate.asCartesianDistance(defaultCoordinate), Epsilon);
    }

    @Test
    public void testAsCartesianDistanceLatitude() {
        SphericCoordinate coordinate1 = new SphericCoordinate(0, 0, 5);
        SphericCoordinate coordinate2 = new SphericCoordinate(0, 0, 5);
        assertEquals(0, coordinate1.asCartesianDistance(coordinate2), Epsilon);
    }

    @Test
    public void testAsCartesianDistanceLongitude() {
        SphericCoordinate coordinate1 = new SphericCoordinate(0, 90, 5);
        SphericCoordinate coordinate2 = new SphericCoordinate(0, -90, 5);
        assertEquals(2 * 5, coordinate1.asCartesianDistance(coordinate2), Epsilon);
    }

    @Test
    public void testAsCartesianDistanceOneRadius() {
        SphericCoordinate coordinateChangedY = new SphericCoordinate(latitude, longitude, radius + 1);
        assertEquals(1, defaultCoordinate.asCartesianDistance(coordinateChangedY), Epsilon);
    }

    @Test
    public void testAsCartesianDistanceAllParameters() {
        SphericCoordinate coordinate1 = new SphericCoordinate(90, 0, 5);
        SphericCoordinate coordinate2 = new SphericCoordinate(0, 180, 5);
        assertEquals(2 * 5, coordinate1.asCartesianDistance(coordinate2), Epsilon);
    }

}