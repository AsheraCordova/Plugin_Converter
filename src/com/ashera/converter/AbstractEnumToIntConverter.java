package com.ashera.converter;

import java.util.Map;
import java.util.Set;

import com.ashera.core.IFragment;
import com.ashera.widget.PluginInvoker;

public abstract class AbstractEnumToIntConverter implements IConverter<Integer, Object> {
	public final static int DEFAULT_UNKNOWN = -99999;
	@Override
	public Integer convertFrom(Object value, Map<String, Object> dependentAttributesMap,IFragment fragment) {
		 Map<String, Integer> mapping = getMapping();
		 
		if (mapping.containsKey(value)) {
			return mapping.get(value);
		}
		
		if (supportsIntAlso()) {
			return PluginInvoker.getInt(value);
		}
		
		Integer defaultValue = getDefault();
		
		if (defaultValue == DEFAULT_UNKNOWN) {
			return null;
		}
		return defaultValue;
		
	}
	
	@Override
	public String convertTo(Integer value, IFragment fragment) {

		Map<String, Integer> mapping = getMapping();
		String convertValue = null;

		Set<String> keySet = mapping.keySet();
					
		for (String key : keySet) {
			Integer mappingValue = mapping.get(key);
			if (mappingValue.equals(value)) {
				convertValue = key;
				break;
			}
		}
		if (convertValue == null && supportsIntAlso()) {
			convertValue = value.toString();
		}
		
		return convertValue;
	}
	
	public boolean supportsIntAlso() {
		return false;
	}
	
	public abstract Map<String, Integer> getMapping();
	public abstract Integer getDefault();

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
