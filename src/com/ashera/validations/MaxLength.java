package com.ashera.validations;


import com.ashera.widget.IWidget;

public class MaxLength extends BaseValidator {

    private final int mMaxLength;
    public MaxLength() {
		mMaxLength = 0;
	}

	@Override
	public Validation newInstance(String... argument) {
		return new MaxLength(Integer.parseInt(argument[0]));
	}

    private MaxLength(final int maxLength) {
        mMaxLength = maxLength;
    }

    /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
        String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/max_length_error_message", widget.getFragment());
        return String.format(res, mMaxLength);
        
        
        
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
        return text.length() <= mMaxLength;
    }
}
