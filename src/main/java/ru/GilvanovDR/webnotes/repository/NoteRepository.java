package ru.GilvanovDR.webnotes.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.GilvanovDR.webnotes.model.Note;

import java.util.List;

@Repository
public class NoteRepository {
    private final NoteDataJpa noteRepo;

    public NoteRepository(NoteDataJpa noteRepo) {
        this.noteRepo = noteRepo;
    }


    @Transactional
    public Note save(Note note) {
        if (!note.isNew() && get(note.getId()) == null) {
            return null;
        }
        return noteRepo.save(note);
    }


    public boolean delete(int id) {
        return noteRepo.delete(id)!=0;
    }


    public Note get(int id) {
        return noteRepo.findById(id)
                .orElse(null);
    }


    public List<Note> getAll() {
        return noteRepo.getAll();
    }
}
