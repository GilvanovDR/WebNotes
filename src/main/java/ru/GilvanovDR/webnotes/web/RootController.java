package ru.GilvanovDR.webnotes.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.GilvanovDR.webnotes.service.NoteService;

@Controller
public class RootController {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final NoteService service;

    public RootController(NoteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String root() {
        log.debug("/");
        return "index";
    }

    @RequestMapping(value = "404", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String Page404(ModelMap model) {
        log.debug("404 page not found");
        return "404";
    }

    @GetMapping("/note")
    public String getNotes(Model model) {
        log.debug("/note");
        model.addAttribute("note", service.getAll());
        return "note";
    }
}
