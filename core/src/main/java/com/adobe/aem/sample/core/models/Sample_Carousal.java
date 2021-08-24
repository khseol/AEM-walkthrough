package com.adobe.aem.sample.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables= Resource.class,
		resourceType =Sample_Carousal.RESOURCE_TYPE,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Sample_Carousal {

	protected final static String RESOURCE_TYPE  = "sample/components/sample-carousal";
	
	
}
