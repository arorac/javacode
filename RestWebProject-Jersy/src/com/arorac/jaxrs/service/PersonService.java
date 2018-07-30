package com.arorac.jaxrs.service;

import com.arorac.jaxrs.model.Person;
import com.arorac.jaxrs.model.Response;

public interface PersonService {

	public Response addPerson(Person p);
	
	public Response deletePerson(int id);
	
	public Person getPerson(int id);
	
	public Person[] getAllPersons();

}