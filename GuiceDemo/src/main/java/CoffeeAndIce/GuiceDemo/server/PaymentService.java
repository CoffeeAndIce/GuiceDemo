package CoffeeAndIce.GuiceDemo.server;

public interface PaymentService {

	void pay(long orderId, long price, Object sessionId);

}
