/**
 * Copyright (C) 2010 Zhang, Guilin <guilin.zhang@hotmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.code.http4j.utils;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @author <a href="mailto:guilin.zhang@hotmail.com">Zhang, Guilin</a>
 */
public final class LongCounterTestCase {
	private Counter<Long> counter;
	
	@BeforeClass
	public void beforeClass() {
		counter = new LongCounter();
	}

	@Test
	public void get() {
		long number = counter.get();
		Assert.assertEquals(number, 0);
	}
	
	@Test(dependsOnMethods = "get")
	public void increase() {
		counter.addAndGet(0L);
		long number = counter.get();
		Assert.assertEquals(number, 0);
		counter.addAndGet(1048576L);
		number = counter.get();
		Assert.assertEquals(number, 1048576L);
		counter.addAndGet(-13L);
		number = counter.get();
		Assert.assertEquals(number, 1048576L - 13);
	}
	
	@Test(dependsOnMethods = "increase")
	public void reset() {
		counter.reset();
		long number = counter.get();
		Assert.assertEquals(number, 0);
	}
}
