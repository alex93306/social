package org.mycompany.managers;

import org.mycompany.beans.Chat;
import org.mycompany.dao.ChatDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatManagerImpl implements ChatManager {
    @Autowired
    private ChatDAO chatDAO;

    @Override
    public Chat find(Long chatID) {
        return chatDAO.find(chatID);
    }

    public Long save(Chat chat) {
        chat.setTitle("kdsf");
        return chatDAO.save(chat);
    }
}
