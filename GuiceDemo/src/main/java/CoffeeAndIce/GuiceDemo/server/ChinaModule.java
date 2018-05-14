package CoffeeAndIce.GuiceDemo.server;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ChinaModule extends AbstractModule{

	@Override
	public void configure() {
		// TODO suit China Yuan
		Multibinder.newSetBinder(binder(), String.class)
		.addBinding().toInstance("CNY");
		
	}
	
}
