package com.brianholman.GetFizzBuzz;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class HttpConnection {
	static HttpServer server;
	
	public static void createServer() throws IOException {
		server = HttpServer.create(new InetSocketAddress(8080), 0);

		server.createContext("/fizzbuzz", new FizzBuzzHandler());
		server.createContext("/stop", new StopServerHandler());
		server.setExecutor(null);
		server.start();
	}
	
	public static void stopServer() {
		server.stop(0);
	}
}