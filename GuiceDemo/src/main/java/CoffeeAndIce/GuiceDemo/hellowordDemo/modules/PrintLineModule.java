package CoffeeAndIce.GuiceDemo.hellowordDemo.modules;

import com.google.inject.AbstractModule;

import CoffeeAndIce.GuiceDemo.Applets;
import CoffeeAndIce.GuiceDemo.hellowordDemo.PrintLineApplet;

public class PrintLineModule extends AbstractModule {

	@Override
	public void configure() {
		Applets.register(binder()).named("println")
		.to(PrintLineApplet.class);
	}

}
