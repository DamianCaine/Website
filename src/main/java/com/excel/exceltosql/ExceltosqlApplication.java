package com.excel.exceltosql;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExceltosqlApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExceltosqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("This is testing");
	}
}
