/**Class name: FoodType.java
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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class FoodType extends DataObject{
private static final long serialVersionUID = 1L;
	
	protected FoodType superType = null;
	protected Set<FoodType>subType = new HashSet<FoodType>();
	
	//declaration of variables
	protected String cuisine = ""; //e.g. Italian, Chinese,...
	protected boolean vegetarian = false;// vegetarian yes/no?
	protected boolean vegan = false;// vegan yes/no?
	protected int spicinessIndicator = 0;// How spicy is a food from 0-10 (0 = not spicy, 10 = super hot)

	/**
	 * @methodtype constructor
	 */
	public FoodType(String cuisine, boolean vegetarian, boolean vegan, int spicinessIndicator) {
		this.cuisine = cuisine;
		this.vegetarian	= vegetarian;
		this.vegan 	= vegan;
		this.spicinessIndicator	= spicinessIndicator;
	}
	
	/**
	 * @methodtype factory
	 */
	public Food createInstance() {
		return new Food(this);
	}
	
	/**
	 * @methodtype getter
	 */
	public FoodType getSuperType() {
		return superType;
	}
	
	/**
	 *  @methodtype getter
	 */
	public boolean isSubType() {
		return superType != null;
	}
	
	/**
	 * @methodtype getter
	 */
	public Iterator<FoodType> getSubTypeIterator() {
		return subType.iterator();
	}
	
	/**
	 * @methodtype setter
	 */
	public void addSubType(FoodType foodType) {
		assert (foodType != null) : "attemp to set null sub-type";
		foodType.setSuperType(this);
		subType.add(foodType);
	}

	/**
	 * @param foodType
	 */
	private void setSuperType(FoodType foodType) {
		superType = foodType;
	}
	
	/**
	 * @methodtype query
	 */
	public boolean hasInstance(Food food) {
		assert (food != null) : "check for null object";
		
		if (food.getType() == this) {
			return true;
		}
		
		for (FoodType type : subType) {
			if (type.hasInstance(food)) {
				return true;
			}
		}
		
		return false;
	}

}
