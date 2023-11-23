package hello.crud_project.db;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BoardItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_title")
    private String boardTitle;
    @Column(name = "board_content")
    private String boardContent;

    public BoardItem() {
    }

    public BoardItem(String board_title, String board_content) {
        this.boardTitle = board_title;
        this.boardContent = board_content;
    }
}
