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
