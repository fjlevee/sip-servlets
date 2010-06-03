package org.mobicents.media.server.impl.resource.dtmf;

import org.mobicents.media.Component;
import org.mobicents.media.ComponentFactory;
import org.mobicents.media.server.spi.Endpoint;
import org.mobicents.media.server.spi.ResourceUnavailableException;

/**
 * 
 * @author amit bhayani
 *
 */
public class GeneratorFactory implements ComponentFactory {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Component newInstance(Endpoint endpoint) throws ResourceUnavailableException {
		GeneratorImpl generator = new GeneratorImpl(this.name, endpoint.getTimer());
		generator.setEndpoint(endpoint);
		return generator;
	}

}
