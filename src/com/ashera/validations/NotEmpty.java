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
 * Class for NotEmpty form validation
 */
public class NotEmpty extends BaseValidator {
	@Override
	public Validation newInstance(String... argument) {
		return new NotEmpty();
	}

    public NotEmpty() {
    }

   /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
        return com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/required_error_message", widget.getFragment());
    }

   /**
     * checks if the field is empty
     *
     * @param text Text string
     * @return isValid true or false
     */
    @Override
    public boolean isValid(final String text, IWidget widget) {
        return text != null && !text.isEmpty();
    }
}
