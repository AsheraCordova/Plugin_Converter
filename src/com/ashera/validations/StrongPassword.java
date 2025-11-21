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

public class StrongPassword extends BaseValidator{

	@Override
	public Validation newInstance(String... argument) {
		return new StrongPassword();
	}

	@Override
	public String getDefaultErrorMessage(IWidget widget) {
		String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/strongpassword_error_message", widget.getFragment());
		return res;
	}

	@Override
	public boolean isValid(String password, IWidget widget) {
		boolean valid = true;
		
		if (password == null || password.trim().equals("")) {
			return true;
		}
		
		if (password.length() < 8) {
			valid = false;
		}
		String upperCaseChars = "(.*[A-Z].*)";
		if (!password.matches(upperCaseChars)) {
			valid = false;
		}
		
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			valid = false;
		}
		String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
		if (!password.matches(specialChars)) {
			valid = false;
		}

		return valid;
	}

}
