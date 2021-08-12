package com.adobe.aem.sample.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * 
 * @author kathyhseol
 *	this is the class that will hold information about the images inside of the JCR
 */
@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BladeImages {
	
	@ValueMapValue
	private String fileReference;

	
	public String getFileReference(){
		return fileReference;
	}
}
