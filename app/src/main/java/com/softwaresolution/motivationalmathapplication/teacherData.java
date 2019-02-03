package com.softwaresolution.motivationalmathapplication;

public class teacherData {
    public String teacherName;
    public String teacherPassword;

    public teacherData(String teacherName, String teacherPassword) {
        this.teacherName = teacherName;
        this.teacherPassword = teacherPassword;
    }

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
}
