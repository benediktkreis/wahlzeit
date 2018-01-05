/**Class name: FoodPhotoFactory.java
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

import com.googlecode.objectify.annotation.*;
import org.wahlzeit.utils.AnnotationUtil;

@AnnotationUtil( 
		patternName = "Singleton", 
		participants = {"FoodPhotoFactory instance -> initialize() method", "getInstance() method", "setInstance() method"} 
)

@Subclass
public class FoodPhotoFactory extends PhotoFactory{

	//initializes instance of FoodPhotoFactory
	private static FoodPhotoFactory instance = null;
	
	/**
	 * @methodtype constructor
	 */
	//default constructor
	public FoodPhotoFactory() {
		super();
	}
	
	//initializes instance
	public static void initialize() {
		if (instance != null) {
			getInstance();
		}
		else {
			throw new IllegalStateException("FoodPhotoFactory is null.");
		}
		
	}

	/**
	 * @methodtype getter
	 */
	//gets instance
	public static synchronized FoodPhotoFactory getInstance() {
		if (instance == null) {
			setInstance(new FoodPhotoFactory());
		}
		else {
			throw new IllegalStateException("FoodPhotoFactory is already set.");
		}
		return instance;
	}

	/**
	 * @methodtype setter
	 */
	//sets instance
	protected static synchronized void setInstance(FoodPhotoFactory foodPhotoFactoryInstance) {
		if (instance != null) {
			//Exception already exists
			throw new IllegalStateException("There was an attempt to initalize FoodPhotoFactory more than once");
		}
		
		instance = foodPhotoFactoryInstance;
	}
	
	/**
	 * @methodtype factory
	 */
	//creates default FoodPhoto without ID
	public FoodPhoto createFoodPhoto(String cuisine, boolean vegetarian, boolean vegan, int spicinessIndicator) {
		return new FoodPhoto(cuisine, vegetarian, vegan, spicinessIndicator);
	} 
	
	/**
	 * @methodtype factory
	 */
	//creates FoodPhoto with ID
	public FoodPhoto createFoodPhoto(PhotoId myID, String cuisine, boolean vegetarian, boolean vegan, int spicinessIndicator) {
		return new FoodPhoto(myID, cuisine, vegetarian, vegan, spicinessIndicator);
	} 
	
}
