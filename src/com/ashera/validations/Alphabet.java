/*
 * Copyright 2013 Philip Schiffer
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.ashera.validations;

import com.ashera.widget.IWidget;

/**
 * Class for Alphanumeric form validation
 */
public class Alphabet extends BaseValidator {
	@Override
	public Validation newInstance(String... argument) {
		return new Alphabet();
	}

    public Alphabet() {
    }


    /**
     * @param context context
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
    	return com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/alphabets_error_message", widget.getFragment());
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
        return text.matches("[a-zA-Z]*");
    }

}
