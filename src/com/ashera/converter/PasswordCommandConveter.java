package com.ashera.converter;

import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class PasswordCommandConveter extends BaseAttributeCommand {
	public PasswordCommandConveter(String id) {
		super(id);
	}
	
	public PasswordCommandConveter newInstance(Object... args) {
		return new PasswordCommandConveter(this.id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null) {
			return null;
		}
		String text = (String) value;
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			result += "*";
		}
		text = result;
		return text;
	}

	@Override
	public void updateArgs(Object... args) {
		
	}
}