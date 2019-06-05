package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

@SpringBootApplication
@RestController
public class DemoApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	private static String VERSION = "v1";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping(path = "hello")
	public ResponseEntity<String> getIp() throws UnknownHostException {
		final String responseBody = VERSION + "|" + UUID.randomUUID().toString() + "|" + InetAddress.getLocalHost()
				.toString();
		LOGGER.info(responseBody);

		return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}
}