package com.brianholman.GetFizzBuzz;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class StopServerHandler implements HttpHandler{

	public void handle(HttpExchange t) throws IOException {
		HttpConnection.stopServer();
	}
}