/**Class name: FoodPhotoFactoryTest.java
 * 
 * Version: 1.1
 * 
 * Creation date: 12/11/2017
 * 
 * Last change date: 14/01/2018
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
import org.junit.ClassRule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

public class FoodPhotoFactoryTest {
	
	//define test rules
	@ClassRule
    public static TestRule chain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider());
	
	//declaration of variables used in the test
	FoodPhotoFactory testFactory;
	
	FoodPhoto photo1;
	FoodPhoto photo2;
	FoodPhoto photo3;
	
	PhotoId id;
	
	//initialization of used variables
	@Before
	public void setUp() throws Exception{
		testFactory = FoodPhotoFactory.getInstance();
		
		id = new PhotoId(5);
		
		photo1 = new FoodPhoto("Italian", false, false, 3);
		photo2 = new FoodPhoto("Chinese", true, false, 10);
		photo3 = new FoodPhoto(id, "Mexican", false, false, 8);
	}
	
	//test case for
	@Test
	public void testPhotoFactory() {
		 assertNotNull(testFactory);
		 
		 assertNotNull(photo1);
		 assertNotNull(photo2);
		 assertNotNull(photo3);
		 
		 assertEquals(photo1.getClass(), photo2.getClass());
		 assertEquals(photo2.getClass(), photo3.getClass());
		 assertEquals(photo3.getClass(), photo1.getClass());
	}
}
