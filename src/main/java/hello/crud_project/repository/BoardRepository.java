package hello.crud_project.repository;

import hello.crud_project.Dto.BoardDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository {

    BoardDto create(BoardDto board);

    BoardDto findById(Long id);

    void update(Long id, BoardDto boardDto);

/*    BoardDto read(Long id);



    void delete(Long id);



    List<BoardDto> findAll();

    */
}
