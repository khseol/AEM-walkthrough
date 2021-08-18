package com.adobe.aem.sample.core.workflows;

import javax.jcr.Node;
import javax.jcr.Session;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

/**
 * 
 * @author kathyhseol
 * below is a class that will practice creating a custom workflow Process
 * 
 * Big note, You should not inject any of the objects, but rather use the
 * workflow session in order to grab any other objects
 *
 */
@Component(service = WorkflowProcess.class, immediate = true, property = {
		"process.label=Practice_CustomWorkflowProcess",
		Constants.SERVICE_VENDOR +"= Practice custom workflow process",
		Constants.SERVICE_DESCRIPTION +"= A practice implementation of cutsom workflow process"
})
public class Practice_CustomProcess implements WorkflowProcess {

	private final Logger log = LoggerFactory.getLogger(Practice_CustomProcess.class); //a log file will be created under the same name as this class.
	
	
	@Override
	public void execute(WorkItem wItem , WorkflowSession wfSession, MetaDataMap processArguments) throws WorkflowException {
		//all process and code executions are handled inside of TRY-catch blocks
		
		log.info("Executing the custom workflow");
		
		//get the information in the workflow model.
		
		
		try {
			//for all information that is passed in the workflow until it gets to the custom process step, 
			//WorkflowData is getting it information from the WorkItem object; being used to hold and retrieve all of the data that is stored "thus far" and end.
			WorkflowData wfData = wItem.getWorkflowData();
			
			//checks for the payload type
			if(wfData.getPayloadType().equals("JCR_PATH")) {
				//grab the session and adopt the workflow session to a JCR session
				//The JCR session is needed to be able to add properties to the JCR
				//this is achieved from getting the workflow session
				Session session = wfSession.adaptTo(Session.class);
				
				//grab the payload and append "jcr:content" to the end of the payload to GET THE JCR CONTENT NODE of the payload.
				String path = wfData.getPayload().toString() + "/jcr:content"; //method grabs the payload that is stored and configured in the workflow
				
				//the path from the code above is used to convert the path to a jcr NODE
				//using the session and getting the item --> casting the item to a node 
				Node node = (Node) session.getItem(path); //type cast the session to a node
				
				
				//code below is getting the DIALOG properties of the custom workflow
				//the name of the DIALOG properties of the workflow is: "PROCESS_ARGS"
				//this is delimted by using the String's split method
				String[] processArgs = processArguments.get("PROCESS_ARGS","string").toString().split(",");
				
				//the for loop that loops thorough the available process argumnents, assign them to a node property
				//and set the node's properties to the JCR
				for(String workflowArgs : processArgs) {
					String [] args = workflowArgs.split(":"); //because my arguments contain ____:
					String properties = args[0]; //key
					String value = args[1]; //value
					
					if(node != null) {
						node.setProperty(properties, value);
					}
				}
				
				
				//MetaDataMap wfd = wItem.getWorkflow().getWorkflowData().getMetaDataMap();
				log.info("THE CUSTOM WORKFLOW PROCESS IS DONE AND COMPLETE");
			}
			
		} catch (Exception e) {
			log.info("Something went wrong");
			log.error(e.getMessage());
		}
	}

}
