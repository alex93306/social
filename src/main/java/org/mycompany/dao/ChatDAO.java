package org.mycompany.dao;

import org.mycompany.beans.Chat;

public interface ChatDAO {
    Chat find(Long chatID);
    Long save(Chat chat);
}
