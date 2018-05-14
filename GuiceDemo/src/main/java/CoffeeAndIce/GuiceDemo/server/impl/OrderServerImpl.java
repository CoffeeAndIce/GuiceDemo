package CoffeeAndIce.GuiceDemo.server.impl;

import javax.inject.Inject; //引用javax的是因为guice已经对其进行实现

import CoffeeAndIce.GuiceDemo.server.OrderService;
import CoffeeAndIce.GuiceDemo.server.PaymentService;
import CoffeeAndIce.GuiceDemo.server.PriceService;


public class OrderServerImpl implements OrderService {
	
	//Dependencies
	private final PriceService priceService;
	private final PaymentService paymentService;
	private final SessionManager sessionManager;

	//States
	private Long ordersPaid = 0L;

	@Inject 
	public OrderServerImpl(PriceService priceService,
			PaymentService paymentService,
			SessionManager sessionManager) {
		super();
		this.priceService = priceService;
		this.paymentService = paymentService;
		this.sessionManager = sessionManager;
	}

	public void sendToPayment(long orderId) {
		long price = priceService.getPrice(orderId);
		paymentService.pay(orderId, price, sessionManager.getSessionId());
		ordersPaid = ordersPaid + 1;
		throw new RuntimeException("Price" + price
				+ ".SessionId=" + sessionManager.getSessionId()
				+ ".orderPaid=" + ordersPaid);
	}
}
