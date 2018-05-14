package CoffeeAndIce.GuiceDemo.server.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.google.inject.Provider;

public class SessionManager {
	private final Provider<Long> SessionIdProvider;

	@Inject
	public SessionManager(@Named("getCurrentTimes") Provider<Long> SessionIdProvider) {
		super();
		this.SessionIdProvider = SessionIdProvider;
	}

	public Long getSessionId() {
		// TODO Auto-generated method stub
		return SessionIdProvider.get();
	}

}
