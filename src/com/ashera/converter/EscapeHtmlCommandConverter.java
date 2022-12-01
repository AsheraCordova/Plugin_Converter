package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class EscapeHtmlCommandConverter  extends BaseAttributeCommand {
	public EscapeHtmlCommandConverter(String id) {
		super(id);
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null) {
			return null;
		}
		String text = (String) value;
        return escapeHtml(text);
	}
	
	private Object escapeHtml(String text) {
		return text.replaceAll("&", "&amp;")
		         .replaceAll("<", "&lt;")
		         .replaceAll(">", "&gt;")
		         .replaceAll("\"", "&quot;")
		         .replaceAll("'", "&#039;");
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		EscapeHtmlCommandConverter autoLinkifyCommandConverter = new EscapeHtmlCommandConverter(this.id);
		autoLinkifyCommandConverter.updateArgs(args);
		autoLinkifyCommandConverter.setPriority(98);
		return autoLinkifyCommandConverter;
	}
	
	@Override
	public void updateArgs(java.lang.Object... args) {
		
	}
}
