package com.sarthak.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.sarthak.springdemo") WE WILL DO THIS IF WE ARE NOT SPECIFYING BEANS MANUALLY
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// DEFINE BEAN FOR SAD FORTUNE SERVICE

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// DEFINE BEAN FOR SWIM COACH AND INJECT DEPENDENCY

	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
