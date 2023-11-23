package hello.crud_project.db.service;

import hello.crud_project.db.BoardItem;
import hello.crud_project.db.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceV1 implements BoardService {

    private final BoardRepository boardRepository;
    @Override
    public BoardItem save(BoardItem boardItem) {
        return boardRepository.save(boardItem);
    }

    @Override
    public void update(Long id, BoardItem boardItem) {
        boardRepository.update(id, boardItem);
    }

    @Override
    public Optional<BoardItem> findById(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public List<BoardItem> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
