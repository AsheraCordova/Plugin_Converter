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

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.widget.PluginInvoker;

public class IntConverter implements IConverter<Integer, Object> {
	@Override
	public Integer convertFrom(Object value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (value == null) {
			return null;
		}
		if (value instanceof Double) {
			return ((Double) value).intValue();
		}
		if (value instanceof String) { 
			return Float.valueOf((String) value).intValue();
		}
		return PluginInvoker.getInt(value);
	}

	@Override
	public Integer convertTo(Integer value, IFragment fragment) {
		return value;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
