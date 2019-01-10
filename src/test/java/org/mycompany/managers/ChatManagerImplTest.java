package org.mycompany.managers;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mycompany.beans.AbstractBean;
import org.mycompany.beans.Chat;
import org.mycompany.dao.ChatDAO;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChatManagerImplTest {
    @Mock private ChatDAO chatDAO;

    @InjectMocks
    private ChatManagerImpl chatManager;

    @Test
    public void testFind_success() throws Exception {
        // Setup
        Chat expectedChat = initTestBean(Chat.class);
        when(chatDAO.find(expectedChat.getId())).thenReturn(expectedChat);

        // Method call
        Chat actualChat = chatManager.find(expectedChat.getId());

        // Assert
        assertEquals(expectedChat, actualChat);
    }

    @Test
    public void testSave_success() throws Exception {
        // Setup
        Long expectedChatID = 23423L;
        Chat chatToSave = new Chat();
        when(chatDAO.save(eq(chatToSave))).thenReturn(expectedChatID);

        // Method call
        Long actualChatID = chatManager.save(chatToSave);

        // Assert
        assertEquals(expectedChatID, actualChatID);
    }



    private <T extends AbstractBean> T initTestBean(Class<T> clazz) throws Exception {
        T t = clazz.newInstance();
        t.setId(new Random().nextLong());
        return t;
    }

}