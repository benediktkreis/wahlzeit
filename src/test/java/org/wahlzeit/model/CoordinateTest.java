package org.wahlzeit.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	Coordinate c1, c2, c3, c4;
	
	@Before
	public void setUp() throws Exception{
		c1 = new Coordinate(0,0,0);
		c2 = new Coordinate(1,0,0);
		c3 = new Coordinate(0,1,0);
		c4 = new Coordinate(1,2,3);
	}
	
	
	@Test
	public void testGetDistance() {
		double distance1 = c1.getDistance(c2);
		double distance2 = c2.getDistance(c3);
		
		System.out.println("Distance1: "+distance1+" (should be 1.0)");
		System.out.println("Distance2: "+distance2+" (should be "+Math.sqrt(2)+")");
		
		if (distance1 == 1 && distance2 == Math.sqrt(2)) {
			System.out.println("getDistance works correctly.");
		}
		else  {
			System.out.println("getDistance doesn't work.");
		}
		
		assert(distance1 == 1);
		assert(distance2 == Math.sqrt(2));
		
		System.out.println();
	}
	
	@Test
	public void testIsEqual() {
		
		if (c1.isEqual(c1) == true) {
		System.out.println("isEqual works correctly.");
		}
		else {
			System.out.println("isEqual doesn't work.");
		}
		
		assert(c1.isEqual(c1));
		
		System.out.println();
	}
	
	@Test
	public void testEquals() {
		
		if (c1.equals(c1) == true) {
		System.out.println("equals works correctly.");
		}
		else {
			System.out.println("equals doesn't work.");
		}
		
		assert(c1.equals(c1));
		
		System.out.println();
	}
	
	@Test
	public void testGetters() {
		
		if (c4.getX() == 1 && c4.getY() == 2 && c4.getZ() == 3) {
		System.out.println("Getters work correctly.");
		}
		else {
			System.out.println("Getters don't work.");
		}
		
		assert(c4.getX() == 1);
		assert(c4.getY() == 2);
		assert(c4.getZ() == 3);
		
		System.out.println();
	}
}
