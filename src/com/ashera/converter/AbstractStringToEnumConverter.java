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
