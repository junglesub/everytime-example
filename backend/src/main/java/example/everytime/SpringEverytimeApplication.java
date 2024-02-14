package example.everytime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringEverytimeApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringEverytimeApplication.class, args);
  }
}
