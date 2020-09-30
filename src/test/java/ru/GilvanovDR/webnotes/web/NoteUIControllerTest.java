package ru.GilvanovDR.webnotes.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.GilvanovDR.webnotes.service.NoteService;
import ru.GilvanovDR.webnotes.util.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.GilvanovDR.webnotes.NoteTestData.CONTAINS;
import static ru.GilvanovDR.webnotes.NoteTestData.NOTE1_ID;

class NoteUIControllerTest extends AbstractControllerTest {
    @Autowired
    NoteService service;

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.get("/note/delete?id=" + NOTE1_ID))
                .andExpect(status().is3xxRedirection());
        assertThrows(NotFoundException.class, () -> service.get(NOTE1_ID));
    }

    @Test
    void getFilteredBy() throws Exception {
        perform(get("/note/filterBy?text=" + CONTAINS))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("note"))
                //             .andExpect(model().attribute("note",NOTES_CONTAINS))  // ??ignore date
                .andExpect(forwardedUrl("/WEB-INF/jsp/note.jsp"));
    }
}