package CoffeeAndIce.GuiceDemo.hellowordDemo;

import java.applet.Applet;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.inject.Guice;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
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
		 Map<String, MyApplet> applets = Guice.createInjector(new MainModule(),
				new CommenLineModule(args))
				.getInstance(Key.get(new TypeLiteral<Map<String,MyApplet>>(){}));
		 if(args.length ==0 || !applets.containsKey(args[0])){
			 System.out.println("Unable to find applet"
			 		+ "Valid applets are "
			 		+ Joiner.on(',').join(applets.keySet()));
			 return;
		 }
		 
		 applets.get(args[0]).run();
	}

}
