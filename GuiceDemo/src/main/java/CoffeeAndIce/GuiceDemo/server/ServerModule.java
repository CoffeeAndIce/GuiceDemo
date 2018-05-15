package CoffeeAndIce.GuiceDemo.server;

import javax.inject.Named;

import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.util.Modules;

import CoffeeAndIce.GuiceDemo.server.impl.GuiceDemoCache;
import CoffeeAndIce.GuiceDemo.server.impl.Logged;
import CoffeeAndIce.GuiceDemo.server.impl.OrderServerImpl;
import CoffeeAndIce.GuiceDemo.server.impl.PaymentServiceImpl;
import CoffeeAndIce.GuiceDemo.server.impl.PriceServiceImpl;
import CoffeeAndIce.GuiceDemo.server.impl.SessionId;

public class ServerModule extends AbstractModule {

	@Override
	protected void configure() {
		//套入其他Module
		install(new ChinaModule());
		install(new GlobalModule());
		
		bind(OrderService.class).to(OrderServerImpl.class);
		bind(PaymentService.class).to(PaymentServiceImpl.class);
		bind(PriceService.class).to(PriceServiceImpl.class);
		bind(new TypeLiteral<Cache<String,String>>(){})
			.to(GuiceDemoCache.class);
		Modules.override(new ChinaModule()).with(new GlobalModule());
		
		LoggedInterceptor loggedInterceptor = 
				new LoggedInterceptor();
		//注入必要参数
		requestInjection(loggedInterceptor);
		
		bindInterceptor(Matchers.any(), 
				Matchers.annotatedWith(Logged.class),
				loggedInterceptor );

	}

	@Provides @Named("getCurrentTimes") Long getCurrentTimeMillis() {// 方式三,名字可以随便起，当且仅当仅一个类型时
		return System.currentTimeMillis();
	}
	@Provides @SessionId Long generateSessionId() {// 方式三,名字可以随便起，当且仅当仅一个类型时
		return System.currentTimeMillis();
	}

}
