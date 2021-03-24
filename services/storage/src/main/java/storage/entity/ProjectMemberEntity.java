package storage.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "projectmembers")
public class ProjectMemberEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String memberId;
    private String email;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "author", cascade = {CascadeType.ALL})
    private List<ProjectEntity> projectsInterestedIn;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "projectMembers_ProjectGroups_table",
            joinColumns = {@JoinColumn(name = "memberId")},
            inverseJoinColumns = {@JoinColumn(name = "projectGroupId")})
    private List<ProjectgroupEntity> projectgroupEntities;

    public ProjectMemberEntity(String memberId) {
        this.memberId = memberId;
        projectsInterestedIn = new ArrayList<>();
    }

    public ProjectMemberEntity(){
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

    public List<ProjectgroupEntity> getProjectgroupEntities() {
        return projectgroupEntities;
    }

    public void setProjectgroupEntities(List<ProjectgroupEntity> projectgroupEntities) {
        this.projectgroupEntities = projectgroupEntities;
    }

    public void setProjectsInterestedIn(List<ProjectEntity> projectsInterestedIn) {
        this.projectsInterestedIn = projectsInterestedIn;
    }

    public void addProjectToInterestedList(ProjectEntity project) {
        this.projectsInterestedIn.add(project);
    }
}
