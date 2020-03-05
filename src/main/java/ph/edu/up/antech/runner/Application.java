package ph.edu.up.antech.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "ph.edu.up.antech.dao")
@SpringBootApplication(scanBasePackages = "ph.edu.up.antech")
@EntityScan(basePackages = {"ph.edu.up.antech.domain"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
