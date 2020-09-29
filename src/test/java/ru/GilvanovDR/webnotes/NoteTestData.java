package ru.GilvanovDR.webnotes;

import ru.GilvanovDR.webnotes.model.Note;
import java.util.List;

import static ru.GilvanovDR.webnotes.model.Note.START_SEQ;

public class NoteTestData {

    public static TestMatcher<Note> NOTE_MATCHER = TestMatcher.usingFieldsWithIgnoringAssertions(Note.class, "date");
    public static final int NOT_FOUND = 10;
    public static final int NOTE1_ID = START_SEQ;

    public static final Note NOTE1 = new Note(NOTE1_ID, "", "текст");
    public static final Note NOTE2 = new Note(NOTE1_ID + 1, "subject1", "текст1");
    public static final Note NOTE3 = new Note(NOTE1_ID + 2, "дом", "текст2");
    public static final Note NOTE4 = new Note(NOTE1_ID + 3, "subject3", "дом");
    public static final Note NOTE5 = new Note(NOTE1_ID + 4, "subject4", "текст4");
    public static final Note NOTE6 = new Note(NOTE1_ID + 5, "subject5", "дом и квартира");
    public static final Note NOTE7 = new Note(NOTE1_ID + 6, "subject6", "текст6");
    public static final Note NOTE8 = new Note(NOTE1_ID + 7, "", "текст7");
    public static final Note NOTE9 = new Note(NOTE1_ID + 8, "", "текст8");


    public static final List<Note> NOTES = List.of(NOTE1,NOTE2,NOTE3,NOTE4,NOTE5,NOTE6,NOTE7,NOTE8,NOTE9);
    public static final List<Note> NOTES_CONTAINS = List.of(NOTE3,NOTE4,NOTE6);

    public static Note getNew() {
        return new Note(null, "новая заметка", "новый текст");
    }

    public static Note getUpdated() {
        return new Note(NOTE1_ID, "Обновленный заголовок", "обновленный текст");
    }
}
