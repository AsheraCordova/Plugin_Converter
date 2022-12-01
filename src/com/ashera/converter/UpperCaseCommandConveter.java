package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class UpperCaseCommandConveter extends BaseAttributeCommand {
	public UpperCaseCommandConveter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null) {
			return null;
		}
		String text = (String) value;
		final String result = text.toUpperCase(java.util.Locale.getDefault());
        return result;
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		return new UpperCaseCommandConveter(this.id);
	}

	@Override
	public void updateArgs(Object... args) {
		
	}
}
