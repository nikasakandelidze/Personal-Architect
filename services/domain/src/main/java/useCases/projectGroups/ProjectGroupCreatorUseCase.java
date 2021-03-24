package useCases.projectGroups;

import model.projectGroup.ProjectGroup;
import storage.group.ProjectGroupCreatorStorage;

public class ProjectGroupCreatorUseCase {
    private final ProjectGroupCreatorStorage projectGroupCreatorStorage;

    public ProjectGroupCreatorUseCase(ProjectGroupCreatorStorage projectGroupCreatorStorage) {
        this.projectGroupCreatorStorage = projectGroupCreatorStorage;
    }

    public void createNewProjectGroup(ProjectGroup projectGroup){
        projectGroupCreatorStorage.createNewProjectGroup(projectGroup);
    }
}
