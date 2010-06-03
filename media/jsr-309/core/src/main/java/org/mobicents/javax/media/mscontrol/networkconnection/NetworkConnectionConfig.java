package org.mobicents.javax.media.mscontrol.networkconnection;

import java.util.HashSet;
import java.util.Set;

import javax.media.mscontrol.EventType;
import javax.media.mscontrol.MediaObject;
import javax.media.mscontrol.MediaSession;
import javax.media.mscontrol.Parameter;
import javax.media.mscontrol.Parameters;
import javax.media.mscontrol.Qualifier;
import javax.media.mscontrol.Value;
import javax.media.mscontrol.networkconnection.SdpPortManagerEvent;
import javax.media.mscontrol.resource.Action;
import javax.media.mscontrol.resource.Trigger;

import org.mobicents.javax.media.mscontrol.MediaSessionImpl;
import org.mobicents.javax.media.mscontrol.ParametersImpl;
import org.mobicents.javax.media.mscontrol.resource.ExtendedParameter;

/**
 * 
 * @author amit bhayani
 * 
 */
public final class NetworkConnectionConfig {

	private final ParametersImpl parametersImpl;
	private final Set<EventType> eventTypes;
	private final Set<Qualifier> qualifiers;
	private final Set<Trigger> triggers;
	private final Set<Value> values;
	private final Set<Action> actions;
	
	private NetworkConnectionConfig(boolean clone) {
		parametersImpl = new ParametersImpl();
		eventTypes = new HashSet<EventType>();
		qualifiers = new HashSet<Qualifier>();
		triggers = new HashSet<Trigger>();
		values = new HashSet<Value>();
		actions = new HashSet<Action>();
	}

	public NetworkConnectionConfig() {

		this.parametersImpl = new ParametersImpl();
		this.parametersImpl.put(ExtendedParameter.ENDPOINT_LOCAL_NAME, "/mobicents/media/packetrelay/$");
		this.parametersImpl.put(MediaObject.MEDIAOBJECT_ID, Parameters.NO_PARAMETER);
		this.parametersImpl.put(MediaSession.TIMEOUT, MediaSessionImpl.SESSION_TIMEOUT);

		actions = new HashSet<Action>();

		eventTypes = new HashSet<EventType>();
		eventTypes.add(SdpPortManagerEvent.OFFER_GENERATED);
		eventTypes.add(SdpPortManagerEvent.ANSWER_GENERATED);
		eventTypes.add(SdpPortManagerEvent.ANSWER_PROCESSED);
		eventTypes.add(SdpPortManagerEvent.NETWORK_STREAM_FAILURE);

		qualifiers = new HashSet<Qualifier>();
		triggers = new HashSet<Trigger>();
		values = new HashSet<Value>();
	}

	protected ParametersImpl getParametersImpl() {
		ParametersImpl newparams = new ParametersImpl();
		newparams.putAll(this.parametersImpl);
		return newparams;
	}

	protected void setParametersImpl(Parameters params) {
		for (Parameter p : params.keySet()) {
			for (Parameter actual : this.parametersImpl.keySet()) {
				if (p == actual) {
					this.parametersImpl.put(actual, params.get(actual));
				}
			}
		}
	}

	public Set<Parameter> getParameters() {
		return parametersImpl.keySet();
	}

	public Set<EventType> getEventTypes() {
		return eventTypes;
	}

	public Set<Qualifier> getQualifiers() {
		return qualifiers;
	}

	public Set<Trigger> getTriggers() {
		return triggers;
	}

	public Set<Value> getValues() {
		return values;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public NetworkConnectionConfig createCustomizedClone(Parameters params) {
		NetworkConnectionConfig clone = new NetworkConnectionConfig(true);
		
		 clone.parametersImpl.putAll(this.parametersImpl);
		 clone.eventTypes.addAll(this.eventTypes);
		 clone.qualifiers.addAll(this.qualifiers);
		 clone.triggers.addAll(this.triggers);
		 clone.values.addAll(this.values);
		 clone.actions.addAll(this.actions);
		
		if (params != null && params != Parameters.NO_PARAMETER) {
			for (Parameter p : clone.parametersImpl.keySet()) {
				for (Parameter pArg : params.keySet()) {
					if (p == pArg) {
						clone.parametersImpl.put(pArg, params.get(pArg));
					}
				}
			}
		}

		return clone;
	}

}
