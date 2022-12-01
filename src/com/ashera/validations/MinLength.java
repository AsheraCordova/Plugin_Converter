package com.ashera.validations;


import com.ashera.widget.IWidget;

/**
 * Class for Length form validation
 */
public class MinLength extends BaseValidator {

    private final int mMinLength;
    public MinLength() {
		mMinLength = 0;
	}

	@Override
	public Validation newInstance(String... argument) {
		return new MinLength(Integer.parseInt(argument[0]));
	}

    private MinLength(final int minLength) {
        mMinLength = minLength;
    }

    /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
        String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/min_length_error_message", widget.getFragment());
        return String.format(res, mMinLength);
        
        
        
    }

    /**
     * checks if the length of field lies between min and max length
     *
     * @param text Text string
     * @return isValid true or false
     */
    @Override
    public boolean isValid(String text, IWidget widget) {
        if (text == null) {
            text = "";
        }
        return text.length() >= mMinLength;
    }
}
