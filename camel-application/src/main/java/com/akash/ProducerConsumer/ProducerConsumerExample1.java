package com.akash.ProducerConsumer;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ProducerConsumerExample1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CamelContext ctx=new DefaultCamelContext();
		
		ctx.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("direct:store")
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						// TODO Auto-generated method stub
						String updatedmsg = exchange.getIn().getBody(String.class);
						updatedmsg = updatedmsg + " - said by Arnold Schwarzenegger";
						exchange.getOut().setBody(updatedmsg);
					}
				})
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
