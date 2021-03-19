package model.members;

import model.project.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    public ProjectMember(){
        this.memberId= UUID.randomUUID().toString();
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

    public List<Project> getProjectsInterestedIn() {
        return projectsInterestedIn;
    }

    public void setProjectsInterestedIn(List<Project> projectsInterestedIn) {
        this.projectsInterestedIn = projectsInterestedIn;
    }

    public void addProjectToInterestedList(Project project) {
        this.projectsInterestedIn.add(project);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectMember that = (ProjectMember) o;
        return Objects.equals(email, that.email) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(projectsInterestedIn, that.projectsInterestedIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, email, firstName, lastName, projectsInterestedIn);
    }
}
