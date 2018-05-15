package CoffeeAndIce.GuiceDemo.hellowordDemo;

import com.google.inject.Guice;
import com.google.inject.Injector;

import CoffeeAndIce.GuiceDemo.Applets;
import CoffeeAndIce.GuiceDemo.hellowordDemo.modules.CommenLineModule;
import CoffeeAndIce.GuiceDemo.hellowordDemo.modules.MainModule;

/**
 * bootstrap parse commend line use set up enviroment kicf off main logic
 * 
 * @param args
 * @author lg
 *
 */
public class App {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(
				new MainModule(),
				new CommenLineModule(args));
		
		Applets.get(injector,args).run();
	}

}
