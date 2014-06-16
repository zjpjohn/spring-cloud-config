/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.platform.config.server;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.platform.config.Environment;


/**
 * @author Dave Syer
 *
 */
public class SpringApplicationEnvironmentRepositoryTests {
	
	private SpringApplicationEnvironmentRepository repository = new SpringApplicationEnvironmentRepository();

	@Test
	public void vanilla() {
		Environment environment = repository.findOne("foo", "development", "master");
		assertEquals(2, environment.getPropertySources().size());
	}

	@Test
	public void prefixed() {
		repository.setSearchLocations("classpath:/test");
		Environment environment = repository.findOne("foo", "development", "master");
		assertEquals(3, environment.getPropertySources().size());
	}

	@Test
	public void prefixedWithFile() {
		repository.setSearchLocations("file:./src/test/resources/test");
		Environment environment = repository.findOne("foo", "development", "master");
		assertEquals(3, environment.getPropertySources().size());
	}

}
