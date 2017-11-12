/*Class name: OfyService.java
 * 
 * Version: 1.1
 * 
 * Creation date: 16/10/2017
 * 
 * Last change date: 12/11/2017 by Benedikt Kreis
 * 
 * Copyright (c) 2017 by Dirk Riehle
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


package org.wahlzeit.services;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import org.wahlzeit.model.Administrator;
import org.wahlzeit.model.Client;
import org.wahlzeit.model.Globals;
import org.wahlzeit.model.Guest;
import org.wahlzeit.model.Moderator;
import org.wahlzeit.model.FoodPhoto; //added by Benedikt Kreis
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoCase;
import org.wahlzeit.model.Tag;
import org.wahlzeit.model.User;
import org.wahlzeit.model.persistence.DatastoreAdapter.ImageWrapper;

/**
 * A badly named class, to be renamed to ObjectifyService first, something better later.
 * 
 * @review
 */
public class OfyService {

	/**
	 * Register all entities at startup
	 */
	static {
		factory().register(FoodPhoto.class);//added by Benedikt Kreis
		factory().register(Photo.class);
		factory().register(Globals.class);
		factory().register(Tag.class);
		factory().register(User.class);
		factory().register(Administrator.class);
		factory().register(Moderator.class);
		factory().register(Client.class);
		factory().register(Guest.class);
		factory().register(PhotoCase.class);
		factory().register(ImageWrapper.class);
	}

	public static Objectify ofy() {
		return ObjectifyService.ofy();
	}

	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}
}
