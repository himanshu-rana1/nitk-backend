package com.project.nitk.model.request;

import org.springframework.web.multipart.MultipartFile;

public class ResourceRequest {

    private String course;
    private Integer year;
    private String documentName;
    private MultipartFile file;

    public ResourceRequest(String course, Integer year, String documentName, MultipartFile file) {
        this.course = course;
        this.year = year;
        this.documentName = documentName;
        this.file = file;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
