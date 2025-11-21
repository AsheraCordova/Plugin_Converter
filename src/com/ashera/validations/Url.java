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

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import com.ashera.widget.IWidget;


/**
 * Class for Alphanumeric form validation
 */
public class Url extends BaseValidator {

	@Override
	public Validation newInstance(String... argument) {
		Url pattern = new Url();
		return pattern;
	}

    public Url() {
    }


   /**
     * @param context context
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(final IWidget widget) {
    	return com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/url_error_message", widget.getFragment());
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
    	try {
			URL u = new URL(text);
			u.toURI();
		} catch (MalformedURLException e) {
			return false;
		} catch (URISyntaxException e) {
			return false;
		}
        return true;
    }
}
