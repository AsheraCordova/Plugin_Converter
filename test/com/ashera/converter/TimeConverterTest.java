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
