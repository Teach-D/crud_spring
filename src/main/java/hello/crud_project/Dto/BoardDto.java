package hello.crud_project.Dto;

import lombok.Data;

@Data
public class BoardDto {

    Long id;

    String boardTitle;
    String boardContent;
}
