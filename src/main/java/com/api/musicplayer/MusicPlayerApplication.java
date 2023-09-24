package com.api.musicplayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.api.musicplayer")
@SpringBootApplication
public class MusicPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicPlayerApplication.class, args);
	}

}
