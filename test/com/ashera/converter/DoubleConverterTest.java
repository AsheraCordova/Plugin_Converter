package com.ashera.converter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleConverterTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvert() {
		DoubleConverter converter = new DoubleConverter();
		Double convertFrom = converter.convertFrom("1.1", null, null);
		Object convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, 1.1);
		
		converter = new DoubleConverter();
		convertFrom = converter.convertFrom(1.1, null, null);
		convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, 1.1);
	}
}
