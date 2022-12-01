package com.ashera.converter;

import java.util.List;
import java.util.Map;

import com.ashera.core.IFragment;

public class ObjectToMapConverter implements IConverter<Object, Object>{

	@Override
	public Object convertFrom(Object value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (value == null) {
			return null;
		}
		if (value instanceof String) {
			if (((String) value).startsWith("[")) {
				return com.ashera.widget.PluginInvoker.unmarshal((String)value, java.util.List.class);
			} else if (((String) value).startsWith("{")) {
				return com.ashera.widget.PluginInvoker.unmarshal((String)value, java.util.Map.class);
			} else {
				return value;
			}
		}
		Map<String, Object> map = com.ashera.widget.PluginInvoker.getMap(value);
		if (map != null) {
			return map;
		}
		List<Object> list = com.ashera.widget.PluginInvoker.getList(value);
		if (list != null) {
			return list;
		}
		return value;
	}

	@Override
	public Object convertTo(Object value, IFragment fragment) {
		return com.ashera.widget.PluginInvoker.getJSONSafeObj(value);
	}

	@Override
	public List<String> getDependentAttributes() {
		return null;
	}

}
