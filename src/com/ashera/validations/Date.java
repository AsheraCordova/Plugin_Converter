package com.ashera.validations;

import java.text.SimpleDateFormat;

import com.ashera.widget.IWidget;

/**
 * Class for Date validation
 */
public class Date extends BaseValidator {
	private String format;
	@Override
	public Validation newInstance(String... argument) {
		Date date = new Date();
		date.format = argument[0];
		return date;
	}
    public static Date build() {
        return new Date();
    }

    public Date() {
    }

    /**
     * @param context context
     * @return error message string
     */
    @Override
    public String getDefaultErrorMessage(IWidget widget) {
    	return com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/date_error_message", widget.getFragment());
    }

    /**
     * checks if the date field format is valid
     *
     * @param text date field
     * @return isValid true or false
     */
    @Override
    public boolean isValid(String text, IWidget widget) {
        if (text == null || text.trim().equals("")) {
            return true;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        java.util.Date date = null;
        boolean result = false;
        try {
            date = dateFormat.parse(text);
            result = dateFormat.format(date).equals(text);
            if (text.length() > 10) {
                result = false;
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
