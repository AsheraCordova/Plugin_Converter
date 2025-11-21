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

import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class PasswordCommandConveter extends BaseAttributeCommand {
	public PasswordCommandConveter(String id) {
		super(id);
	}
	
	public PasswordCommandConveter newInstance(Object... args) {
		return new PasswordCommandConveter(this.id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null) {
			return null;
		}
		String text = (String) value;
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			result += "*";
		}
		text = result;
		return text;
	}

	@Override
	public void updateArgs(Object... args) {
		
	}
}