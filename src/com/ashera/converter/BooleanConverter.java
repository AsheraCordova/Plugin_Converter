package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

public class BooleanConverter implements IConverter<Boolean, Object>{
	@Override
	public Boolean convertFrom(Object value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		try {
			return com.ashera.utils.StringUtils.getBoolean(value);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean convertTo(Boolean value, IFragment fragment) {
		return value;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
