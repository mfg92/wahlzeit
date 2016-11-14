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

import com.googlecode.objectify.annotation.Subclass;

/**
 * A special {@link Photo} class for photos of Seatings
 */
@Subclass
public class SeatingPhoto extends Photo {
	public static final int UNKNOWN_SEAT_COUNT = -1;
	/**
	 *
	 */
	private int seatCount = UNKNOWN_SEAT_COUNT;

	/**
	 *
	 */
	public SeatingPhoto() {
	}

	/**
	 *
	 * @param myId
	 */
	public SeatingPhoto(PhotoId myId) {
		super(myId);
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		if(seatCount < 0 && seatCount != UNKNOWN_SEAT_COUNT)
			throw new IllegalArgumentException("Seat count has to in range [0,..Integer.MAX] " +
					"or be eqauls to SeatingPhoto.UNKNOWN_SEAT_COUNT");
		this.seatCount = seatCount;
	}

	public boolean hasSeatCount(){
		return getSeatCount() != UNKNOWN_SEAT_COUNT;
	}
}
