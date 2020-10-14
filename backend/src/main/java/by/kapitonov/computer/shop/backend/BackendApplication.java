package by.kapitonov.computer.shop.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class BackendApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(BackendApplication.class);
	private static final String PROTOCOL = "http";


	public static void main(String[] args) throws UnknownHostException {
		SpringApplication application = new SpringApplication(BackendApplication.class);
		Environment environment = application.run(args).getEnvironment();

		LOGGER.info("\n----------------------------------------------------------\n\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\t{}://localhost:{}\n\t" +
						"External: \t{}://{}:{}\n\t" +
						"\t\t\n----------------------------------------------------------",
				environment.getProperty("spring.application.name"),
				PROTOCOL,
				environment.getProperty("server.port"),
				PROTOCOL,
				InetAddress.getLocalHost().getHostAddress(),
				environment.getProperty("server.port"));

	}

}
