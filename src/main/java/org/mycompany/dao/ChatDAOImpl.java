package org.mycompany.dao;

import org.mycompany.beans.Chat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ChatDAOImpl implements ChatDAO {
    @Override
    public Chat find(Long chatID) {
        return null;
    }

    @Override
    public Long save(Chat chat) {
        return null;
    }
}
