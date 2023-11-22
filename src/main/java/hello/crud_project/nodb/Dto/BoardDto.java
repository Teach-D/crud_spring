package hello.crud_project.nodb.Dto;

import lombok.Data;

@Data
public class BoardDto {

    public static Long id = 0L;

    Long boardId;
    String boardTitle;
    String boardContent;


}
