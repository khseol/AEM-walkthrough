package com.adobe.aem.sample.core.services;

import java.io.StringWriter;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.sling.models.export.spi.ModelExporter;
import org.apache.sling.models.factory.ExportException;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service= ModelExporter.class)
public class BladeXmlExporter implements ModelExporter {

	private static final Logger log = LoggerFactory.getLogger(BladeXmlExporter.class);
	/**
	 * method that provides the content to sling model framework to export.
	 * most important method to implement
	 * 
	 * below is the implemented code that exports the content in XML format
	 * 
	 * Three apis are imported:
	 * StringWriter --> 	A character stream that COLLECTS its output in a STRING BUFFER, which can then be used to CONSTRUCT A STRING
	 * JAXBContext --> 		provides the client's entry point to the JAXB API. It provides an abstraction for managing the XML/Java binding 
	 * 						information necessary to implement the JAXB binding framework operations: unmarshal, marshal and validate.
	 * Marshaller --> 		responsible for governing the process of serializing Java content trees back into XML data
	 */
	@Override
	public <T> T export(Object arg0, Class<T> arg1, Map<String, String> arg2) throws ExportException {
		StringWriter write = new StringWriter();
		try {
			JAXBContext jaxb = JAXBContext.newInstance(arg0.getClass());
			Marshaller marshall = jaxb.createMarshaller();
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshall.marshal(arg0, write);
			
		}catch(JAXBException e){
			log.info("\n Marshall ERROR: {}", e.getMessage());
		}
		
		return (T)write.toString();
	}

	/**
	 * defines the NAME OF THE CUSTOM SLING MODEL EXPORTER
	 * so...whenever you want to use the exporter, refer it the return value name.
	 */
	@Override
	public String getName() {
		 
		return "VideoPlayer-xmlExporter"; //use this name to refer to the name of the custom exporter
	}

	/**
	 * notifies the framework that the custom exporter will 'support' the desired format...ie xml
	 */
	@Override
	public boolean isSupported(Class<?> arg0) {
		
		return true; //changed it from false to true.
	}

}
