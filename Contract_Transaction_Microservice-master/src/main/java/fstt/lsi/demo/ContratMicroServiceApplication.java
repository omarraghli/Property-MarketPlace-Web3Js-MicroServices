package fstt.lsi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan({ "fstt.lsi.Controller" })
@ComponentScan({ "fstt.lsi.serviceImpl" })
@ComponentScan({ "fstt.lsi.serviceInterface" })
@ComponentScan({ "fstt.lsi.Security" })
@EnableMongoRepositories("fstt.lsi.**")
@EnableEurekaClient
public class ContratMicroServiceApplication {

	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(ContratMicroServiceApplication.class, args);
	}

}
