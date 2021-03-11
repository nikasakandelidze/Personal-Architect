package web.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectGroupDto {
    private final String projectId;
    private final String groupName;
    private final List<ProjectMemberDto> members;

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

    public void addNewMember(ProjectMemberDto projectMember){
        members.add(projectMember);
    }

    public String getGroupName() {
        return groupName;
    }


}
