package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.widget.IdGenerator;

public class IdConverter implements IConverter<Integer, String> {
	@Override
	public Integer convertFrom(String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		return IdGenerator.getId(value);
	}

	@Override
	public String convertTo(Integer value, IFragment fragment) {
		return IdGenerator.getName(value);
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}

}
