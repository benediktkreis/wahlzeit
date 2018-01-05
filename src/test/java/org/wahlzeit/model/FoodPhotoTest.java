/**Class name: FoodPhotoTest.java
 * 
 * Version: 1.1
 * 
 * Creation date: 12/11/2017
 * 
 * Last change date: 02/01/2018
 * 
 * Copyright (c) 2018 by Benedikt Kreis
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
import org.wahlzeit.overall.OverallWahlzeitTestSuite;
import org.wahlzeit.utils.AnnotationUtil;

@AnnotationUtil( 
		patternName = "Composite", 
		participants = {"Component = OverallWahlzeitTest.java", "Composite = test suite", "Leaf = test case"} 
)

public class FoodPhotoTest {
	
	//declaration of variables used in the test
	FoodPhoto photo1;
	FoodPhoto photo2;
	FoodPhoto photo3;
	FoodPhoto photo4;
	FoodPhoto photo5;
	PhotoId id;
		
	
		//initialization of used variables
		@Before
		public void setUp() throws Exception{
			id = new PhotoId(4);
			photo1 = new FoodPhoto("Italian", false, false, 3);
			photo2 = new FoodPhoto("Chinese", true, false, 10);
			photo3 = new FoodPhoto("Vietnamese", false, false, 10);
			photo4 = new FoodPhoto(id, "Mexican", false, false, 8);
			photo5 = new FoodPhoto(id, "Mexican", false, false, 8);
			
		}
		
		//test case for FoodPhoto
		@Test
		public void testPhoto() {
			assertEquals(photo1.getCuisine(), "Italian");
			assertEquals(photo1.isVegetarian(), false);
			assertEquals(photo1.isVegan(), false);
			assertEquals(photo1.getSpicinessIndicator(), 3);
			assertEquals(photo2.getSpicinessIndicator(), photo3.getSpicinessIndicator());
			assertEquals(photo3.isVegetarian(), photo4.isVegetarian());
			assertEquals(photo2.isVegan(), photo3.isVegan());
			assertNotEquals(photo1.isVegetarian(), photo2.isVegetarian());
			assertEquals(photo4.getId(), photo5.getId());
		}
}
