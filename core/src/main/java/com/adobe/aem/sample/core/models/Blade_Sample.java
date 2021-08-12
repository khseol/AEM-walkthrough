package com.adobe.aem.sample.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL) //declared the class a SLING MODEL
public class Blade_Sample {

	@ValueMapValue
	private String bladetitle;
	@ValueMapValue
	private String content;
	
	@Inject //this refers to the container field that contains the name "imageList"
	private List<BladeImages> imageList; 
	
	
	public String getBladetitle() {
		return bladetitle;
	}
	
	public String getContent() {
		return content;
	}
	
	public List<BladeImages> getImageList(){
		return imageList;
	}
	
}
