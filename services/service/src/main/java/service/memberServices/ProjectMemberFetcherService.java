package service.memberServices;

import model.members.ProjectMember;

import java.util.List;

public interface ProjectMemberFetcherService {
    List<ProjectMember> getProjectMembersOfProjectWithIdOf(String projectId);
}
