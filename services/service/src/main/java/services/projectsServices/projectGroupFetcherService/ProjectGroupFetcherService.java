package services.projectsServices.projectGroupFetcherService;

import model.projectGroup.ProjectGroup;

import java.util.List;

public interface ProjectGroupFetcherService {
    ProjectGroup getProjectGroupWithProjectIdOf(String projectId);
    List<ProjectGroup> getAllProjectGroups();
}
