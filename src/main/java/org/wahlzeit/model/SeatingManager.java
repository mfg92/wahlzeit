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

import org.wahlzeit.services.ObjectManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class SeatingManager extends ObjectManager {
	/**
	 *
	 */
	private static SeatingManager instance;

	/**
	 *
	 */
	private HashMap<String,SeatingType> seatingTypeMap = new HashMap<>();

	/**
	 *
	 */
	private List<Seating> allSeatings = new ArrayList<>();

	/**
	 *
	 * @return
	 */
	public static synchronized SeatingManager getInstance(){
		if(instance == null)
			instance=new SeatingManager();
		return instance;
	}

	/**
	 *
	 */
	private SeatingManager(){ }

	/**
	 *
	 * @param typeName
	 * @return
	 */
	public Seating createSeating(String typeName){
		SeatingType type = getSeatingType(typeName);
		Seating seating = type.createInstance();
		allSeatings.add(seating);
		return seating;
	}

	/**
	 *
	 * @param superType null for default super type
	 * @param typeName
	 * @param seatCount
	 * @return
	 */
	public SeatingType createSeatingType(SeatingType superType, String typeName, int seatCount){
		if(seatingTypeMap.containsKey(typeName)){
			throw new RuntimeException(String.format("SeatingType %s already exists.", typeName));
		}
		SeatingType newType = new SeatingType(superType, typeName, seatCount);
		seatingTypeMap.put(typeName, newType);
		return  newType;
	}

	/**
	 *
	 * @param typeName
	 * @return
	 */
	public SeatingType getSeatingType(String typeName) {
		SeatingType type = seatingTypeMap.get(typeName);
		if(type == null){
			throw new RuntimeException(String.format("Unknown SeatingType %s.", typeName));
		}
		return  type;
	}

	/**
	 *
	 * @param typeName
	 * @return
	 */
	private SeatingType doGetSeatingType(String typeName) {
		return seatingTypeMap.get(typeName);
	}
}
