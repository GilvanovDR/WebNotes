package ru.GilvanovDR.webnotes.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.GilvanovDR.webnotes.model.Note;
import ru.GilvanovDR.webnotes.service.NoteService;
import ru.GilvanovDR.webnotes.util.exception.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static ru.GilvanovDR.webnotes.util.ValidationUtil.checkNew;

@Controller
@RequestMapping("/note")
public class NoteUIController {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final NoteService service;

    public NoteUIController(NoteService service) {
        this.service = service;
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        log.info("delete {}", getId(request));
        service.delete(getId(request));
        return "redirect:/note";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        Note note = service.get((getId(request)));
        log.info("update {}", note);
        model.addAttribute("note", note);
        return "noteForm";
    }

    @GetMapping("/create")
    public String create(Model model) {
        log.info("Create");
        model.addAttribute("note", new Note(null, null, "text"));
        return "noteForm";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request, Model model) {
        Note note = new Note(
                request.getParameter("subject"),
                request.getParameter("text"));
        if (request.getParameter("id").isEmpty()) {
            try {
                log.info("create {}", note);
                checkNew(note);
                service.create(note);
            } catch (NotFoundException e) {
                model.addAttribute("error", e.getMessage());
                model.addAttribute("note", note);
                return "noteForm";
            }
        } else {
            note.setId(getId(request));
            log.info("update {}", note);
            service.update(note);
        }
        return "redirect:/note";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

    @GetMapping("/filterBy")
    public String getFilteredBy(@RequestParam String text, Model model) {
        model.addAttribute("note", service.getFiltered(text));
        return "note";
    }
}