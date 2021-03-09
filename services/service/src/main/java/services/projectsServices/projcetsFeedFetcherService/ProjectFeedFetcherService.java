package services.projectsServices.projcetsFeedFetcherService;

import services.helpers.ProjectsFilterServiceData;
import model.projects.Project;

import java.util.List;

public interface ProjectFeedFetcherService {
    Project getProjectWithId(String projectId);
    List<Project> getAllProjects();
    List<Project> filterProjects(ProjectsFilterServiceData projectFiltererData);
}
