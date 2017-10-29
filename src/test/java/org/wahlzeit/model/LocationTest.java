package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

public class LocationTest{
	Coordinate c1, c2;
	Location l1, l2;
	
	@Before
	public void setUp() throws Exception{
		c1 = new Coordinate(1,2,3);
		
		l1 = new Location(c1);
		l2 = new Location(1,2,3);
	}
	
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
