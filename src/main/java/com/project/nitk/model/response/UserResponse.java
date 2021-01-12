package com.project.nitk.model.response;

public class UserResponse {

    private Long id;
    private String name;
    private String designation;
    private String profilePicture;

    public UserResponse(Long id, String name, String designation, String profilePicture) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.profilePicture = profilePicture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
