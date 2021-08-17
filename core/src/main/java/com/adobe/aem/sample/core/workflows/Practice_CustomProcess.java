package com.adobe.aem.sample.core.workflows;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

/**
 * 
 * @author kathyhseol
 * below is a class that will practice creating a custom workflow Process
 * 
 *
 */
@Component(service = WorkflowProcess.class, immediate = true, property = {
		"process.label=Practice_CustomWorkflowProcess",
		Constants.SERVICE_VENDOR +"= Practice custom workflow process",
		Constants.SERVICE_DESCRIPTION +"= A practice implementation of cutsom workflow process"
})
public class Practice_CustomProcess implements WorkflowProcess {

	@Override
	public void execute(WorkItem wItem , WorkflowSession wfSession, MetaDataMap processArguments) throws WorkflowException {
		
	}

}
