package com.snackpicker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
