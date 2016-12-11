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
 * Test cases for the SeatingPhoto class.
 */
public class SeatingPhotoTest {

	/**
	 *
	 */
	@Test(expected = SeatingPhoto.SeatingPhotoException.class)
	public void testSeatsCountSetterIllegalArgument() throws SeatingPhoto.SeatingPhotoException {
		SeatingPhoto photo = new SeatingPhoto();
		photo.setSeatCount(-42);
	}

	/**
	 *
	 */
    @Test
    public void testSeatsCountSetterGetter() throws SeatingPhoto.SeatingPhotoException {
		int seatCount = 42;
		SeatingPhoto photo = new SeatingPhoto();
		photo.setSeatCount(seatCount);
		Assert.assertEquals(seatCount, photo.getSeatCount());
    }

    /**
     *
     */
    @Test
    public void testConstructor() {
        new Photo();
    }

    /**
     *
     */
    @Test
    public void testConstructor2() {
        new Photo(PhotoId.NULL_ID);
    }

}