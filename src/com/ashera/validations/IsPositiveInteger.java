package com.ashera.validations;

import com.ashera.widget.IWidget;

/**
 * Class for IsPositiveInteger form validation
 */
public class IsPositiveInteger extends BaseValidator {

    public static final String POSITIVE_INT_PATTERN = "\\d+";

	@Override
	public Validation newInstance(String... argument) {
		return new IsPositiveInteger();
	}

	public IsPositiveInteger() {
    }

    /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
    	String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/positivenumber_error_message", widget.getFragment());
        return res;
    }

    /**
     * checks if the field is a positive number
     *
     * @param text Text string
     * @return isValid true or false
     */
    @Override
    public boolean isValid(final String text, IWidget widget) {
    	if (text == null || text.isEmpty()) {
    		return true;
    	}
        return text.matches(POSITIVE_INT_PATTERN);
    }
}
