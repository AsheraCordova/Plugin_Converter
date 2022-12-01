package com.ashera.converter;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Map;

import com.ashera.core.IFragment;

public class PercentConverter implements IConverter<Float, String> {
    @Override
    public Float convertFrom(String value, Map<String, Object> dependentAttributesMap, IFragment fragment) {
        try {
        	if (value == null) {
        		return null;
        	}
            float floatValue = new DecimalFormat("0.0#%").parse(value).floatValue();
            return floatValue;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String convertTo(Float value, IFragment fragment) {
    	if (value == null) {
    		return null;
    	}
        return new DecimalFormat("0.#%").format(value.doubleValue());
    }

    @Override
    public java.util.List<String> getDependentAttributes() {
        return null;
    }
}
