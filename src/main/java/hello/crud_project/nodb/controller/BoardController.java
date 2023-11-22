/*
package hello.crud_project.controller;

import hello.crud_project.Dto.BoardDto;
import hello.crud_project.service.BoardServiceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static hello.crud_project.Dto.BoardDto.*;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceV1 serviceV1;
    private final List<Long> boardList = new ArrayList<>();

    @GetMapping("/home")
    public String home(Model model) {
        for (Long i = 2L; i <= 4L; i++) {
            boardList.add(i);
        }

        model.addAttribute("boardList", boardList);
        return "home";
    }

    @GetMapping("/read")
    public String read(@RequestParam("id") String id, Model model) {
        log.info(id);
        BoardDto byId = serviceV1.findById(Long.valueOf(id));
        model.addAttribute("byId", byId);
        return "read";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String created(BoardDto boardDto) {
        id++;
        boardDto.setBoardId(id);
        serviceV1.create(boardDto);
        return "redirect:/board/home";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") String id, Model model) {
        BoardDto byId = serviceV1.findById(Long.valueOf(id));
        log.info(String.valueOf(byId.getClass()));
        model.addAttribute("byId", byId);
        return "update";
    }

    @PostMapping("updated")
    public String updated(BoardDto boardDto) {
        serviceV1.update(boardDto.getBoardId(), boardDto);
        return "home";
    }

*/
/*

    @PostMapping("/updated")
    public String updated(BoardDto boardDto) {
        serviceV1.update(boardDto.getId(), boardDto);
        return "redirect:/home";
    }*//*

}
*/
