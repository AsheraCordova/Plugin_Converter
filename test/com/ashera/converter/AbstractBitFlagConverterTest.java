package com.ashera.converter;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractBitFlagConverterTest {
	final static class AutoLink extends AbstractBitFlagConverter {
		private Map<String, Integer> mapping = new HashMap<>();
		{
			mapping.put("all", 0xf);
			mapping.put("email", 0x2);
			mapping.put("map", 0x8);
			mapping.put("none", 0x0);
			mapping.put("phone", 0x4);
			mapping.put("web", 0x1);
		}

		@Override
		public Map<String, Integer> getMapping() {
			return mapping;
		}

		@Override
		public Integer getDefault() {
			return 0;
		}
	}
	
	final static class RequiresFadingEdge extends AbstractBitFlagConverter {
		private Map<String, Integer> mapping = new HashMap<>();
		{
			mapping.put("horizontal", 0x1000);
			mapping.put("none", 0x0);
			mapping.put("vertical", 0x2000);
		}

		@Override
		public Map<String, Integer> getMapping() {
			return mapping;
		}

		@Override
		public Integer getDefault() {
			return 0;
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
		Integer convertFrom = autoLink.convertFrom("web", null, null);
		Object convertTo = autoLink.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "web");
		
		convertFrom = autoLink.convertFrom("web|email", null, null);
		convertTo = autoLink.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "web|email");
		
		convertFrom = autoLink.convertFrom(null, null, null);
		convertTo = autoLink.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "none");
		
		RequiresFadingEdge requiresFadingEdge = new RequiresFadingEdge();
		convertFrom = requiresFadingEdge.convertFrom("horizontal", null, null);
		convertTo = requiresFadingEdge.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "horizontal");
	}

}
