package com.ashera.converter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ashera.core.IFragment;

public class ListToIntArrayConverter implements IConverter<int[], List<Object>>{
	@Override
	public int[] convertFrom(List<Object> list, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		if (list == null) {
			return null;
		}
	    
		return convertIntegers(list);
	}
	
	public int[] convertIntegers(List<Object> integers) {
		int[] ret = new int[integers.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = (int) integers.get(i);
		}
		return ret;
	}


	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}

	@Override
	public List<Object> convertTo(int[] value, IFragment fragment) {
		return Arrays.asList(value);
	}
}

