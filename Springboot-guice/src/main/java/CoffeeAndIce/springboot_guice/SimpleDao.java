package CoffeeAndIce.springboot_guice;

import org.springframework.stereotype.Component;

/**
 * 模拟Dao，但是不做真操作
 * @author lg
 *
 */
@Component //componentScan会注册他
public class SimpleDao {
	public void save(String data){
		System.out.println("data:"+data);
	};
}
