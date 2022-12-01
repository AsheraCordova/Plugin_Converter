package com.ashera.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ashera.widget.IWidget;

/**
 * Class for Time validation
 */
public class Time extends BaseValidator {
    private Pattern pattern;
    private Matcher matcher;
    private static final String TIME24HOURS_PATTERN =
            "([01]?[0-9]|2[0-3]):[0-5][0-9]";

	@Override
	public Validation newInstance(String... argument) {
		return new Time();
	}

    public Time() {
    }


    @Override
    public String getDefaultErrorMessage(IWidget widget) {
    	String res = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", "@string/time_error_message", widget.getFragment());
        return res;
    }

    @Override
    public boolean isValid(String text, IWidget widget) {
    	if (text == null || text.isEmpty()) {
    		return true;
    	}
        return validate(text);
    }


    /**
     * Validate time in 24 hours format with regular expression
     *
     * @param time time address for validation
     * @return true valid time format, false invalid time format
     */
    public boolean validate(final String time) {
        pattern = Pattern.compile(TIME24HOURS_PATTERN);
        matcher = pattern.matcher(time);
        return matcher.matches();
    }
}
