package org.mycompany.dto;

import java.util.ArrayList;
import java.util.List;

public class ChatResponseDTO {
    private Long chatID;
    private String title;
    private List<Long> membersIDs = new ArrayList<>();

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
