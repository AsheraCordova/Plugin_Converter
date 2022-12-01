package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class MaxLengthCommandConveter extends BaseAttributeCommand {
	private int maxLength;

	public MaxLengthCommandConveter(String id) {
		super(id);
	}

	public MaxLengthCommandConveter(String id, int maxLength) {
		super(id);
		this.maxLength = maxLength;
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null) {
			return null;
		}
		String text = (String) value;
		if (text.length() > maxLength) {
			text = text.substring(0, maxLength);
		}
		return text;
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		return new MaxLengthCommandConveter(this.id, (int) args[0]);
	}

	@Override
	public void updateArgs(Object... args) {
		this.maxLength = (int) args[0];
	}
}