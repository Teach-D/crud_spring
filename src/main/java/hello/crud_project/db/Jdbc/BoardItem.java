package hello.crud_project.db.Jdbc;

import lombok.Data;

@Data
public class BoardItem {

    private Long id;

    private String boardTitle;
    private String boardContent;

    public BoardItem() {
    }

    public BoardItem(String board_title, String board_content) {
        this.boardTitle = board_title;
        this.boardContent = board_content;
    }
}
