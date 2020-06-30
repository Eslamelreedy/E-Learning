package com.example.e_learning.pojo;

public class AnnouncementModel {
        private String Department;
        private String Level ;
        private String Section ;
        private String Subject ;

        public String getDepartment() {
            return Department;
        }

        public void setDepartment(String department) {
            Department = department;
        }

        public String getLevel() {
            return Level;
        }

        public void setLevel(String level) {
            Level = level;
        }

        public String getSection() {
            return Section;
        }

        public String getSubject() {
            return Subject;
        }

        public void setSubject(String subject) {
            Subject = subject;
        }

        public void setSection(String section) {
            Section = section;
        }

        public AnnouncementModel(String department, String level, String section, String subject) {
            Department = department;
            Level = level;
            Section = section;
            Subject = subject;



    }
}
