package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class ImageStateCommandConverter extends BaseAttributeCommand {
	private Object value;

	public ImageStateCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (this.value != null) {
			return this.value;
		}
		return value;
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		ImageStateCommandConverter imageStateCommandConverter = new ImageStateCommandConverter(this.id);
		imageStateCommandConverter.setPriority(10);
		imageStateCommandConverter.updateArgs(args);
		return imageStateCommandConverter;
	}

	@Override
	public void updateArgs(Object... args) {
		this.value = args[0];
	}

	@Override
	public boolean executeAfterPostMeasure() {
		return true;
	}

}
