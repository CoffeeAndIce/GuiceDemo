package CoffeeIce.GuiceDemo.Server.impl;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;

import CoffeeAndIce.GuiceDemo.server.ServerModule;
import CoffeeAndIce.GuiceDemo.server.impl.SessionManager;


public class SessionManagerTest {
	@Inject private SessionManager sessionManager;
	
	@Before public void setUp() {
		Guice.createInjector(new ServerModule())
		.injectMembers(this);
		
	}
	@Test
	public void test() throws InterruptedException {
		Long sessionId = sessionManager.getSessionId();
		System.out.println(sessionId);
		Thread.sleep(1000);
		Long sessionIdss = sessionManager.getSessionId();
		System.out.println(sessionIdss);
		Assert.assertNotEquals(sessionId.longValue(), sessionIdss.longValue());
	}

}
