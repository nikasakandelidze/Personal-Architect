package storage.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectgroupEntity {
    private final String projectId;
    private final String groupName;
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

    public List<ProjectMemberEntity> getMembers() {
        return members;
    }

    public void addNewMember(ProjectMemberEntity projectMember){
        members.add(projectMember);
    }

    public String getGroupName() {
        return groupName;
    }

    public String getProjectId() {
        return projectId;
    }
}
