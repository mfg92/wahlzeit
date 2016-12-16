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

package org.wahlzeit.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * A helper class that uses generics and java reflections to offer an easy to use value-object factory
 */
public class ValueFactory<T> {

	private final HashMap<String, T> allInstances = new HashMap<>();
	private final Constructor<T> constructor;

	/**
	 *
	 * @param clazz the class of witch the objects are made of
	 * @param constructorParameterTypes the classes of the constructors arguments
	 */
	public ValueFactory(Class<T> clazz, Class<?>... constructorParameterTypes) {
		try {
			this.constructor = clazz.getDeclaredConstructor(constructorParameterTypes);
			this.constructor.setAccessible(true);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	public ValueFactory(Constructor<T> constructor){
		this.constructor = constructor;
		this.constructor.setAccessible(true);
	}

	/**
	 *
	 * @param constructorParameters
	 * @return the new created value-object or an equal cached version of that
	 */
	public T getValueObject(Object... constructorParameters) {
		StringBuilder idBuilder = new StringBuilder();
		for(Object paramter: constructorParameters){
			idBuilder.append(paramter);
			idBuilder.append(',');
		}

		String id = idBuilder.toString();

		T value = allInstances.get(id);
		if (value == null) {
			synchronized (this) {
				value = allInstances.get(id);
				if (value == null) {
					try {
						value = constructor.newInstance(constructorParameters);
					} catch(InvocationTargetException e){
						if(e.getTargetException() instanceof RuntimeException){
							throw (RuntimeException) e.getTargetException();
						}
						throw new RuntimeException(e);
					} catch (InstantiationException | IllegalAccessException e) {
						throw new RuntimeException(e);
					}
					allInstances.put(id, value);
				}
			}
		}
		return value;
	}
}
