package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.widget.PluginInvoker;

public class IntConverter implements IConverter<Integer, Object> {
	@Override
	public Integer convertFrom(Object value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (value == null) {
			return null;
		}
		if (value instanceof Double) {
			return ((Double) value).intValue();
		}
		if (value instanceof String) { 
			return Float.valueOf((String) value).intValue();
		}
		return PluginInvoker.getInt(value);
	}

	@Override
	public Integer convertTo(Integer value, IFragment fragment) {
		return value;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
