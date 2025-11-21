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

import java.util.List;
import java.util.Map;

import com.ashera.core.IFragment;

public class OverlayBoundsConverter implements IConverter<int[], Object[]>{


	@Override
	public List<String> getDependentAttributes() {
		return null;
	}

	@Override
	public int[] convertFrom(Object[] value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		String algorithm = (String) value[0];
		int[] bounds = new int[4];
		int intrinsicWidth = (int) value[1];
		int intrinsicHeight = (int) value[2];
		int left = (int) value[3];
		int top = (int) value[4];
		int viewWidth = (int) value[5];
		int viewHeight = (int) value[6];
		
		switch (algorithm) {
		case "center":
			bounds[0] = left + (viewWidth-intrinsicWidth)/2;  
			bounds[1] = top +(viewHeight-intrinsicHeight)/2;
			bounds[2] = intrinsicWidth;
			bounds[3] = intrinsicHeight;
			break;
		case "top_left":
			bounds[0] = left;  
			bounds[1] = top;
			bounds[2] = intrinsicWidth;
			bounds[3] = intrinsicHeight;
			break;
		case "top_right":
			bounds[0] = left + viewWidth-intrinsicWidth;  
			bounds[1] = top;
			bounds[2] = intrinsicWidth;
			bounds[3] = intrinsicHeight;
			break;
		case "bottom_right":
			bounds[0] = left + viewWidth-intrinsicWidth;  
			bounds[1] = top + viewHeight-intrinsicHeight;
			bounds[2] = intrinsicWidth;
			bounds[3] = intrinsicHeight;
			break;
		case "bottom_left":
			bounds[0] = left;  
			bounds[1] = top + viewHeight-intrinsicHeight;
			bounds[2] = intrinsicWidth;
			bounds[3] = intrinsicHeight;
			break;
		default:
			break;
		}

		return bounds;
	}

	@Override
	public Object[] convertTo(int[] value, IFragment fragment) {
		return null;
	}

}
