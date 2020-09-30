package ru.GilvanovDR.webnotes.web;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RootControllerTest extends AbstractControllerTest {

    @Test
    void root() throws Exception {
        perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/index.jsp"));
    }

    @Test
    void page404() throws Exception {
        perform(get("/wrongUrl"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getNotes() throws Exception {
        perform(get("/note"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("note"))
                //          .andExpect(model().attribute("note",NOTES))  // ??ignore date
                .andExpect(forwardedUrl("/WEB-INF/jsp/note.jsp"));
    }
}