package ru.GilvanovDR.webnotes.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.GilvanovDR.webnotes.model.Note;
import ru.GilvanovDR.webnotes.repository.NoteRepository;

import java.util.List;

import static ru.GilvanovDR.webnotes.util.ValidationUtil.checkNotFoundWithId;

@Service
public class  NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public Note get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public List<Note> getAll() {
        return repository.getAll();
    }

    public void update(Note note) {
        Assert.notNull(note, "note must not be null");
        checkNotFoundWithId(repository.save(note), note.id());
    }

    public Note create(Note note) {
        Assert.notNull(note, "note must not be null");
        return repository.save(note);
    }
}