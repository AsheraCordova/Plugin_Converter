package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

public class ArrayConverter implements IConverter<String[], String>{
	@Override
	public String[] convertFrom(String text, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (text == null) {
			return null;
		}
	    String value = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "array", text, fragment);
	    if (value == null) {
	    	return null;
	    }
	    String separatorKey = text + ".separator";
		String separator = com.ashera.utils.ResourceBundleUtils.getString("values/strings", "array", separatorKey, fragment);
	    if (separator == null || separatorKey.equals(separator)) {
	    	separator = ",";
	    }
		return value.split(separator);
	}

	@Override
	public String convertTo(String[] value, IFragment fragment) {
		if (value == null) {
			return null;
		}
		return String.join(",", value);
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}

