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
import com.ashera.utils.ResourceBundleUtils;
import com.ashera.widget.PluginInvoker;

public class DimensionConverter implements IConverter<Integer, String> {
	private static final int MATCH_PARENT = -1;
	private static final int WRAP_CONTENT = -2;

	@Override
	public Integer convertFrom(String dimen, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		int paramDimen = WRAP_CONTENT;
		if (dimen != null) {
			dimen = dimen.trim();
			dimen = ResourceBundleUtils.getString("values/dimens", "dimen", dimen, fragment);
			if (dimen.equalsIgnoreCase("match_parent")) {
				paramDimen = MATCH_PARENT;
			} else if (dimen.equalsIgnoreCase("wrap_content")) {
				paramDimen = WRAP_CONTENT;
			} else if (dimen.endsWith("dp")) {
				paramDimen = (int) Math.ceil(PluginInvoker.convertDpToPixel(dimen));
			} else {
				throw new RuntimeException("The dimension can be match_parent/wrap_content or should be expressed in dp - " + dimen);
			}
		}

		return paramDimen;
		
	}

	@Override
	public String convertTo(Integer value, IFragment fragment) {
		String convertValue = null;
		if (value != null) {
			if (value == -1) {
				convertValue = "match_parent";
			} else if (value == -2) {
				convertValue = "wrap_content";				
			} else {
				convertValue = PluginInvoker.convertPixelToDp(value, true);
			}
		}
		return convertValue;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
