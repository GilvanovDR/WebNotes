package ru.GilvanovDR.webnotes.web;

import org.springframework.util.Assert;

public interface HasId {
    Integer getId();

    void setId(Integer id);

    default boolean isNew() {
        return getId() == null;
    }

    default int id() {
        Assert.notNull(getId(), "Заметка должна иметь id");
        return getId();
    }
}
