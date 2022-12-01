package com.ashera.converter;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractEnumToIntArrayTest {
	final static class StateListDrawableState extends AbstractEnumToIntArrayConverter {
		private Map<String, Integer> mapping = new HashMap<>();
		{
			mapping.put("state_activated", 0x0);
			mapping.put("state_active", 0x1);
			mapping.put("state_checkable", 0x4);
			mapping.put("state_checked", 0x8);
			mapping.put("state_enabled", 0x10);
			mapping.put("state_first", 0x20);
			mapping.put("state_focused", 0x40);
			mapping.put("state_last", 0x80);
			mapping.put("state_middle", 0x100);
			mapping.put("state_pressed", 0x200);
			mapping.put("state_selected", 0x400);
			mapping.put("state_single", 0x800);
			mapping.put("state_window_focused", 0x1000);
		}

		@Override
		public Map<String, Integer> getMapping() {
			return mapping;
		}

		@Override
		public int[] getDefault() {
			return new int[] {};
		}
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvert() {
		StateListDrawableState autoLink = new StateListDrawableState();
		int[] convertFrom = autoLink.convertFrom("state_activated|state_middle", null, null);
		Object convertTo = autoLink.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "state_activated|state_middle");

	}

}
