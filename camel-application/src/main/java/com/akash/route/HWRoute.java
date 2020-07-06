package com.akash.route;

import org.apache.camel.builder.RouteBuilder;

public class HWRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//Test Message
		//System.out.println("Hello Worlds");
		
		//File Copy Example from 1 Folder to Another
		from("file:C://ipbox?noop=true").to("file:D://opbox");
	}

}
