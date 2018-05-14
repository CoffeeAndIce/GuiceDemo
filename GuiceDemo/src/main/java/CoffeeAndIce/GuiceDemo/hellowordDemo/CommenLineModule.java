package CoffeeAndIce.GuiceDemo.hellowordDemo;

import java.util.Arrays;
import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class CommenLineModule extends AbstractModule {
	private final String[] args;

	public CommenLineModule(String[] args) {
		this.args = args;
	}

	@Override
	public void configure() {

	}

	@Provides
	@Args
	List<String> getComment() {
		return Arrays.asList(args).subList(1, args.length);
	}

}
