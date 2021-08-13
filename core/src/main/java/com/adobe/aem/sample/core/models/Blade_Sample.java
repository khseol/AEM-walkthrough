package com.adobe.aem.sample.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


/**
 * 
 * @author kathyhseol
 *	to complications with the multifields in granite and coral, the content.xml structure for the dialog
 *will no longer contain a multifield.
 */
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL) //declared the class a SLING MODEL
public class Blade_Sample {

	@ValueMapValue
	private String bladetitle;
	@ValueMapValue
	private String content;
	
	@ValueMapValue
	private String fileReference;
	@ValueMapValue
	private String fileReference2;
	@ValueMapValue
	private String fileReference3;
	
	public String getBladetitle() {
		return bladetitle;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getFileReference() {
		return fileReference;
	}
	
	public String getFileReference2() {
		return fileReference2;
	}
	
	public String getFileReference3() {
		return fileReference3;
	}
	
}
