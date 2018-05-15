package CoffeeAndIce.GuiceDemo.server;

import java.util.Set;

public interface PriceService {

	Set<String> getSupportCurrenties();

	Long getPrice(long orderId);

}
