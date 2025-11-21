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

import java.util.regex.Pattern;

import com.ashera.widget.IWidget;

/**
 * Mobile Number validation.
 */

public class IsMobileNumber extends BaseValidator {
	@Override
	public Validation newInstance(String... argument) {
		return new IsMobileNumber();
	}


   /**
     * Instantiates a new Is valid mobile number.
     */
    public IsMobileNumber() {

    }

    @Override
    public String getDefaultErrorMessage(IWidget widget) {
    	String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/mobile_error_message", widget.getFragment());
        return res;
    }

    @Override
    public boolean isValid(String text, IWidget widget) {
    	if (text == null || text.isEmpty()) {
    		return true;
    	}
        return Pattern.compile("\\d{10}").matcher(text).matches();
    }
}