/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
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

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for the SeatingManager class.
 */
public class SeatingManagerTest {

	private SeatingManager manager = SeatingManager.getInstance();
	private static final String TEST_SEATING_TYPE =  "TestSeating";

	@Test
	public void testSingleton(){
		Assert.assertNotNull(manager);
		Assert.assertSame(manager, SeatingManager.getInstance());
	}

	@Test
	public void testCreateSeatingType(){
		final int seatCount = 42;
		Assert.assertNotNull(manager.createSeatingType(null, TEST_SEATING_TYPE, seatCount));
		Assert.assertNotNull(manager.getSeatingType(TEST_SEATING_TYPE));
		Assert.assertEquals(manager.getSeatingType(TEST_SEATING_TYPE).getSeatCount(), seatCount);
	}

	@Test
	public void testCreateSeatingSubType(){
		final int seatCount = 1337;
		final SeatingType superType = manager.getSeatingType(TEST_SEATING_TYPE);
		final String subTypeName = "Sub" + TEST_SEATING_TYPE;

		Assert.assertNotNull(superType);
		Assert.assertNotNull(manager.createSeatingType(superType, subTypeName, seatCount));

		final SeatingType subType = manager.getSeatingType(subTypeName);

		Assert.assertNotNull(superType);
		Assert.assertEquals(manager.getSeatingType(subTypeName).getSeatCount(), seatCount);
		Assert.assertTrue(superType.isSubtype(subType));
		Assert.assertTrue(subType.isSubtype(subType));
		Assert.assertTrue(superType.isSubtype(superType));
		Assert.assertFalse(subType.isSubtype(superType));
		Assert.assertNotSame(subType, superType);
	}

	@Test
	public void testCreateSeating(){
		Seating.SeatingCondition condition = Seating.SeatingCondition.New;
		Seating seating = manager.createSeating(TEST_SEATING_TYPE, condition);
		Assert.assertNotNull(seating);
		Assert.assertNotNull(seating.getType());
		Assert.assertEquals(seating.getType(), manager.getSeatingType(TEST_SEATING_TYPE));
		Assert.assertEquals(seating.getCondition(), condition);
	}

}