package ru.GilvanovDR.webnotes.model;

import ru.GilvanovDR.webnotes.web.HasId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.LocalDateTime.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = "notes")
public class Note implements HasId {
    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Note(Integer id, String subject, @NotBlank String text, @NotNull LocalDateTime date) {
        this.id = id;
        this.subject = subject;
        this.text = text;
        this.date = date;
    }

    public Note(Integer id, String subject, @NotBlank String text) {
        this(id,subject,text,now());
    }

    public Note() {
    }

    public static final int START_SEQ = 100000;
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    Integer id;

    @Column(name = "subject")
    String subject;

    @Column(name = "text")
    @NotBlank
    String text;

    @Column(name = "date")
    @NotNull
    LocalDateTime date;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id.equals(note.id) &&
                Objects.equals(subject, note.subject) &&
                Objects.equals(text, note.text) &&
                date.equals(note.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, text, date);
    }
}
