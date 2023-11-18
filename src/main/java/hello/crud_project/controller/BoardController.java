package hello.crud_project.controller;

import hello.crud_project.Dto.BoardDto;
import hello.crud_project.service.BoardServiceV1;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceV1 serviceV1;

    @GetMapping("/home")
    public String home(Model model) {
        BoardDto byId = serviceV1.findById(2L);
        model.addAttribute("byId", byId);
        return "home";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String created(BoardDto boardDto) {
        BoardDto.id++;
        boardDto.setBoardId(BoardDto.id);
        serviceV1.create(boardDto);
        return "a";
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
        return "a";
    }

/*

    @PostMapping("/updated")
    public String updated(BoardDto boardDto) {
        serviceV1.update(boardDto.getId(), boardDto);
        return "redirect:/home";
    }*/
}
