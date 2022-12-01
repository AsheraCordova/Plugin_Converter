package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.widget.PluginInvoker;

public class DoubleConverter implements IConverter<Double, Object>{

	@Override
	public Double convertFrom(Object value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (value == null) {
			return null;
		}
		if (value instanceof Double) {
			return (Double) value;
		}
		if (value instanceof String) { 
			return Double.valueOf((String) value);
		}
		return PluginInvoker.getDouble(value);
	}

	@Override
	public Double convertTo(Double value, IFragment fragment) {
		return value;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
