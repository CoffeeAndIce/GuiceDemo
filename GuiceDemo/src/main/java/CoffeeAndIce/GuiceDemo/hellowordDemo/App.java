package CoffeeAndIce.GuiceDemo.hellowordDemo;

import com.google.inject.Guice;
import com.google.inject.Key;
import com.google.inject.name.Names;

/**
 * bootstrap parse commend line use set up enviroment kicf off main logic
 * 
 * @param args
 * @author lg
 *
 */
public class App {
	public static void main(String[] args) {
		MyApplet mainApplet = Guice.createInjector(new MainModule(),
				new CommenLineModule(args))
				.getInstance(Key.get(
						MyApplet.class,Names.named(args[0])));
		mainApplet.run();
	}

}
