package hello.crud_project.db.config;

import hello.crud_project.db.repository.BoardRepository;
import hello.crud_project.db.repository.JdbcRepositoryV1;
import hello.crud_project.db.service.BoardService;
import hello.crud_project.db.service.BoardServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
@RequiredArgsConstructor
public class BoardConfig {

    private final DataSource dataSource;

    @Bean
    public BoardService boardService() {
        return new BoardServiceV1(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository() {
        return new JdbcRepositoryV1(dataSource);
    }
}
