package hello.crud_project.Jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public BoardService boardService() {
        return new BoardServiceV1(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository() {
        return new MemoryBoardRepository();
    }
}
