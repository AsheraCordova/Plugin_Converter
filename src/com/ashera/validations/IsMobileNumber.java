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