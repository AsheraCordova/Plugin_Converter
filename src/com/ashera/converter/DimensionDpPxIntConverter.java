package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.utils.ResourceBundleUtils;
import com.ashera.widget.PluginInvoker;

public class DimensionDpPxIntConverter implements IConverter<Integer, String> {
    @Override
    public Integer convertFrom(String dimen, Map<String, Object> dependentAttributesMap, IFragment fragment) {
        int paramDimen = 0;
        if (dimen != null) {
            dimen = dimen.trim();
            dimen = ResourceBundleUtils.getString("values/dimens", "dimen", dimen, fragment);
            if (dimen.endsWith("px")) {
            	paramDimen = Integer.parseInt(dimen.substring(0, dimen.length() - 2));
            } else if (dimen.endsWith("dp")) {
            	paramDimen = Integer.parseInt(dimen.substring(0, dimen.length() - 2));
            	paramDimen = (int) Math.ceil(PluginInvoker.convertDpToPixel(dimen));
            } else {
                throw new RuntimeException(
                        "The dimension can be match_parent/wrap_content or should be expressed in dp/px");
            }
        }

        return paramDimen;

    }


    @Override
    public String convertTo(Integer value, IFragment fragment) {
        String convertValue = null;
        if (value != null) {
            if (value == -1) {
                convertValue = null;
            } else {
                convertValue = PluginInvoker.convertPixelToDp(value, true);
            }
        }
        return convertValue;
    }

    @Override
    public java.util.List<String> getDependentAttributes() {
        return null;
    }
}
