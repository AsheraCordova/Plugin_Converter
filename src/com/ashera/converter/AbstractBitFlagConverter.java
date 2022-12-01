package com.ashera.converter;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.ashera.core.IFragment;

public abstract class AbstractBitFlagConverter implements IConverter<Integer, String> {
	@Override
	public Integer convertFrom(String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		 Map<String, Integer> mapping = getMapping();
		if (value == null) {
			return getDefault();
		} else {
			String[] values = value.split("\\|");
			int returnInt = 0;
			for (int i = 0; i < values.length; i++) {
				if (mapping.containsKey(values[i])) {
					returnInt |= mapping.get(values[i]);
				} else {
					throw new RuntimeException("Invalid mapping found " + values[i]);
				}
			}
			return returnInt;
		}		
	}
	
	@Override
    public String convertTo(Integer value, IFragment fragment) {
        Map<String, Integer> mapping = getMapping();

        LinkedHashSet<String> values = new LinkedHashSet<>();
        outer: for (Integer flag : getReverseMappingFlags()) {

            if (flag != 0) {
                Integer maskedValue = value & flag;
                Set<String> keySet = mapping.keySet();

                for (String key : keySet) {
                    Integer mask = mapping.get(key);
                    if (value == 0 && value == mask) {
                    	values.add(key);
                        break outer;
                    } else if (value != 0 && mask != 0 && maskedValue.intValue() == mask.intValue()) {
                    	values.add(key);
                    }
                    
                    String allOption = getAllOption();
					if (allOption != null && values.contains(allOption)) {
                    	values.clear();
                    	values.add(allOption);
                    	break;
                    }
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
	public abstract Integer getDefault();
	public Collection<Integer> getReverseMappingFlags() {
		return getMapping().values();
	}
}
