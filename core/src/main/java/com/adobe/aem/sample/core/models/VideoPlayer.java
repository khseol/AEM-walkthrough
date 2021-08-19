package com.adobe.aem.sample.core.models;

import org.apache.sling.api.resource.Resource; 
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, 
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class VideoPlayer {
	protected static final String RESOURCE_TYPE = "sample/components/video-player";
	
	@ValueMapValue
	private String videotitle;
	
	@ValueMapValue
	private String link;
	
	
	public String getVideotitle() {
		return videotitle;
	}
	
	public String getLink() {
		return link;
	}

}
