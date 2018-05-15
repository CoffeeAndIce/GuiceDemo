package CoffeeAndIce.GuiceDemo.server.impl;

import java.util.Set;

import javax.inject.Inject;

import com.google.common.cache.Cache;

import CoffeeAndIce.GuiceDemo.server.PriceService;

public class PriceServiceImpl implements PriceService {
	private  Set<String> supportedCurrenties;
	private final Cache<String,String> cache;
	@Inject
	public PriceServiceImpl(Set<String> supportedCurrenties,
			Cache<String,String> cache) {
		this.supportedCurrenties = supportedCurrenties;
		this.cache = cache;
	}

	String getCache(String key) {
		return cache.getIfPresent(key);// 如果存在获取
	}

	@Override 
	public Long getPrice(long orderId) {
		// TODO Auto-generated method stub
		return 456L;
	}

	@Override
	public Set<String> getSupportCurrenties() {
		return supportedCurrenties;
	}
	
}
