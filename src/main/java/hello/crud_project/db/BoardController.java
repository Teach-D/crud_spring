package hello.crud_project.db;

import hello.crud_project.db.service.BoardService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String items(BoardItem boardItem, Model model) {
        List<BoardItem> all = boardService.findAll();
        model.addAttribute("items", all);
        return "board/items";
    }

    @NonNull
    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        BoardItem boardItem = boardService.findById(itemId).get();
        model.addAttribute("item", boardItem);
        return "board/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "board/addForm";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute BoardItem boardItem, RedirectAttributes
            redirectAttributes) {
        BoardItem save = boardService.save(boardItem);
        redirectAttributes.addAttribute("itemId", boardItem.getId());
        return "redirect:/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        BoardItem boardItem = boardService.findById(itemId).get();
        model.addAttribute("item", boardItem);
        return "board/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute BoardItem boardItem) {
        boardService.update(itemId, boardItem);
        return "redirect:/items/{itemId}";
    }

    @GetMapping("/{itemId}/delete")
    public String delete(@PathVariable Long itemId) {
        boardService.deleteById(itemId);
        return "redirect:/items";
    }
}
