package hello.crud_project.Jdbc;

import lombok.Data;

@Data
public class BoardItem {

    private Long id;

    private String board_title;
    private String board_content;

    public BoardItem() {
    }

    public BoardItem(String board_title, String board_content) {
        this.board_title = board_title;
        this.board_content = board_content;
    }
}
