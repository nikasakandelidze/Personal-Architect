package web.dto;

import java.util.ArrayList;
import java.util.List;

public class ProjectMemberDto {
    private String memberId;
    private String email;
    private String firstName;
    private String lastName;
    private List<ProjectDto> projectsInterestedIn;

    public ProjectMemberDto(String memberId) {
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

    public List<ProjectDto> getProjectsInterestedIn() {
        return projectsInterestedIn;
    }

    public void setProjectsInterestedIn(List<ProjectDto> projectsInterestedIn) {
        this.projectsInterestedIn = projectsInterestedIn;
    }

    public void addProjectToInterestedList(ProjectDto project) {
        this.projectsInterestedIn.add(project);
    }
}
