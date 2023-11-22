package hello.crud_project;

import hello.crud_project.Jdbc.BoardConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(BoardConfig.class)
@SpringBootApplication(scanBasePackages = "hello.crud_project.Jdbc")
public class CrudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectApplication.class, args);
	}

}
