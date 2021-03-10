package useCases.projectGroups;

import exceptions.ProjectNotFoundException;
import model.projectGroup.ProjectGroup;
import model.projects.Project;
import model.projects.ProjectsFeed;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProjectGroupFetcherUseCase {
    private final ProjectsFeed projectsFeed;

    public ProjectGroupFetcherUseCase(ProjectsFeed projectsFeed) {
        this.projectsFeed = projectsFeed;
    }

    public ProjectGroup getProjectGroupOfProjectWithIdOf(String projectId) {
        final Optional<Project> projectWithIdOf = projectsFeed.getProjectWithIdOf(projectId);
        final Project project = projectWithIdOf.orElseThrow(() -> new ProjectNotFoundException(String.format("Project with id: %s , was not found", projectId)));
        return project.getProjectGroup();
    }

    public List<ProjectGroup> getAllProjectGroups() {
        return projectsFeed.getAllProjects().stream()
                .map(Project::getProjectGroup)
                .collect(Collectors.toList());
    }
}
