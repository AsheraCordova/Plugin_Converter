package com.ashera.validations;


import com.ashera.widget.IWidget;

/**
 * Class for Length form validation
 */
public class Length extends BaseValidator {

    private final int mMinLength;
    private final int mMaxLength;
    public Length() {
    	mMinLength = 0;
		mMaxLength = 0;
	}

	@Override
	public Validation newInstance(String... argument) {
		if (argument.length == 2) {
			return new Length(Integer.parseInt(argument[0]), Integer.parseInt(argument[1]));
		}
		if (argument.length == 1) {
			return new Length(Integer.parseInt(argument[0]), -1);
		}
		
		return new Length(0, 0);
	}

    private Length(final int minLength, final int maxLength) {
        mMinLength = minLength;
        mMaxLength = maxLength;
    }

    /**
     * @param context Context class instance
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
        if (mMinLength != -1 && mMaxLength != -1) {
        	String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/length_between_error_message", widget.getFragment());
            return String.format(res, mMinLength, mMaxLength);
        } else if (mMinLength == -1 && mMaxLength != -1) {
        	String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/length_atmost_error_message", widget.getFragment());
            return String.format(res, mMaxLength);
        }
        String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/length_atleast_error_message", widget.getFragment());
        return String.format(res, mMinLength);
        
        
        
    }

    /**
     * checks if the length of field lies between min and max length
     *
     * @param text Text string
     * @return isValid true or false
     */
    @Override
    public boolean isValid(final String text, IWidget widget) {
        if (text == null) {
            return false;
        }
        if (mMinLength > 0 && mMaxLength > 0) {
            return text.length() >= mMinLength && text.length() <= mMaxLength;
        }
        if (mMinLength > 0 && mMaxLength < 0) {
            return text.length() >= mMinLength;
        }
        return text.length() <= mMaxLength;
    }
}
