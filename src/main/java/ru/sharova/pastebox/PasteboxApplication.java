package ru.sharova.pastebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.sharova.pastebox.service.PasteboxServiceImpl;

@SpringBootApplication
//@EnableConfigurationProperties(PasteboxServiceImpl.class)
public class PasteboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasteboxApplication.class, args);
	}

}
