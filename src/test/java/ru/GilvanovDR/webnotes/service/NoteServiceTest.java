package ru.GilvanovDR.webnotes.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.GilvanovDR.webnotes.TimingExtension;
import ru.GilvanovDR.webnotes.model.Note;
import ru.GilvanovDR.webnotes.util.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.GilvanovDR.webnotes.NoteTestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ExtendWith(TimingExtension.class)
class NoteServiceTest {
    @Autowired
    protected NoteService service;

    @Test
    void get() {
        Note actual = service.get(NOTE1_ID);
        NOTE_MATCHER.assertMatch(actual, NOTE1);
    }

    @Test
    void delete() {
        service.delete(NOTE1_ID);
        assertThrows(NotFoundException.class, () -> service.get(NOTE1_ID));
    }

    @Test
    void getAll() {
        NOTE_MATCHER.assertMatch(service.getAll(), NOTES);
    }

    @Test
    void update() {
        Note updated = getUpdated();
        service.update(updated);
        NOTE_MATCHER.assertMatch(service.get(NOTE1_ID), getUpdated());
    }

    @Test
    void create() {
        Note created = service.create(getNew());
        int newId = created.id();
        Note newNote = getNew();
        newNote.setId(newId);
        NOTE_MATCHER.assertMatch(created, newNote);
        NOTE_MATCHER.assertMatch(service.get(newId), newNote);
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND));
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND));
    }

    @Test
    void createWithException() {
        assertThrows(NotFoundException.class, () -> service.create(new Note(null, "", "")));
    }

    @Test
    void getAllContains() {
        NOTE_MATCHER.assertMatch(service.getFiltered(CONTAINS), NOTES_CONTAINS);
    }
}