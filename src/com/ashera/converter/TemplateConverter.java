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

import java.util.HashMap;
import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.widget.IWidget;

public class TemplateConverter implements IConverter<IWidget, String> {
	@Override
	public IWidget convertFrom(String ref, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		String resPrefix = "@layout/";
		String inlineResource = fragment.getInlineResource(ref);
		if (inlineResource != null) {
			return com.ashera.widget.PluginInvoker.parse(inlineResource, true, fragment);
		} else if (ref.startsWith(resPrefix)) {
			String fileName = ref.replaceFirst(resPrefix, "");
			String fileResourcePath = "layout/" + fileName + ".xml";
			
			if ("dev".equals(fragment.getRootActivity().getAssetMode())) {
				 HashMap<String, String> urlMap = new HashMap<>();
				 urlMap.put("www/" + fileResourcePath, String.format("http://%s/%s", fragment.getRootActivity().getDevServerIp(), "res/" + fileResourcePath));
				String html = com.ashera.utils.FileUtils.readFilesContent(urlMap).get("www/" + fileResourcePath);
				return com.ashera.widget.PluginInvoker.parse(html, true, fragment);
			}
			return com.ashera.widget.PluginInvoker.parseFile(fileResourcePath, true, fragment);
		} 
		return null;
	}

	@Override
	public String convertTo(IWidget value, IFragment fragment) {
		return null;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
