package hello.crud_project.repository;

import hello.crud_project.Dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Slf4j
public class BoardRepositoryV1 implements BoardRepository{

    private final JdbcTemplate template;

    public BoardRepositoryV1(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public BoardDto create(BoardDto board) {
        String sql = "insert into board(board_id, board_title, board_content) values (?,?)";
        template.update(sql, board.getId(), board.getBoardTitle(), board.getBoardContent());
        return board;
    }

    @Override
    public BoardDto read(Long id) {
        String sql = "select * from board where board_id=?";
        return template.queryForObject(sql, boardRowMapper(),id);
    }

    @Override
    public void update(Long id, BoardDto boardDto) {
        String sql = "update board set board_title=? board_content=? where board_id=?";
        template.update(sql, boardDto.getBoardTitle(), boardDto.getBoardContent(), id);
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from board where board_id=?";
        template.update(sql, id);
    }

    @Override
    public BoardDto findById(Long id) {
        String sql = "select * from board where board_id=?";
        return template.queryForObject(sql, boardRowMapper(), id);
    }


    @Override
    public List<BoardDto> findAll() {
        String sql = "select * from board";
        return template.query(sql, boardRowMapper());
    }

    private RowMapper<BoardDto> boardRowMapper() {
        return (rs, rowNum) -> {
            BoardDto boardDto = new BoardDto();
            boardDto.setBoardTitle(rs.getString("board_title"));
            boardDto.setBoardContent(rs.getString("board_content"));
            return boardDto;
        };
    }

}
