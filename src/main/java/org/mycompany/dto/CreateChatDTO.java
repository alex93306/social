package org.mycompany.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CreateChatDTO {
    private Long chatID;
    private String title;
    private List<Long> membersIDs;

    public Long getChatID() {
        return chatID;
    }

    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getMembersIDs() {
        return membersIDs;
    }

    public void setMembersIDs(List<Long> membersIDs) {
        this.membersIDs = membersIDs;
    }
}
