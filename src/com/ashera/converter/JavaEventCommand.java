package com.ashera.converter;

import java.util.Map;

import com.ashera.model.ModelExpressionParser;
import com.ashera.model.ModelExpressionParser.ModelFromScopeHolder;
import com.ashera.model.ModelExpressionParser.ModelUpdateToScopeHolder;
import com.ashera.model.ModelScope;
import com.ashera.widget.EventCommand;
import com.ashera.widget.IWidget;
import com.ashera.widget.PluginInvoker;

public class JavaEventCommand implements EventCommand{
	interface SingleParamFunction {
		Object apply(IWidget widget, Object modelVal, Map<String, Object> configMap);
	}
	@Override
	public Object executeCommand(IWidget widget, Map<String, Object> eventObject, Object... params) {
		String event = (String) eventObject.get("event");
		switch (event) {
			case "increment":
				executeCommand(widget, eventObject, this::increment);
			break;
			case "decrement":
				executeCommand(widget, eventObject, this::decrement);
			break;
			case "toggle":
				executeCommand(widget, eventObject, this::toggle);
			break;
		}
		return null;
	}

	private void executeCommand(IWidget widget, Map<String, Object> eventObject, SingleParamFunction func) {
		String eventParams = (String) eventObject.get("eventParams");
		if (eventParams != null) {
			Map<String, Object> configMap = ModelExpressionParser.parseSimpleCssExpression(eventParams);
			String getExpression = (String) configMap.get("exp_get");
			String storeExpression = (String) configMap.get("exp_store");

			Object modelVal = getObject(widget, getExpression);
			Object result = func.apply(widget, modelVal, configMap);
			
			storeObject(widget, storeExpression, result);
		}
	}

	private void storeObject(IWidget widget, String storeExpression, Object result) {
		ModelUpdateToScopeHolder modelUpdateToScopeHolder = ModelExpressionParser.parseModelUpdateToScope(storeExpression);
		String varPath = modelUpdateToScopeHolder.varPath;
		String varName = modelUpdateToScopeHolder.varName;
		ModelScope varScope = modelUpdateToScopeHolder.varScope;
		
		result = com.ashera.model.ModelStore.changeModelDataType(modelUpdateToScopeHolder.varType, result);

		if (varPath.equals(".")) {
			widget.storeModelToScope(varName, varScope, result);
		} else {
			Object obj = widget.getModelFromScope(varName, varScope);
			widget.updateModelByPath(varPath, result, obj);
		}
	}

	private Object getObject(IWidget widget, String expression) {
		ModelFromScopeHolder modelFromScopeHolder = ModelExpressionParser.parseModelFromScope(expression);			
		String varPath = modelFromScopeHolder.varPath;
		String varName = modelFromScopeHolder.varName;
		ModelScope varScope = modelFromScopeHolder.varScope;
		Object obj = widget.getModelFromScope(varName, varScope);
		obj = widget.getModelByPath(varPath, obj);
		return obj;
	}

	private float getFloat(Object modelVal) {
		float val = 0;
		try {
			val = PluginInvoker.getFloat(modelVal);
		} catch (NumberFormatException e) {
		}
		return val;
	}

	private Object increment(IWidget widget, Object modelVal, Map<String, Object> configMap) {
		float val = getFloat(modelVal);
		float increment = 1;
		if (configMap.containsKey("inc")) {
			increment = getFloat(configMap.get("inc"));
		}
		if (configMap.containsKey("exp_inc")) {
			increment = getFloat(getObject(widget, (String) configMap.get("exp_inc")));
		}
		
		val += increment;
		
		if (configMap.containsKey("max")) {
			float max = getFloat(configMap.get("max"));
			if (val > max) {
				val = max;
			}	
		}
		if (configMap.containsKey("exp_max")) {
			float max = getFloat(getObject(widget, (String) configMap.get("exp_max")));
			if (val > max) {
				val = max;
			}	
		}
		return val;
	}

	private Object decrement(IWidget widget, Object modelVal, Map<String, Object> configMap) {
		float val = getFloat(modelVal);
		float decrement = 1;
		if (configMap.containsKey("dec")) {
			decrement = getFloat(configMap.get("dec"));
		}
		if (configMap.containsKey("dec_inc")) {
			decrement = getFloat(getObject(widget, (String) configMap.get("dec_inc")));
		}
		val -= decrement;
		
		if (configMap.containsKey("min")) {
			float min = getFloat(configMap.get("min"));
			if (val < min) {
				val = min;
			}	
		}
		
		if (configMap.containsKey("exp_min")) {
			float min = getFloat(getObject(widget, (String) configMap.get("exp_min")));
			if (val < min) {
				val = min;
			}
		}
		
		return val;
	}
	
	private Object toggle(IWidget widget, Object modelVal, Map<String, Object> configMap) {
		Boolean val = PluginInvoker.getBoolean(modelVal);		
		return val != null && val ? Boolean.FALSE : Boolean.TRUE;
	}
	

}
