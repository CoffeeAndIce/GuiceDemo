package CoffeeAndIce.GuiceDemo.hellowordDemo;

import java.io.PrintStream;
import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;



public class HelloWorldModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(MyApplet.class).annotatedWith(Names.named("hello")).to(StringWtringApplet.class);
		bind(MyDestination.class).to(PrintStreamWriter.class);
		bind(PrintStream.class).toInstance(System.out);
//		bind(String.class).annotatedWith(OutPut.class).
//		toInstance("hello world");
	}
	@Provides @OutPut String getOutPutString(@Args List<String> args){
		return args.get(0);
	}
}
