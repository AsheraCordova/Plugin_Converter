package com.ashera.validations;

import java.util.regex.Pattern;

import com.ashera.widget.IWidget;

/**
 * PIN Number validation.
 */

public class IsValidPIN extends BaseValidator {
	@Override
	public Validation newInstance(String... argument) {
		return new IsValidPIN();
	}
    /**
     * Validates a number is valid pin code.
     */
    public IsValidPIN() {

    }

    @Override
    public String getDefaultErrorMessage(IWidget widget) {
    	String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/pincode_error_message", widget.getFragment());
        return res;
    }

    @Override
    public boolean isValid(String text, IWidget widget) {
    	if (text == null || text.isEmpty()) {
    		return true;
    	}
        return Pattern.compile("\\d{6}").matcher(text).matches();
    }
}