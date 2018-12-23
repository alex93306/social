package org.mycompany.managers;

import org.mycompany.beans.Chat;

public interface ChatManager {
    Chat find(Long chatID);
    Long save(Chat chat);
}
