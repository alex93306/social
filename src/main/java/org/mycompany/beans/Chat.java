package org.mycompany.beans;

import java.util.Objects;

public class Chat extends AbstractBean {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(title, chat.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
