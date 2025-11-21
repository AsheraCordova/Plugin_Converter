//start - license
/*
 * Copyright (c) 2025 Ashera Cordova
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
//end - license
package com.ashera.converter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DimensionFloatConverterTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvert() {
		DimensionFloatConverter converter = new DimensionFloatConverter();
		Float convertFrom = converter.convertFrom("match_parent", null, new DummyFragment());
		Assert.assertEquals(convertFrom.intValue(), -1);

		Object convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "match_parent");
		
		convertFrom = converter.convertFrom(null, null, new DummyFragment());
		Assert.assertEquals(convertFrom.intValue(), -2);
		convertTo = converter.convertTo(convertFrom, null);
		Assert.assertEquals(convertTo, "wrap_content");

	}
}
