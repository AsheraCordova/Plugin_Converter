package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.BaseAttributeCommand;
import com.ashera.widget.IWidget;

public class MarqueeCommandConverter extends BaseAttributeCommand {
	private int whiteSpace;
	private int offset;
	private String originalText;
	private String direction;
	public MarqueeCommandConverter(String id) {
		super(id);
	}

	public MarqueeCommandConverter(String id, int whiteSpace, int offset, String direction) {
		super(id);
		this.whiteSpace = whiteSpace;
		this.direction = direction;
	}

	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		if (value == null) {
			return null;
		}
		String text = (String) value;
		
		if (originalText != null && !originalText.equals(text)) {
			this.offset = 0;
			this.whiteSpace = 0;
			this.originalText = text;
			return text;
		}
		this.originalText = text;
		if (direction.equals("forward")) {
			StringBuffer strBuf = new StringBuffer(text);
			for (int i = 0; i < whiteSpace; i++) {
				strBuf.append("\u2003");
			}
			String indexFirst = strBuf.substring(0, offset);
			String indexSecond = strBuf.substring(offset);
			return indexSecond + indexFirst;
		} else {
			StringBuffer strBuf = new StringBuffer(text);
			for (int i = 0; i < whiteSpace; i++) {
				strBuf.insert(0, "\u2003");
			}
			String indexFirst = strBuf.substring(strBuf.length() - offset, strBuf.length());
			String indexSecond = strBuf.substring(0, strBuf.length() - offset);
			return indexFirst + indexSecond;
		}
	}

	@Override
	public AttributeCommand newInstance(Object... args) {
		return new MarqueeCommandConverter(this.id, (int) args[0], (int) args[1], (String) args[2]);
	}

	@Override
	public void updateArgs(Object... args) {
		whiteSpace = (int) args[0];
		offset = (int) args[1];
	}
	
	public int getOffset() {
		return offset;
	}
}