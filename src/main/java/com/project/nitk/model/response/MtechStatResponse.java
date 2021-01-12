package com.project.nitk.model.response;

public class MtechStatResponse {

    private int totalStudents;
    private int totalPlacements;

    public MtechStatResponse(int totalStudents, int totalPlacements) {
        this.totalStudents = totalStudents;
        this.totalPlacements = totalPlacements;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalPlacements() {
        return totalPlacements;
    }

    public void setTotalPlacements(int totalPlacements) {
        this.totalPlacements = totalPlacements;
    }
}
