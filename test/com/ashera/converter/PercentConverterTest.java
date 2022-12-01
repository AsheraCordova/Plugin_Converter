package com.ashera.converter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PercentConverterTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvert() {
		PercentConverter converter = new PercentConverter();
		Float convertFrom = converter.convertFrom("100%", null, null);
		Assert.assertEquals(convertFrom.floatValue(), 1.0f, 0);
		Object convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "100%");
		
		convertFrom = converter.convertFrom(null, null, null);
		convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, null);
	}
}
