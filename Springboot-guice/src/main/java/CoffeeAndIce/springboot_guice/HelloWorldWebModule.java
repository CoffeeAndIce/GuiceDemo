package CoffeeAndIce.springboot_guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

import CoffeeAndIce.GuiceDemo.hellowordDemo.MyApplet;
import CoffeeAndIce.GuiceDemo.hellowordDemo.MyDestination;
import CoffeeAndIce.GuiceDemo.hellowordDemo.StringWtringApplet;
import CoffeeAndIce.GuiceDemo.hellowordDemo.binds.OutPut;

public class HelloWorldWebModule extends AbstractModule {


	@Override
	public void configure() {
		install(new ServletModule());
		bind(MyApplet.class).to(StringWtringApplet.class);
		bind(MyDestination.class).to(WebDestination.class);
	}
	
	@Provides @OutPut String getOutputString(RequestParams requestParams){
		return requestParams.getMessage();
	}
}
