package hello.crud_project.nodb.repository;

import hello.crud_project.nodb.Dto.BoardDto;
import org.springframework.stereotype.Repository;

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
