package services.projectsServices.projectGroupMemberAdditorService;

import model.members.ProjectMember;

public interface ProjectGroupMemberAdditorService {
    void addProjectMemberIntoProjectGroup(ProjectMember newMember, String projectId);
}
