package org.mycompany.beans;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile extends AbstractBean {
    private String avatarUrl;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
//    private List<Language> languages = new ArrayList<>();
    private String relationShipStatus;
    private String aboutMe;
    private String Workplace;
    private String school;
    private String univercity;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

//    public List<Language> getLanguages() {
//        return languages;
//    }
//
//    public void setLanguages(List<Language> languages) {
//        this.languages = languages;
//    }

    public String getRelationShipStatus() {
        return relationShipStatus;
    }

    public void setRelationShipStatus(String relationShipStatus) {
        this.relationShipStatus = relationShipStatus;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getWorkplace() {
        return Workplace;
    }

    public void setWorkplace(String workplace) {
        Workplace = workplace;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUnivercity() {
        return univercity;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }
}
