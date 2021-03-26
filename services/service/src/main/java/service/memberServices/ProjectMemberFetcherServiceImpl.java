package service.memberServices;

import model.members.ProjectMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import useCases.projectsMembers.ProjectMemberFetcherUseCase;

import java.util.List;

@Service
public class ProjectMemberFetcherServiceImpl implements ProjectMemberFetcherService{
    @Autowired
    private ProjectMemberFetcherUseCase projectMemberFetcherUseCase;

    @Override
    public List<ProjectMember> getProjectMembersOfProjectWithIdOf(String projectId) {
        return projectMemberFetcherUseCase.getAllMemberOfTheProjectWithIdOf(projectId);
    }
}
