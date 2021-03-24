package storage.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "projectgroups")
public class ProjectgroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String projectGroupId;
    private String groupName;
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "projectgroupEntities")
    private List<ProjectMemberEntity> members;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "projectId")
    private ProjectEntity projectEntity;

    public ProjectgroupEntity(){}

    public ProjectgroupEntity(List<ProjectMemberEntity> members, String groupName, String projectGroupId) {
        this.groupName = groupName;
        this.members = members;
        this.projectGroupId = projectGroupId;
    }

    public ProjectgroupEntity(String groupName) {
        this.members = new ArrayList<>();
        this.groupName = groupName;
        this.projectGroupId = UUID.randomUUID().toString();
    }

    public String getProjectGroupId() {
        return projectGroupId;
    }

    public void setProjectGroupId(String projectGroupId) {
        this.projectGroupId = projectGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<ProjectMemberEntity> getMembers() {
        return members;
    }

    public ProjectEntity getProjectEntity() {
        return projectEntity;
    }

    public void setProjectEntity(ProjectEntity projectEntity) {
        this.projectEntity = projectEntity;
    }
}
