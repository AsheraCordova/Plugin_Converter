package com.ashera.validations;

import com.ashera.widget.IWidget;


/**
 * Class for InRange form validation
 */
public class MaxValue extends BaseValidator {

    private final int mMaxValue;
    public MaxValue() {
		mMaxValue = 0;
	}

	@Override
	public Validation newInstance(String... argument) {
		return new MaxValue(Integer.parseInt(argument[0]));
	}

    private MaxValue(final int maxValue) {
        mMaxValue = maxValue;
    }

    /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
        String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/max_value_error_message", widget.getFragment());
        return String.format(res, mMaxValue);
        
        
        
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
			return Float.parseFloat(text) <= mMaxValue;
		} catch (NumberFormatException e) {
			return false;
		}
    }
}
