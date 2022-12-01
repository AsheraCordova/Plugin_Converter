package com.ashera.converter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DimensionConverterTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvert() {
		DimensionConverter converter = new DimensionConverter();
		Integer convertFrom = converter.convertFrom("match_parent", null, new DummyFragment());
		Assert.assertEquals(convertFrom.intValue(), -1);

		Object convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "match_parent");
		
		convertFrom = converter.convertFrom(null, null, new DummyFragment());
		Assert.assertEquals(convertFrom.intValue(), -2);
		convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "wrap_content");

	}
}
