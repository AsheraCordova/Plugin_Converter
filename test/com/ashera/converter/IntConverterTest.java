package com.ashera.converter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntConverterTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvert() {
		IntConverter converter = new IntConverter();
		Integer convertFrom = converter.convertFrom("1", null, null);
		Object convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, 1);
		
		converter = new IntConverter();
		convertFrom = converter.convertFrom(1.1, null, null);
		convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, 1);
	}
}
