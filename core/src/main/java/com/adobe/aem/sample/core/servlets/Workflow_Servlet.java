package com.adobe.aem.sample.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;


/**
 * 
 * @author kathyhseol
 * this is an example of a workflow being TRIGGERED from the back-end.
 * the class is classified as a SERVICE component and extends from the SlingSafeMethodsServlet
 * and the workflow is triggered when accessing the servlet path below and containe the query parameter that leads to the payload
 *
 */
@Component(service = Servlet.class, property = {"sling.servlet.paths=/bin/workflowServlet"})

public class Workflow_Servlet extends SlingSafeMethodsServlet {
	

	private static final long serialVersionUID = -6393283404069809833L;
	//private static final Logger log = LoggerFactory.getLogger(CustomWorkflow.class);
	private final Logger logger = LoggerFactory.getLogger(getClass()); //a log file will be created under the same name as this class.
	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {	
		//to trigger a workflow you need a resource resolver
		final ResourceResolver resolver = request.getResourceResolver(); //the way to get the resource resolver in servlets
		
		String payload = request.getParameter("page"); //the string path of the payload and is obtained as a query paramteter
		
		String status = "workflow executing";
		
		
		//all workflow related API's will be handled in a try-catch block		
		try {
			//access the Worfklow session..import using the granite
			WorkflowSession wfSession = resolver.adaptTo(WorkflowSession.class);
			
			//access the workflow model via the session
			WorkflowModel wfModel = wfSession.getModel("/var/workflow/models/practice-workflow-page-versioning"); //param will hold the aboslute path of the workflow model
			
			//access the workflow data(payload) via the session...The type MUST BE IN ALL CAPS
			//the payload is a page in which the workflow model listens for...in my case:	 /content/sample/us/en    <--the payload
			WorkflowData wfData = wfSession.newWorkflowData("JCR_PATH", payload); //the JCR_Path is the type of the path, 'payload' refers to the payload object used for creating the new WorkflowData instance
			
			//ACTIVATE the workflow USING the session
			//wfSession.startWorkflow(wfModel, wfData);
			
			//this is a debugging method used to get he status of the workflow...uses the getState method to return the state of the workflow as String
			status = wfSession.startWorkflow(wfModel, wfData).getState(); //this should 'running' when the servlet is called
			
			//the servlet is called correctly but the payload is never present when put down as a query parameter.

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().write(status);
	
		
	}

}
