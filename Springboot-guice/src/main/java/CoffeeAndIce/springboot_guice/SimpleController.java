package CoffeeAndIce.springboot_guice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.google.inject.Guice;
import com.google.inject.Injector;

import CoffeeAndIce.GuiceDemo.hellowordDemo.MyApplet;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication
@ServletComponentScan
public class SimpleController {
	
	@Bean 
	Injector injector(ApplicationContext context){//每一个@Bean下面，都有默认注入，如果有参数。
		return Guice.createInjector(
				new HelloWorldWebModule(),
				new SpringAwareModule(context));
	}
	
	@Bean @RequestScope
	RequestParams requestParam(Injector injector){
		return injector.getInstance(RequestParams.class);
	}
	
	@Bean @RequestScope
	WebDestination desdestination(Injector injector){
		return injector.getInstance(WebDestination.class);
	}
	
	@Bean @RequestScope
	MyApplet applet(Injector injector){
		return injector.getInstance(MyApplet.class);
	}
	
	@Autowired MyApplet applet;
	@Autowired WebDestination destination;
	@Autowired RequestParams requestParam;
    @GetMapping("/hello")
    String home(@RequestParam String name) {
    	requestParam.setMessage(name);
    	applet.run();
        return destination.getResult();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SimpleController.class, args);
    }
}
