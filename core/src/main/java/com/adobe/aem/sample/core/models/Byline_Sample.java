package com.adobe.aem.sample.core.models;

import java.util.List;

/**
 * This is the interface that will represent the Byline Component in my sample project while doing the tutorial
 */
	
public interface Byline_Sample {
	/**
	 * @return expose the values for the name and occupations for the Byline component.
	 */
	String getName();
	
	List<String> getOccupation();
	
	/**
	 * isEmpty() method is used to determine if the component has any content to render 
	 * or if it is waiting to be configured.
	 */
	boolean isEmpty();
}
