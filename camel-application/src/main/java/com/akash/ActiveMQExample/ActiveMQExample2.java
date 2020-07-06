package com.akash.ActiveMQExample;

import java.util.Date;

import javax.jms.ConnectionFactory;

import org.apache.activemq.camel.CamelConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class ActiveMQExample2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		CamelContext ctx=new DefaultCamelContext();
		
		ConnectionFactory cfact=new ActiveMQConnectionFactory();
		ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(cfact));
		
		ctx.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("jms:queue:testQueue")
				.to("seda:end");
				//.to("file:D://opbox");
			}
		});
		
		ctx.start();
		
		ConsumerTemplate ctemp=ctx.createConsumerTemplate();
		String msg = ctemp.receiveBody("seda:end",String.class);
		System.out.println(msg);
		
	}

}
