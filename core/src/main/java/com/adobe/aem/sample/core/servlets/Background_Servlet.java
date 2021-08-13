package com.adobe.aem.sample.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.adobe.aem.sample.core.services.Serve_Background;

/**
 * 
 * @author kathyhseol
 *	Servlets are a form of a SERVICE COMPONENT
 *	I will need a Service interface to point to the service
 *
 *	it is bad practice to use sling.servlet.path right now but this will be later
 *cahnged to be using the resource Type
 */
@Component(service = {Servlet.class},property = { "sling.servlet.paths=/bin/backgroundServlet",
"sling.servlet.methods=GET" })
public class Background_Servlet extends  SlingSafeMethodsServlet {
	
	@Reference 
	Serve_Background getCurrentPath;
	
	/**
	 * this is the getMethod that will serve up the current image path.
	 * for now the current image path is the first one: fileReference.
	 */
	
	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws IOException {
		//after running the bundle, it was a sucess.
		response.getWriter().write("inside of Get request");
		String check = request.getParameter("check");
		
		if(check.equals("true")) {
			response.getWriter().write("inside of backend"); //this is returning blank
			//String currentPath = getCurrentPath.getNextImagePath();
			//response.getWriter().write(currentPath); //this is returning blank
		}
		
		
	}

}
