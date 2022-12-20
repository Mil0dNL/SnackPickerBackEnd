package com.snackpicker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})
public class MainApplication {

	public static void main(String[] args) {
		try
		{
			SpringApplication.run(MainApplication.class, args);
		}
		catch(Exception e)
		{
			System.out.println("DB connection error.");
			return;
		}
	}

}
