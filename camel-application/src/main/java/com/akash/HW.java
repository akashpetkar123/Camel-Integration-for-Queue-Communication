package com.akash;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.akash.route.HWRoute;

public class HW {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CamelContext ctx=new DefaultCamelContext();
		HWRoute builder=new HWRoute();
		ctx.addRoutes(builder);
		
		while(true)
			ctx.start();
	}

}
