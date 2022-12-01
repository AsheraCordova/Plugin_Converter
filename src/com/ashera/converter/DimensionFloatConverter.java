package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.utils.ResourceBundleUtils;
import com.ashera.widget.PluginInvoker;

public class DimensionFloatConverter implements IConverter<Float, String> {
	private static final int MATCH_PARENT = -1;
	private static final int WRAP_CONTENT = -2;

	@Override
	public Float convertFrom(String dimen, Map<String, Object> dependentAttributesMap, IFragment fragment) {
		float paramDimen = WRAP_CONTENT;
		if (dimen != null) {
			dimen = dimen.trim();
			dimen = ResourceBundleUtils.getString("values/dimens", "dimen", dimen, fragment);
			if (dimen.equalsIgnoreCase("match_parent")) {
				paramDimen = MATCH_PARENT;
			} else if (dimen.equalsIgnoreCase("wrap_content")) {
				paramDimen = WRAP_CONTENT;
			} else if (dimen.endsWith("dp")) {
				paramDimen = PluginInvoker.convertDpToPixel(dimen);
			} else {
				throw new RuntimeException("The dimension can be match_parent/wrap_content or should be expressed in dp");
			}
		}

		return paramDimen;		
	}

	@Override
	public String convertTo(Float value, IFragment fragment) {
		String convertValue = null;
		if (value != null) {
			if (value == -1) {
				convertValue = "match_parent";
			} else if (value == -2) {
				convertValue = "wrap_content";				
			} else {
				convertValue = PluginInvoker.convertPixelToDp(value, false);
			}
		}
		return convertValue;
	}

	@Override
	public java.util.List<String> getDependentAttributes() {
		return null;
	}
}
