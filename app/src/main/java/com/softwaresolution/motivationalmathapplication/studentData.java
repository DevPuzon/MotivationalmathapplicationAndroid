package com.softwaresolution.motivationalmathapplication;

public class studentData {
    public  String studentUsername;
    public String studentPassword;

    public studentData(String studentUsername, String studentPassword) {
        this.studentUsername = studentUsername;
        this.studentPassword = studentPassword;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }
}
