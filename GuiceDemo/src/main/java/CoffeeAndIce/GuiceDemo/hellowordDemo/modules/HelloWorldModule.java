package CoffeeAndIce.GuiceDemo.hellowordDemo.modules;

import java.io.PrintStream;
import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import CoffeeAndIce.GuiceDemo.Applets;
import CoffeeAndIce.GuiceDemo.hellowordDemo.MyDestination;
import CoffeeAndIce.GuiceDemo.hellowordDemo.PrintStreamWriter;
import CoffeeAndIce.GuiceDemo.hellowordDemo.StringWtringApplet;
import CoffeeAndIce.GuiceDemo.hellowordDemo.binds.Args;
import CoffeeAndIce.GuiceDemo.hellowordDemo.binds.OutPut;



public class HelloWorldModule extends AbstractModule {
	@Override
	protected void configure() {
		Applets.register(binder()).named("hello")
		.to(StringWtringApplet.class);
		
		bind(MyDestination.class).to(PrintStreamWriter.class);
		bind(PrintStream.class).toInstance(System.out);
	}
	@Provides @OutPut String getOutPutString(@Args List<String> args){
		return args.get(0);
	}
}
