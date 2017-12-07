package com.brianholman.GetFizzBuzz;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class HttpConnectionTest {
	
	// If this was being hosted externally I would try to use mocking
	// to replicate the external requests
	@Before
	public void testCreateServer() throws IOException {
		HttpConnection.createServer();
	}
	
	@Test
	public void testStopServer() {
		HttpConnection.stopServer();
	}
}
