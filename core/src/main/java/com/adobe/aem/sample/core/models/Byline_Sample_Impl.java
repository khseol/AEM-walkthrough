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
import org.apache.sling.models.factory.ModelFactory;
import com.adobe.cq.wcm.core.components.models.Image;

import org.apache.sling.models.annotations.injectorspecific.OSGiService;

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

	private Image image; // Best practice approach uses the @Self annotation to
							// automatically adapt the current request to the Core Component’s Image.class
							// but for learning purposes, the resources are converted into a Core Component
							// image sling model

	@OSGiService
	private ModelFactory modelFactory;
	@Self
	private SlingHttpServletRequest request;

	@PostConstruct
	private void init() {
		image = modelFactory.getModelFromWrappedRequest(request, request.getResource(), Image.class);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * The getOccupation will implement a business logic that sorts the occupations
	 */
	@Override
	public List<String> getOccupation() {
		if (occupations != null) { // a null check
			Collections.sort(occupations); // a method that sorts the list of occupations in an ascending order, by use
											// of the Collections API
			return new ArrayList<String>(occupations);
		} else {
			return Collections.emptyList(); // return the list as empty is there is no content in the occupations list
		}
	}

	/**
	 * The method that should consider the component to rendered: checking to see if
	 * any of the fields of the model is empty.
	 * 
	 * return true when one or more of the fields are null return false if all
	 * fields are populated
	 * 
	 * checking the presence of image, using the best practice approach -- checking
	 * fileReference JCR property resolves to an asset
	 */
	@Override
	public boolean isEmpty() {
		if (StringUtils.isEmpty(name)) {
			return true;
		} else if (occupations == null || occupations.isEmpty()) {
			return true;
		} else if (image == null || StringUtils.isBlank(image.getSrc())) { //null check for the image component.
			return true;
		} else {
			// Everything is populated, so this component is not considered empty
			return false;
		}
	}

	private Image getImage() {
        return image;
    }
	
}
