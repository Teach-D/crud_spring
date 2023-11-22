package hello.crud_project.db.Jdbc;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    BoardItem save(BoardItem boardItem);

    void update(Long id, BoardItem boardItem);

    Optional<BoardItem> findById(Long id);

    List<BoardItem> findAll(BoardItem boardItem);
}
