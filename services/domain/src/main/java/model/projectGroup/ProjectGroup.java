package model.projectGroup;

import model.members.ProjectMember;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ProjectGroup {
    private final String projectId;
    private final String groupName;
    private final List<ProjectMember> members;

    public ProjectGroup(List<ProjectMember> members, String groupName, String projectId) {
        this.groupName = groupName;
        this.members = members;
        this.projectId = projectId;
    }

    public ProjectGroup(String groupName) {
        this.members = new ArrayList<>();
        this.groupName = groupName;
        this.projectId = UUID.randomUUID().toString();
    }

    public List<ProjectMember> getMembers() {
        return members;
    }

    public void addNewMember(ProjectMember projectMember){
        members.add(projectMember);
    }

    public String getGroupName() {
        return groupName;
    }

    public String getProjectId() {
        return projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectGroup that = (ProjectGroup) o;
        return Objects.equals(groupName, that.groupName) && Objects.equals(members, that.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, members);
    }
}
