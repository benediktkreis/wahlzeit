/**Class name: Food.java
 * 
 * Version: 1.0
 * 
 * Creation date: 14/01/2018
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

/**	Creation of new type object
 * 
 * In order to create a new Food type object it is required to create a new instance of FoodType.
 * There is a factory method called which creates a new TypeObject with given attributes.
 * Afterwards the attributes are set in the constructor of the class FoodType by the FoodManager.
 * The FoodManager has its own createFood() method to create the new instance of a TypeObject and manages them in a list.
 * FoodPhoto.initialize() calls this factory method and the creates a photo.
 * 
 * 
 * Solution space
 * 
 * Delegation -> seperate-object
 * Selection -> on-the-spot
 * Configuration -> in-code
 * Instantiation -> in-code
 * Initialization -> default
 * Building -> default
 */

public class Food {
	protected FoodType foodType = null;

	/**
	 * @methodtype constructor 
	 */
	public Food(FoodType foodType) {
		this.foodType = foodType;
	}

	/**
	 * @methodtype getter
	 */
	public FoodType getType() {
		return foodType;
	}

}
