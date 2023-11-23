package hello.crud_project;

import hello.crud_project.db.config.BoardConfig;
import hello.crud_project.db.config.JpaBoardConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(BoardConfig.class)
@Import(JpaBoardConfig.class)
@SpringBootApplication(scanBasePackages = "hello.crud_project.db")
public class CrudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectApplication.class, args);
	}

}
