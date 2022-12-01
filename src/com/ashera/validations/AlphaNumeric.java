package com.ashera.validations;

import com.ashera.widget.IWidget;


/**
 * Class for Alphanumeric form validation
 */
public class AlphaNumeric extends BaseValidator {
	@Override
	public Validation newInstance(String... argument) {
		return new AlphaNumeric();
	}

    public AlphaNumeric() {
    }


    /**
     * @param context context
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(final IWidget widget) {
    	return com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/alphanumeric_error_message", widget.getFragment());
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
        return text.matches("[0-9a-zA-Z]*");
    }
}
