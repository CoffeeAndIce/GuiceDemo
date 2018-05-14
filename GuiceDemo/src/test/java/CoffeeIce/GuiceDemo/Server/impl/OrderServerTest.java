package CoffeeIce.GuiceDemo.Server.impl;

import java.util.Set;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.util.Modules;

import CoffeeAndIce.GuiceDemo.server.OrderService;
import CoffeeAndIce.GuiceDemo.server.PriceService;
import CoffeeAndIce.GuiceDemo.server.ServerModule;
import CoffeeAndIce.GuiceDemo.server.impl.PriceServiceImpl;


class PriceServiceMock extends PriceServiceImpl{
	@Inject
	public PriceServiceMock(Set<String> supportedCurrienties) {
		super(supportedCurrienties);
	}

	public long getPrice(long orderId) {
		return 5678999L;
	}

}

public class OrderServerTest {
	@Inject private OrderService orderService;
	@Inject private PriceService priceService;
	
	@Before
	public void SetUp() {
		//利用injectMembers，将当前所需的类具现化
		Guice.createInjector(Modules.override(new ServerModule())
				.with(
				new AbstractModule() {
					
					@Override
					public void configure() {
						bind(PriceServiceImpl.class)
							.to(PriceServiceMock.class);
					}
				}
				)).injectMembers(this);
	}
	@Test
	public void testSendToPayment() {
//		旧方法，将所需的类具现化
//		OrderService orderService = Guice.createInjector(new ServerModule())
//		.getInstance(OrderService.class);
		
		orderService.sendToPayment(789L);
	}
	
	@Test
	public void tesOrderCurrenties(){
		throw new RuntimeException(
		priceService.getSupportCurrenties().toString()
		);
	}

}
