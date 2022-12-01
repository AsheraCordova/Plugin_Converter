package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

public class TimeConverter implements IConverter<Integer, String> {

	@Override
	public Integer convertFrom(String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (value == null) {
			return null;
		}
		int finalValue = 0;
		if (value.endsWith("s")) {
			finalValue = Integer.parseInt(value.substring(0, value.length()-1)) * 1000;	
		}
		
		return finalValue;
	}

	@Override
	public String convertTo(Integer value, IFragment fragment) {
		return value == null ? null : value/1000 + "s";
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
