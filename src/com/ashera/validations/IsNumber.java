package com.ashera.validations;

import com.ashera.widget.IWidget;

/**
 * Class for IsNumber form validation
 */
public class IsNumber extends BaseValidator {
	@Override
	public Validation newInstance(String... argument) {
		return new IsNumber();
	}

    public IsNumber() {
    }

    /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
    	String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/number_error_message", widget.getFragment());
        return res;
    }

    /**
     * checks if the field is a number
     *
     * @param value Text String
     * @return isValid true or false
     */
    @Override
    public boolean isValid(final String text, IWidget widget) {
    	if (text == null || text.isEmpty()) {
    		return true;
    	}
        return text.matches("[0-9]*");
    }
}
