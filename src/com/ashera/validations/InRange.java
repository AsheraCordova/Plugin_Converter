package com.ashera.validations;

import com.ashera.widget.IWidget;


/**
 * Class for InRange form validation
 */
public class InRange extends BaseValidator {
    private final int mMin;
    private final int mMax;
    
    
    public InRange() {
    	mMin = 0;
    	mMax = 0;
	}
	@Override
	public Validation newInstance(String... argument) {
		return new InRange(Integer.parseInt(argument[0]), Integer.parseInt(argument[1]));
	}

    private InRange(final int min, final int max) {
        mMin = min;
        mMax = max;
    }

    /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
    	String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/inrange_error_message", widget.getFragment());
		return String.format(res, mMin, mMax);
    }

    /**
     * checks if the field value lies between given min and max range
     *
     * @param text text string
     * @return isValid true or false
     */
    @Override
    public boolean isValid(final String text, IWidget widget) {
    	if (text == null || text.isEmpty()) {
    		return true;
    	}
        try {
            final int value = Integer.parseInt(text);
            if ((value >= mMin) && (value <= mMax)) {
                return true;
            }
        } catch (final NumberFormatException ignored) {
        }
        return false;
    }
}
