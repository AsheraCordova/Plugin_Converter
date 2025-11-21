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
 * Class for IsEmail form validation
 */
public class IsEmail extends BaseValidator {
	public static final Pattern EMAIL_ADDRESS
    = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
        "\\@" +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
        "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
        ")+"
    );
    public IsEmail() {
    }
	@Override
	public Validation newInstance(String... argument) {
		return new IsEmail();
	}


   /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
    	String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/email_error_message", widget.getFragment());
        return res;
    }

   /**
     * checks if the field is a valid email id
     *
     * @param text Text string
     * @return isValid true or false
     */
    @Override
    public boolean isValid(final String text, IWidget widget) {
    	if (text == null || text.isEmpty()) {
    		return true;
    	}
        return EMAIL_ADDRESS.matcher(text).matches();
    }
}
