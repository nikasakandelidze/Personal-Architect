package model.projects;

import model.projects.member.ProjectMember;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProjectGroup {
    private final String groupName;
    private final List<ProjectMember> members;

    public ProjectGroup(List<ProjectMember> members, String groupName) {
        this.groupName = groupName;
        this.members = members;
    }

    public ProjectGroup(String groupName) {
        this.members = new ArrayList<>();
        this.groupName = groupName;
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
