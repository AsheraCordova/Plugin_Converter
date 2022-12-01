package com.ashera.validations;


import com.ashera.widget.IWidget;

/**
 * Class for NotEmpty form validation
 */
public class NotEmpty extends BaseValidator {
	@Override
	public Validation newInstance(String... argument) {
		return new NotEmpty();
	}

    public NotEmpty() {
    }

    /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
        return com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/required_error_message", widget.getFragment());
    }

    /**
     * checks if the field is empty
     *
     * @param text Text string
     * @return isValid true or false
     */
    @Override
    public boolean isValid(final String text, IWidget widget) {
        return text != null && !text.isEmpty();
    }
}
