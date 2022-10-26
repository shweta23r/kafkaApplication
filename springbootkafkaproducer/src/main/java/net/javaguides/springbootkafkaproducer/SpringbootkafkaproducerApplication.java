package net.javaguides.springbootkafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootkafkaproducerApplication implements CommandLineRunner {

	@Autowired
	private WikimediaChangesProducerService wikimediaChangesProducerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootkafkaproducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		wikimediaChangesProducerService.sendMessage();

	}
}

