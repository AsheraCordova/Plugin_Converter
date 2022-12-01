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
