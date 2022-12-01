package com.ashera.converter;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbstractEnumToIntConverterTest {
	final static class AutoLink extends AbstractEnumToIntConverter {
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
			return AbstractEnumToIntConverter.DEFAULT_UNKNOWN;
		}
	}
	
	final static class MarqueeRepeatLimit extends AbstractEnumToIntConverter {
		private Map<String, Integer> mapping = new HashMap<>();
		{
			mapping.put("marquee_forever", 0xffffffff);
		}

		@Override
		public Map<String, Integer> getMapping() {
			return mapping;
		}

		@Override
		public Integer getDefault() {
			return 0;
		}

		@Override
		public boolean supportsIntAlso() {
			return true;
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
		
		convertFrom = autoLink.convertFrom(null, null, null);
		convertTo = autoLink.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, null);
		
		convertFrom = autoLink.convertFrom("web|email", null, null);
		convertTo = autoLink.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, null);
		
		MarqueeRepeatLimit marqueeRepeatLimit = new MarqueeRepeatLimit();
		convertFrom = marqueeRepeatLimit.convertFrom("marquee_forever", null, null);
		convertTo = marqueeRepeatLimit.convertTo(convertFrom, null);
		System.out.println(convertFrom + " " + convertTo);

	}

}
