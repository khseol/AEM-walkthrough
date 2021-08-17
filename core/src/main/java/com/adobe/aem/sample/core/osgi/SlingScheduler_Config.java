package com.adobe.aem.sample.core.osgi;


import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "SlingSchedulerConfiguration", description = "Sling scheduler configuration")
public @interface SlingScheduler_Config {

	
	@AttributeDefinition(
			name = "Scheduler name", 
			description = "Name of the scheduler", 
			type = AttributeType.STRING)
	public String schdulerName() default " Practice Custom Sling Scheduler Configuration";

	
	@AttributeDefinition(
			name = "Cron Expression practice", 
			description = "Cron expression used by the scheduler", 
			type = AttributeType.STRING)
	public String cronExpression() default "0 * * * * ?";
	
}
