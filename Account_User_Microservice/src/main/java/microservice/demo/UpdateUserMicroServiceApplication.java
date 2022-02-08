package microservice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan({ "microservice.Controller" })
@ComponentScan({ "microservice.Service" })
@ComponentScan({ "microservice.Interface" })
@ComponentScan({ "microservice.security" })
@EnableMongoRepositories("microservice.**")
@EnableEurekaClient
public class UpdateUserMicroServiceApplication {

	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(UpdateUserMicroServiceApplication.class, args);
	}

}
