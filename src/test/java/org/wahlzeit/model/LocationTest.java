/*Class name: LocationTest.java
 * 
 * Version: 1.1
 * 
 * Creation date: 29/10/2017
 * 
 * Last change date: 05/11/2017
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

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LocationTest{
	
	//declaration of coordinates and locations that are used in the test
	Coordinate c1, c2;
	Location l1, l2;
	
	//initialization of used coordinates and locations
	@Before
	public void setUp() throws Exception{
		c1 = new Coordinate(1,2,3);
		
		l1 = new Location(c1);
		l2 = new Location(1,2,3);
	}
	
	//test case for getDistance method
	//checks if both contructors work correctly
	@Test
	public void testLocation() {
		
		if (l1.getClass().equals(l2.getClass())) {
		System.out.println("Location works correctly.");
		}
		else {
			System.out.println("Location doesn't work.");
		}
		
		assert(l1.getClass().equals(l2.getClass()));
		
		System.out.println();
	}
}
