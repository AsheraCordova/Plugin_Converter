package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

public class ResourceStringConverter implements IConverter<String, String>{

	@Override
	public String convertFrom(String text, Map<String, Object> dependentAttributesMap, IFragment fragment) {
	    return com.ashera.utils.ResourceBundleUtils.getString("values/strings", "string", (String) text, fragment);
	}

	@Override
	public String convertTo(String value, IFragment fragment) {
		return value;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
