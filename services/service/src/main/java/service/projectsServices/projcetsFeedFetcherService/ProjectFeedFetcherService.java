package service.projectsServices.projcetsFeedFetcherService;

import service.helpers.ProjectsFilterServiceData;
import model.project.Project;

import java.util.List;

public interface ProjectFeedFetcherService {
    Project getProjectWithId(String projectId);
    List<Project> getAllProjects();
    List<Project> filterProjects(ProjectsFilterServiceData projectFiltererData);
}
