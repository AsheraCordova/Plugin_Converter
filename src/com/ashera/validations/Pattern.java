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
package com.ashera.validations;

import com.ashera.widget.IWidget;


/**
 * Class for Alphanumeric form validation
 */
public class Pattern extends BaseValidator {
	private String format;

	@Override
	public Validation newInstance(String... argument) {
		Pattern pattern = new Pattern();
		pattern.format = argument[0];
		return pattern;
	}

    public Pattern() {
    }


   /**
     * @param context context
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(final IWidget widget) {
    	return com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/pattern_error_message", widget.getFragment());
    }

   /**
     * checks if the field is alphanumeric value
     *
     * @param text text field
     * @return isValid true or false
     */
    @Override
    public boolean isValid(final String text, IWidget widget) {
    	if (text == null || text.isEmpty()) {
    		return true;
    	}
        return text.matches(format);
    }
}
