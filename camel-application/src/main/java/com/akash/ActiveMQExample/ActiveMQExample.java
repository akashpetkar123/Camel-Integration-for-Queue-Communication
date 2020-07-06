package com.akash.ActiveMQExample;

import javax.jms.ConnectionFactory;

import org.apache.activemq.camel.CamelConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class ActiveMQExample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		CamelContext ctx=new DefaultCamelContext();
		
		ConnectionFactory cfact=new ActiveMQConnectionFactory();
		ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(cfact));
		
		ctx.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("file:ipbox?noop=true")
				.to("jms:queue:testQueue");
				//.to("file:D://opbox");
			}
		});
		
		while(true)
			ctx.start();
	}

}
