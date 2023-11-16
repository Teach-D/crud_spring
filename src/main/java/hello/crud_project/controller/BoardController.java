package hello.crud_project.controller;

import hello.crud_project.Dto.BoardDto;
import hello.crud_project.service.BoardServiceV1;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceV1 serviceV1;

    @GetMapping("/home")
    public String home(Model model) {
        List<BoardDto> boardList = serviceV1.findAll();
        model.addAttribute("boardList", boardList);
        return "home";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String created(BoardDto boardDto) {
        serviceV1.create(boardDto);
        return "home";
    }

    @PostMapping("/update")
    public String update(Model model, Long id) {
        BoardDto byId = serviceV1.findById(id);
        model.addAttribute("byId", byId);
        return "update";
    }

    @PostMapping("/updated")
    public String updated(BoardDto boardDto) {
        serviceV1.update(boardDto.getId(), boardDto);
        return "redirect:/home";
    }
}
