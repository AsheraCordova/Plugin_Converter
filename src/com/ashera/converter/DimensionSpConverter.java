package com.ashera.converter;

import java.util.Map;

import com.ashera.core.IFragment;
import com.ashera.utils.ResourceBundleUtils;
import com.ashera.widget.PluginInvoker;

public class DimensionSpConverter implements IConverter<Object, String> {
    @Override
    public Object convertFrom(String dimen, Map<String, Object> dependentAttributesMap, IFragment fragment) {
        float paramDimen = 0;
        if (dimen != null) {
            dimen = dimen.trim();
            dimen = ResourceBundleUtils.getString("values/dimens", "dimen", dimen, fragment);
            if (dimen.endsWith("sp")) {
                paramDimen = PluginInvoker.convertSpToPixel(dimen);
            } else {
                throw new RuntimeException(
                        "The dimension can be match_parent/wrap_content or should be expressed in sp");
            }
        }

        return paramDimen;
    }


    @Override
    public String convertTo(Object value, IFragment fragment) {
        String convertValue = null;
        if (value != null) {
            if (((Number) value).floatValue() == -1) {
                convertValue = null;
            } else {
                convertValue = PluginInvoker.convertPixelToSp(value, false);
            }
        }
        return convertValue;
    }

    @Override
    public java.util.List<String> getDependentAttributes() {
        return null;
    }

}
