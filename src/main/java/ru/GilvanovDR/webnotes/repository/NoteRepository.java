package ru.GilvanovDR.webnotes.repository;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.GilvanovDR.webnotes.model.Note;
import ru.GilvanovDR.webnotes.util.exception.NotFoundException;

import java.util.List;

@Repository
public class NoteRepository {
    private static final Logger log = LoggerFactory.getLogger(NoteRepository.class);
    private final NoteDataJpa noteRepo;

    public NoteRepository(NoteDataJpa noteRepo) {
        this.noteRepo = noteRepo;
    }

    public Note save(Note note) throws NotFoundException {
        try {
            if (!note.isNew() && get(note.getId()) == null) {
                return null;
            }
            return noteRepo.save(note);
        } catch (Exception ex) {
            log.debug(ex.getMessage());
            throw new NotFoundException("Такая заметка уже есть!");
        }
    }

    public boolean delete(int id) {
        return noteRepo.delete(id) != 0;
    }

    public Note get(int id) {
        return noteRepo.findById(id)
                .orElse(null);
    }

    public List<Note> getAll() {
        return noteRepo.getAll();
    }
}
