package CoffeeAndIce.GuiceDemo.hellowordDemo;

import javax.inject.Inject;

import com.google.inject.Provider;

import CoffeeAndIce.GuiceDemo.hellowordDemo.binds.OutPut;

public class StringWtringApplet implements MyApplet {
	private MyDestination destination;
	private Provider<String> stringProvider;

	@Inject
	public StringWtringApplet(MyDestination destination, 
			@OutPut Provider<String> stringProvider) {
		super();
		this.destination = destination;
		this.stringProvider = stringProvider;
	}

	private void writerString() {
		destination.write(stringProvider.get());
	}

	public void run() {
		writerString();
	}
}
