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

public class BooleanConverter implements IConverter<Boolean, Object>{
	@Override
	public Boolean convertFrom(Object value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		try {
			return com.ashera.utils.StringUtils.getBoolean(value);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean convertTo(Boolean value, IFragment fragment) {
		return value;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
