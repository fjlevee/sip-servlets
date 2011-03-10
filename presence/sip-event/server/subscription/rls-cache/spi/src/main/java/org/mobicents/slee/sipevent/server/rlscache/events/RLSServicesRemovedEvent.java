package org.mobicents.slee.sipevent.server.rlscache.events;

import java.util.Set;

import javax.slee.EventTypeID;

import org.mobicents.slee.sipevent.server.rlscache.RLSService;
import org.mobicents.slee.sipevent.server.rlscache.RLSService.Status;
import org.openxdm.xcap.client.appusage.resourcelists.jaxb.EntryType;

public class RLSServicesRemovedEvent extends AbstractEvent {

	/**
	 * IMPORTANT: must sync with the event descriptor data!!!!
	 */
	public static final EventTypeID EVENT_TYPE_ID = new EventTypeID("RLSServicesRemovedEvent","org.mobicents","1.0");
	
	private final String uri;
	private final RLSService.Status oldStatus;
	private final RLSService.Status newStatus;
	private final Set<EntryType> removedEntries;
	
	public RLSServicesRemovedEvent(String uri,RLSService.Status newStatus,Status oldStatus, 
			Set<EntryType> removedEntries) {
		super();
		this.uri = uri;
		this.newStatus = newStatus;
		this.oldStatus = oldStatus;
		this.removedEntries = removedEntries;
	}

	public RLSService.Status getNewStatus() {
		return newStatus;
	}
	
	public RLSService.Status getOldStatus() {
		return oldStatus;
	}
	
	public Set<EntryType> getRemovedEntries() {
		return removedEntries;
	}
		
	public String getUri() {
		return uri;
	}
}
