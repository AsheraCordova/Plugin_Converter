//start - license
/*
 * Copyright (c) 2025 Ashera Cordova
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
//end - license
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
