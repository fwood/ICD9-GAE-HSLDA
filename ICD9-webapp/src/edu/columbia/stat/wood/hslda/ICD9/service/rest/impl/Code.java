package edu.columbia.stat.wood.hslda.ICD9.service.rest.impl;

import java.util.Map;

import javax.ws.rs.Consumes;
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

@Path("/icd9/")
public class Code {
	@GET
	@Produces( { "application/xml", "application/json" })
	@Path("/{code}/")
	public ICD9CodeConverter getJSON(@PathParam("code") String code) {
		// ICD9Code codeObject = new ICD9Code();
		// codeObject.setCode((new Integer((new
		// Integer(dischargeSummary))+1).toString()));

		// Look up code in store of codes;
		Key key = KeyFactory.createKey("IDC9Code", code);
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Entity codeEntity;
		try {
			codeEntity = datastore.get(key);
			ICD9Code codeObject = new ICD9Code();
			Map<String, Object> list = codeEntity.getProperties();

			codeObject.setCode((String) list.get("code"));
			codeObject.setText((String) list.get("text"));

			ICD9CodeConverter converter = new ICD9CodeConverter(codeObject);
			return converter;
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	
	@GET
	@Produces( { "text/plain" })
	@Path("/{code}/")
	public String getText(@PathParam("code") String code) {
		// ICD9Code codeObject = new ICD9Code();
		// codeObject.setCode((new Integer((new
		// Integer(dischargeSummary))+1).toString()));

		// Look up code in store of codes;
		Key key = KeyFactory.createKey("IDC9Code", code);
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Entity codeEntity;
		try {
			codeEntity = datastore.get(key);
			ICD9Code codeObject = new ICD9Code();
			Map<String, Object> list = codeEntity.getProperties();

			codeObject.setCode((String) list.get("code"));
			return (String) list.get("text");

		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	
    // used to load data into app store; however this is pointedly unsecure
	// and thus removed from the code base
	/*@PUT 
	@Path("/{code}/")
	@Consumes("text/plain")
	public void putText(@PathParam("code") String code, String body) {

		Key key = KeyFactory.createKey("IDC9Code", code);
		String text = body; // get the text from the query somehow
									// req.getParameter("content");
		// Places the greeting in the same entity group as the guestbook
		Entity codeEntity = new Entity(key);
		codeEntity.setProperty("code", code);
		codeEntity.setProperty("text", text);

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		datastore.put(codeEntity);

	}*/

}
