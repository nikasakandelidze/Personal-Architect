package service.groupServices;

import model.projectGroup.ProjectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import useCases.projectGroups.ProjectGroupCreatorUseCase;

@Service
public class ProjectGroupCreatorServiceImpl implements ProjectGroupCreatorService {
    @Autowired
    private ProjectGroupCreatorUseCase projectGroupCreatorUseCase;

    @Override
    public void createNewProjectGroup(ProjectGroup projectGroup) {
        projectGroupCreatorUseCase.createNewProjectGroup(projectGroup);
    }
}
