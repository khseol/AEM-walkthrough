package com.adobe.aem.sample.core.serviceImpl;

import java.nio.file.Paths;
import java.util.ArrayList;
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
	public String getNextImagePath(String currentPath, List<String> fileReferences) {
		//for now:
		int currentPathIndex = fileReferences.indexOf(currentPath);
		String nextPath = fileReferences.get(currentPathIndex); //for now it should only be the first one...
		//there will be a conditional statement that will check the current index
		//is there is an index, ++, if the last index -->go back to the first index of the list.
		return nextPath;
	}

}
