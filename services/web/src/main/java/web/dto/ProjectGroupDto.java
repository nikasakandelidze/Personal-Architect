package web.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectGroupDto {
    private String projectId;
    private String groupName;
    private List<ProjectMemberDto> members;

    public ProjectGroupDto(List<ProjectMemberDto> members, String groupName, String projectId) {
        this.groupName = groupName;
        this.members = members;
        this.projectId = projectId;
    }

    public ProjectGroupDto(String groupName) {
        this.members = new ArrayList<>();
        this.groupName = groupName;
        this.projectId = UUID.randomUUID().toString();
    }

    public List<ProjectMemberDto> getMembers() {
        return members;
    }

    public void addNewMember(ProjectMemberDto projectMember) {
        members.add(projectMember);
    }

    public String getGroupName() {
        return groupName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setMembers(List<ProjectMemberDto> members) {
        this.members = members;
    }
}
