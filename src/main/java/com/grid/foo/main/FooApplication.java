package com.grid.foo.main;

import com.grid.foo.implementations.FooImplementationUser;
import com.grid.foo.users.FooUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.grid.foo")
public class FooApplication {

	public static void main(String[] args) {
		//SpringApplication.run(FooApplication.class, args);

		//Inicializar context de spring
		ApplicationContext ctx = SpringApplication.run(FooApplication.class,args);

		FooUser fooUser = ctx.getBean(FooUser.class);
		fooUser.printMessage();

		FooImplementationUser fooImplementationUser = ctx.getBean(FooImplementationUser.class);
		fooImplementationUser.printMessage();




	}


}
