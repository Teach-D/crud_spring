package hello.crud_project.repository;

import hello.crud_project.Dto.BoardDto;
import hello.crud_project.connection.DBConnectionUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
@Slf4j
@RequiredArgsConstructor
public class BoardRepositoryV1 implements BoardRepository{

    private final JdbcTemplate jdbcTemplate;

    public BoardDto create(BoardDto board) {
        String sql = "insert into board(board_id, board_title, board_content) values(?, ?, ?)";
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, board.getBoardId());
            pstmt.setString(2, board.getBoardTitle());
            pstmt.setString(3, board.getBoardContent());
            pstmt.executeUpdate();
            return board;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con, pstmt, null);
        }
    }

    @Override
    public BoardDto findById(Long id) {
        String sql = "select * from board where board_id = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                BoardDto boardDto = new BoardDto();
                boardDto.setBoardId(rs.getLong("board_id"));
                boardDto.setBoardTitle(rs.getString("board_title"));
                boardDto.setBoardContent(rs.getString("board_content"));
                return boardDto;
            } else {
                throw new NoSuchElementException("member not found memberId=" +
                        id);
            }
        } catch (SQLException e) {
            log.error("db error", e);
            throw new RuntimeException(e);
        } finally {
            close(con, pstmt, rs);
        }
    }

    @Override
    public void update(Long id, BoardDto boardDto) {
        String sql = "update board set board_title=?, board_content=? where board_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, boardDto.getBoardTitle());
            pstmt.setString(2, boardDto.getBoardContent());
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con ,pstmt, null);
        }
    }




/*    @Override
    public List<BoardDto> findAll() {
        String sql = "select * from board";
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardDto.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con, pstmt, null);
        }
    }*/

    private void close(Connection con, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
