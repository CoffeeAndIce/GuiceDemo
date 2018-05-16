package CoffeeAndIce.springboot_guice;

import javax.inject.Inject;

import com.google.inject.servlet.RequestScoped;

import CoffeeAndIce.GuiceDemo.hellowordDemo.MyDestination;

@RequestScoped
public class WebDestination implements MyDestination {
	private final StringBuilder sb;
	private final SimpleDao dao;

	@Inject
	public WebDestination(SimpleDao dao) {
		System.out.println("WebDestination constroct");
		this.dao = dao;
		this.sb = new StringBuilder();
	}

	@Override
	public void write(String string) {
		sb.append(string);
		dao.save(string);
	}

	public String getResult() {
		return sb.toString();
	}

}
