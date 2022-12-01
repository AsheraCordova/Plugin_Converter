package com.ashera.converter;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbstractStringToEnumConverterTest {
	final static class AutoLink extends AbstractStringToEnumConverter {
		private Map<String, Object> mapping = new HashMap<>();
		{
			mapping.put("all", "1");
			mapping.put("email", "2");
			mapping.put("map", "3");
			mapping.put("none","4");
			mapping.put("phone", "5");
			mapping.put("web", "6");
		}

		@Override
		public Map<String, Object> getMapping() {
			return mapping;
		}

		@Override
		public Object getDefault() {
			return null;
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
		AutoLink autoLink = new AutoLink();
		Object convertFrom = autoLink.convertFrom("web", null, null);
		Assert.assertEquals(convertFrom, "6");
		Object convertTo = autoLink.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "web");
		
		convertFrom = autoLink.convertFrom("web|email", null, null);
		convertTo = autoLink.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, null);
		
		convertFrom = autoLink.convertFrom(null, null, null);
		convertTo = autoLink.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, null);
	}

}
