/**Class name: FoodPhoto.java
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

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class FoodPhoto extends Photo {

	private static final long serialVersionUID = 1L;

	//declaration of variables
	private static final String defCuisine = ""; //e.g. Italian, Chinese,...
	private static final boolean defVegetarian = false;// vegetarian yes/no?
	private static final boolean defVegan = false;// vegan yes/no?
	private static final int defSpicinessIndicator = 0;// How spicy is a food from 0-10 (0 = not spicy, 10 = super hot)
	
	/**
	 * @methodtype Constructor
	 */
	public FoodPhoto(PhotoId myId) {
		super(myId);
		this.initialize(defCuisine, defVegetarian, defVegan, defSpicinessIndicator);
	}
	
	/**
	 * @methodtype constructor
	 */
	public FoodPhoto(PhotoId myID, String cuisine, boolean vegetarian, boolean vegan, int spicinessIndicator) {
		super(myID);
		this.initialize(cuisine, vegetarian, vegan, spicinessIndicator);
	}
	
	/**
	 * @methodtype constructor
	 */
	public FoodPhoto(String cuisine, boolean vegetarian, boolean vegan, int spicinessIndicator) {
		super();
		this.initialize(cuisine, vegetarian, vegan, spicinessIndicator);
	}


	/**
	 * @methodtype constructor
	 */
	public FoodPhoto(PhotoId myID, FoodType foodType) {
		super(myID);
		this.initialize(foodType);
	}
	
	/**
	 * @methodtype constructor
	 */
	public FoodPhoto(FoodType foodType) {
		super();
		this.initialize(foodType);
	}
	
	/**
	 * @methodtype factory
	 */
	public void initialize(String cuisine, boolean vegetarian, boolean vegan, int spicinessIndicator) {
		FoodType type = FoodManager.getInstance().createFoodType(cuisine, vegetarian, vegan, spicinessIndicator);
		FoodManager.getInstance().createFood(type);
	}
	
	/**
	 * @methodtype factory
	 */
	public void initialize(FoodType type) {
		FoodManager.getInstance().createFood(type);
	}

}
