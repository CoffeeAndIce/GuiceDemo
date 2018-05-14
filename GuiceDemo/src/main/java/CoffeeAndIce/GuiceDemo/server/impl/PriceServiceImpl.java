package CoffeeAndIce.GuiceDemo.server.impl;

import java.util.Set;

import javax.inject.Inject;

import CoffeeAndIce.GuiceDemo.server.PriceService;

public class PriceServiceImpl implements PriceService {
	private  Set<String> supportedCurrenties;

	@Inject
	public PriceServiceImpl(Set<String> supportedCurrenties) {
		this.supportedCurrenties = supportedCurrenties;
	}

	@Override
	public long getPrice(long orderId) {
		// TODO Auto-generated method stub
		return 456;
	}

	@Override
	public Set<String> getSupportCurrenties() {
		return supportedCurrenties;
	}

}
