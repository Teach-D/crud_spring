package hello.crud_project.repository;

import hello.crud_project.Dto.BoardDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository {

    BoardDto create(BoardDto board);

    BoardDto read(Long id);

    void update(Long id, BoardDto boardDto);

    void delete(Long id);

    BoardDto findById(Long id);

    List<BoardDto> findAll();
}
