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

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class TextFormatCommandConverter extends BaseAttributeCommand {
	private String textFormat;
	public TextFormatCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null) {
			return null;
		}
		String text = (String) value;
		final String result = String.format(textFormat, text);
        return result;
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		TextFormatCommandConverter textFormatCommandConverter = new TextFormatCommandConverter(this.id);
		textFormatCommandConverter.updateArgs(args);
		return textFormatCommandConverter;
	}

	@Override
	public void updateArgs(Object... args) {
		this.textFormat = (String) args[0];
	}
}
