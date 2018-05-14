package CoffeeAndIce.GuiceDemo.hellowordDemo;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class PrintLineModule extends AbstractModule {

	@Override
	public void configure() {
		MapBinder.newMapBinder(binder(),String.class, MyApplet.class)
		.addBinding("println").to(StringWtringApplet.class);
//		bind(MyApplet.class).annotatedWith(Names.named("println")).to(PrintLineApplet.class);
	}

}
