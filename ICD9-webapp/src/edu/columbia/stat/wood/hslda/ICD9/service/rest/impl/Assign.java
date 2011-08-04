package edu.columbia.stat.wood.hslda.ICD9.service.rest.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import edu.columbia.stat.wood.hslda.ICD9.service.converter.ICD9CodeConverter;
import edu.columbia.stat.wood.hslda.ICD9.service.model.ICD9Code;

@Path("/assign")
public class Assign {		
	@POST
	@Consumes("text/plain")
	@Produces( { "application/xml", "application/json" })
	public List<ICD9CodeConverter> putText(String body) {

		String text = body; 
		// parse body
		// look up text in dictionary
		// assign topic
		// perform regression
		
		// you have less than thirty seconds to compute and return an arraylist of icd9 codes from here
		
		ArrayList<ICD9CodeConverter> ret = new ArrayList<ICD9CodeConverter>(2);
		ret.add(new ICD9CodeConverter(new ICD9Code("0","Barf")));
		ret.add(new ICD9CodeConverter(new ICD9Code("1","Bag")));
		return ret;
	}

}
