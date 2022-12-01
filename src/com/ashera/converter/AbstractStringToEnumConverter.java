package com.ashera.converter;

import java.util.Map;
import java.util.Set;

import com.ashera.core.IFragment;

public abstract class AbstractStringToEnumConverter implements IConverter<Object, String> {
    @Override
    public Object convertFrom(String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
        Map<String, Object> mapping = getMapping();

        if (mapping.containsKey(value)) {
            return mapping.get(value);
        }

        Object defaultValue = getDefault();
        return defaultValue;
    }


    @Override
    public String convertTo(Object value, IFragment fragment) {

        Map<String, Object> mapping = getMapping();
        String convertValue = null;
        Set<String> keySet = mapping.keySet();

        for (String key : keySet) {
            Object mappingValue = mapping.get(key);
            if (mappingValue == value) {
                convertValue = key;
                break;
            }
        }

        return convertValue;

    }


    public abstract Map<String, Object> getMapping();


    public abstract Object getDefault();

    @Override
    public java.util.List<String> getDependentAttributes() {
        return null;
    }
}
