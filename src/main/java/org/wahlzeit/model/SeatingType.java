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

/**
 *
 */
public class SeatingType {

	/**
	 *
	 */
	public static final SeatingType BASIC_SEATING_TYPE = new SeatingType("BasicSeatingType", 0);

	/**
	 *
	 */
	private final SeatingType superType;

	/**
	 *
	 */
	private final int seatCount;

	/**
	 *
	 */
	private final String typeName;

	/**
	 *
	 * @param seatCount
	 * @param typeName
	 */
	SeatingType(String typeName, int seatCount) {
		this(null, typeName, seatCount);
	}

	/**
	 *
	 * @param superType
	 * @param typeName
	 * @param seatCount
	 */
	SeatingType(SeatingType superType, String typeName, int seatCount) {
		this.superType = superType!=null?superType:BASIC_SEATING_TYPE;
		this.typeName = typeName;
		this.seatCount = seatCount;
	}

	/**
	 *
	 * @return
	 */
	public Seating createInstance(){
		return  new Seating(this);
	}

	/**
	 *
	 * @return
	 */
	public SeatingType getSuperType(){
		return superType;
	}

	/**
	 *
	 * @param type
	 * @return returns true if type is a subtype of this
	 */
	public boolean isSubtype(SeatingType type){
		while (type != null){
			if(this == type){
				return true;
			}
			type = type.getSuperType();
		}
		return false;
	}

	/**
	 *
	 * @return
	 */
	public int getSeatCount() {
		return seatCount;
	}

	/**
	 *
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}
}
