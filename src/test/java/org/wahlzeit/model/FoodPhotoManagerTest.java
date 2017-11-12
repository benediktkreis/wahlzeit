/*Class name: FoodPhotoManagerTest.java
 * 
 * Version: 1.0
 * 
 * Creation date: 12/11/2017
 * 
 * Last change date: 12/11/2017
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
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.*;
import java.io.IOException;

public class FoodPhotoManagerTest {
	
	//define test rules
	@ClassRule
	public static TestRule chain = RuleChain.
		outerRule(new LocalDatastoreServiceTestConfigProvider()).
		around(new RegisteredOfyEnvironmentProvider());
	
	@Rule
	public final ExpectedException expException  = ExpectedException.none();
	
	//declaration of variables used in the test
	FoodPhoto photo1;
	FoodPhoto photo2;
	FoodPhoto photo3;
	
	PhotoManager testManager;
	
	//initialization of used variables
	@Before
	public void setUp() throws Exception{
		photo1 = new FoodPhoto("Italian", false, false, 3);
		photo2 = new FoodPhoto("Chinese", true, false, 10);
		photo3 = photo2;
		//photo3 = new FoodPhoto("Vietnamese", false, false, 10);
		
		testManager = FoodPhotoManager.getInstance();
	}
	
	//test case for PhotoManager
	@Test
	public void testPhotoManager() {
		assertNotNull(testManager);
		
	        try {
	            testManager.addPhoto(photo1);
	            testManager.addPhoto(photo2);
	        } catch (IOException e1) {
	            assertNull(e1);
	        }

			assertNotNull(testManager.getPhoto(photo1.id));
			assertNotNull(testManager.getPhoto(photo2.id));
	        
	        try {
	        	expException.expect(IllegalStateException.class);
	            testManager.addPhoto(photo3);
	        } catch (IOException e2) {
	            assertNotNull(e2);
	        }
	        
	        assertFalse(testManager.hasPhoto(photo3.id));
	}
}
