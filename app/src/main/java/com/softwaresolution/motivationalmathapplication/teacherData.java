package com.softwaresolution.motivationalmathapplication;

public class teacherData {
    String teacherName;
    String teacherPassword;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
    public teacherData(String teacherName, String teacherPassword) {
        this.teacherName = teacherName;
        this.teacherPassword = teacherPassword;
    }

}
