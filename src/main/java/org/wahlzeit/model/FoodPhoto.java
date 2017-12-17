/*Class name: FoodPhoto.java
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

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class FoodPhoto extends Photo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//declaration of variables
	protected String cuisine = ""; //e.g. Italian, Chinese,...
	protected boolean vegetarian = false;// vegetarian yes/no?
	protected boolean vegan = false;// vegan yes/no?
	protected int spicinessIndicator = 0;// How spicy is a food from 0-10 (0 = not spicy, 10 = super hot)
	
	/**
	 * @methodtype constructor
	 */
	//default constructor (if there is no photo)
	public FoodPhoto(String cuisine, boolean vegetarian, boolean vegan, int spicinessIndicator) {
		super();
		this.cuisine = cuisine;
		this.vegetarian = vegetarian;
		this.vegan = vegan;
		this.spicinessIndicator = spicinessIndicator;
		assertClassInvariants();
	}
	
	/**
	 * @methodtype constructor
	 */
	//constructor (if there is a photo) 
	public FoodPhoto(PhotoId myID, String cuisine, boolean vegetarian, boolean vegan, int spicinessIndicator) {
		super(myID);
		this.cuisine = cuisine;
		this.vegetarian = vegetarian;
		this.vegan = vegan;
		this.spicinessIndicator = spicinessIndicator;
		assertClassInvariants();
	}

	/**
	 * @methodtype getter
	 */
	//generated getters
	public String getCuisine() {
		return cuisine;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public boolean isVegan() {
		return vegan;
	}

	public int getSpicinessIndicator() {
		return spicinessIndicator;
	}
	
	private void assertClassInvariants() {
		assert spicinessIndicator < Integer.MAX_VALUE && spicinessIndicator > Integer.MIN_VALUE;
		
		if (!Double.isFinite(spicinessIndicator)) {
		throw new IllegalArgumentException("SpicinessIndicator is not a number.");
		}
	}

}
