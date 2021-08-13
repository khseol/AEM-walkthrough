package com.adobe.aem.sample.core.serviceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.adobe.aem.sample.core.models.Blade_Sample;
import com.adobe.aem.sample.core.services.Serve_Background;

@Component(service= {Serve_Background.class})
public class Serve_Background_Impl implements Serve_Background {

	/**
	 * the method will most likely need to be changed to take in the 
	 * boolean value for the sling scheduler: true to serve up the next image to change false otherwise.
	 */
	@Override
	public String getNextImagePath() {
		//for now:
		Blade_Sample component = new Blade_Sample();
		List<String> paths = component.getFileReferences();
		String currentPath= paths.get(0);
		int currentPathIndex = paths.indexOf(currentPath);
		//there will be a conditional statement that will check the current index
		//is there is an index, ++, if the last index -->go back to the first index of the list.
		return currentPath;
	}

}
