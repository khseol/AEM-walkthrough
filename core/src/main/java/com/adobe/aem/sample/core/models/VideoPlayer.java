package com.adobe.aem.sample.core.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.sling.api.resource.Resource; 
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author kathyhseol
 * sling model for the video player component
 * sling mode will be used to test and demonstrate the export the content as a service in XML format
 * name of the exporter annotation refers to the NAME defined in from the XML exporter service (inside of the service 
 * package of same module)
 * 
 * JAXB requires a specific set of annotations to be used to export in xml format
 * XmlElement (annotation) --> is the annotation required to export the method's content in xml format.
 * 								can be used over the method as well as the model's properties(most PRFERRED to be on METHODS)
 * 
 *Because this is custom, you must add in everything required for this custom exporter.
 *so you must provide annotations to EVERYTHING...
 * 
 * the class will need a root element annotaion for XML
 */
@Model(adaptables = Resource.class, 
		resourceType = VideoPlayer.RESOURCE_TYPE,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "VideoPlayer-xmlExporter", extensions = "xml") 
@XmlRootElement(name = "Video-Player-Exporter")
public class VideoPlayer {
	protected static final String RESOURCE_TYPE = "sample/components/video-player";
	private static final Logger log = LoggerFactory.getLogger(VideoPlayer.class);
	
	@ValueMapValue
	private String videotitle;
	
	@ValueMapValue
	private String link;
	
	
	@XmlElement(name = "Video-Title")
	public String getVideotitle() {
		return videotitle;
	}
	@XmlElement
	public String getLink() {
		return link;
	}
	
	//this is not mapped to anything but can still be exposed in xml format with the use of the annotation
	@XmlElement
	public String getAuthor() {
		return "Kathy";
	}

}
