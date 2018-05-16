package CoffeeAndIce.springboot_guice;


import com.google.inject.servlet.RequestScoped;

import CoffeeAndIce.GuiceDemo.hellowordDemo.MyDestination;

@RequestScoped
public class WebDestination implements MyDestination {
	private final StringBuilder sb = new StringBuilder();
	
	public WebDestination() {
		System.out.println("WebDestination constroct");
	}

	@Override
	public void write(String string) {
		sb.append(string);
	}

	public String getResult() {
		return sb.toString();
	}

}
