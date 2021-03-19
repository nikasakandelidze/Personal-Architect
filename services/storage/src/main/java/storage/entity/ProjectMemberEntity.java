package storage.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "projectmembers")
public class ProjectMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String memberId;
    private String email;
    private String firstName;
    private String lastName;
    @ManyToMany
    private List<ProjectEntity> projectsInterestedIn;

    public ProjectMemberEntity(String memberId) {
        this.memberId = memberId;
        projectsInterestedIn = new ArrayList<>();
    }

    public ProjectMemberEntity(){
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

    public List<ProjectEntity> getProjectsInterestedIn() {
        return projectsInterestedIn;
    }

    public void setProjectsInterestedIn(List<ProjectEntity> projectsInterestedIn) {
        this.projectsInterestedIn = projectsInterestedIn;
    }

    public void addProjectToInterestedList(ProjectEntity project) {
        this.projectsInterestedIn.add(project);
    }
}
