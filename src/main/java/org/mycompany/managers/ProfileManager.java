package org.mycompany.managers;

import org.mycompany.beans.Profile;

public interface ProfileManager {
    Profile find(Long id);
    Long update(Profile profile);
}
