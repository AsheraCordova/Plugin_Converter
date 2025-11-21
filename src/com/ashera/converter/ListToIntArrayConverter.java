//start - license
/*
 * Copyright (c) 2025 Ashera Cordova
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
//end - license
package com.ashera.converter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ashera.core.IFragment;

public class ListToIntArrayConverter implements IConverter<int[], List<Object>>{
	@Override
	public int[] convertFrom(List<Object> list, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (list == null) {
			return null;
		}
	    
		return convertIntegers(list);
	}
	
	public int[] convertIntegers(List<Object> integers) {
		int[] ret = new int[integers.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = (int) integers.get(i);
		}
		return ret;
	}


	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}

	@Override
	public List<Object> convertTo(int[] value, IFragment fragment) {
		return Arrays.asList(value);
	}
}

