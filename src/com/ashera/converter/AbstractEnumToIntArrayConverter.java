package com.ashera.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ashera.core.IFragment;

public abstract class AbstractEnumToIntArrayConverter implements IConverter<int[], String> {
	@Override
	public int[] convertFrom(String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		 Map<String, Integer> mapping = getMapping();
		if (value == null) {
			return getDefault();
		} else {
			String[] values = value.split("\\|");
			int[] returnInt = new int[values.length];
			for (int i = 0; i < values.length; i++) {
				if (mapping.containsKey(values[i])) {
					returnInt[i] = mapping.get(values[i]);
				} else {
					throw new RuntimeException("Invalid mapping found " + values[i]);
				}
			}
			return returnInt;
		}		
	}
	
	@Override
    public String convertTo(int[] value, IFragment fragment) {
        Map<String, Integer> mapping = getMapping();

        List<String> values = new ArrayList<>();
        for (int currentValue : value) {
        	Set<String> keySet = mapping.keySet();
        	for (String key : keySet) {
                Integer keyValue = mapping.get(key);
                if (keyValue.intValue() == currentValue) {
                	values.add(key);
                	break;
                }
        	}
		}

        StringBuilder stringBuilder = new StringBuilder();
        String seperator = "";
        for (String str : values) {
        	stringBuilder.append(seperator).append(str);
        	seperator = "|";
		}
        return stringBuilder.toString();

    }
	
	public String getAllOption() {
		return null;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}

	public abstract Map<String, Integer> getMapping();
	public abstract int[] getDefault();
	public Collection<Integer> getReverseMappingFlags() {
		return getMapping().values();
	}
}
