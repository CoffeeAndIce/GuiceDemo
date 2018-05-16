package CoffeeAndIce.springboot_guice;


import org.springframework.context.ApplicationContext;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class SpringAwareModule extends AbstractModule {
	private final ApplicationContext context;

	public SpringAwareModule(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public void configure() {
		bind(ApplicationContext.class).toInstance(context);
	}

	@Provides SimpleDao getSimpleDao(ApplicationContext context){
		return context.getBean(SimpleDao.class);
	}
}
