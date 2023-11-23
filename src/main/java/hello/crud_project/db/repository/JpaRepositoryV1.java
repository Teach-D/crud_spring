package hello.crud_project.db.repository;

import hello.crud_project.db.BoardItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class JpaRepositoryV1 implements BoardRepository{

    private final SpringDataJpaRepository repository;

    @Override
    public BoardItem save(BoardItem boardItem) {
        return repository.save(boardItem);
    }

    @Override
    public void update(Long id, BoardItem boardItem) {
        BoardItem findItem = repository.findById(id).orElseThrow();
        findItem.setBoardTitle(boardItem.getBoardTitle());
        findItem.setBoardContent(boardItem.getBoardContent());
    }

    @Override
    public Optional<BoardItem> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<BoardItem> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
