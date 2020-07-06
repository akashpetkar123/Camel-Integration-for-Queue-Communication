package com.akash.ProducerConsumer;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ProducerConsumerExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CamelContext ctx=new DefaultCamelContext();
		
		ctx.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("direct:store")
				.to("seda:get");
			}
			
		});
		
		ctx.start();
		
		ProducerTemplate ptemp=ctx.createProducerTemplate();
		ptemp.sendBody("direct:store", "HI I AM BACK");
		
		ConsumerTemplate ctemp=ctx.createConsumerTemplate();
		String msg = ctemp.receiveBody("seda:get",String.class);
		
		System.out.println(msg);
	}

}
