package CoffeeAndIce.GuiceDemo.hellowordDemo;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class PrintLineModule extends AbstractModule {

	@Override
	public void configure() {
		bind(MyApplet.class).annotatedWith(Names.named("println")).to(PrintLineApplet.class);
	}

}
