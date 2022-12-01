package com.ashera.converter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimeConverterTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvert() {
		TimeConverter converter = new TimeConverter();
		Integer convertFrom = converter.convertFrom("1s", null, null);
		Assert.assertEquals(convertFrom.floatValue(), 1000.0f, 0);
		Object convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "1s");
		
		convertFrom = converter.convertFrom(null, null, null);
		convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, null);
	}
}
