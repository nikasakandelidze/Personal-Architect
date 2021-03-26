package service.memberServices;

import model.members.ProjectMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import useCases.projectsMembers.ProjectMemberCreatorUseCase;

import java.util.List;

@Service
public class ProjectProjectMemberCreatorServiceImpl implements ProjectMemberCreatorService {
    @Autowired
    private ProjectMemberCreatorUseCase projectMemberCreatorUseCase;

    @Override
    public void createNewMember(ProjectMember projectMember) {
        projectMemberCreatorUseCase.createNewMember(projectMember);
    }
}
