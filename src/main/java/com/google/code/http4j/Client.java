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

package com.google.code.http4j;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author <a href="mailto:guilin.zhang@hotmail.com">Zhang, Guilin</a>
 */
public interface Client {

	Response submit(Request request) throws InterruptedException, IOException, URISyntaxException;

	Response get(String url) throws InterruptedException, IOException, URISyntaxException;

	Response post(String url) throws InterruptedException, IOException, URISyntaxException;
	
	void shutdown();
	
	// configuration methods
	Client useConnectionPool(boolean use);
	
	Client useDNSCache(boolean use);
	
	Client followRedirect(boolean follow);
	
	Client setMaxConnectionsPerHost(int max);
}
