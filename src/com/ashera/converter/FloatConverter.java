package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.widget.PluginInvoker;

public class FloatConverter implements IConverter<Float, Object>{

	@Override
	public Float convertFrom(Object value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (value == null) {
			return null;
		}
		if (value instanceof Float) {
			return ((Float) value);
		}
		if (value instanceof String) { 
			return Float.valueOf((String) value);
		}
		return PluginInvoker.getFloat(value);
	}

	@Override
	public Float convertTo(Float value, IFragment fragment) {
		return value;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
