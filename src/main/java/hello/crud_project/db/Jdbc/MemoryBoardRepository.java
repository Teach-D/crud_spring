package hello.crud_project.db.Jdbc;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemoryBoardRepository implements  BoardRepository{

    private static final Map<Long, BoardItem> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public BoardItem save(BoardItem boardItem) {
        boardItem.setId(++sequence);
        store.put(boardItem.getId(), boardItem);
        return boardItem;
    }

    @Override
    public void update(Long id, BoardItem boardItem) {
        BoardItem findItem = findById(id).orElseThrow();
        findItem.setBoardTitle(boardItem.getBoardTitle());
        findItem.setBoardTitle(boardItem.getBoardContent());
    }

    @Override
    public Optional<BoardItem> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<BoardItem> findAll(BoardItem boardItem) {
        return store.values().stream().collect(Collectors.toList());
    }
}
