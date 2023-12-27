package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;

public class NilConverter  implements IConverter<String, Object>{
	@Override
	public String convertFrom(Object value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		return "";
	}


	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}


	@Override
	public Object convertTo(String value, IFragment fragment) {
		return "";
	}
}
