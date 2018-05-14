package CoffeeAndIce.GuiceDemo.server;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class GlobalModule extends AbstractModule{

	@Override
	public void configure() {
		// TODO USD,ENY
		Multibinder<String> multibinder = Multibinder.newSetBinder(binder(), String.class);
		multibinder.addBinding().toInstance("USD");
		multibinder.addBinding().toInstance("ENY");
	}

}
