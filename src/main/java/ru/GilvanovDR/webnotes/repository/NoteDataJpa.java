package ru.GilvanovDR.webnotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.GilvanovDR.webnotes.model.Note;

import java.util.List;

public interface NoteDataJpa extends JpaRepository<Note,Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Note n WHERE n.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT n FROM Note n ORDER BY n.date DESC")
    List<Note> getAll();
}
