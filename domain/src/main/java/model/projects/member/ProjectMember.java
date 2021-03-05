package model.projects.member;

import model.projects.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectMember {
    private String memberId;
    private String email;
    private String firstName;
    private String lastName;
    private List<Project> projectsInterestedIn;

    public ProjectMember(String memberId) {
        this.memberId = memberId;
        projectsInterestedIn = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public List<Project> getProjectsInterestedIn() {
        return projectsInterestedIn;
    }

    public void setProjectsInterestedIn(List<Project> projectsInterestedIn) {
        this.projectsInterestedIn = projectsInterestedIn;
    }
}
