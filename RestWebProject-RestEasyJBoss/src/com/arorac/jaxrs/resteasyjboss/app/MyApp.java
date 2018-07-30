package com.arorac.jaxrs.resteasyjboss.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.arorac.jaxrs.service.PersonServiceImpl;

public class MyApp extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();

	public MyApp() {
		singletons.add(new PersonServiceImpl());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
