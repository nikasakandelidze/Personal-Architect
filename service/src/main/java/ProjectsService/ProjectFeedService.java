package ProjectsService;

import ProjectsService.helpers.ProjectsFilterServiceData;
import model.projects.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectFeedService {
    Optional<Project> getProjectWithId(String projectId);
    List<Project> getAllProjects();
    List<Project> filterProjects(ProjectsFilterServiceData projectFiltererData);
}
