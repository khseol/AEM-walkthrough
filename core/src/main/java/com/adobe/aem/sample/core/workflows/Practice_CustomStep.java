package com.adobe.aem.sample.core.workflows;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import javax.jcr.Node;
import javax.jcr.Session;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = WorkflowProcess.class, 
			property = {
					"process.label = Practice Custom Worflow Step",
					Constants.SERVICE_VENDOR + "=Practice custom workflow process",
					Constants.SERVICE_DESCRIPTION + "=practice on creating a custom workflow step"
	
})
public class Practice_CustomStep implements WorkflowProcess {

	//created a logger that will track the changes in the log file.
	private final Logger log = LoggerFactory.getLogger(Practice_CustomStep.class);
	
	@Override
	public void execute(WorkItem wItem , WorkflowSession wfSession, MetaDataMap processArguments) throws WorkflowException {
		log.info("\n******************************CUSTOM WORKFLOW STEP********************************************");
		
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
				String name = processArguments.get("NAME","");
				boolean multinational = processArguments.get("MULTINATIOAL", false);
				
				//MetaDataMap wfd = wItem.getWorkflow().getWorkflowData().getMetaDataMap(); //information will be displayed in log file

			    log.info("\n NAME : {} , MULTINATIONAL : {}", name, multinational);
			
			}
			
		} catch (Exception e) {
			//it keeps saying my process resource is null...but i don't know what that means
			log.info("Something went wrong");
			log.error(e.getMessage());
		}
		
	}

}
