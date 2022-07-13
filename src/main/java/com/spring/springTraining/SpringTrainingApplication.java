package com.spring.springTraining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringTrainingApplication {
	private static Logger logger = LoggerFactory.getLogger(SpringTrainingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringTrainingApplication.class, args);
		logger.info("============= some info log");
		logger.error("============= some error log");
		logger.warn("============= some warn log");
		logger.debug("============= some debug log");
	}


}
