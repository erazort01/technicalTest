package aquinones.technicaltest.techincaltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("aquinones.technicaltest.*")
@ComponentScan(basePackages = { "aquinones.technicaltest.*" })
@EntityScan("aquinones.technicaltest.*")  
@SpringBootApplication
public class TechincaltestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechincaltestApplication.class, args);
	}

}
