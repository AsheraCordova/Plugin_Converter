package com.ashera.converter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BooleanConverterTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvert() {
		BooleanConverter converter = new BooleanConverter();
		Boolean convertFrom = converter.convertFrom("no", null, null);
		Object convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, false);
		
		convertFrom = converter.convertFrom(null, null, null);
		convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, false);
		
		convertFrom = converter.convertFrom("yes", null, null);
		convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, true);
	}
}
