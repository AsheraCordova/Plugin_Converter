package com.ashera.validations;

import com.ashera.widget.IWidget;


/**
 * Class for InRange form validation
 */
public class MinValue extends BaseValidator {

    private final int mMinValue;
    public MinValue() {
		mMinValue = 0;
	}

	@Override
	public Validation newInstance(String... argument) {
		return new MinValue(Integer.parseInt(argument[0]));
	}

    private MinValue(final int minValue) {
        mMinValue = minValue;
    }

    /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
        String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/min_value_error_message", widget.getFragment());
        return String.format(res, mMinValue);
        
        
        
    }

    /**
     * checks if the Value of field lies between min and max Value
     *
     * @param text Text string
     * @return isValid true or false
     */
    @Override
    public boolean isValid(String text, IWidget widget) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        try {
			return Float.parseFloat(text) >= mMinValue;
		} catch (NumberFormatException e) {
			return false;
		}
    }
}
