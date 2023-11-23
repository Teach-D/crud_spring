package hello.crud_project.db.repository;

import hello.crud_project.db.BoardItem;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcRepositoryV1 implements BoardRepository {

    private final NamedParameterJdbcTemplate template;

    public JdbcRepositoryV1(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public BoardItem save(BoardItem boardItem) {
        String sql = "insert into board2(board_title,board_content) " +
                "values(:boardTitle, :boardContent)";

        SqlParameterSource param = new BeanPropertySqlParameterSource(boardItem);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, param,keyHolder);

        long key = keyHolder.getKey().longValue();
        boardItem.setId(key);
        return boardItem;
    }

    @Override
    public void update(Long id, BoardItem boardItem) {
        String sql = "update board2 " +
                "set board_title=:boardTitle, board_content=:boardContent " +
                "where id=:id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("boardTitle", boardItem.getBoardTitle())
                .addValue("boardContent", boardItem.getBoardContent())
                .addValue("id", id);

        template.update(sql, param);
    }

    @Override
    public Optional<BoardItem> findById(Long id) {
        String sql = "select id, board_title, board_content from board2 where id=:id";
        try {
            Map<String, Object> param = Map.of("id", id);
            BoardItem item = template.queryForObject(sql, param, itemRowMapper());
            return Optional.of(item);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<BoardItem> findAll() {
        /*String sql = "select id, board_title, board_content from board2";
        //BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource();
        return template.query(sql, param, itemRowMapper());*/
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    private RowMapper<BoardItem> itemRowMapper() {
        return BeanPropertyRowMapper.newInstance(BoardItem.class); //camel 변환 지원
    }
}
