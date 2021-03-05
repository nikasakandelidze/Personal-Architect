package model.projects;

import java.util.ArrayList;
import java.util.List;

public class ProjectGroup {
    private List<ProjectMember> members;

    public ProjectGroup(List<ProjectMember> members) {
        this.members = members;
    }

    public ProjectGroup() {
        this.members = new ArrayList<>();
    }

    public List<ProjectMember> getMembers() {
        return members;
    }

    public void setMembers(List<ProjectMember> members) {
        this.members = members;
    }
}
