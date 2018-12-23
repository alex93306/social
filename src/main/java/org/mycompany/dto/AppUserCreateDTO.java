package org.mycompany.dto;

import org.mycompany.beans.AppUser;

public class AppUserCreateDTO {
    private String email;
    private boolean enable;

    public AppUserCreateDTO() {
    }

    public String  getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
