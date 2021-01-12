package com.project.nitk.model.request;

import org.springframework.web.multipart.MultipartFile;

public class UserRequest {

    private String name;
    private String designation;
    private MultipartFile profilePicture;

    public UserRequest(String name, String designation, MultipartFile profilePicture) {
        this.name = name;
        this.designation = designation;
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public MultipartFile getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }
}
