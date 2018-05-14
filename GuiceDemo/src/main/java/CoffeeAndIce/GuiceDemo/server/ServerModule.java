package CoffeeAndIce.GuiceDemo.server;

import javax.inject.Named;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.util.Modules;

import CoffeeAndIce.GuiceDemo.server.impl.OrderServerImpl;
import CoffeeAndIce.GuiceDemo.server.impl.PaymentServiceImpl;
import CoffeeAndIce.GuiceDemo.server.impl.PriceServiceImpl;

public class ServerModule extends AbstractModule {

	@Override
	protected void configure() {
		//套入其他Module
		install(new ChinaModule());
		install(new GlobalModule());
		
		bind(OrderService.class).to(OrderServerImpl.class);
		bind(PaymentService.class).to(PaymentServiceImpl.class);
		bind(PriceService.class).to(PriceServiceImpl.class);
		Modules.override(new ChinaModule()).with(new GlobalModule());
//		bind(new TypeLiteral<List<String>>(){})
//		.annotatedWith(Names.named("getCurrentTimes"))
//		.toInstance(Arrays.asList("CNY","ENR","USD"));
//		 bind(Long.class).annotatedWith(SessionId.class).toInstance(1234L);;//方式一
		// bind(Long.class).annotatedWith(SessionId.class).toProvider(new
		// Provider<Long>() {//方式二
		//
		// @Override
		// public Long get() {
		// return 1234L;
		// }
		// });
	}

	@Provides @Named("getCurrentTimes") Long generateSessionId() {// 方式三,名字可以随便起，当且仅当仅一个类型时
		return System.currentTimeMillis();
	}

}
