/**Class name: FoodManager.java
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

import java.util.ArrayList;
import java.util.List;
import org.wahlzeit.services.ObjectManager; 

public class FoodManager extends ObjectManager{
	private static FoodManager instance = new FoodManager();
	
	private List<Food> foodList = new ArrayList<>();
	private List<FoodType> foodTypes = new ArrayList<>();
	
	/**
	 * @methodtype getter
	 */
	public static FoodManager getInstance() {
		return instance;
	}

	/**
	 * @methodtype factory
	 */
	public synchronized Food createFood(FoodType foodType) {
		Food food = foodType.createInstance();
		
		if(foodList.contains(food)) {
			return foodList.get(foodList.indexOf(food));
		}
		else {
			foodList.add(food);
			return food;
		}
	}

	/**
	 * @methodtype factory
	 */
	public synchronized FoodType createFoodType(String cuisine, boolean vegetarian, boolean vegan, int spicinessIndicator) {
		FoodType foodType = new FoodType(cuisine, vegetarian, vegan, spicinessIndicator);
		
		if(foodTypes.contains(foodType)) {
			return foodTypes.get(foodTypes.indexOf(foodType));
		}
		else {
			foodTypes.add(foodType);
			return foodType;
		}
	}

}
