package com.adobe.aem.sample.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.wcm.core.components.models.Image;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { Byline_Sample.class }, resourceType = {
		Byline_Sample_Impl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Byline_Sample_Impl implements Byline_Sample {
	protected final static String RESOURCE_TYPE = "sample/components/byline-sample"; // a reference to the path of the
																						// component involved.

	// set fields that where they will map to the properties of the component
	// java field name must match exact to the component's properties name

	@ValueMapValue
	private String name;
	@ValueMapValue
	private List<String> occupations;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public List<String> getOccupation() {
		if (occupations != null) { // a null
			Collections.sort(occupations); // a method that sorts the list of occupations in an ascending order.
			return new ArrayList<String>(occupations);
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


}
