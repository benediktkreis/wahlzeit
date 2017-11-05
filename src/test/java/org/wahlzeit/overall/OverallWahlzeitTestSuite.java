/* Class name: OverallWahlzeitTestSuite.java
 * 
 * Version: 1.0
 * 
 * Creation date: 05/11/2017
 * 
 * Last change date: 05/11/2017
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

package org.wahlzeit.overall;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runner.RunWith;

@RunWith
(Suite.class)

//includes all test suites of Wahlzeit
@SuiteClasses
({
	org.wahlzeit.handlers.HandlersTestSuite.class,
	org.wahlzeit.model.ModelTestSuite.class,
	org.wahlzeit.model.persistence.PersistenceTestSuite.class,
	org.wahlzeit.services.ServicesTestSuite.class,
	org.wahlzeit.services.mailing.MailingTestSuite.class,
	org.wahlzeit.utils.UtilsTestSuite.class
})

//runs all test suites
public class OverallWahlzeitTestSuite {

}
