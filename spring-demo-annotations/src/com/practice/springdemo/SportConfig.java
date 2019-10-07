package com.practice.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.practice.springdemo") //As we have manually creating  beans in Sportconfig now
											// so component scan is not required.
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define bean for our swim coach AND inject dependency.
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
