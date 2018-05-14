package CoffeeAndIce.GuiceDemo.hellowordDemo.modules;

import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

	@Override
	protected void configure() {
	install(new HelloWorldModule());
	install(new PrintLineModule());
	}

	// @Provides private String getString(){
	// return "hello world";
	// }

}
