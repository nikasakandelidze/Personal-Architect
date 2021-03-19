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
    private String projectId;
    private final String groupName;
    @ManyToMany
    private final List<ProjectMemberEntity> members;

    public ProjectgroupEntity(List<ProjectMemberEntity> members, String groupName, String projectId) {
        this.groupName = groupName;
        this.members = members;
        this.projectId = projectId;
    }

    public ProjectgroupEntity(String groupName) {
        this.members = new ArrayList<>();
        this.groupName = groupName;
        this.projectId = UUID.randomUUID().toString();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<ProjectMemberEntity> getMembers() {
        return members;
    }

}
