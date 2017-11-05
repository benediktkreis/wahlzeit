/* Class name: MailingTestSuite.java
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

package org.wahlzeit.services.mailing;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runner.RunWith;

@RunWith
(Suite.class)

//includes all test classes of mailing package
@SuiteClasses
({
	org.wahlzeit.services.mailing.EmailServiceTest.class
})

//runs all test of mailing package
public class MailingTestSuite {

}
