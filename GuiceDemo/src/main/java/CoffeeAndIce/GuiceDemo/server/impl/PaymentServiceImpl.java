package CoffeeAndIce.GuiceDemo.server.impl;

import javax.inject.Inject;

import com.google.common.cache.Cache;

import CoffeeAndIce.GuiceDemo.server.PaymentService;

public class PaymentServiceImpl implements PaymentService {
	private final Cache<String, String> cache;

	@Inject
	private PaymentServiceImpl(Cache<String, String> cache) {
		super();
		this.cache = cache;
	}

	@Override 
	public void pay(long orderId, long price, Object sessionId) {
	}

	void putCache(String key, String value) {
		cache.put(key, value);
	}
}
