package CoffeeAndIce.GuiceDemo.server.impl;

import CoffeeAndIce.GuiceDemo.server.PaymentService;

public class PaymentServiceImpl implements PaymentService{

	@Override
	public void pay(long orderId, long price, Object sessionId) {
		System.out.print(orderId+""+price+""+sessionId);
	}

}
