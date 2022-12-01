package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.plugin.IPlugin;

public abstract class BaseConverterPlugin implements Converter, IPlugin {
	@Override
	public String getName() {
		return "converter";
	}

	@Override
	public Object invoke(String name, Object... args) {
		//start - converter
		switch (name) {
		case "convertFrom":
			return convertFrom((IConverter) args[0],(Map<String,Object>) args[1],(Object) args[2],(IFragment) args[3]);
		case "convertTo":
			return convertTo((IConverter) args[0],(Object) args[1],(IFragment) args[2]);
		case "getConverter":
			return getConverter((String) args[0]);
		case "getDependentAttributes":
			return getDependentAttributes((IConverter) args[0]);
		case "getColor":
			return getColor((String) args[0]);
		case "convertDpToPixel":
			return convertDpToPixel((String) args[0]);
		case "convertSpToPixel":
			return convertSpToPixel((String) args[0]);
		case "convertPixelToDp":
			return convertPixelToDp((Object) args[0],(boolean) args[1]);
		case "convertPixelToSp":
			return convertPixelToSp((Object) args[0],(boolean) args[1]);
		default:
			break;
		}
		throw new RuntimeException("Unknown method " + name);
		//end - converter
	}

	@Override
	public Object convertFrom(IConverter converter, Map<String, Object> dependentAttributesMap, Object value, IFragment fragment) {
		return converter.convertFrom(value, dependentAttributesMap, fragment);
	}

	@Override
	public Object convertTo(IConverter converter, Object objValue, IFragment fragment) {
		return converter.convertTo(objValue, fragment);
	}

	@Override
	public IConverter getConverter(String name) {
		return ConverterFactory.get(name);
	}

	@Override
	public java.util.List<String> getDependentAttributes(com.ashera.converter.IConverter converter) {
		return converter.getDependentAttributes();
	}
}
