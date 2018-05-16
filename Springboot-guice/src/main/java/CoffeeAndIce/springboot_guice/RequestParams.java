package CoffeeAndIce.springboot_guice;

import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class RequestParams {
	private String message;

	
	public RequestParams() {
		System.out.println("RequestParams constroct");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
