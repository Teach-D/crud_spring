package hello.crud_project.nodb.service;

import hello.crud_project.nodb.Dto.BoardDto;
import hello.crud_project.nodb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceV1 {

    private final BoardRepository boardRepository;

    public BoardDto create(BoardDto board) {
        return boardRepository.create(board);
    }

    public BoardDto findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(Long id, BoardDto boardDto) {
        boardRepository.update(id, boardDto);
    }
/*
    public BoardDto read(Long id) {
        return boardRepository.read(id);
    }




    public void delete(Long id) {
        boardRepository.delete(id);
    }




    public List<BoardDto> findAll() {
        return boardRepository.findAll();
    }

*/

}
